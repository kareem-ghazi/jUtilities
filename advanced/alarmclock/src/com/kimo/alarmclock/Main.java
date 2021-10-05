package com.kimo.alarmclock;

import java.util.Scanner;

import com.kimo.alarmclock.utils.FormatUtils;
import com.kimo.alarmclock.utils.InputUtils;

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
            choice = InputUtils.getValidInput(scan, "INT");
            
            switch (choice) {
                case 1:
                    scan.nextLine();
                    System.out.print("Enter alarm clock's name: ");
                    clockName = scan.nextLine();

                    if (AlarmClockManager.getAlarmClockByName(clockName) == null) {
                        new AlarmClock(clockName);
                    } else if (AlarmClockManager.getAlarmClockByName(clockName) != null) {
                        System.out.println("Alarm clock exists, please try a different name.");
                    }
                    
                    break;
                case 2:
                    scan.nextLine();
                    System.out.print("Enter clock's name: ");
                    clockName = scan.nextLine();

                    clock = AlarmClockManager.getAlarmClockByName(clockName);
                    if (clock != null) {
                        clock.getFileSave().delete();
                    } else {
                        System.out.println("Alarm clock does not exist, please try again.");
                    }

                    break;
                case 3:
                    scan.nextLine();
                    System.out.print("Enter clock's name: ");
                    clockName = scan.nextLine();

                    clock = AlarmClockManager.getAlarmClockByName(clockName);
                    if (clock != null) {
                        System.out.println("Successfully logged in!");
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
        System.out.println(FormatUtils.getSeparator("QUARTER") + " (MAIN MENU) " + FormatUtils.getSeparator("QUARTER"));
        System.out.println("1. Create an alarm clock.");
        System.out.println("2. Delete an alarm clock.");
        System.out.println("3. Enter an alarm clock's menu.");
        System.out.println("4. Exit.");
    }
}
