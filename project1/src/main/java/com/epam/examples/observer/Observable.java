package com.epam.examples.observer;

import com.epam.examples.service.ServiceException;

public interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers() throws ServiceException;

}
