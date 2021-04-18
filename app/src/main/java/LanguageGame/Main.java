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

                // for (WordTranslationDataType data : list) {
                // System.out.println(data);
                // }
                var writer = new Output();
                writer.askListed(list, start);

        }
}
