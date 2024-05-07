package  com.example.handyman;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private GoogleMap googleMap;
    private FusedLocationProviderClient fusedLocationClient;
    private LatLng currentLocation = new LatLng(0, 0); // Default location

    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        @Override
        public void onMapReady(GoogleMap map) {
            googleMap = map;

            // Move camera to current location
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f)); // Zoom level 15

            // Add marker for current location
            googleMap.addMarker(new MarkerOptions().position(currentLocation).title("Your Location"));

            // Add marker click listener if needed
            // Set map click listener


            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(@NonNull LatLng latLng) {

                    int w=0;
                    w=0;
                    // Clear existing marker
                    googleMap.clear();
                    // Add new marker at clicked location
                    googleMap.addMarker(new MarkerOptions().position(latLng).title("Selected Location"));
                    // Update currentLocation
                    currentLocation = latLng;
                    // You can also update other UI elements or variables as needed


                }


            });
            // Enable current location

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext());
        fetchLastLocation();
    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
            googleMap.setMyLocationEnabled(true);



            return;
        }



        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(requireActivity(), new com.google.android.gms.tasks.OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                            if (googleMap != null) {
                                // Move camera to current location
                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f)); // Zoom level 15
                                // Add marker for current location
                                googleMap.addMarker(new MarkerOptions().position(currentLocation).title("Your Location"));
                            }
                        }
                    }
                });
    }

    // Handle permission request result if needed
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, show the map
                fetchLastLocation();
            }
        }
    }

}
