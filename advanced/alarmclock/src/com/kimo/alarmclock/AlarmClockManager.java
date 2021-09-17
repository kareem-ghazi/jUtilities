package com.kimo.alarmclock;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AlarmClockManager {
    private static ArrayList<AlarmClock> alarmClocks = new ArrayList<AlarmClock>();

    private AlarmClockManager() {

    }

    public static ArrayList<AlarmClock> getAlarmClocks() {
        return alarmClocks;
    }

    public static AlarmClock getAlarmClockByName(String name) {
        for (AlarmClock alarmClock : AlarmClockManager.getAlarmClocks()) {
            if (alarmClock.getClockName().equals(name)) {
                return alarmClock;
            }
        }

        return null;
    }

    public static LocalDateTime getNow(String type) {
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

    public static void loadAlarmClocks() {
        File folder = new File("src//com//kimo//alarmclock//alarmclocks//");
        File[] listOfFiles = folder.listFiles();

        AlarmClockManager.getAlarmClocks().clear();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                new AlarmClock(file.getName().replace(".txt", ""));
            }
        }
    }
}
