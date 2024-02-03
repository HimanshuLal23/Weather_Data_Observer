package com.Notifier.WeatherNotifier.service.Subject;

import com.Notifier.WeatherNotifier.ClassProvider;
import com.Notifier.WeatherNotifier.service.Observers.Observers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class WeatherService implements Subject{
    private final List<Observers> observersList;
    private static final String url = "https://api.tomorrow.io/v4/weather/forecast?location=hyderabad&apikey=xG5XJgCrPeAK4FYZxvo2vU1wkuJGh5dJ";
    private static final String accept = "application/json";
    private RestTemplate restTemplate;

    public WeatherService() {
        this.observersList = new ArrayList<>();
    }

    public ResponseEntity getWeatherDataFromApi() {
        restTemplate = getRestTemplate();
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(accept,accept);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(httpHeaders),String.class);
            log.info(responseEntity.toString());
            notifyObserver();
            return responseEntity;
        }catch (Exception ex) {
            log.error("Something went wrong ",ex);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        }
    }
    private RestTemplate getRestTemplate() {
        return ClassProvider.getRestTemplateInstance();
    }
    @Override
    public void registerObserver(Observers observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(Observers observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(var observer:observersList) {
            observer.update();
        }
    }
}
