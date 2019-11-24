package com.example.hydrate;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.widget.Toast;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {

    /** The GoogleMap to work with. */
    private GoogleMap map;

    private final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;

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
        map = googleMap;

        // Initial Markers.
        for (Map.Entry<String, LatLng> entry : BUILDING_LATLNGS.entrySet()) {
            setMarker(entry.getKey(), entry.getValue());
        }

        // Add a marker in Sydney and move the camera
        LatLng union = new LatLng(40.1092, -88.2272);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

        }
        map.setOnMyLocationButtonClickListener(this);
        map.setOnMyLocationClickListener(this);
        //map.addMarker()
        //map.addMarker(new MarkerOptions().position(origin).title("Marker at user location"));
        map.moveCamera(CameraUpdateFactory.newLatLng(union));
        // Here, thisActivity is the current activity
    }

    /**
     * Sets a marker at the specified location with the specified name.
     */
    public void setMarker(String name, LatLng location) {
        map.addMarker(new MarkerOptions().position(location).title("Marker on " + name));
        map.moveCamera(CameraUpdateFactory.newLatLng(location));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location.toString(), Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }
}
