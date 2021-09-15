package com.kimo.alarmclock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        loadAlarmClocks();
        mainMenu();

        // while (true) {
        // System.out.print("-: ");
        // String userInput = scan.nextLine();

        // if (userInput.equals("!alarms")) {
        // System.out.println("Enter the clock's name: ");
        // String userInputClockName = scan.nextLine();

        // for (AlarmClock alarmClock : AlarmClock.getAlarmClocks()) {
        // if (!alarmClock.getClockName().equals(userInputClockName)) {
        // continue;
        // }
        // alarmClock.loadAlarms();
        // System.out.println(alarmClock.getClockName() + " alarm clock: \n");
        // for (Alarm alarm : alarmClock.getAlarms()) {
        // System.out.println(alarm.getName());
        // System.out.println(alarm.getTime());
        // System.out.println(alarm.getRingtone() + "\n");
        // }
        // }
        // } else if (userInput.equals("!alarmsave")) {
        // // kimosAlarmClock.saveAlarms();
        // } else if (userInput.equals("!exit")) {
        // scan.close();
        // System.exit(1);
        // } else if (userInput.equals("!create")) {
        // System.out.println("Enter name: ");
        // String name = scan.nextLine();

        // System.out.println("Enter year: ");
        // int year = scan.nextInt();

        // System.out.println("Enter day: ");
        // int day = scan.nextInt();

        // System.out.println("Enter hour: ");
        // int hour = scan.nextInt();

        // System.out.println("Enter minute: ");
        // int minute = scan.nextInt();

        // System.out.println("Enter second: ");
        // int second = scan.nextInt();

        // scan.nextLine();

        // System.out.println("Enter ringtone: ");
        // File file = new File(scan.nextLine());

        // LocalDateTime dateTime = LocalDateTime.of(year, Month.OCTOBER, day, hour,
        // minute, second);

        // // kimosAlarmClock.addAlarm(new Alarm(name, dateTime, file));
        // } else {
        // System.out.println("Invalid input.");
        // }
        // }
    }

    private static void mainMenu() {
        int choice;
        String clockName;
        AlarmClock clock;

        while (true) {
            loadAlarmClocks();
            System.out.println("---------------------");
            System.out.println("1. Create an alarm clock.");
            System.out.println("2. Delete an alarm clock.");
            System.out.println("3. Enter an alarm clock's menu.");
            System.out.println("4. Exit.");
            System.out.print("-: ");
            choice = scan.nextInt();

            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter alarm clock's name: ");
                    clockName = scan.nextLine();

                    try {
                        new AlarmClock(clockName);
                    } catch (UnsupportedAudioFileException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (LineUnavailableException e1) {
                        e1.printStackTrace();
                    }

                    break;
                case 2:
                    System.out.println("Enter clock's name: ");
                    clockName = scan.nextLine();

                    try {
                        clock = getAlarmClockByName(clockName);                        
                        clock.getFileSave().delete();
                    } catch (Exception e) {
                        System.out.println("Alarm clock does not exist, please try again.");
                    }
                    
                    break;
                case 3:
                    System.out.print("Enter clock's name: ");
                    clockName = scan.nextLine();

                    try {
                        clock = getAlarmClockByName(clockName);
                        clock.loadAlarms();

                        getClockMenu(clock);
                    } catch (NullPointerException e) {
                        System.out.println("Alarm clock does not exist, please try again.\n");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Exited program successfully.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void getClockMenu(AlarmClock clock) {
        int choice;

        while (true) {
            printClockMenu();

            System.out.print("-: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    // createAlarm(clock);
                    break;
                case 2:
                    // deleteAlarm(clock);
                    break;
                case 3:
                    // editAlarm(clock);
                    break;
                case 4:
                    printClockSummary(clock);
                    break;
                case 5:
                    // snoozeRunningAlarm(clock);
                    break;
                case 6:
                    System.out.println("Exited clock menu successfully.");
                    scan.nextLine();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void printClockMenu() {
        System.out.println("---------------------");
        System.out.println("1. Create an alarm.");
        System.out.println("2. Delete an alarm.");
        System.out.println("3. Edit an alarm.");
        System.out.println("4. Print alarm clock's summary.");
        System.out.println("5. Snooze running alarm.");
        System.out.println("6. Exit.");
    }

    private static void printClockSummary(AlarmClock clock) {
        for (Alarm alarm : clock.getAlarms()) {
            System.out.println("Alarm's name: " + alarm.getName());
            System.out.println("Alarm's time: " + alarm.getTime());
            System.out.println("Alarm's ringtone: " + alarm.getRingtone() + "\n");
        }
    }

    private static void loadAlarmClocks() {
        File folder = new File("src//com//kimo//alarmclock//alarmclocks//");
        File[] listOfFiles = folder.listFiles();
        
        AlarmClock.clearAlarmClocks();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    new AlarmClock(file.getName().replace(".txt", ""));
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static AlarmClock getAlarmClockByName(String name) {
        for (AlarmClock alarmClock : AlarmClock.getAlarmClocks()) {
            if (!alarmClock.getClockName().equals(name)) {
                continue;
            }

            return alarmClock;
        }

        return null;
    }
}
