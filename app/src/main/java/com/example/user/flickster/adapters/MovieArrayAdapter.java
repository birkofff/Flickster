package com.example.user.flickster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.flickster.R;
import com.example.user.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super (context, android.R.layout.simple_list_item_1, movies);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Movie movie = getItem(position);
        if (convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
          convertView =  inflater.inflate(R.layout.item_movie,parent, false);
        }
        ImageView ivImage = convertView.findViewById(R.id.ivMovieImage);
        ivImage.setImageResource(0);

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        return convertView;
    }

}
