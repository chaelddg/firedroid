package com.example.learningandroid;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.DisplayMetrics;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // DATABASE INIT
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference dataRoot = database.child("data").child("form_data");
    //    DatabaseReference myRef = database.getReference("firespike-89a8f");

    // COMPONENTS
    TextView txtView;

    // MAIN VARIABLES
    String tag = "@@@@ Main";
    String eventTag = "Event Triggered";

    int request_code = 1;
    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Event : onCreate");

        super.onCreate(savedInstanceState);

//        txtView = (TextView) findViewById(R.id.textView2);
//        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DisplayMetrics display = this.getResources().getDisplayMetrics();
//
//        int width = display.widthPixels;
//        int height = display.heightPixels;
//
//        if (width > height) {
//            // LANDSCAPE MODE
//            Fragment1 fragment1 = new Fragment1();
//
//            fragmentTransaction.replace(android.R.id.content, fragment1);
//        } else {
//            // PORTRAIT MODE
//            Fragment2 fragment2 = new Fragment2();
//
//            fragmentTransaction.replace(android.R.id.content, fragment2);
//        }
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();

        dataRoot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                    String text = (String) messageSnapshot.child("text").getValue();
                    String type = (String) messageSnapshot.child("type").getValue();

                    switch(type) {
                        case "label":
                            Fragment1 fragment1 = new Fragment1();
                            fragmentTransaction.add(android.R.id.content, fragment1);
                            break;
                        case "button":
                            Fragment2 fragment2 = new Fragment2();
                            fragmentTransaction.add(android.R.id.content, fragment2);
                            break;
                        case "input":
                            Fragment1 fragment3 = new Fragment1();
                            fragmentTransaction.add(android.R.id.content, fragment3);

                            break;
                    }


                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

//                Toast.makeText(MainActivity.this, text_value, Toast.LENGTH_SHORT).show();
//                txtView.setText(text_value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onClick(View view) {
        Log.d(eventTag, "MainActivity : onClick");

//        Intent i = new Intent("com.example.learningandroid.SecondActivity");
//
//        i.putExtra("str1", "This is a string");
//        i.putExtra("age1", 25);
//
//        Bundle extras = new Bundle();
//
//        extras.putString("str2", "This is another string");
//        extras.putInt("age2", 25);
//
//        i.putExtras(extras);
//
//        startActivityForResult(i, request_code);

//        startActivityForResult(new Intent("com.example.learningandroid.SecondActivity"), request_code);
//        startActivity(new Intent("com.example.learningandroid.SecondActivity"));

//        displayNotification();
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Log.d(eventTag, "MainActivity : onActivityResult");
//        if (requestCode == request_code) {
//            if (resultCode == RESULT_OK) {
//                Toast.makeText(this, Integer.toString(data.getIntExtra("age3", 0)), Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

//    protected void displayNotification()
//    {
//
//        Intent i = new Intent(this, NotificationView.class);
//        i.putExtra("notificationID", notificationID);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
//        NotificationManager nm = (NotificationManager)getSystemService
//                (NOTIFICATION_SERVICE);
//        NotificationCompat.Builder notifBuilder;
//        notifBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Meeting Reminder")
//                .setContentText("Reminder: Meeting starts in 5 minutes");
//        nm.notify(notificationID, notifBuilder.build());
//    }

    @Override
    public void onStart() {
        super.onStart();

//        dataRoot.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d(tag,dataSnapshot.child("form_data").getValue().toString());
//
////                Toast.makeText(MainActivity.this, text_value, Toast.LENGTH_SHORT).show();
////                txtView.setText(text_value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
