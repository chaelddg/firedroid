package com.example.learningandroid;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;

public class NotificationView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Notification", "Event : onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(getIntent().getExtras().getInt("notificationID"));
    }
}
