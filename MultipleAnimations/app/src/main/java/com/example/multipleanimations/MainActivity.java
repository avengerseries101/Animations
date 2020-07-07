package com.example.multipleanimations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView searchIcon;
    private Button buttonCancel;
    private TextView textView;
    private ImageView imageViewLogo;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int SEARCH_ANIMATION_DURATION = 2000; // 2 sec

        searchIcon = findViewById(R.id.iv_search);
        textView = findViewById(R.id.tv_text);
        imageViewLogo = findViewById(R.id.iv_imageLogo);
        editText = findViewById(R.id.et_text);
        buttonCancel = findViewById(R.id.btnCancel);

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // take to leftmost position
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int modifierX = -(displayMetrics.widthPixels - v.getWidth());

                ObjectAnimator searchIconLeftAnimation = ObjectAnimator.ofFloat(v, "translationX", modifierX);
                searchIconLeftAnimation.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator logoFadeOutAnimator = ObjectAnimator.ofFloat(imageViewLogo, "alpha", 0f, 1f);
                logoFadeOutAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator cancelImageFadeInAnimator = ObjectAnimator.ofFloat(buttonCancel, "alpha", 0f, 1f);
                cancelImageFadeInAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator searchEditTextAnimator = ObjectAnimator.ofFloat(editText, "alpha", 0f, 1f);
                searchEditTextAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator textViewAnimator = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f);
                textViewAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(searchIconLeftAnimation).with(textViewAnimator);
                animatorSet.play(searchIconLeftAnimation).with(logoFadeOutAnimator);
                animatorSet.play(searchIconLeftAnimation).with(cancelImageFadeInAnimator);
                animatorSet.play(searchIconLeftAnimation).with(searchEditTextAnimator);

                animatorSet.start();
            }
        });
    }
}
