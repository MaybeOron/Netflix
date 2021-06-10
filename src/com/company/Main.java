package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SmartUsersArray users = new SmartUsersArray();
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner, users);
    }

    public static void mainMenu(Scanner scanner, SmartUsersArray users) {
        System.out.println("~~~~ Netflix ~~~~");
        System.out.println("Choose an option: ");
        System.out.println("1. Create a new user.");
        System.out.println("2. log in.");
        System.out.print("--> ");
        int mainMenuChoice = scanner.nextInt();
        switch (mainMenuChoice) {
            case 1:
                System.out.print("Choose a username: ");
                String usernameInput = scanner.next();

                for (int i = 0; i < users.getElementCount(); i++) {
                    if (users.getElement(i).getUsername().equals(usernameInput)) {
                        System.out.println("Name already taken! choose another name.");
                        mainMenu(scanner, users);
                        break;
                    }
                }
                System.out.print("Choose a password [min 6 chars, a letter and a num]: ");
                String passwordInput = scanner.next();
                boolean containsDigit = false, containsLetter = false;
                for (int j = 0; j < passwordInput.length(); j++) {
                    if (Character.isDigit(passwordInput.charAt(j))) {
                        containsDigit = true;
                    }
                    if (Character.isLetter(passwordInput.charAt(j))) {
                        containsLetter = true;
                    }
                }
                if (containsDigit && containsLetter && passwordInput.length() >= 6) {
                    users.insert(new NetflixUser(usernameInput, passwordInput));
                    System.out.println("New user Added!");
                    System.out.println();
                    mainMenu(scanner, users);
                    break;
                } else {
                    System.out.println("bad password! try again.");
                    mainMenu(scanner, users);
                }

            case 2:
                System.out.print("Enter username: ");
                String usernameLogIn = scanner.next();
                System.out.print("Enter password: ");
                String passwordLogIn = scanner.next();

                boolean userExist = false;
                for (int i = 0; i < users.getElementCount(); i++) {
                    if (users.getElement(i).getUsername().equals(usernameLogIn) &&
                            users.getElement(i).getPassword().equals(passwordLogIn)) {
                        System.out.println("Welcome " + usernameLogIn + ".");
                        userExist = true;
                        System.out.println();
                        NetflixUser loggedUser = null;
                        for (int t = 0; t < users.getElementCount(); t++) {
                            if (users.getElement(i).getUsername().equals(usernameLogIn)) {
                                loggedUser = users.getElement(i);
                            }
                        }
                        userMenu(scanner, loggedUser, users);
                    }
                }

                if (!userExist) {
                    System.out.println("Account does not exist, returning to main menu.");
                    mainMenu(scanner, users);
                }
                break;

            default:
                System.out.println("Not a valid option, try again");
                mainMenu(scanner, users);
                break;
        }
    }

    public static void userMenu(Scanner scanner, NetflixUser loggedUser, SmartUsersArray users) {

        System.out.println("1. Print all shows.");
        System.out.println("2. Print all shows you are watching.");
        System.out.println("3. Show user details.");
        System.out.println("4. Choose a series to watch.");
        System.out.println("5. Exit.");
        System.out.print("--> ");
        int userChoice = scanner.nextInt();
        Series[] allSeries = SeriesBank.getSeriesBank();

        switch (userChoice) {
            case 1:
                for (int i = 0; i < allSeries.length; i++) {
                    System.out.println((i + 1) + "." + allSeries[i].getSeriesName());
                }
                System.out.println(" ~ returning to menu");
                userMenu(scanner, loggedUser, users);
                break;
            case 2:
                boolean watchedSomething = false;
                for (int j = 0; j < loggedUser.getWatchedSeries().getElementCount(); j++) { // looking for a series
                    if (loggedUser.getWatchedSeries().getElement(j).getEpIndex() > 0) {
                        watchedSomething = true;
                        System.out.print("watching " + loggedUser.getWatchedSeries().getElement(j).getSName());
                        System.out.println(" at episode " + loggedUser.getWatchedSeries().getElement(j).getEpIndex());
                    }
                }
                if (!watchedSomething) {
                    System.out.println("You have not watched any series");
                }
                System.out.println("~~ returning to user menu");
                userMenu(scanner, loggedUser, users);
                break;
            //break; // case 2
            case 3:
                int totalEpWatched = 0;
                int numOfSeriesDone = 0;
                int numOfSeriesStartedWatching = 0;

                // series done + num of series watching now
                for (int r = 0; r < loggedUser.getWatchedSeries().getElementCount(); r++) {
                    for (int t = 0; t < allSeries.length; t++) {
                        if (loggedUser.getWatchedSeries().getElement(r).getSName().equals(allSeries[t].getSeriesName())) {
                            if (loggedUser.getWatchedSeries().getElement(r).getEpIndex() == allSeries[t].getEpisodes().length) {
                                numOfSeriesDone++;
                            }
                            if (loggedUser.getWatchedSeries().getElement(r).getEpIndex() < allSeries[t].getEpisodes().length
                                    && loggedUser.getWatchedSeries().getElement(r).getEpIndex() > 0) {
                                numOfSeriesStartedWatching++;
                            }
                        }
                    }
                }

                // total episodes watched
                for (int r = 0; r < loggedUser.getWatchedSeries().getElementCount(); r++) {
                    totalEpWatched += loggedUser.getWatchedSeries().getElement(r).getEpIndex();
                }
                loggedUser.printCreationDate();
                loggedUser.printExpDate();
                System.out.println(" - You have " + numOfSeriesStartedWatching + " Series on your watch list");
                System.out.println(" - You ended " + numOfSeriesDone + " Series");
                System.out.println(" - You have watched a total of " + totalEpWatched + " episode(s).");
                System.out.println("~~ returning to user menu");
                System.out.println();
                userMenu(scanner, loggedUser, users);
                break;

            //  break; //case 3
            case 4:
                boolean isSeriesExist = false;
                System.out.print("Enter series name to watch: ");
                String chosenSeries = scanner.next();
                for (int i = 0; i < allSeries.length; i++) {
                    if (chosenSeries.equals(allSeries[i].getSeriesName())) {
                        isSeriesExist = true;

                        // current episode on chosen series
                        for (int r = 0; r < loggedUser.getWatchedSeries().getElementCount(); r++) {
                            if (loggedUser.getWatchedSeries().getElement(r).getSName().equals(chosenSeries)) {
                                if (loggedUser.getWatchedSeries().getElement(r).getEpIndex() > 0) {
                                    System.out.println(" -- You watched " + loggedUser.getWatchedSeries().getElement(r).getEpIndex() + " episode(s).");
                                }
                            }
                        }

                        // print episode list of current series
                        System.out.println("Chosen series episode list:");
                        for (int k = 0; k < allSeries[i].getEpisodes().length; k++) {
                            System.out.print(k + 1 + ". ");
                            allSeries[i].getEpisodes()[k].printEpisodeDetails();
                        }

                        boolean isEpFound = false;

                        System.out.println("~~~");
                        System.out.print("Enter episode name to watch: ");
                        String userEpName = scanner.next();

                        for (int k = 0; k < allSeries[i].getEpisodes().length; k++) {
                            if (userEpName.equals(allSeries[i].getEpisodes()[k].getEpisodeName())) {
                                SeriesDataType newData = new SeriesDataType(userEpName, chosenSeries);
                                loggedUser.getWatchedSeries().insert(newData);
                                for (int w = 0; w < loggedUser.getWatchedSeries().getElementCount(); w++) {
                                    if (loggedUser.getWatchedSeries().getElement(w).getSName().equals(chosenSeries)) {
                                        if (loggedUser.getWatchedSeries().getElement(w).getEpIndex() < allSeries[i].getEpisodes().length) { // number of episodes
                                            loggedUser.getWatchedSeries().getElement(w).addEpIndex();
                                        }
                                        isEpFound = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (isEpFound) {
                            break; // exiting big loop
                        } else {
                            System.out.println("Episode not found.");
                        }
                    }
                }

                if (!isSeriesExist) {
                    System.out.println(chosenSeries + " does not exists.");
                }
                userMenu(scanner, loggedUser, users);
                break; // case 4 break
            case 5:

                System.out.println("Returning to main menu");
                System.out.println();
                mainMenu(scanner, users);
                break;
            default:
                System.out.println("Not a valid option, try again.");
                System.out.println();
                userMenu(scanner, loggedUser, users);
        }
    }
}
