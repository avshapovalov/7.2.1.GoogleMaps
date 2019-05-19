package com.example.a721googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt_Coordinates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_Coordinates = findViewById(R.id.edit_coordinates);
    }

    public void searchCoordinates(View view) {
        Intent mapsIntent = new Intent();
        mapsIntent.setAction(Intent.ACTION_VIEW);
        String coordinatesString = edt_Coordinates.getText().toString();
        if (checkLetters(coordinatesString)) {
            Uri uri = Uri.parse("geo:?q=" + coordinatesString);
            mapsIntent.setData(uri);
            startActivity(mapsIntent);
        } else {
            Uri uri = Uri.parse("geo:" + coordinatesString);
            mapsIntent.setData(uri);
            startActivity(mapsIntent);
        }
    }

    private Boolean checkLetters(String coordinatesString) {
        for (int i = 0; i < coordinatesString.length(); i++) {
            char letter = coordinatesString.charAt(i);
            if (Character.isLetter(letter)) {
                return true;
            } else {
                return false;
            }
        }
       return false;
    }
}


