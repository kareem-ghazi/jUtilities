package com.kimo.alarmclock;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import com.kimo.alarmclock.utils.FormatUtils;
import com.kimo.alarmclock.utils.InputUtils;

public class AlarmClockMenu {
    private static Scanner scan = new Scanner(System.in);

    public static void getClockMenu(AlarmClock clock) {
        int choice;

        clock.start();

        while (true) {
            clock.loadAlarms();
            printClockMenuOptions(clock);

            System.out.print("-: ");
            choice = InputUtils.getValidInput(scan, "INT");

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
                    System.out.println("Exited clock menu and stopped clock successfully.");
                    clock.saveAlarms();
                    clock.terminate();
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
        String name = validateName(scan.nextLine(), clock);

        System.out.print("Enter alarm's date (yyyy-MM-dd;hh:mm:ss): ");
        LocalDateTime date = validateDate(scan.nextLine().split(";"));

        System.out.print("Enter alarm's ringtone (File path): ");
        File file = validateFile(scan.nextLine());

        System.out.print("Enter how many times to repeat: ");
        int repeat = InputUtils.getValidInput(scan, "INT");

        clock.addAlarm(new Alarm(name, date, file, repeat));

        System.out.println("Successfully created alarm.");
    }

    private static String validateName(String name, AlarmClock clock) {
        while (true) {
            if (clock.getAlarmByName(name) == null) {
                return name;
            } else if (clock.getAlarmByName(name) != null) {
                System.out.println("Alarm exists, please try a different name.");
                System.out.print("-: ");
                name = scan.nextLine();
            }
        }
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
        System.out.print("Enter alarm's name: ");
        String alarmName = scan.nextLine();

        Alarm alarm = clock.getAlarmByName(alarmName);

        if (alarm != null) {
            System.out.println("Successfully deleted alarm.");
            clock.getAlarms().remove(alarm);
        } else {
            System.out.println("Alarm does not exist.");
        }
    }

    private static void getAlarmSummary(AlarmClock clock) {
        System.out.print("Enter alarm's name: ");
        String alarmName = scan.nextLine();

        Alarm alarm = clock.getAlarmByName(alarmName);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");

        if (alarm != null) {
            System.out.println(FormatUtils.getSeparator("QUARTER") + " (ALARM: " + alarm.getName() + ") "
                    + FormatUtils.getSeparator("QUARTER"));
            System.out.println("Time: " + alarm.getTime().format(dateTimeFormatter));
            System.out.println("Ringtone: " + alarm.getRingtone().getName());
            System.out.println("Remaining repeats: " + alarm.getRepeat());
            System.out.println("Time left until alarm rings: " + alarm.calculateRemainingTime());
            System.out.println();
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
            printEditAlarmMenuOptions(alarm);
            System.out.print("-: ");
            choice = InputUtils.getValidInput(scan, "INT");

            switch (choice) {
                case 1:
                    scan.nextLine();
                    System.out.print("Enter alarm's new name: ");
                    String newName = scan.nextLine();

                    if (clock.getAlarmByName(newName) == null) {
                        alarm.setName(newName);
                    } else if (clock.getAlarmByName(newName) != null) {
                        System.out.println("Alarm exists, please try a different name.");
                    }
                    break;
                case 2:
                    scan.nextLine();
                    System.out.print("Enter alarm's date (yyyy-MM-dd;hh:mm:ss): ");
                    LocalDateTime date = validateDate(scan.nextLine().split(";"));

                    alarm.setTime(date);
                    break;
                case 3:
                    scan.nextLine();
                    System.out.print("Enter alarm's ringtone (File path): ");
                    File ringtone = validateFile(scan.nextLine());

                    alarm.setRingtone(ringtone);
                    break;
                case 4:
                    scan.nextLine();
                    System.out.print("Enter how many times to repeat the alarm: ");
                    int repeat = InputUtils.getValidInput(scan, "INT");

                    alarm.setRepeat(repeat);
                case 5:
                    System.out.println("Exited and saved alarm successfully.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void printEditAlarmMenuOptions(Alarm alarm) {
        System.out.println(FormatUtils.getSeparator("QUARTER") + " (EDITING ALARM: " + alarm.getName() + ") "
                + FormatUtils.getSeparator("QUARTER"));
        System.out.println("1. Edit name.");
        System.out.println("2. Edit date and time.");
        System.out.println("3. Edit ringtone.");
        System.out.println("4. Edit how many times to repeat.");
        System.out.println("5. Exit.");
    }

    private static void printClockMenuOptions(AlarmClock clock) {
        System.out.println(FormatUtils.getSeparator("QUARTER") + " (CLOCK: " + clock.getClockName() + ") "
                + FormatUtils.getSeparator("QUARTER"));
        System.out.println("1. Create an alarm.");
        System.out.println("2. Delete an alarm.");
        System.out.println("3. Edit an alarm.");
        System.out.println("4. Print alarm clock's summary.");
        System.out.println("5. Get and print alarm summary.");
        System.out.println("6. Snooze running alarm.");
        System.out.println("7. Exit.");
    }

    private static void printClockSummary(AlarmClock clock) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");

        if (!clock.getAlarms().isEmpty()) {
            for (Alarm alarm : clock.getAlarms()) {
                System.out.println(FormatUtils.getSeparator("QUARTER") + " (ALARM: " + alarm.getName() + ") "
                        + FormatUtils.getSeparator("QUARTER"));
                System.out.println("Time: " + alarm.getTime().format(dateTimeFormatter));
                System.out.println("Ringtone: " + alarm.getRingtone());
                System.out.println("Remaining repeats: " + alarm.getRepeat());
                System.out.println();
            }
        } else if (clock.getAlarms().isEmpty()) {
            System.out.println("There are no alarms in the clock.");
        }
    }
}
