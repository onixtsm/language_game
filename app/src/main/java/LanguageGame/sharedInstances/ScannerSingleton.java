package LanguageGame.sharedInstances;

import java.util.Scanner;

public class ScannerSingleton {
        private static Scanner scanner = new Scanner(System.in);

        private ScannerSingleton() {
        }

        public static Scanner getInstance() {
                return scanner;
        }
}
