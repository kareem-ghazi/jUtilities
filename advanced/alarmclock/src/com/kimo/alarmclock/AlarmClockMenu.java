package com.kimo.alarmclock;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;
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
                    scan.nextLine();
                    createAlarm(clock);
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
                    clock.saveAlarms();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
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

            if (getExtensionByStringHandling(validFile.getName()).get().equals("wav")) {
                return validFile;
            } else {
                System.out.println("Invalid file, please try again.");
                System.out.print("-: ");
                filePath = scan.nextLine();
            }
        }
    }

    private static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename).filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
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
