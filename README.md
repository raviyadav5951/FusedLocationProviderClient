# FusedLocationProviderClient
FusedLocationProviderClient is new way to fetch the user current location in terms of latitude and longitude.

Note:This is just a basic functionality to fetch the latitude and longitude.
Most Imp Note : Here we have integrated SettingsClient Api
https://developers.google.com/android/reference/com/google/android/gms/location/SettingsClient 
To know that before checking for runtime permission of Location in our demo app, first we need to check if Location Services(GPS) enabled or not.

This demo is useful to know the location only once.

Earlier when we are using the FusedLocationProvider Api we have to use more number of methods to fetch the user current location in terms of latitude and longitude.
But now in the new updates all the complexities are gone and most of the things are handled automatically.

For FusedLocationProviderApi with reverse geocoding you can check this :
https://github.com/askfortricks/FusedLocationProvider-Api-Demo


