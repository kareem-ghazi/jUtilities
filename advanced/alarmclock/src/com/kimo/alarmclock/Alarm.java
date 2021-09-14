package com.kimo.alarmclock;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Alarm {
    private String name;

    private LocalDateTime time;

    private File ringtone;

    private AudioPlayer audioPlayer;

    public Alarm(String name, LocalDateTime time, File ringtone)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.name = name;
        this.time = time;
        this.ringtone = ringtone;

        this.audioPlayer = new AudioPlayer(ringtone);
    }

    public void play() throws InterruptedException {
        audioPlayer.getClip().loop(Clip.LOOP_CONTINUOUSLY);
        while (audioPlayer.getClip().isRunning()) {
            Thread.sleep(audioPlayer.getClip().getMicrosecondLength() / 1000);
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

}