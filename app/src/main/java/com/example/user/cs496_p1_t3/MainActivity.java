package com.example.user.cs496_p1_t3;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class MainActivity extends AppCompatActivity {
    Vibrator vibrator = null;
    private TextView mTextMessage;
    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            contextOfApplication = getApplicationContext();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction tr = fm.beginTransaction();

            Fragment frag1 = new ReadContact();
            Fragment frag2 = new gallery();
            Fragment frag3 = new freefrag();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tr.replace(R.id.message,frag1);
                    tr.commit();
                    vibrator.vibrate(500);
                    return true;
                case R.id.navigation_dashboard:
                    tr.replace(R.id.message,frag2);
                    tr.commit();
                    vibrator.vibrate(500);
                    return true;
                case R.id.navigation_notifications:
                    tr.replace(R.id.message,frag3);
                    tr.commit();
                    vibrator.vibrate(500);
                    return true;
            }
            return false;
        }
    };

    //permission handling

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {Manifest.permission.READ_CONTACTS, Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE};

        if(!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);

        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();

        Fragment frag1 = new ReadContact();
        tr.replace(R.id.message,frag1);
        tr.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    //Permission 추가
    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}
