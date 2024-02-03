package com.Notifier.WeatherNotifier.service.Subject;

import com.Notifier.WeatherNotifier.service.Observers.Observers;

public interface Subject {
    void registerObserver(Observers observer);
    void removeObserver(Observers observer);
    void notifyObserver();
}
