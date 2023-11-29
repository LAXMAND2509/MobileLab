package com.example.sem_ex6_location;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText loc_ipt, lat_ipt, lon_ipt;
    Button search_btn, search_loc;
    TextView lat_val, lon_val, write_loc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        loc_ipt = findViewById(R.id.loc_ipt);
        search_btn = findViewById(R.id.search_btn);
        lat_val = findViewById(R.id.lat_val);
        lon_val = findViewById(R.id.lon_val);

        lat_ipt = findViewById(R.id.lat_ipt);
        lon_ipt = findViewById(R.id.lon_ipt);
        search_loc = findViewById(R.id.search_loc);
        write_loc = findViewById(R.id.write_loc);


        search_btn.setOnClickListener(v->{
            try {
                List<Address> addresses = geocoder.getFromLocationName(loc_ipt.getText().toString(),1);
                lat_val.setText("Latitude : "+String.valueOf((float) addresses.get(0).getLatitude()));
                lon_val.setText("Latitude : "+String.valueOf((float) addresses.get(0).getLongitude()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        search_loc.setOnClickListener(v->{
            List<Address> addresses = null;
            try {
                addresses = geocoder.getFromLocation(Double.valueOf(lat_ipt.getText().toString()),Double.valueOf(lon_ipt.getText().toString()),1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            write_loc.setText("Latitude : "+addresses.get(0).getAddressLine(0));
        });

    }
}