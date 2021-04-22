package com.example.navigation.ui.maps;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.navigation.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Maps extends FragmentActivity implements OnMapReadyCallback {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.Maps);
        mapFragment.getMapAsync(this);



    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Coventry and move the camera
        LatLng coventry = new LatLng(52.4074, -1.5026);
        googleMap.addMarker(new MarkerOptions().position(coventry).title("Coventry University"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(coventry));
    }
}