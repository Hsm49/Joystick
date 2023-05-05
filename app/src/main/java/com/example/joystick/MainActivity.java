package com.example.joystick;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView squareVertical, squareHorizontal;
    private RelativeLayout verticalBar, horizontalBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        squareVertical = findViewById(R.id.square_vertical);
        squareHorizontal = findViewById(R.id.square_horizontal);
        verticalBar = findViewById(R.id.vertical_bar);
        horizontalBar = findViewById(R.id.horizontal_bar);

        verticalBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    float y = motionEvent.getY();
                    if (y > 0 && y < verticalBar.getHeight()) {
                        squareVertical.setY(y - squareVertical.getHeight() / 2);
                    }
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    squareVertical.setY(verticalBar.getHeight() / 2 - squareVertical.getHeight() / 2);
                }
                return true;
            }
        });

        horizontalBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    float x = motionEvent.getX();
                    if (x > 0 && x < horizontalBar.getWidth()) {
                        squareHorizontal.setX(x - squareHorizontal.getWidth() / 2);
                    }
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    squareHorizontal.setX(horizontalBar.getWidth() / 2 - squareHorizontal.getWidth() / 2);
                }
                return true;
            }
        });
    }
}