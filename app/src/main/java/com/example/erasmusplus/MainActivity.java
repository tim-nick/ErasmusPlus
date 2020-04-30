package com.example.erasmusplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.NavController;

import java.util.Observer;


public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //NavController navController;
        //AppBarConfiguration appBarConfiguration =
        //        new AppBarConfiguration.Builder(navController.getGraph()).build();


        //Set up Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //myToolbar.setTitle("Citys");



        first_navigation firstFragment = (first_navigation) getSupportFragmentManager().findFragmentById(R.id.first_navigation);
        second_navigation secondFragment = (second_navigation) getSupportFragmentManager().findFragmentById(R.id.second_navigation);

        //FragmentLifecycleObserver observation1 = new FragmentLifecycleObserver();
        //SecondFragmentLifecycleObserver observation2 = new SecondFragmentLifecycleObserver();

        //getSupportActionBar().setTitle("ErasmusPlus");

    }

    public void launchActivity() {
        Intent intent = new Intent(this, Sights.class);
        startActivity(intent);
    }

    public void setToolBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }



}

