package com.matheas.doggy.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matheas.doggy.view.activity.DogDetail;
import com.matheas.doggy.R;
import com.matheas.doggy.domain.model.Dogs;
import com.squareup.picasso.Picasso;

public class DogRecyclerAdapter extends RecyclerView.Adapter<DogRecyclerAdapter.ViewHolder> {

    private Context context;
    private Dogs dogList;

    public DogRecyclerAdapter(Context context, Dogs dogList) {
        this.context = context;
        this.dogList = dogList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dogs_list_item, parent,false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(dogList.getDogNameAtPosition(position));

        Picasso.
        get()
        .load(dogList.getDogImageAtPosition(position))
        .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dogList.getDogsCount();
    }

    public void setDogListItems(Dogs dogList){
        this.dogList = dogList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public ViewHolder(@NonNull final View view, final Context ctx) {
            super(view);
            context=ctx;
            name=(TextView) view.findViewById(R.id.dog_name);
            image=(ImageView) view.findViewById(R.id.dog_image);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle mBundle=new Bundle();
                    mBundle.putSerializable("image", dogList.getDogImageAtPosition(getAdapterPosition()));
                    mBundle.putSerializable("name", dogList.getDogNameAtPosition(getAdapterPosition()));
                    mBundle.putSerializable("origin", dogList.getDogOriginAtPosition(getAdapterPosition()));
                    mBundle.putSerializable("breedFor", dogList.getDogBreedForAtPosition(getAdapterPosition()));
                    mBundle.putSerializable("breedGroup", dogList.getDogBreedGroupAtPosition(getAdapterPosition()));
                    mBundle.putSerializable("lifeSpan", dogList.getDogLifeSpanAtPosition(getAdapterPosition()));

                    Intent i=new Intent(ctx, DogDetail.class);
                    i.putExtras(mBundle);
                    ctx.startActivity(i);
                }
            });

        }
    }
}
