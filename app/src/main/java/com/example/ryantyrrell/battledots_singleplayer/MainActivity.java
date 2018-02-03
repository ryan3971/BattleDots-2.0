package com.example.ryantyrrell.battledots_singleplayer;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.ryantyrrell.battledots_singleplayer.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

/**
 * Created by ryan3971 on 2/11/2016.
 */
public class MainActivity extends Activity{

    static Constants CONSTANTS;

    boolean nextPairedDevice = false;


    WeakReference<MainActivity> mainActivityWeakReference;

    Handler handler;

    static ViewFlipper VF;

    TextView countDownText;
    int countDownNum;

    GameView game;

    static TextView endGame;

    static boolean START_GAME = true;

   // StartGameThread startGameThread;

    TextView statues;

    Animations animations;

    /**
     *The first method called when the app is opened.
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_layout);

        VF = (ViewFlipper) findViewById(R.id.ViewFlipper01);
        game = (GameView) findViewById(R.id.game_view);

        CONSTANTS = new Constants();

        handler = new Handler();

        countDownText = (TextView) findViewById(R.id.count_down);
        endGame = (TextView)findViewById(R.id.endGameText);


        animations = new Animations(getApplicationContext());

    }



    public void startGame(View onClick) {
        Log.w("TAGTAG", "UH-HUH");

     //   ArrayList<Double> dataIntList = new ArrayList<>();
      //  dataIntList.add(CONSTANTS.START_GAME_TRUE_CONSTANT);
      //  DataToByteAndSend(CONSTANTS.START_GAME_CONSTANT, dataIntList);
        GameConstants.PLAYER_TAG = 1;
        handler.postDelayed(startGameChecker, 0);

    }

    public Runnable startGameChecker = new Runnable() {
        @Override
        public void run() {

            if (START_GAME == true)     {
                START_GAME = false;
                game.initilizer();
                VF.setDisplayedChild(1);
                game.setClickable(false);       //figure out latter
                countDownNum = 3;
                countDownText.setVisibility(View.VISIBLE);
                handler.postDelayed(countDown, 0);

            }else   {
                handler.postDelayed(startGameChecker, 1);

            }
        }
    };


    public static void endGame(int winOrLose) {

        VF.setDisplayedChild(2);
        if (winOrLose == 0) {
            endGame.setTextColor(Color.GREEN);
            endGame.setText("WINNER");
        }else if (winOrLose == 1) {
            endGame.setTextColor(Color.RED);
            endGame.setText("LOSER");
        }

    }

    public Runnable countDown = new Runnable() {
        @Override
        public void run() {
            Log.w("TAG", "YUP");
            if (countDownNum == 3) {
                countDownNum = 2;
                countDownText.setText("3");
                animations.animateStartTimer(countDownText);
                handler.postDelayed(countDown, 1000);

            }else if (countDownNum == 2) {
                countDownNum = 1;
                countDownText.setText("2");
                animations.animateStartTimer(countDownText);
                handler.postDelayed(countDown, 1000);

            }else if (countDownNum == 1) {
                countDownNum = 0;
                countDownText.setText("1");
                animations.animateStartTimer(countDownText);
                handler.postDelayed(countDown, 1000);

            }else {
                countDownText.setVisibility(View.INVISIBLE);
                game.setClickable(true);
            }
        }
    };


}

//not working from my phone cause of my running through all paired phones thing
//might change hoe constants object is passed on
// might not call GameConstants statically. May use instance instead, depending on performance
//too much data over bluetooth causes crash - google and research
// relook at transfering of obstaclles and powerups - find more efficient method
//sometimes, obstacles and powerps aren't removed. Theory is that the data isn't sent over bluetooth. happens approximetly every 1 in 10. Fix latter
//just change all dot_radius from float to double - stay consistent
// game may start with dots on an obstacle or powerup - has happened
//set invisible dot using alpha instead of white
//instead of two classes for all powerups, just send both manage_Objects and check which is null to determine what to do
//lasers may move at different speeds on both devices
//when other device hits a powerup that should have disappered, crashes game with indexoutofbounds error
//slight delay with movement of objects, depending on the devices used - big delay with moms, minimul delay with justyns
//sentry gun and rapid fire rely on processing speed for timing - might be issues for different phones with different procesing speeds
//reason lag after start game because other connect threads still running??? - i think so cause lag is always on one connecting -COMFIRMED
//convert spped from dp to pixals
// theory - crashes when both players get a powerup or obstacle simaltaneously. Solution - thought that sort of issue was fixed, try using a try...catch statment?
//find if there is a way to check if device recieved data from other device
//if issues with making new obstacles and powerups, have a set size that it should maintan - a set number of obstacles and powerups that there will always be
//PROBLEM - checkinh collision, dot_x and dot_y jut use the middle of the screen - INCORRECT - need actual coordinates
//not enough obstacles and powerups may be caused from the frequent demand for new ones, preventing current ones being made from being completed. may be good idea to include set number of obstacles and powerups, like what I've already done
//for connecting, have all connect threads put in a public array, and when connected, call a method that stops all threads in that array.
//rapid fire image not showing
//sentry gun has limited number of shots?
//may change obstacles and powerups creation to have it chose a completly random location and check if it is on top of boundaries or other objects
//create method in powerupvariables that checks dot size to determine shield size. use getter whenever refrencing shield from other classes


//mode showing three possible powerups you could get from one - shown through 3 images on one powerup
//timer grow and fade out effect
//way to arm yourself
//circular buffer - method so data isn't lost over bluetooth
//STRATEGY!!!!!!
//minor fixes - speed, size, etc.
//fix up spped boost
//many different options for setting up the game - timer, enable speedboost, etc.
//maintain bluetooth connection when phone turns off
//make Constants statically called or variable?
//issue with firing if not moving

//two powerups still in the works

/*
make discoverable
scan
connect



Questions to ask:

- open up multiple bluetooth connections with the same devices
- multithreading with android + with bluetooth
- smoothly open up new layouts
- touch views from thread that did not create view hierarchy
 */