package com.example.location_new;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.location_new.R;
import com.google.android.gms.location.FusedLocationProviderClient; import
        com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private
    EditText locationNameEditText;
    private Button searchLocationButton;
    private TextView latitudeTextView, longitudeTextView, searchLatitudeTextView,
            searchLongitudeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(this);
        locationNameEditText = findViewById(R.id.locationNameEditText);
        searchLocationButton = findViewById(R.id.searchLocationButton);
        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitudeTextView);
        searchLatitudeTextView = findViewById(R.id.searchLatitudeTextView);
        searchLongitudeTextView = findViewById(R.id.searchLongitudeTextView);
        findViewById(R.id.getLocationButton).setOnClickListener(new
                                                                        View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View view) {
                                                                                getLocation();
                                                                            }
                                                                        });
        searchLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchLocation();
            }
        });
    }

    private void getLocation() {

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new
                                                                                       OnSuccessListener<Location>() {
                                                                                           @Override
                                                                                           public void onSuccess(Location location) {
                                                                                               if (location != null) {
                                                                                                   double latitude = location.getLatitude();
                                                                                                   double longitude = location.getLongitude();
                                                                                                   latitudeTextView.setText("Latitude: " + latitude);
                                                                                                   longitudeTextView.setText("Longitude: " + longitude);
                                                                                               } else {
                                                                                                   showToast("Location not available");
                                                                                               }
                                                                                           }
                                                                                       });
        } else {
            ActivityCompat.requestPermissions(this, new
                            String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST);
        }
    }

    private void searchLocation() {
        String locationName = locationNameEditText.getText().toString().trim();
        if (!locationName.isEmpty()) {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            try {
                List<Address> addresses =
                        geocoder.getFromLocationName(locationName, 1);
                if (addresses != null && !addresses.isEmpty()) {
                    Address address = addresses.get(0);
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    searchLatitudeTextView.setText("Searched Latitude: " +
                            latitude);
                    searchLongitudeTextView.setText("Searched Longitude: " +
                            longitude);
                } else {
                    showToast("Location not found");
                }

            } catch (IOException e) {
                e.printStackTrace();
                showToast("Geocoding error");
            }
        } else {
            showToast("Please enter a location name");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[]
            permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if
        (requestCode == LOCATION_PERMISSION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                showToast("Location permission denied");
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}