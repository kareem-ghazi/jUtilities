package com.kimo.alarmclock;

import java.util.Scanner;

public class AlarmClockMenu {
    private static Scanner scan = new Scanner(System.in);

    public static void getClockMenu(AlarmClock clock) {
        int choice;

        while (true) {
            printClockMenuOptions();

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

    public static void printClockMenuOptions() {
        System.out.println("---------------------");
        System.out.println("1. Create an alarm.");
        System.out.println("2. Delete an alarm.");
        System.out.println("3. Edit an alarm.");
        System.out.println("4. Print alarm clock's summary.");
        System.out.println("5. Snooze running alarm.");
        System.out.println("6. Exit.");
    }

    public static void printClockSummary(AlarmClock clock) {
        for (Alarm alarm : clock.getAlarms()) {
            System.out.println("Alarm's name: " + alarm.getName());
            System.out.println("Alarm's time: " + alarm.getTime());
            System.out.println("Alarm's ringtone: " + alarm.getRingtone() + "\n");
        }
    }
}
