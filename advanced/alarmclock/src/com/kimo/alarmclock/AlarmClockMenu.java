package com.kimo.alarmclock;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class AlarmClockMenu {
    private static Scanner scan = new Scanner(System.in);

    public static void getClockMenu(AlarmClock clock) {
        int choice;

        clock.start();

        while (true) {
            clock.loadAlarms();
            printClockMenuOptions();

            System.out.print("-: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    scan.nextLine();
                    createAlarm(clock);
                    break;
                case 2:
                    scan.nextLine();
                    deleteAlarm(clock);
                    break;
                case 3:
                    scan.nextLine();
                    editAlarm(clock);
                    break;
                case 4:
                    printClockSummary(clock);
                    break;
                case 5:
                    scan.nextLine();
                    getAlarmSummary(clock);
                    break;
                case 6:
                    snoozeRunningAlarm(clock);
                    break;
                case 7:
                    System.out.println("Exited clock menu successfully.");
                    clock.saveAlarms();
                    scan.nextLine();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            clock.saveAlarms();
        }
    }

    private static void createAlarm(AlarmClock clock) {
        System.out.print("Enter alarm's name: ");
        String name = scan.nextLine();

        System.out.print("Enter alarm's date (yyyy-MM-dd;hh:mm:ss): ");
        LocalDateTime date = validateDate(scan.nextLine().split(";"));

        System.out.print("Enter alarm's ringtone (File path): ");
        File file = validateFile(scan.nextLine());

        clock.addAlarm(new Alarm(name, date, file));

        System.out.println("Successfully added alarm.");
    }

    private static LocalDateTime validateDate(String[] splitDate) {
        String date;
        LocalDateTime validDate;

        while (true) {
            try {
                date = splitDate[0] + "T" + splitDate[1];
                validDate = LocalDateTime.parse(date);
                return validDate;
            } catch (Exception e) {
                System.out.println("Invalid date, please try again.");
                System.out.print("-: ");
                splitDate = scan.nextLine().split(";");
            }
        }
    }

    private static File validateFile(String filePath) {
        File validFile;

        while (true) {
            validFile = new File(filePath);
            
            if (getExtensionByString(validFile.getName()).isPresent()
                    && getExtensionByString(validFile.getName()).get().equals("wav")) {
                return validFile;
            } else {
                System.out.println("Invalid file, please try again.");
                System.out.print("-: ");
                filePath = scan.nextLine();
            }
        }
    }

    private static Optional<String> getExtensionByString(String filename) {
        return Optional.ofNullable(filename).filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    private static void snoozeRunningAlarm(AlarmClock clock) {
        if (clock.getRunningAlarm() != null) {
            clock.getRunningAlarm().snooze();

            System.out.println("Snoozed: " + clock.getRunningAlarm().getName());
            System.out.println("Time Elapsed: +" + clock.getRunningAlarm().getTimeElapsed() + "s");
        } else {
            System.out.println("There's no running alarm currently.");
        }
    }

    private static void deleteAlarm(AlarmClock clock) {
        System.out.println("Enter alarm's name: ");
        String alarmName = scan.nextLine();

        Alarm alarm = clock.getAlarmByName(alarmName);

        if (alarm != null) {
            clock.getAlarms().remove(alarm);
        } else {
            System.out.println("Alarm does not exist.");
        }
    }

    private static void getAlarmSummary(AlarmClock clock) {
        System.out.println("Enter alarm's name: ");
        String alarmName = scan.nextLine();

        Alarm alarm = clock.getAlarmByName(alarmName);

        if (alarm != null) {
            System.out.println("Alarm's Name: " + alarm.getName());
            System.out.println("Alarm's Time: " + alarm.getTime());
            System.out.println("Alarm's Ringtone: " + alarm.getRingtone().getName());
            System.out.println();
            System.out.println("Time left until alarm rings: " + alarm.calculateRemainingTime());
        } else {
            System.out.println("Alarm does not exist.");
        }
    }

    private static void editAlarm(AlarmClock clock) {
        int choice;

        System.out.print("Enter alarm's name: ");
        String oldName = scan.nextLine();

        Alarm alarm = clock.getAlarmByName(oldName);

        if (alarm == null) {
            System.out.println("Alarm does not exist.");
            return;
        }

        while (true) {
            printEditAlarmMenuOptions();
            System.out.print("-: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter alarm's new name: ");
                    String newName = scan.nextLine();

                    alarm.setName(newName);
                    break;
                case 2:
                    System.out.print("Enter alarm's date (yyyy-MM-dd;hh:mm:ss): ");
                    LocalDateTime date = validateDate(scan.nextLine().split(";"));

                    alarm.setTime(date);
                    break;
                case 3:
                    System.out.print("Enter alarm's ringtone (File path): ");
                    File ringtone = validateFile(scan.nextLine());

                    alarm.setRingtone(ringtone);
                    break;
                case 4:
                    System.out.println("Exited and saved alarm successfully.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void printEditAlarmMenuOptions() {
        System.out.println("---------------------");
        System.out.println("1. Edit name.");
        System.out.println("2. Edit date and time.");
        System.out.println("3. Edit ringtone.");
        System.out.println("4. Exit.");
    }

    private static void printClockMenuOptions() {
        System.out.println("---------------------");
        System.out.println("1. Create an alarm.");
        System.out.println("2. Delete an alarm.");
        System.out.println("3. Edit an alarm.");
        System.out.println("4. Print alarm clock's summary.");
        System.out.println("5. Get and print alarm summary.");
        System.out.println("6. Snooze running alarm.");
        System.out.println("7. Exit.");
    }

    private static void printClockSummary(AlarmClock clock) {
        for (Alarm alarm : clock.getAlarms()) {
            System.out.println("Alarm's name: " + alarm.getName());
            System.out.println("Alarm's time: " + alarm.getTime());
            System.out.println("Alarm's ringtone: " + alarm.getRingtone() + "\n");
        }
    }
}
