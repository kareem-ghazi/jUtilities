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

        AlarmClock kimosAlarmClock = new AlarmClock("kimo");
        
        kimosAlarmClock.loadAlarms();
        kimosAlarmClock.start();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("-: ");
            String userInput = scan.nextLine();

            if (userInput.equals("!alarms")) {
                for (Alarm alarminClock : kimosAlarmClock.getAlarms()) {
                    System.out.println(alarminClock.getName());
                    System.out.println(alarminClock.getTime());
                    System.out.println(alarminClock.getRingtone() + "\n");
                }
            } else if (userInput.equals("!alarmsave")) {
                kimosAlarmClock.saveAlarms();
            } else if (userInput.equals("!exit")) {
                scan.close();
                System.exit(1);
            } else if (userInput.equals("!create")) {
                System.out.println("Enter name: ");
                String name = scan.nextLine();

                System.out.println("Enter year: ");
                int year = scan.nextInt();

                System.out.println("Enter day: ");
                int day = scan.nextInt();

                System.out.println("Enter hour: ");
                int hour = scan.nextInt();

                System.out.println("Enter minute: ");
                int minute = scan.nextInt();

                System.out.println("Enter second: ");
                int second = scan.nextInt();
                
                scan.nextLine();

                System.out.println("Enter ringtone: ");
                File file = new File(scan.nextLine());

                LocalDateTime dateTime = LocalDateTime.of(year, Month.OCTOBER , day, hour, minute, second);

                kimosAlarmClock.addAlarm(new Alarm(name, dateTime, file));
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    private static void loadAlarmClocks() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File folder = new File("src//com//kimo//alarmclock//alarmclocks//");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                new AlarmClock(file.getName());
            }
        }
    }
}
