package com.linkdev.circularlayout;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ImageView imgGreenCircle;
    private ValueAnimator greenVA;
    private ImageView imgYellowCircle;
    private ValueAnimator yellowVA;
    private ImageView imgDarkBlueCircle;
    private ValueAnimator darkBlueVA;
    private ImageView imgPinkCircle;
    private ValueAnimator pinkVA;
    private ImageView imgBrownCircle;
    private ValueAnimator brownVA;


    private TextView btnStartAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGreenCircle = findViewById(R.id.imgGreenCircle);
        imgYellowCircle = findViewById(R.id.imgYellowCircle);
        imgDarkBlueCircle = findViewById(R.id.imgDarkBlueCircle);
        imgPinkCircle = findViewById(R.id.imgPinkCircle);
        imgBrownCircle = findViewById(R.id.imgBrownCircle);
        btnStartAnimation = findViewById(R.id.btnStartAnimation);
        btnStartAnimation.setOnClickListener(btnStartAnimationOnClick);
    }

    private ValueAnimator animatePlanet(final ImageView planet, long orbitDuration, int startAngle, int endAngle) {
        ValueAnimator anim = ValueAnimator.ofInt(startAngle, endAngle);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int val = (Integer) animation.getAnimatedValue();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) planet.getLayoutParams();
                layoutParams.circleAngle = val;
                planet.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(orbitDuration);
        anim.setInterpolator(new LinearInterpolator());
        return anim;
    }

    private View.OnClickListener btnStartAnimationOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            greenVA = animatePlanet(imgGreenCircle, TimeUnit.SECONDS.toMillis(1), 0, 360);
            greenVA.start();
            yellowVA = animatePlanet(imgYellowCircle, TimeUnit.SECONDS.toMillis(1), 45, 405);
            yellowVA.start();
            darkBlueVA = animatePlanet(imgDarkBlueCircle, TimeUnit.SECONDS.toMillis(1), 90, 450);
            darkBlueVA.start();
            pinkVA = animatePlanet(imgPinkCircle, TimeUnit.SECONDS.toMillis(1), 135, 495);
            pinkVA.start();
            brownVA = animatePlanet(imgBrownCircle, TimeUnit.SECONDS.toMillis(1), 180, 540);
            brownVA.start();
        }
    };
}
