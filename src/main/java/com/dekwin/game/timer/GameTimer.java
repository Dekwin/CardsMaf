package com.dekwin.game.timer;

import com.dekwin.game.Game;
import com.dekwin.game.GameState;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by igor on 13.08.17.
 */
public class GameTimer {

    private ReadWriteLock rwlock = new ReentrantReadWriteLock();

    private final long TAKING_CARDS_TIME_MS = 5000;
    private final long THROWING_TIME_MS = 30000;
    private final long BEATING_TIME_MS = 30000;
    private final long DISCARD_TIME_MS = 5000;


    private GameState state = GameState.TAKING_CARDS;
    private Game game;

    private Timer timer = new Timer();

    public GameState getState() {
        rwlock.readLock().lock();
        try {
            return state;
        } finally {
            rwlock.readLock().unlock();
        }
    }

    public void setState(GameState state) {
        rwlock.writeLock().lock();
        try {
            this.state = state;
        } finally {
            rwlock.writeLock().unlock();
        }
    }

    public GameTimer(Game game) {
        this.game = game;
    }

    public void start() {
        game.gameStateUpdated(getState(),getMillisForState());
        update();
    }

    private GameState getNextState() {


        switch (getState()) {

            case TAKING_CARDS:

                return GameState.THROWING;

            case THROWING:
                return GameState.BEATING;

            case BEATING:

                return GameState.DISCARD;
            case DISCARD:

                return GameState.TAKING_CARDS;


            default:
                return GameState.TAKING_CARDS;

        }


    }

    private long getMillisForState() {
        switch (getState()) {

            case TAKING_CARDS:

                return TAKING_CARDS_TIME_MS;

            case THROWING:
                return THROWING_TIME_MS;

            case BEATING:

                return BEATING_TIME_MS;
            case DISCARD:

                return TAKING_CARDS_TIME_MS;


            default:
                return TAKING_CARDS_TIME_MS;

        }
    }

//    public void myTimer(final long MAC, final String ipAddress) {
//        GameTimerTask timerTask = new GameTimerTask() {
//
//            @Override
//            public void run() {
//
//                System.out.println("MAC: " + MAC + "ipAddress:" + ipAddress);
//                update();
//            }
//        };
//        timer = new Timer();
//        timer.schedule(timerTask, 1000);
//
//    }

    private void update() {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
               // System.out.println("Updated timer");


                setState(getNextState());


                update();
            }
        };
        timer.cancel();
        timer = new Timer();
        timer.schedule(timerTask, getMillisForState());
    }
}
