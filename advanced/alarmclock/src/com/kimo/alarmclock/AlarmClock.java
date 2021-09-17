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
        this.fileSave = new File("src//com//kimo//alarmclock//alarmclocks//" + this.clockName);

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

    public Alarm getRunningAlarm() {
        return currentAlarm;
    }

    public File getFileSave() {
        return fileSave;
    }

    public Alarm getAlarmByName(String name) {
        for (Alarm alarm : this.alarms) {
            if (alarm.getName().equals(name)) {
                return alarm;
            }
        }

        return null;
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

                if (time.isAfter(AlarmClockManager.getNow("FORMAT"))) {
                    alarms.add(new Alarm(name, time, ringtone));   
                }
            }
            
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void run() {
        LocalDateTime now;
        
        do {
            now = AlarmClockManager.getNow("FORMAT");

            for (Alarm currentAlarm : alarms) {
                if (currentAlarm.getTime().equals(now)) {
                    try {
                        this.currentAlarm = currentAlarm;
                        currentAlarm.play();
                        System.out.print(currentAlarm.getName() + " is running!\n-: ");

                        do {
                            Thread.sleep(1000);
                            currentAlarm.incrementTimeElapsed();
                        } while (currentAlarm.getAudioPlayer().getClip().isRunning());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
                }
            }

            try {
                Thread.sleep(850);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!this.getAlarms().isEmpty());
    }
}
