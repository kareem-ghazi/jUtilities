package com.kimo.alarmclock;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    Clip clip;
    AudioInputStream audioInputStream;
    File file;

    public AudioPlayer(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
        this.clip = AudioSystem.getClip();
        
        clip.open(audioInputStream);
    }

    public Clip getClip() {
        return clip;
    }

}
