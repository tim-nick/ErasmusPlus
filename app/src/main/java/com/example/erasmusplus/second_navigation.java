package com.example.erasmusplus;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.Matrix;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.NoSuchElementException;


/*
 * A simple {@link Fragment} subclass.
 * Use the {@link second_navigation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class second_navigation extends Fragment  {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);


        final Button addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_second_navigation_to_third_navigation);
            }
        });

        final Button buttonSightsFirstCard = view.findViewById(R.id.sightButtonFirstCard);
        buttonSightsFirstCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_second_navigation_to_fourth_navigation);
            }
        });

        final Button buttonSightsSecondCard = view.findViewById(R.id.sightbuttonSecondCard);
        buttonSightsSecondCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_second_navigation_to_fourth_navigation);
            }
        });

        final Button buttonSightsThirdCard = view.findViewById(R.id.sightbuttonThirdCard);
        buttonSightsThirdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_second_navigation_to_fourth_navigation);
            }
        });

        final Button buttonSightsFourthCard = view.findViewById(R.id.sightbuttonFourthCard);
        buttonSightsFourthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_second_navigation_to_fourth_navigation);
            }
        });

        final Button buttonSightsFifthCard = view.findViewById(R.id.sightbuttonFifthCard);
        buttonSightsFifthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_second_navigation_to_fourth_navigation);
            }
        });

        final Button buttonSightsSixthCard = view.findViewById(R.id.sightbuttonSixthCard);
        buttonSightsSixthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_second_navigation_to_fourth_navigation);
            }
        });




    }
}
