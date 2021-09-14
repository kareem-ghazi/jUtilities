package com.kimo.alarmclock;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlarmClock extends Thread {

    private ArrayList<Alarm> alarms;

    private Alarm currentAlarm;

    public AlarmClock() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.alarms = new ArrayList<Alarm>();
    }

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }

    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public void saveAlarms() {

    }

    public void loadAlarms() {

    }

    public static LocalDateTime getCurrentTime(String type) {
        LocalDateTime now = LocalDateTime.now();

        if (type.toUpperCase().equals("FORMAT")) {
            return LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute(),
                    now.getSecond());
        } else if (type.toUpperCase().equals("REGULAR")) {
            return LocalDateTime.now();
        } else {
            return null;
        }
    }

    public Alarm getCurrentAlarm() {
        return currentAlarm;
    }

    @Override
    public void run() {
        LocalDateTime now;
        ArrayList<Alarm> oldAlarms;
        
        do {
            oldAlarms = new ArrayList<Alarm>();
            now = getCurrentTime("FORMAT");

            for (Alarm currentAlarm : this.getAlarms()) {
                if (currentAlarm.getTime().equals(now)) {
                    try {
                        this.currentAlarm = currentAlarm;
                        System.out.println(currentAlarm.getName() + " is playing right now! Type '!snooze' to snooze it");
                        currentAlarm.play();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    oldAlarms.add(currentAlarm);
                    break;
                } else if (currentAlarm.getTime().isBefore(now)) {
                    oldAlarms.add(currentAlarm);
                }
            }

            this.getAlarms().removeAll(oldAlarms);

            try {
                Thread.sleep(850);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!this.getAlarms().isEmpty());
    }
}
