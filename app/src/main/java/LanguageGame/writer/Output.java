package LanguageGame.writer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

import LanguageGame.sharedInstances.ScannerSingleton;
import LanguageGame.parser.WordTranslationDataType;
import LanguageGame.start.Menu;

public class Output {

        private WordTranslationDataType random(List<WordTranslationDataType> list) {
                Random random = new Random();
                int num = random.nextInt(list.size());
                return list.get(num);
        }

        private void question(WordTranslationDataType dt) {
                String rus = dt.getSourceLanguage();
                List<String> eng = new ArrayList<String>();
                List<String> wt = new ArrayList<String>();

                eng = dt.getTranslationLanguage();
                wt = dt.getWordType();

                var userAnswer = new HashSet<String>();
                Scanner scanner = ScannerSingleton.getInstance();
                String answer;
                while (eng.size() > userAnswer.size()) {

                        System.out.println("Translate this word - " + rus);
                        answer = scanner.nextLine();
                        System.out.println(answer);

                        if (userAnswer.contains(answer)) {
                                System.out.println("Duplicate!");
                                continue;
                        }

                        if (eng.contains(answer)) {
                                userAnswer.add(answer);
                                System.out.println("Correct");
                        } else {
                                System.out.println("Incorrect");
                                return;
                        }
                }

        }

        public void asklisted(List<WordTranslationDataType> list) {
                for (WordTranslationDataType s : list) {
                        question(s);
                }
        }

        public void askRandom(List<WordTranslationDataType> list) {
                var dt = random(list);
                question(dt);
        }

}
