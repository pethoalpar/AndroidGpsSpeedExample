<H1>Android how to get gps datas.</H1> 

<H3>Manifest file.</H3>

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
```

<H3>Main class.</H3>

```java
implements LocationListener
```

```java
LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
this.onLocationChanged(null);
```
```java
 @Override
    public void onLocationChanged(Location location) {
            location.hasSpeed();
            location.getSpeed();
            location.hasAccuracy();
            location.getAccuracy();
            location.hasAltitude();
            location.getAltitude();
            location.hasBearing();
            location.getBearing();
            location.getLatitude();
            location.getLongitude();
      }
```
