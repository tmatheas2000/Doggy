package com.matheas.doggy.service.util;

import com.matheas.doggy.domain.model.Dogs;

public interface DogListObserver {
    void onDogListFetched(Dogs dogList);
}
