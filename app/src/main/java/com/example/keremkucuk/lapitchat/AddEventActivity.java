package com.example.keremkucuk.lapitchat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEventActivity extends Activity{

    private static final String TAG = "AddEventActivity";

    private Button btSave;

    private EditText etEventName;
    private EditText etDate;
    private Spinner  spHours;
    private Spinner  spMin;
    private EditText etStreet;
    private EditText etCity;

    protected String sMin;
    protected String sHours;
    protected boolean spMinBool = false;
    protected boolean spHoursBool = false;

    protected String date;

    private FirebaseAuth mAuth;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        Bundle b = getIntent().getExtras();
        date = b.getString("date");

        mAuth = FirebaseAuth.getInstance();

        etEventName = findViewById(R.id.etEventName);
        etDate = findViewById(R.id.etDate);
        etStreet = findViewById(R.id.etStreet);
        etCity = findViewById(R.id.etCity);

        btSave = findViewById(R.id.btSave);

        spHours = findViewById(R.id.spinHours);
        spMin = findViewById(R.id.spinMinutes);


        etDate.setText(date);

        spHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sHours = adapterView.getItemAtPosition(i).toString();
                spHoursBool = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spMin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sMin = adapterView.getItemAtPosition(i).toString();
                spMinBool = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sEventname = etEventName.getEditableText().toString();
                String sDate = etDate.getEditableText().toString();
                String sStreet = etStreet.getEditableText().toString();
                String sCity = etCity.getEditableText().toString();
                if(spMinBool || spHoursBool != true)
                {
                    Toast.makeText(AddEventActivity.this, "Bitte eine Uhrzeit auswählen!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Es wurde keine Uhrzeit ausgewählt");
                }
                else {
                    //Speichern in Firebase Database
                    Log.d(TAG, "Eventname: " + sEventname + " Datum: " + sDate + " Straße: " + sStreet + " Stadt: " + sCity + " Uhrzeit: " + spHours + ":" + spMin);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}
