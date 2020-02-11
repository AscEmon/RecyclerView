package com.example.recycleviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    int [] Image;
    String []CourseName;

    public MyAdapter(Context context, int[] image, String[] courseName) {
        this.context = context;
        Image = image;
        CourseName = courseName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.sample_recycler_layout,parent,false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.imageView.setImageResource(Image[position]);
        holder.textView.setText(CourseName[position]);

    }

    @Override
    public int getItemCount() {
        return Image.length;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.SampleImageId);
            textView=itemView.findViewById(R.id.SampleTextId);
        }
    }
}
