package com.kimo.alarmclock;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AlarmClock {
    private ArrayList<Alarm> alarms;

    public AlarmClock() {
        this.alarms = new ArrayList<Alarm>();

    }

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }

    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public static LocalDateTime refreshCurrentTime(String type) {
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
}
