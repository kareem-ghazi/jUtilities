package com.kimo.alarmclock;

import java.io.File;
import java.time.LocalDateTime;

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

        this.audioPlayer = new AudioPlayer(ringtone);
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

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void incrementTimeElapsed() {
        timeElapsed++;
    }

}