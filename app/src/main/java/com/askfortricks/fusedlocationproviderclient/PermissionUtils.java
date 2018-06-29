package com.askfortricks.fusedlocationproviderclient;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Location setting and permission check
 */

public final class PermissionUtils {
    public static final int REQUEST_CODE = 400;
    /**
     * Runtime Permission Check
     */
    public static void requestPermission(AppCompatActivity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{
                                      Manifest.permission.ACCESS_FINE_LOCATION},
                                      REQUEST_CODE);
    }

    /**
     * Common methods to determine if a location permission is granted
     */
    public static boolean isPermissionGranted(String[] grantPermissions,
                                              int[] grantResults){
        int permissionSize = grantPermissions.length;
        for (int i = 0; i < permissionSize; i++) {
            if (Manifest.permission.ACCESS_FINE_LOCATION.equals(grantPermissions[i])) {
                return grantResults[i] == PackageManager.PERMISSION_GRANTED;
            }
        }
        return false;
    }
    /**
     * Dialog extension for permissions
     */
    public static class LocationSettingDialog extends DialogFragment{
        /**
         * Create a new instance of this dialog and click on the 'OK' button to
         * selectively advance the call activity.
         */
        public static LocationSettingDialog newInstance() {
            return new LocationSettingDialog();
        }
        @NonNull
        @Override
        public Dialog onCreateDialog( Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage("You need to set your device's location.")
                    .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }).create();
        }
    }
}
