package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.affectiva.android.affdex.sdk.Frame;
import com.affectiva.android.affdex.sdk.detector.CameraDetector;
import com.affectiva.android.affdex.sdk.detector.Face;
import com.example.lab_1_affectiva.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CameraDetector.CameraEventListener, CameraDetector.ImageListener
{

    SurfaceView cameraDetectorSurfaceView;
    CameraDetector cameraDetector;

    int maxProcessingRate = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraDetectorSurfaceView = (SurfaceView) findViewById(R.id.cameraDetectorSurfaceView);

        cameraDetector = new CameraDetector(this, CameraDetector.CameraType.CAMERA_FRONT, cameraDetectorSurfaceView);

        cameraDetector.setMaxProcessRate(maxProcessingRate);

        cameraDetector.setImageListener(this);
        cameraDetector.setOnCameraEventListener(this);

        cameraDetector.setDetectAllEmotions(true);

        cameraDetector.start();

    }

    @Override
    public void onCameraSizeSelected(int cameraHeight, int cameraWidth, Frame.ROTATE rotate) {
        ViewGroup.LayoutParams params = cameraDetectorSurfaceView.getLayoutParams();

        //2
        params.height = cameraHeight;
        params.width = cameraWidth;

        //3
        cameraDetectorSurfaceView.setLayoutParams(params);
    }

    @Override
    public void onImageResults(List<Face> faces, Frame frame, float timeStamp) {
        if (faces == null)
            return; //frame was not processed
        //2
        if (faces.size() == 0)
            return; //no face found
        //3
        Face face = faces.get(0);
        //4
    }

    public void threshHold() {

    }
    public void volumeAdjust(){

    }

    public void songSwitch(){

    }
}