package com.dekwin.game;

/**
 * Created by igor on 12.08.17.
 */
public class GameData {
    private int initialCardNumber;
    private int cellsNumber;
    private long throwingTime;
    private long beatingTime;
    private int initialHealth;

    public int getInitialCardNumber() {
        return initialCardNumber;
    }

    public void setInitialCardNumber(int initialCardNumber) {
        this.initialCardNumber = initialCardNumber;
    }

    public int getCellsNumber() {
        return cellsNumber;
    }

    public void setCellsNumber(int cellsNumber) {
        this.cellsNumber = cellsNumber;
    }

    public long getThrowingTime() {
        return throwingTime;
    }

    public void setThrowingTime(long throwingTime) {
        this.throwingTime = throwingTime;
    }

    public long getBeatingTime() {
        return beatingTime;
    }

    public void setBeatingTime(long beatingTime) {
        this.beatingTime = beatingTime;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }
}
