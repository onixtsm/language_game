package LanguageGame.start;

import java.util.InputMismatchException;
import java.util.Scanner;
import LanguageGame.sharedInstances.ScannerSingleton;

import lombok.Data;

@Data
public class Menu {

        private int mode;
        private int wt;

        public void showMenu() {
                Scanner scanner = ScannerSingleton.getInstance();
                int i = 1;
                while (true) {
                        if (i % 50 == 0) {
                                System.out.println("Are you fucking kiding me????");
                        }

                        System.out.printf(
                                        "Hello\nPress 1 to play Russian -> English\nPress 2 to play English -> Russian");
                        try {
                                int option = scanner.nextInt();
                                if (checkInput(option)) {
                                        this.mode = option;
                                        break;
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Please, type integer");
                        }
                        i++;
                }

                while (true) {
                        System.out.printf("Hello\nPress 1 to play with wt types\nPress 2 to play without wt mode");
                        try {
                                int option = scanner.nextInt();
                                if (checkInput(option)) {
                                        this.wt = option;
                                        break;
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Please, type integer");
                        }
                }


        }

        private boolean checkInput(int option) {
                return (option != 1 && option != 2) ? false : true;
        }

}
