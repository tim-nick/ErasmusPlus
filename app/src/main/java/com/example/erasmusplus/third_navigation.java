package com.example.erasmusplus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link third_navigation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class third_navigation extends Fragment {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int RESULT_OK = -1 ;
    String currentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;
    Uri thisIsUri;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public third_navigation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment third_navigation.
     */
    // TODO: Rename and change types and number of parameters
    public static third_navigation newInstance(String param1, String param2) {
        third_navigation fragment = new third_navigation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView titleTextView = getActivity().findViewById(R.id.tittle_text_input);
        final TextView categoryTextView = getActivity().findViewById(R.id.category_text_input);
        final TextView locationTextView = getActivity().findViewById(R.id.location_text_input);
        final TextView descriptionTextView = getActivity().findViewById(R.id.descrription_text_input);
        final ImageView inputImage = getActivity().findViewById(R.id.imageView4);

        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
        Button addButton = getActivity().findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect all data input
                collectInputData(inputImage, titleTextView, categoryTextView, locationTextView, descriptionTextView);
                navController.navigate(R.id.action_third_navigation_to_second_navigation);
            }
        });

        ImageButton addImageButton = getActivity().findViewById(R.id.imageButton);
        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Stellt sicher das eine Kamera Aktivität den intent handelt
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Datei erstellen in welche das Foto gespeichert wird
            File photoFile = null;
            try {
                photoFile = createImageFile();
            }catch (IOException ex) {
                // Error der beim erstellen der Datei verursacht wurde
                System.out.println("Error occurred while creating the File");
            }
            // Wird nur ausgeführt wenn die Datei erfolgreich erstellt wurde
            if(photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getContext(),
                        "com.example.erasmusplus.fileprovider",
                        photoFile);
                System.out.println(photoURI + " Funktionierende photoUri");
                askForUri(photoURI); // Foto ist fertig und würde Funktionieren
                // Don't work from here on

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);// Intentset Extra (data)

                System.out.println(takePictureIntent);
                Bundle extra = takePictureIntent.getExtras();
                Object objectOne = extra.get("data");
                System.out.println(objectOne + " Das ist objectOne"); // Ist null also Extra ist schuld (Extra is null)

                if(takePictureIntent.getExtras() == extra) {
                    System.out.print(extra + " Das ist extra");
                } else {
                    System.out.print(takePictureIntent.getExtras() + " Das ist takePictureIntent.getExtras() ");
                    System.out.print( "\n" + extra + " Das ist extra");
                }

                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);


                System.out.println(" \nBild wurde erstellt");
            }

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(data + "This is before super call");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            System.out.println("Request und result true");
            System.out.println(requestCode + "<- request" + " " + "result ->" + resultCode);

            System.out.println(data);

            if (data != null) {
                Bundle extras = data.getExtras();
                Uri uriOne = (Uri) extras.get("data");
                ImageView imageView = getActivity().findViewById(R.id.imageView4);
                imageView.setImageURI(uriOne);
            } else {
                // System.out.println(data.getExtras() + "Das ist der Intent Extra Inhalt in Activity result");
                System.out.println("Hello Error");
                ImageView imageView = getActivity().findViewById(R.id.imageView4);

                setImage(thisIsUri, imageView);
                System.out.println("Kein Bild da");
            }


        } else {
            /*
            System.out.println("Request oder result true");
            Bundle extras = data.getExtras();
            System.out.println(extras);
            Uri uriOne = (Uri) extras.get("data");
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageURI(uriOne);*/

        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public void askForUri(Uri uri) {
        thisIsUri = uri;
    }

    public void setImage(Uri uri, ImageView imgV) {
        imgV.setImageURI(uri);
        System.out.println("Uri wurde gesetzt = URi ist leer");
    }

    public void collectInputData(ImageView picture, TextView title, TextView category, TextView location, TextView description) {
        CharSequence titleValue = title.getText();
        CharSequence categoryValue = category.getText();
        CharSequence locationValue = location.getText();
        CharSequence descriptionValue = description.getText();

        System.out.println(titleValue + " <- Title " + categoryValue + "<- category " + locationValue + " <- location" + descriptionValue + "<-description");

    }
}






