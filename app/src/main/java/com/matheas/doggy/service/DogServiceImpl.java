package com.matheas.doggy.service;

import android.util.Log;

import com.matheas.doggy.domain.model.Dog;
import com.matheas.doggy.domain.model.Dogs;
import com.matheas.doggy.service.util.Api;
import com.matheas.doggy.service.util.DogListObserver;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogServiceImpl implements DogService {
    private Dogs dogList = new Dogs();

    private DogListObserver dogListObserver;

    public Dogs getDogList() {

        Call<List<Dog>> dogs = Api.Companion.create().getDogs();
        dogs.enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                if (response.isSuccessful()) {
                    dogList = new Dogs(response.body());
                    dogListObserver.onDogListFetched(dogList);
                } else {
                    Log.e("Dogs Api Failed", "Failed to load data");
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                Log.e("Dogs Api Failed", "Failed to load data " + t.getMessage());
            }
        });
        return dogList;
    }

    public void setDogObserver(DogListObserver dogListObserver) {
        this.dogListObserver = dogListObserver;
    }
}
