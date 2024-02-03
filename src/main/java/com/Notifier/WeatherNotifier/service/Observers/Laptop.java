package com.Notifier.WeatherNotifier.service.Observers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Laptop implements Observers{
    @Override
    public void update() {
        log.info("Laptop has been notified");
    }
}