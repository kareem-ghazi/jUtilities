package com.kimo.alarmclock;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        AlarmClockManager.loadAlarmClocks();
        getMainMenu();
    }

    private static void getMainMenu() {
        int choice;
        String clockName;
        AlarmClock clock;

        while (true) {
            AlarmClockManager.loadAlarmClocks();
            printMainMenuOptions();

            System.out.print("-: ");
            choice = scan.nextInt();

            scan.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter alarm clock's name: ");
                    clockName = scan.nextLine();

                    new AlarmClock(clockName);
                    break;
                case 2:
                    System.out.println("Enter clock's name: ");
                    clockName = scan.nextLine();

                    clock = AlarmClockManager.getAlarmClockByName(clockName);
                    if (clock != null) {
                        clock.getFileSave().delete();
                    } else {
                        System.out.println("Alarm clock does not exist, please try again.");
                    }

                    break;
                case 3:
                    System.out.print("Enter clock's name: ");
                    clockName = scan.nextLine();

                    clock = AlarmClockManager.getAlarmClockByName(clockName);
                    if (clock != null ) {
                        AlarmClockMenu.getClockMenu(clock);
                    } else {
                        System.out.println("Alarm clock does not exist, please try again.");
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

    private static void printMainMenuOptions() {
        System.out.println("---------------------");
        System.out.println("1. Create an alarm clock.");
        System.out.println("2. Delete an alarm clock.");
        System.out.println("3. Enter an alarm clock's menu.");
        System.out.println("4. Exit.");
    }
}
