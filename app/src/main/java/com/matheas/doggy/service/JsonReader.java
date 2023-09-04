package com.matheas.doggy.service;
import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.matheas.doggy.domain.model.Dog;
import com.matheas.doggy.domain.model.Dogs;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReader {
    public static Dogs readJsonFromAssets(AssetManager assetManager, String fileName) {
        try {
            InputStream inputStream = assetManager.open(fileName);
            InputStreamReader reader = new InputStreamReader(inputStream);
            Gson gson = new Gson();
            Type type = new TypeToken<List<Dog>>() {}.getType();
            Dogs data = new Dogs();
            reader.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

