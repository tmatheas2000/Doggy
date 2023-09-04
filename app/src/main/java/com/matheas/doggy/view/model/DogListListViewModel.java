package com.matheas.doggy.view.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.matheas.doggy.domain.model.Dogs;
import com.matheas.doggy.domain.model.repository.DogListRepository;
import com.matheas.doggy.service.util.DogListObserver;
import com.matheas.doggy.service.util.Resource;

public class DogListListViewModel extends ViewModel implements DogListObserver {

    private MutableLiveData<Resource<Dogs>> dogs = new MutableLiveData<>();
    private String TAG = "DogListListViewModel";

    private DogListRepository dogRepository;

    public DogListListViewModel(DogListRepository dogRepository) {
        this.dogRepository = dogRepository;
        this.dogRepository.dogListObserver = this;
        fetchDogs();
    }

    private void fetchDogs () {
        dogs.postValue(Resource.loading(null));
        dogRepository.getDogs();
    }

    public LiveData<Resource<Dogs>> getDogs() {
        return dogs;
    }

    @Override
    public void onDogListFetched(Dogs dogList) {
        dogs.postValue(Resource.success(dogList));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "onCleared:: Viewmodel ready to be disposed");
    }
}
