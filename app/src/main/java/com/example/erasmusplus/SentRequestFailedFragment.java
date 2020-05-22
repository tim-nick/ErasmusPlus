package com.example.erasmusplus;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class SentRequestFailedFragment extends DialogFragment {

    String[] errors = {" the Picture", " the Title", " the Category", " the Location", " the Description"};

    int errorValue = third_navigation.feedback;


    String error;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {




        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        if (errorValue == 1) {
            error = errors[0];
            // Picture empty error

        } else if (errorValue == 2) {
            error = errors[1];
            builder.setTitle(R.string.requestSentFailed)
                    .setMessage(R.string.requestSentFailedTextTitle)
                    .setPositiveButton(R.string.gotIt, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                            navController.navigate(R.id.action_sentRequestFailedFragment_to_second_navigation);
                        }
                    });
        } else if (errorValue == 3) {
            error = errors[2];
            builder.setTitle(R.string.requestSentFailed)
                    .setMessage(R.string.requestSentFailedTextCategory)
                    .setPositiveButton(R.string.gotIt, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                            navController.navigate(R.id.action_sentRequestFailedFragment_to_second_navigation);
                        }
                    });
        } else if (errorValue == 4) {
            error = errors[3];
            builder.setTitle(R.string.requestSentFailed)
                    .setMessage(R.string.requestSentfailedTextLocation)
                    .setPositiveButton(R.string.gotIt, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                            navController.navigate(R.id.action_sentRequestFailedFragment_to_second_navigation);
                        }
                    });
        } else if ( errorValue == 5) {
            error = errors[4];
            builder.setTitle(R.string.requestSentFailed)
                    .setMessage(R.string.requestSentfailedTextDescription)
                    .setPositiveButton(R.string.gotIt, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                            navController.navigate(R.id.action_sentRequestFailedFragment_to_second_navigation);
                        }
                    });
        } else {
            error = "";
            builder.setTitle(R.string.requestSentFailed)
                    .setMessage(R.string.unexpectederror)
                    .setPositiveButton(R.string.gotIt, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                            navController.navigate(R.id.action_sentRequestFailedFragment_to_second_navigation);
                        }
                    });
        }
        // Create the AlertDialog object and return it
        return builder.create();
    }


}
