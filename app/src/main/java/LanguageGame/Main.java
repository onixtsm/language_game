package LanguageGame;

import LanguageGame.parser.*;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        var parser = new CsvParser();

        var file = Main.class.getClassLoader().getResource("words.csv").getFile();
        var list = parser.parseFile(new File(file));

        for (WordTranslationDataType data : list) {
            System.out.println(data);
        }
    }
}
