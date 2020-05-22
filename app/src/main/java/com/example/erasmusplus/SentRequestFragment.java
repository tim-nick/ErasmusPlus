package com.example.erasmusplus;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class SentRequestFragment extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle(R.string.requestSent)
                .setMessage(R.string.requestSentText)
                .setPositiveButton(R.string.gotIt, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        navController.navigate(R.id.action_sentRequestFragment_to_second_navigation);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
