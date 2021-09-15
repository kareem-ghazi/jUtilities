package com.kimo.alarmclock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlarmClock extends Thread {

    private String clockName;

    private static ArrayList<AlarmClock> alarmClocks = new ArrayList<AlarmClock>();

    private ArrayList<Alarm> alarms;

    private Alarm currentAlarm;

    private File fileSave;

    public AlarmClock(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.clockName = name;
        this.alarms = new ArrayList<Alarm>();
        this.fileSave = new File("src//com//kimo//alarmclock//alarmclocks//" + this.clockName + ".txt");
    
        alarmClocks.add(this);
    }

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }

    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public static ArrayList<AlarmClock> getAlarmClocks() {
        return alarmClocks;
    }

    public String getClockName() {
        return clockName;
    }

    public void saveAlarms() throws IOException {
        if (!fileSave.exists()) {
            fileSave.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(fileSave);

        for (Alarm alarm : alarms) {
            fileWriter.write(alarm.getName() + " ; " + alarm.getTime() + " ; "
                    + alarm.getRingtone().getPath() + "\n");
        }

        fileWriter.close();
    }

    public void loadAlarms() throws FileNotFoundException, UnsupportedAudioFileException, LineUnavailableException {
        if (!fileSave.exists()) {
            System.out.println("File does not exist to load alarms from.");
            return;
        }

        FileReader fileReader = new FileReader(fileSave);
        String line;

        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine()) != null) {
                String[] alarmInformation = line.split(" ; ");
                
                String name = alarmInformation[0];
                LocalDateTime time = LocalDateTime.parse(alarmInformation[1]);
                File ringtone = new File(alarmInformation[2]);
                
                alarms.add(new Alarm(name, time, ringtone));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        int timeElapsed;

        do {
            oldAlarms = new ArrayList<Alarm>();
            now = getCurrentTime("FORMAT");
            timeElapsed = 0;

            for (Alarm currentAlarm : alarms) {
                if (currentAlarm.getTime().equals(now)) {
                    try {
                        this.currentAlarm = currentAlarm;
                        currentAlarm.play();
                        System.out.println();
                        do {
                            Thread.sleep(10000);
                            timeElapsed += 10;
                            System.out.println("Time Elapsed: +" + timeElapsed + "s");
                        } while (currentAlarm.getAudioPlayer().getClip().isRunning());
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
