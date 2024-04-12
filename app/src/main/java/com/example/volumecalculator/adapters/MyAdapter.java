package com.example.volumecalculator.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.volumecalculator.Figure_class;
import com.example.volumecalculator.R;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Figure_class> {
    private ArrayList<Figure_class> figuteList;
    private Context context;

    public MyAdapter(ArrayList<Figure_class> figuteList, Context context) {
        super(context, R.layout.figure_layout, figuteList);
        this.figuteList = figuteList;
        this.context = context;
    }

    private static class MyViewHolder {
        TextView figureName;
        ImageView picture;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Figure_class figure = getItem(position);
        MyViewHolder myViewHolder;
        final View result;
        final ImageView myImageView;

        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.figure_layout,
                    parent,
                    false
            );

            myViewHolder.figureName = (TextView) convertView.findViewById(R.id.name);
            myViewHolder.picture = (ImageView) convertView.findViewById(R.id.image);

            result = convertView;
            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        //get data from model
        myViewHolder.figureName.setText(figure.getName());
        //myViewHolder.picture.setImageResource(figure.getImageID());

        //Glibe library
        Glide.with(this.getContext()).load(figure.getImageID()).into(myViewHolder.picture);

        return result;
    }
}
