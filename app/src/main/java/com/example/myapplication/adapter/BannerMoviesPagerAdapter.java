package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.myapplication.MovieDetails;
import com.example.myapplication.R;
import com.example.myapplication.model.BannerMovies;

import java.util.List;

public class BannerMoviesPagerAdapter extends PagerAdapter {

    Context context;

    List<BannerMovies> bannerMoviesList;

    public BannerMoviesPagerAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    public void setItems(List<BannerMovies> bannerMoviesList) {
        this.bannerMoviesList = bannerMoviesList;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout, null);
        ImageView bannerImage = view.findViewById(R.id.banner_image);
        Glide.with(context).load(bannerMoviesList.get(position).getImageURL()).into(bannerImage);
        container.addView(view);
        bannerImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 Intent i = new Intent(context, MovieDetails.class);
                 i.putExtra("movieId",bannerMoviesList.get(position).getId());
                i.putExtra("movieName",bannerMoviesList.get(position).getMovieName());
                i.putExtra("movieImageUrl",bannerMoviesList.get(position).getImageURL());
                i.putExtra("movieFile",bannerMoviesList.get(position).getFileURL());
                i.putExtra("movieFile",bannerMoviesList.get(position).getFileURL());

                context.startActivity(i);

                  }
        });

        return view;
    }
    public void updateData(List<BannerMovies> bannerMoviesList) {
        this.bannerMoviesList = bannerMoviesList;
    }

}