package com.example.hydrate;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.maps.android.SphericalUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {

    /** The GoogleMap to work with. */
    private GoogleMap map;

    /** The Request Constant (can be any number). */
    private final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;

    /** Google Play Location services client. */
    private FusedLocationProviderClient fusedLocationClient;

    /** The Map of all building LatLng objects. */
    private Map<String, LatLng> BUILDING_LATLNGS = BuildingLatLng.getNameMap();

    /** The List of all building names. */
    private ArrayList<String> BUILDING_NAMES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Initializing google play location services client.
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Getting last known user location to center the map on.
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Centering map on the user.
                            final float defaultMapZoom = 17f;
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                new LatLng(location.getLatitude(), location.getLongitude()), defaultMapZoom));
                        }
                    }
                });

        // Adding building names to an ArrayList.
        for (Map.Entry<String, LatLng> entry : BUILDING_LATLNGS.entrySet()) {
            BUILDING_NAMES.add(entry.getKey());
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        ImageButton settings = findViewById(R.id.settings);
        Button hydrate = findViewById(R.id.hydrate);
        map = googleMap;

        // Initial Markers.
        for (Map.Entry<String, LatLng> entry : BUILDING_LATLNGS.entrySet()) {
            setMarker(entry.getKey(), entry.getValue());
        }

        // Getting location permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }

        map.setOnMyLocationButtonClickListener(this);
        map.setOnMyLocationClickListener(this);

        // Handler for the settings button.
        settings.setOnClickListener(unused -> startActivity(new Intent(this, SettingsActivity.class)));
    }

    /**
     * Sets a marker at the specified location with the specified name.
     */
    public void setMarker(String name, LatLng location) {
        map.addMarker(new MarkerOptions().position(location).title("Marker on " + name).icon(BitmapDescriptorFactory.fromResource(R.drawable.drinking_fountain_logo)));
        map.moveCamera(CameraUpdateFactory.newLatLng(location));
    }

    /**
     * Asks the user for access to their location
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted.
                    return;
                } else {
                    // Permission denied; try again.
                    Toast.makeText(this, "Please let us have your location", Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                }
                return;
            }
        }
    }
    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location", Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "Current Location", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).

        // Getting last known user location to center the map on.
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Centering map on the user.
                            final float defaultMapZoom = 17f;
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                    new LatLng(location.getLatitude(), location.getLongitude()), defaultMapZoom));
                        }
                    }
                });

        return false;
    }
}
