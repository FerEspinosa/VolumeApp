package com.curso.android.app.practica.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList;
    Context context;

    public MyCustomAdapter (Context context, ArrayList<Shape> shapeArrayList) {
        // It is a custom adapter because I need to display a custom Layout for each item

        super(context, R.layout.grid_item_layout, shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }

    // ViewHolder
    private static class MyViewHolder {
        TextView shapeName;
        ImageView shapeImage;
    }

    // getView
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // 1- get the shape object for the current position
        Shape shapes = shapeArrayList.get(position);

        // 2- Inflate the layout for each item
        MyViewHolder myViewHolder;
        if (convertView == null) {

            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false);

            // find views by id
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textview);
            myViewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.imageView);

            // set tag for myViewHolder
            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        // 3- set data to corresponding views
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImage.setImageResource(shapes.getShapeImg());

        return convertView;
    }


}
