package com.kimo.alarmclock;

import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.sound.sampled.Clip;

public class Alarm {
    private String name;

    private int timeElapsed;

    private LocalDateTime time;

    private File ringtone;

    private AudioPlayer audioPlayer;

    public Alarm(String name, LocalDateTime time, File ringtone) {

        this.name = name;
        this.time = time;
        this.ringtone = ringtone;

        this.audioPlayer = new AudioPlayer(ringtone, this);
    }

    public void play() {
        audioPlayer.getClip().loop(Clip.LOOP_CONTINUOUSLY);
        while (audioPlayer.getClip().isRunning()) {
            try {
                Thread.sleep(audioPlayer.getClip().getMicrosecondLength() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void snooze() {
        audioPlayer.getClip().stop();
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public File getRingtone() {
        return ringtone;
    }

    public void setRingtone(File ringtone) {
        this.ringtone = ringtone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void incrementTimeElapsed() {
        timeElapsed++;
    }

    public String calculateRemainingTime() {
        // Calucalte time difference in milliseconds
        LocalDateTime tempDateTime = LocalDateTime.from(AlarmClockManager.getNow("FORMAT"));

        long years = tempDateTime.until(getTime(), ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears(years);

        long months = tempDateTime.until(getTime(), ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(months);

        long days = tempDateTime.until(getTime(), ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(days);

        long hours = tempDateTime.until(getTime(), ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(hours);

        long minutes = tempDateTime.until(getTime(), ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes(minutes);

        long seconds = tempDateTime.until(getTime(), ChronoUnit.SECONDS);

        return years + " years, " + months + " months, " + days + " days, " + hours + " hours, " + minutes
                + " minutes, " + seconds + " seconds.";
    }

}