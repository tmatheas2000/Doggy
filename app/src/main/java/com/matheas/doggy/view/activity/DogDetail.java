package com.matheas.doggy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.matheas.doggy.R;
import com.squareup.picasso.Picasso;

public class DogDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_detail);

        ImageView image = (ImageView) findViewById(R.id.dog_detail_image);
        Picasso.
        get()
        .load((String) getIntent().getSerializableExtra("image"))
        .into(image);

        TextView name = (TextView) findViewById(R.id.dog_detail_name);
        name.setText((String) getIntent().getSerializableExtra("name"));

        TextView origin = (TextView) findViewById(R.id.dog_detail_origin);
        origin.setText((String) getIntent().getSerializableExtra("origin"));

        TextView breedFor = (TextView) findViewById(R.id.dog_detail_breedfor);
        breedFor.setText((String) getIntent().getSerializableExtra("breedFor"));

        TextView breedGroup = (TextView) findViewById(R.id.dog_detail_breedgroup);
        breedGroup.setText((String) getIntent().getSerializableExtra("breedGroup"));

        TextView lifeSpan = (TextView) findViewById(R.id.dog_detail_lifespan);
        lifeSpan.setText((String) getIntent().getSerializableExtra("lifeSpan"));
    }
}