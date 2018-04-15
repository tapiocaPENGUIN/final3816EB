package com.example.eli.a3816final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DrinkNine extends AppCompatActivity {

    RatingBar rb;
    TextView value;
    Button submitBtn;

    DatabaseReference drinksDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_nine);

        drinksDB = FirebaseDatabase.getInstance().getReference("drinks");

        rb = (RatingBar) findViewById(R.id.ratingBar);
        value = (TextView) findViewById(R.id.value);
        submitBtn = (Button) findViewById(R.id.submitBtn);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                String id = drinksDB.push().getKey();

                drinks drinks = new drinks(id,rating);
                drinksDB.child(id).setValue(rating);
                value.setText("Value is " + rating);
            }
        });

    }


}

