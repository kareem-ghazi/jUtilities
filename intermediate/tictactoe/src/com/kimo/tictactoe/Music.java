package com.kimo.tictactoe;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
    private Clip clip;

    private AudioInputStream audioInputStream;

    private static final File DEFAULT_MUSIC = new File(
            "D:\\VSCode Workspace\\jUtilities\\intermediate\\tictactoe\\src\\com\\kimo\\tictactoe\\Adventure-320bit.wav");

    public Music() {
        try {
            this.audioInputStream = AudioSystem.getAudioInputStream(Music.DEFAULT_MUSIC.getAbsoluteFile());
            this.clip = AudioSystem.getClip();
            
            this.clip.open(this.audioInputStream);

            this.clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        this.clip.setFramePosition(0);
        this.clip.start();
    }

    public void stop() {
        this.clip.stop();
    }
    
    public Clip getClip() {
        return clip;
    }
}
