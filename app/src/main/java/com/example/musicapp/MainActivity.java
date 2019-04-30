package com.example.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.affectiva.android.affdex.sdk.Frame;
import com.affectiva.android.affdex.sdk.detector.CameraDetector;
import com.affectiva.android.affdex.sdk.detector.Face;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CameraDetector.CameraEventListener, CameraDetector.ImageListener
 {

    SurfaceView cameraDetectorSurfaceView;
    CameraDetector cameraDetector;
     public static final String MOOD = "MOOD";

    String mood = "";


    int maxProcessingRate = 10;

    float time = 0;
    float joySumTimed = 0;

    List<Float> joyValues = new ArrayList<Float>();
    List<Float> engagementValues = new ArrayList<>();
    List<Float> disgustValues = new ArrayList<>();
    List<Float> sadnessValues = new ArrayList<>();

    List<Float> joyValuesTimed = new ArrayList<Float>();
    float joySum;
    float engageSum;
    float disgustSum;
    float sadSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage);


        cameraDetectorSurfaceView = (SurfaceView) findViewById(R.id.cameraDetectorSurfaceView);

        cameraDetector = new CameraDetector(this, CameraDetector.CameraType.CAMERA_FRONT, cameraDetectorSurfaceView);

        cameraDetector.setMaxProcessRate(maxProcessingRate);

        cameraDetector.setImageListener(this);
        cameraDetector.setOnCameraEventListener(this);

        cameraDetector.setDetectAllEmotions(true);

        cameraDetector.start();


    }

     public void onButtonClick(View v) {
         setContentView(R.layout.emotionget);

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
        System.out.println("entered image resu");
         TextView emotion =  (TextView) findViewById(R.id.cameraFound);;
         if (faces == null)
             return; //frame was not processed

         //2
         if (faces.size() == 0) {
             if (!(emotion == null)) emotion.setText("");
             return; //no face found
         }
         if (faces.size() > 0){
             if (!(emotion == null)) emotion.setText("Camera Detected!");
         }

         //3
         Face face = faces.get(0);

         //4
         float joy = face.emotions.getJoy();
         System.out.println("joy: " + joy);
         float engagement = face.emotions.getEngagement();
         float disgust = face.emotions.getDisgust();
         float sadness = face.emotions.getSadness();

         if(joy != 0) {
             joyValues.add(joy);
             joySum += joy;
         }
         if(engagement != 0) {
             engagementValues.add(engagement);
             engageSum += engagement;
         }
         if(disgust != 0) {
             disgustValues.add(disgust);
             disgustSum += disgust;
         }
         if(sadness != 0) {
             sadnessValues.add(sadness);
             sadSum += sadness;
         }

             System.out.println("joy values: " + joyValues.size());

             TextView complete = (TextView) findViewById(R.id.complete);
             if(joyValues.size() > 30) {
                 System.out.println("ENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\n");
                 mood = "joy";
                 complete.setText("Complete!");
                 for (int i = 0; i < 100; i++) {
                     System.out.print("");
                 }
                 Intent intent = new Intent(this, EmotionHandling.class);
                 intent.putExtra(MOOD, mood);
                 startActivity(intent);
             }


         if(sadnessValues.size() > 30) {
             System.out.println("ENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\nENTERED THE IF\n");
             mood = "sad";
             complete.setText("Complete!");
             for (int i = 0; i < 100; i++) {
                 System.out.print("");
             }
             Intent intent = new Intent(this, EmotionHandling.class);
             intent.putExtra(MOOD, mood);
             startActivity(intent);
         }



         }




     }




