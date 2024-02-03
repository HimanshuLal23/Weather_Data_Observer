package com.Notifier.WeatherNotifier;

import com.Notifier.WeatherNotifier.service.Observers.Laptop;
import com.Notifier.WeatherNotifier.service.Observers.Mobile;
import com.Notifier.WeatherNotifier.service.Observers.Observers;
import com.Notifier.WeatherNotifier.service.Subject.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Notifier.WeatherNotifier.configure,com.Notifier.WeatherNotifier.controller,com.Notifier.WeatherNotifier.service")
public class WeatherNotifierApplication {

	public static void main(String[] args) {
		Observers laptop = new Laptop();
		Observers mobile = new Mobile();
		WeatherService weatherService = ClassProvider.getWeatherServiceInstance();
		weatherService.registerObserver(mobile);
		weatherService.registerObserver(laptop);
		SpringApplication.run(WeatherNotifierApplication.class, args);
	}

}
