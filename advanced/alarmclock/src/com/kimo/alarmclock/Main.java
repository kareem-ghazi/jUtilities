package com.kimo.alarmclock;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    private static LocalDateTime now;

    public static void main(String[] args)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        
        AlarmClock alarmClock = new AlarmClock();
        File file = new File("src\\com\\kimo\\alarmclock\\resources\\alarm-sound.wav");
        File file2 = new File("src\\com\\kimo\\alarmclock\\resources\\alarm-sound.wav");
        LocalDateTime dateTime = LocalDateTime.of(2021, Month.SEPTEMBER, 13, 17, 4, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2021, Month.SEPTEMBER, 13, 17, 7, 0);

        Alarm alarm = new Alarm("Deez", dateTime, file, alarmClock);
        Alarm alarm2 = new Alarm("Amogus", dateTime2, file2, alarmClock);

        do {
            now = AlarmClock.refreshCurrentTime("FORMAT");

            for (Alarm currentAlarm : alarmClock.getAlarms()) {
                if (currentAlarm.getTime().equals(now)) {
                    currentAlarm.play();
                    alarmClock.getAlarms().remove(currentAlarm);
                    break;
                }
            }

            Thread.sleep(850);
        } while (!alarmClock.getAlarms().isEmpty());
    }
}
