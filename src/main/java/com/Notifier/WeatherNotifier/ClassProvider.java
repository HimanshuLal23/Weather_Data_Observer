package com.Notifier.WeatherNotifier;

import com.Notifier.WeatherNotifier.service.Subject.WeatherService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class ClassProvider {
    private ClassProvider() {
    }

    private static class Holder {
        private static final WeatherService weatherInstance = new WeatherService();
        private static final RestTemplate restTemplateInstance = getRestTemplate(new RestTemplateBuilder());

        private static RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
            return restTemplateBuilder.build();
        }

    }
    public static WeatherService getWeatherServiceInstance() {
        return Holder.weatherInstance;
    }
    public static RestTemplate getRestTemplateInstance() {
        return Holder.restTemplateInstance;
    }
}
