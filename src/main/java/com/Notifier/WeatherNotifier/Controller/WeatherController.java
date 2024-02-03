package com.Notifier.WeatherNotifier.Controller;

import com.Notifier.WeatherNotifier.ClassProvider;
import com.Notifier.WeatherNotifier.service.Subject.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weatherData")
@RequiredArgsConstructor
public class WeatherController {
    private WeatherService weatherService;
    @GetMapping("/get-weather-data")
    public ResponseEntity<?> getWeatherDataFromApi() {
        weatherService = ClassProvider.getWeatherServiceInstance();
        return ResponseEntity.ok(weatherService.getWeatherDataFromApi());
    }
}
