package com.Notifier.WeatherNotifier.service.Observers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mobile implements Observers{
    @Override
    public void update() {
        log.info("Mobile has been notified");
    }
}