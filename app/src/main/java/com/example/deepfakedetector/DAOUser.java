package com.example.deepfakedetector;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUser {
    private DatabaseReference databaseReference;

    public DAOUser(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(user.class.getSimpleName());
    }
    public Task<Void> add(user newUser){
        return databaseReference.push().setValue(newUser);
    }
}
