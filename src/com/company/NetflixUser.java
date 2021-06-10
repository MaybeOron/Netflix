package com.company;
import java.util.Calendar;

public class NetflixUser {

    private final String username;
    private final String password;
    private SmartSeriesDataArray watchedSeriesId;

    private int day;
    private int month;
    private int year;

    public void printCreationDate() { System.out.println(" - Account creation date: " + day + "/" + month + "/" + year); }
    public void printExpDate() { System.out.println(" - Account expiration date: " + day + "/" + month + "/" + (year + 1)); }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public SmartSeriesDataArray getWatchedSeries() {
        return watchedSeriesId;
    }

    public NetflixUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.watchedSeriesId = new SmartSeriesDataArray();

        this.day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        this.month = Calendar.getInstance().get(Calendar.MONTH); month++; // month starts from 0
        this.year = Calendar.getInstance().get(Calendar.YEAR);
    }
}
