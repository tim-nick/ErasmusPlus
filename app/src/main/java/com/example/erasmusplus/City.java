package com.example.erasmusplus;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class City {
    private CardView view;
    private ImageView image;
    private TextView title;
    private TextView description;



    public City(CardView v) {

        view = v;
       // image = i;
        //title = t;
       // description = d;
    }

    public void setImage() {
        this.image.setImageResource(R.drawable.mgh);
    }

    public void setTitle() {
        this.title.setText("Bad Mergentheim");
    }
    public void setDescription() {
        this.description.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
    }
}
