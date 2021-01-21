package com.pixfar.firebaseofflinedatabse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.bumptech.glide.Glide;

import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import de.hdodenhof.circleimageview.CircleImageView;




public class MainActivity2 extends AppCompatActivity {

    CircleImageView circleImageView;
    MaterialTextView textView;

    DatabaseReference reference;
    SharedPreferences sharedpreferences;

    Button button;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static  final String Key = "userKey";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        circleImageView = findViewById(R.id.profile_image);
        textView = findViewById(R.id.profileNmae);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        });



        if(Get() != null){

        reference = FirebaseDatabase.getInstance().getReference("Images").child(Get());
        reference.keepSynced(true);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                UserInfo user = dataSnapshot.getValue(UserInfo.class);
                textView.setText(user.getImageName());
                if (user.getImageURL().equals("")) {
                    circleImageView.setImageResource(R.mipmap.ic_launcher);
                }

                else {
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(circleImageView);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        }



       // textView.setText(userId);



    }

    public String Get() {
        sharedpreferences = getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Key)) {
            if(sharedpreferences.getString(Key, "") != "")
            {
                return  sharedpreferences.getString(Key, "");
//                userName.setText( sharedpreferences.getString(Key, ""));

               // Toast.makeText(this, sharedpreferences.getString(Key, ""), Toast.LENGTH_SHORT).show();
                //return true;
            } else
            {
                return null;
            }

        }
        else
        {
            return null;
        }
    }
}