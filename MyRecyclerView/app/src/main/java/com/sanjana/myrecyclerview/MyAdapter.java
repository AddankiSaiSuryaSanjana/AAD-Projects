package com.sanjana.myrecyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    String t[];
    int images[];
    //alt + insert


    public MyAdapter(Context context, String[] t, int[] images) {
        this.context = context;
        this.t = t;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_design, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movie_title.setText(t[position]);
        holder.poster.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView poster;
        TextView movie_title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById((R.id.movie_poster));
            movie_title = itemView.findViewById(R.id.movie_title);
        }
    }
}



