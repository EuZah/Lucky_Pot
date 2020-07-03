package com.luckypot.luckypot;

public class Wheel extends Thread {
    interface WheelListener {
        void newImage(int img);
    }

    private static int[]imgs = {R.mipmap.dice1xxxhdpi, R.mipmap.dice2xxxhdpi, R.mipmap.dice3xxxhdpi, R.mipmap.dice4xxxhdpi, R.mipmap.dice5xxxhdpi,
            R.mipmap.dice6xxxhdpi, R.mipmap.dice7xxxhdpi, R.mipmap.dice8xxxhdpi, R.mipmap.dice9xxxhdpi} ;
    public int currentIndex;
    private WheelListener wheelListener;
    private long frameDuration;
    private long startIn;
    private boolean isStarted;

    public Wheel(WheelListener wheelListener, long frameDuration, long startIn){
        this.wheelListener= wheelListener;
        this.frameDuration = frameDuration;
        this.startIn = startIn;
        this.isStarted = isStarted;

        currentIndex = 0;
        isStarted = true;
    }

    public void nextImg(){
        currentIndex++;

        if(currentIndex == imgs.length){
            currentIndex = 0;
        }
    }

    @Override
    public  void run(){
        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
        }

        while(isStarted) {
            try {
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
            }

            nextImg();

            if (wheelListener != null){
                wheelListener.newImage(imgs[currentIndex]);
            }
        }
    }

    public void stopWheel() {
        isStarted = false; }
}
