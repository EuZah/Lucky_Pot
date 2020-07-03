package com.luckypot.luckypot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class GameActivity extends AppCompatActivity{
    private TextView msg;
    private TextView msgBWin;
    private TextView msgLWin;
    private TextView msgLoose;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private Wheel wheel1, wheel2, wheel3, wheel4, wheel5, wheel6, wheel7, wheel8, wheel9;
    private Button btn;
    private boolean isStarted;
    int countBigWin = 0;
    int countLWin = 0;
    int countLoose = 0;

    public static final Random RANDOM = new Random();


    public static long randomLong(long lower, long upper) {
        return lower + (long)(RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);
        img7 = (ImageView) findViewById(R.id.img7);
        img8 = (ImageView) findViewById(R.id.img8);
        img9 = (ImageView) findViewById(R.id.img9);


        btn =(Button) findViewById(R.id.btn);
        msg = (TextView) findViewById(R.id.msg);
        msgBWin = (TextView) findViewById(R.id.msgBWin);
        msgLWin = (TextView) findViewById(R.id.msgLWin);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if(isStarted) {
                    wheel1.stopWheel();
                    wheel2.stopWheel();
                    wheel3.stopWheel();
                    wheel4.stopWheel();
                    wheel5.stopWheel();
                    wheel6.stopWheel();
                    wheel7.stopWheel();
                    wheel8.stopWheel();
                    wheel9.stopWheel();

                    if(wheel4.currentIndex == wheel5.currentIndex && wheel5.currentIndex == wheel6.currentIndex ){
                        msg.setText(R.string.win);
                        //  victoryLine();
                        countBigWin++;
                        msgBWin.setText(String.valueOf(countBigWin));

                    } else if (wheel4.currentIndex == wheel5.currentIndex || wheel5.currentIndex == wheel6.currentIndex || wheel4.currentIndex == wheel6.currentIndex){
                        msg.setText((R.string.little_prize));
                        countLWin++;
                        msgLWin.setText(String.valueOf(countLWin));

                    } else {
                        msg.setText((R.string.lose));
                        countLoose++;
                    }
                    btn.setText(R.string.btnStart);
                    isStarted = false;



                } else {
                    wheel1 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0,200));

                    wheel1.start();

                    wheel2 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150,400));

                    wheel2.start();

                    wheel3 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(250,550));

                    wheel3.start();

                    wheel4 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(250,400));

                    wheel4.start();

                    wheel5 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img5.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(350,500));

                    wheel5.start();

                    wheel6 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img6.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(190,550));

                    wheel6.start();

                    wheel7 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img7.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(95,150));

                    wheel7.start();

                    wheel8 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img8.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(50,400));

                    wheel8.start();

                    wheel9 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img9.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(290,400));

                    wheel9.start();

                    btn.setText(R.string.stop);
                    msg.setText("");
                    isStarted = true;
                }
            }
        });


    }
}