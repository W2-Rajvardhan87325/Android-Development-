package com.sunbeaminfo.app2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout);

        // Get the sensor manager object
        SensorManager sensorManager = getSystemService(SensorManager.class);

        // from the sensor manager object get the required sensor
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        // Create the object of SensorEventListner that will listen to the events on the sensor
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float distance = event.values[0];
                Log.e("MainActivity","distance = "+distance);
                if(distance==0.0)
                    linearLayout.setBackgroundColor(Color.BLACK);
                else
                    linearLayout.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        // register the listner for that given sensor
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
}