package com.example.youtube;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView , dataView;
    TextView textView;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = imageView.findViewById(R.id.relative_image);
        nameView = nameView.findViewById(R.id.relative_name);
        dataView = nameView.findViewById(R.id.relative_data);
        textView= textView.findViewById(R.id.relative_cost);



    }
}
