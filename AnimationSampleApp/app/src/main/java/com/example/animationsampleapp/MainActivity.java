package com.example.animationsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewAnimated1;
    private TextView textViewAnimated2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAnimated1 = findViewById(R.id.tv_animated1);
        textViewAnimated2 = findViewById(R.id.tv_animated2);

        //Way-1 = Programmatically - Value Animator.
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(0f, 500f);
        valueAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());   // increase the speed first and then decrease
        valueAnimator1.setDuration(5000);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                textViewAnimated1.setTranslationY(progress);
                // no need to use invalidate() as it is already present in the text view.
            }
        });
        valueAnimator1.start();

        //Way-2 = Using XML - Value Animator.
/*        ValueAnimator valueAnimator2= ValueAnimator.ofFloat(0f,500f);
        AnimatorInflater.loadAnimator(this,R.animator.value_animator);
        valueAnimator2.AnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                textViewAnimated2.setTranslationY(progress);
            }
        });
        valueAnimator2.start();
 */

        //Way-3 = Programmatically - Using Object Animator.
        ObjectAnimator tvAnimator = ObjectAnimator.ofFloat(textViewAnimated2, "translationY", 0f, 500f);
        tvAnimator.setDuration(5000).setInterpolator(new AccelerateDecelerateInterpolator());
        tvAnimator.start();

        //Way-4 = Using XML - Using Object Animator.
/*        ObjectAnimator textViewAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animator);
        textViewAnimator.setTarget(textViewAnimated2);
        textViewAnimator.start();
*/
    }
}
