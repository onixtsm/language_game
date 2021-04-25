package LanguageGame;

import LanguageGame.parser.*;
import LanguageGame.writer.*;
import LanguageGame.start.*;

import java.io.File;

public class Main {

        public static void main(String[] args) {

                var start = new Menu();
                start.showMenu();

                var parser = new CsvParser();

                var file = Main.class.getClassLoader().getResource("words.csv").getFile();
                var list = parser.parseFile(new File(file));

                var writer = new Output();
                for (int i = 0; i < start.getLength(); i++) {
                        writer.askRandom(list, start);
                }
                System.out.printf("You answerd %d out of %d", writer.getCorrect(), start.getLength());

        }
}
