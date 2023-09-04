package com.matheas.doggy.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.matheas.doggy.R;
import com.matheas.doggy.domain.model.repository.DogListRepository;
import com.matheas.doggy.service.DogServiceImpl;
import com.matheas.doggy.service.util.Resource;
import com.matheas.doggy.view.adapter.DogRecyclerAdapter;
import com.matheas.doggy.domain.model.Dogs;
import com.matheas.doggy.view.model.DogListListViewModel;

public class DogsList extends AppCompatActivity {

    private String TAG = "DogListActivity";
    private RecyclerView.LayoutManager layoutManager;
    private DogRecyclerAdapter dogRecyclerAdapter;

    private DogListListViewModel dogViewModel;
    private DogListRepository dogListRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);

        setupViewModel();
        setupObserver();
        RecyclerView dogRV = findViewById(R.id.dogs_list_view);
        layoutManager = new LinearLayoutManager(this);
        dogRV.setLayoutManager(layoutManager);
        dogRecyclerAdapter = new DogRecyclerAdapter(this, new Dogs());
        dogRV.setAdapter(dogRecyclerAdapter);
    }

    private void setupObserver() {
        dogViewModel.getDogs().observe(this, new Observer<Resource<Dogs>>() {
            @Override
            public void onChanged(Resource<Dogs> it) {
                switch (it.getStatus()) {
                    case SUCCESS:
                        Log.i(TAG, "Data loaded!");
                        Dogs dogs = it.getData();
                        if (dogs != null) {
                            updateList(dogs);
                        }
                        break;
                    case LOADING:
                        Log.i(TAG, "Data loading...");
                        break;
                    default:
                        Log.e(TAG, it.getMessage());
                        break;
                }
            }
        });
    }

    private void updateList(Dogs dogs) {
        dogRecyclerAdapter.setDogListItems(dogs);
    }

    private void setupViewModel() {
        dogListRepository = new DogListRepository(new DogServiceImpl());
        dogViewModel = new ViewModelProvider(this, new ViewModelFactory(dogListRepository)). get(DogListListViewModel.class);
    }

    private class ViewModelFactory implements ViewModelProvider.Factory {
        private DogListRepository dogListRepository;

        public ViewModelFactory(DogListRepository dogListRepository) {
            this.dogListRepository = dogListRepository;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new DogListListViewModel(dogListRepository);
        }
    }
}