package com.example.alif.myrecyclernew;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class CardHeroAdapter extends RecyclerView.Adapter<CardHeroAdapter.CardViewHolder>  {
    private Context context;
    private ArrayList<Hero> heroes;

    public CardHeroAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override


    public CardHeroAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_card_hero,viewGroup,false);
        return new CardViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(@NonNull CardHeroAdapter.CardViewHolder CardViewHolder, int i) {
        CardViewHolder.tvName.setText(getHeroes().get(i).getName());
        CardViewHolder.tvDescription.setText(getHeroes().get(i).getDescription());

        Glide.with(context)
                .load(getHeroes().get(i).getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(CardViewHolder.imgPhoto);

    }

    @Override
    public int getItemCount() {

        return getHeroes().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription;
        ImageView imgPhoto;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
