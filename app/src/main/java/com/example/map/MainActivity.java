package com.example.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        LatLng uteq = new LatLng(-1.012278, -79.470136);
        mMap.addMarker(new MarkerOptions()
                .position(uteq)
                .title("Facultad de Ciencias Empresariales")
                .snippet("Universidad Técnica Estatal de Quevedo"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-1.012586, -79.470421))
                .title("Facultad de Ciencias Sociales, Económicas y Financieras")
                .snippet("Universidad Técnica Estatal de Quevedo"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-1.012905, -79.469366))
                .title("Facultad de Ciencias de la Salud")
                .snippet("Universidad Técnica Estatal de Quevedo"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uteq, 18));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter(MainActivity.this));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                Toast.makeText(MainActivity.this, marker.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
