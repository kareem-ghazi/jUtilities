package com.kimo.alarmclock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class AlarmClock extends Thread {

    private String clockName;

    private ArrayList<Alarm> alarms;

    private Alarm currentAlarm;

    private File fileSave;

    private boolean isRunning;

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

    public void terminate() {
        isRunning = false;
    }

    public void saveAlarms() {
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(fileSave);

            for (Alarm alarm : alarms) {
                fileWriter.write(
                        alarm.getName() + " ; " + alarm.getTime() + " ; " + alarm.getRingtone().getPath() + " ; " + alarm.getRepeat() + "\n");
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

        String name;
        LocalDateTime time = LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0, 0);
        File ringtone;
        int repeat;

        try {
            fileReader = new FileReader(fileSave);
            bufferedReader = new BufferedReader(fileReader);

            this.getAlarms().clear();

            while ((line = bufferedReader.readLine()) != null) {
                String[] alarmInformation = line.split(" ; ");

                name = alarmInformation[0];

                try {
                    time = LocalDateTime.parse(alarmInformation[1]);
                } catch (DateTimeParseException e) {
                    System.out.println("An error has occured, please update the time for '" + name + "'.");
                }

                ringtone = new File(alarmInformation[2]);
                repeat = Integer.parseInt(alarmInformation[3]);

                if (time.isAfter(AlarmClockManager.getNow("FORMAT"))) {
                    alarms.add(new Alarm(name, time, ringtone, repeat));
                } else if (time.isEqual(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0, 0))) {
                    System.out.println("An error has occured, please update the time for '" + name + "'.");
                    alarms.add(new Alarm(name, time, ringtone, repeat));
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
        isRunning = true;

        while (isRunning) {
            now = AlarmClockManager.getNow("FORMAT");

            for (Alarm currentAlarm : alarms) {
                if (currentAlarm.getTime().equals(now)) {
                    try {
                        this.currentAlarm = currentAlarm;
                        currentAlarm.play();
                        System.out.print(currentAlarm.getName() + " is running!\n-: ");

                        if (currentAlarm.getRepeat() >= 1) {
                            currentAlarm.setTime(currentAlarm.getTime().plusDays(1));
                            currentAlarm.setRepeat(currentAlarm.getRepeat() - 1);
                        }

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
        }
    }
}
