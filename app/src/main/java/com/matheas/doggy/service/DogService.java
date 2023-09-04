package com.matheas.doggy.service;

import com.matheas.doggy.domain.model.Dogs;
import com.matheas.doggy.service.util.DogListObserver;

public interface DogService {

    Dogs getDogList();

    void setDogObserver(DogListObserver dogListObserver);
}
