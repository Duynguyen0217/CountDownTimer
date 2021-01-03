package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imgswitcher;
    Button btnstart;
    int[] mArrImages ={R.drawable.hinh1,
            R.drawable.hinh2,
            R.drawable.hinh3,
            R.drawable.hinh4,
            R.drawable.hinh5
                       };
    int count;
    boolean mIsStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgswitcher = findViewById(R.id.imageswitcher);
        btnstart = findViewById(R.id.Btnstart);

        imgswitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });

        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        imgswitcher.setOutAnimation(out);
        imgswitcher.setInAnimation(in);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIsStarted == false){

                    CountDownTimer countDownTimer = new CountDownTimer(1200, 1000) {
                        @Override
                        public void onTick(long millisecond) {
                            mIsStarted = true;
                            if(millisecond - 1000 >0){
                                if(count>= mArrImages.length){
                                    count =0;
                                }

                                imgswitcher.setImageResource(mArrImages[count++]);

                            }
                        }

                        @Override
                        public void onFinish() {

                            this.start();

                        }
                    };
                    countDownTimer.start();

                }




            }
        });





      /*  CountDownTimer countdowntimer = new CountDownTimer(5000 , 1000) {
            @Override
            public void onTick(long millisUntiFinished) {
                if(millisUntiFinished -1000 >0){
                    Log.d("NNNNN" , millisUntiFinished + "" );

                }



            }

            @Override
            public void onFinish() {
                Log.d("NNNNN" , "Finish CountDown");

            }
        };
        countdowntimer.start();*/
    }
}
