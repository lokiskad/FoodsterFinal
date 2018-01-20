package com.example.keremkucuk.lapitchat;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Brian on 29.11.2017.
 * https://stackoverflow.com/questions/42621911/firebase-ondatachange-not-entered
 */

public interface OnGetDataListener {
    // make new interface for callback
    void onSuccess(DataSnapshot dataSnapshot);
    void onStart();
    void onFailure();
}