package com.pixfar.firebaseofflinedatabse;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class OfflineSync extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


    }
}
