## Using FusedLocationProviderClient
- Find your current location using FusedLocationProviderClient
- [Add in Google LBS API  version 11](https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderClient)
## Be sure to read(AndroidManifest.xml)
```
<meta-data android:name="com.google.android.geo.API_KEY"       
            android:value="GoogleMap Key"/>
```

## For Google Map Support only,to register a new app on Google Console
You can create a new app on https://console.cloud.google.com and have to go to  **Enabled APIs and services**  to enable **Geolocation API** 

**Note : Don't forget to paste your Android applicationId from app->build.gradle and your SHA while creating key.**

-Create the key and paste into Android app.


## build.gradle(App module)
```
implementation 'com.google.android.gms:play-services-location:15.0.1'
implementation 'com.google.android.gms:play-services-maps:15.0.1'
```
