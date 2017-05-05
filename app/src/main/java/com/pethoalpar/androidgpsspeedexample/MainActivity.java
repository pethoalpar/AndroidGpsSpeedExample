package com.pethoalpar.androidgpsspeedexample;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener{

    private LocationManager locationManager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) this.findViewById(R.id.textView);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},120);
        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
            this.onLocationChanged(null);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if(location == null){
            textView.setText("The location is not accessible");
        }else{
            StringBuilder sb = new StringBuilder();
            if(location.hasSpeed()){
                sb.append("Speed:").append(location.getSpeed()).append("m/s").append("\n");
            }
            if(location.hasAccuracy()){
                sb.append("Accuracy:").append(location.getAccuracy()).append("m").append("\n");
            }
            if(location.hasAltitude()){
                sb.append("Altitude:").append(location.getAltitude()).append("m").append("\n");
            }
            if(location.hasBearing()){
                sb.append("Bearing:").append(location.getBearing()).append("degree").append("\n");
            }
            sb.append("Latitude:").append(location.getLatitude()).append("\n");
            sb.append("Longitude:").append(location.getLongitude()).append("\n");
            textView.setText(sb.toString());
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
