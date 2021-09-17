package com.kimo.alarmclock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AlarmClock extends Thread {

    private String clockName;

    private ArrayList<Alarm> alarms;

    private Alarm currentAlarm;

    private File fileSave;

    public AlarmClock(String name) {
        this.clockName = name;
        this.alarms = new ArrayList<Alarm>();
        this.fileSave = new File("src//com//kimo//alarmclock//alarmclocks//" + this.clockName + ".txt");

        try {
            fileSave.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        AlarmClockManager.getAlarmClocks().add(this);
    }

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }

    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public String getClockName() {
        return clockName;
    }

    public Alarm getCurrentAlarm() {
        return currentAlarm;
    }

    public File getFileSave() {
        return fileSave;
    }

    public void saveAlarms() {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(fileSave);
            
            for (Alarm alarm : alarms) {
                fileWriter.write(alarm.getName() + " ; " + alarm.getTime() + " ; " + alarm.getRingtone().getPath() + "\n");
            }
    
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadAlarms() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;

        try {
            fileReader = new FileReader(fileSave);
            bufferedReader = new BufferedReader(fileReader);
            this.getAlarms().clear();
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] alarmInformation = line.split(" ; ");

                String name = alarmInformation[0];
                LocalDateTime time = LocalDateTime.parse(alarmInformation[1]);
                File ringtone = new File(alarmInformation[2]);

                alarms.add(new Alarm(name, time, ringtone));
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void run() {
        LocalDateTime now;
        ArrayList<Alarm> oldAlarms;
        int timeElapsed;

        do {
            oldAlarms = new ArrayList<Alarm>();
            now = AlarmClockManager.getCurrentTime("FORMAT");
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
