package com.matheas.doggy.domain.model.repository;

import com.matheas.doggy.domain.model.Dogs;
import com.matheas.doggy.service.DogService;
import com.matheas.doggy.service.util.DogListObserver;

public class DogListRepository implements DogListObserver {
    private DogService dogService;
    public DogListObserver dogListObserver;

    public DogListRepository(DogService dogService) {
        this.dogService = dogService;
        this.dogService.setDogObserver(this);
    }

    public Dogs getDogs() {
        return dogService.getDogList();
    }

    @Override
    public void onDogListFetched(Dogs dogList) {
        if (dogListObserver != null) {
            dogListObserver.onDogListFetched(dogList);
        }
    }
}