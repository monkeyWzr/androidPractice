package com.example.wzr.lbstest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public LocationClient mLocationClient;
    public static final int UPDATE_TEXT = 1;

    private TextView positionText;
    private StringBuilder currentPosition;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    positionText.setText(currentPosition);
            }
        }
    };

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            currentPosition = new StringBuilder();
            currentPosition.append("Latitude: ").append(location.getLatitude()).append("\n");
            currentPosition.append("Longitude: ").append(location.getLongitude()).append("\n");
            currentPosition.append("国家: ").append(location.getCountry()).append("\n");
            currentPosition.append("省： ").append(location.getProvince()).append("\n");
            currentPosition.append("市： ").append(location.getCity()).append("\n");
            currentPosition.append("区： ").append(location.getDistrict()).append("\n");
            currentPosition.append("街道： ").append(location.getStreet()).append("\n");
            currentPosition.append("Locating type: ");
            if (location.getLocType() == BDLocation.TypeGpsLocation)
                currentPosition.append("GPS");
            else if (location.getLocType() == BDLocation.TypeNetWorkLocation)
                currentPosition.append("Network");
//            positionText.setText(currentPosition);
            Message message = new Message();
            message.what = UPDATE_TEXT;
            handler.sendMessage(message);
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        setContentView(R.layout.activity_main);
        positionText = (TextView) findViewById(R.id.position_text_view);
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        } else
            requestLocation();
    }

    private void requestLocation() {
        initLocatoin();
        mLocationClient.start();
    }

    private void initLocatoin() {
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "You need to agree all the permissions", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "Unexcepted error occurred!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
    }
}
