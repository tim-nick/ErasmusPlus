package com.example.erasmusplus;

import android.location.LocationListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;



/*
 * A simple {@link Fragment} subclass.
 * Use the {@link first_navigation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class first_navigation extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_navigation, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //getLifecycle().addObserver(new FragmentLifecycleObserver());



        final Bundle bundle = new Bundle();
        bundle.putBoolean("test_boolean", true);



        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        final Button firstButton = view.findViewById(R.id.buttonfirstcard);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_first_navigation_to_second_navigation, bundle);
                System.out.println("Button function triggered!!!");
            }
        });

        Button secondButton = view.findViewById(R.id.buttonsecondcard);

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_first_navigation_to_second_navigation);

            }
        });

        Button thirdButton = view.findViewById(R.id.buttonthirdcard);

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_first_navigation_to_second_navigation);
            }
        });





    }
}
