package com.matheas.doggy.service.util;

import com.matheas.doggy.domain.model.Dog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Api {
    @GET("dogs")
    Call<List<Dog>> getDogs();

    class Companion {
        public static String BASE_URL = "https://0638f127-1825-4136-9c9c-2315ebb3cba8.mock.pstmn.io/";

        public static Api create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
            return retrofit.create(Api.class);
        }
    }
}
