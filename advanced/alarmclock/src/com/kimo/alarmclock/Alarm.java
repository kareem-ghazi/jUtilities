package com.kimo.alarmclock;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Alarm {
    private String name;

    private LocalDateTime time;

    private File ringtone;

    private AudioPlayer audioPlayer;

    public Alarm(String name, LocalDateTime time, File ringtone, AlarmClock alarmClock)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        this.name = name;
        this.time = time;
        this.ringtone = ringtone;
        
        this.audioPlayer = new AudioPlayer(ringtone);
        audioPlayer.setSound(this.ringtone);

        alarmClock.addAlarm(this);
    }

    public void play() throws InterruptedException {
        audioPlayer.getClip().start();
        Thread.sleep(audioPlayer.getClip().getMicrosecondLength() / 1000);
    }

    public void snooze() {
        audioPlayer.getClip().stop();
    }

    public File getRingtone() {
        return ringtone;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

}