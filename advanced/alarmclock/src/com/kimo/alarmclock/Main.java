package com.kimo.alarmclock;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    public static void main(String[] args)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

        AlarmClock kimosAlarmClock = new AlarmClock();

        File file = new File("src\\com\\kimo\\alarmclock\\resources\\alarm-sound.wav");
        LocalDateTime dateTime = LocalDateTime.of(2021, Month.SEPTEMBER, 14, 15, 6, 45);

        File file2 = new File("src\\com\\kimo\\alarmclock\\resources\\ALARMCLOCK.wav");
        LocalDateTime dateTime2 = LocalDateTime.of(2021, Month.SEPTEMBER, 14, 15, 9, 0);
        
        File file3 = new File("src\\com\\kimo\\alarmclock\\resources\\Air-raid-siren.wav");
        LocalDateTime dateTime3 = LocalDateTime.of(2021, Month.SEPTEMBER, 14, 15, 12, 0);

        Alarm alarm = new Alarm("SAT", dateTime, file);
        Alarm alarm2 = new Alarm("Work", dateTime2, file2);
        Alarm alarm3 = new Alarm("Water", dateTime3, file3);

        kimosAlarmClock.addAlarm(alarm);
        kimosAlarmClock.addAlarm(alarm2);
        kimosAlarmClock.addAlarm(alarm3);

        kimosAlarmClock.start();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("-: ");
            String userInput = scan.nextLine();

            if (userInput.equals("!snooze")) {
                kimosAlarmClock.getCurrentAlarm().snooze();
            } else if (userInput.equals("!exit")) {
                System.out.println("Exited program successfully.");
                scan.close();
                System.exit(0);
            } else {
                System.out.println("Invalid input.");
            }
        }
    }
}
