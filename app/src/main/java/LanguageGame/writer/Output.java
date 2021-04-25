package LanguageGame.writer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

import LanguageGame.sharedInstances.ScannerSingleton;
import LanguageGame.parser.WordTranslationDataType;
import LanguageGame.start.Menu;

import lombok.Data;

@Data
public class Output {

        private int correct;

        private WordTranslationDataType random(List<WordTranslationDataType> list) {
                Random random = new Random();
                int num = random.nextInt(list.size());
                return list.get(num);
        }

        private void question(WordTranslationDataType dt, Menu options) {
                List<String> rus = new ArrayList<String>();
                List<String> eng = new ArrayList<String>();
                List<String> wt = new ArrayList<String>();

                rus = dt.getSourceLanguage();
                eng = dt.getTranslationLanguage();
                wt = dt.getWordType();

                if (options.getMode() == 1) {
                        checkWord(rus, eng);

                } else {
                        checkWord(eng, rus);
                }
                if (options.getWt() == 1) {
                        checkWt(wt);
                }

        }

        private void checkWord(List<String> def, List<String> ans) {
                Random r = new Random();
                var userAnswer = new HashSet<String>();
                String defWord = def.get(r.nextInt(def.size()));
                Scanner scanner = ScannerSingleton.getInstance();
                String answer;
                while (ans.size() > userAnswer.size()) {

                        System.out.println("Translate this word - " + defWord);
                        answer = scanner.nextLine();
                        System.out.println(answer);

                        if (userAnswer.contains(answer)) {
                                System.out.println("Duplicate!");
                                continue;
                        }

                        if (ans.contains(answer)) {
                                userAnswer.add(answer);
                                System.out.println("Correct");
                        } else {
                                System.out.printf("Incorrect!\nCorrect is/are -\n");
                                for (String s : ans) {
                                        System.out.println(" " + s);
                                }
                                return;
                        }
                }
        }

        private void checkWt(List<String> wt) {
                var userAnswer = new HashSet<String>();
                Scanner scanner = ScannerSingleton.getInstance();
                String answer;
                while (wt.size() > userAnswer.size()) {

                        System.out.println("Write word type");
                        answer = scanner.nextLine();
                        System.out.println(answer);

                        if (userAnswer.contains(answer)) {
                                System.out.println("Duplicate!");
                                continue;
                        }

                        if (wt.contains(answer)) {
                                userAnswer.add(answer);
                                System.out.println("Correct");
                        } else {
                                System.out.printf("Incorrect.\nCorrect is/are -\n");

                                for (String s : wt) {
                                        System.out.println(" " + s);
                                }
                                return;
                        }
                }
                this.correct++;
        }

        public void askListed(List<WordTranslationDataType> list, Menu options) {
                for (var s : list) {
                        System.out.println(s);
                        question(s, options);
                }

        }

        public void askRandom(List<WordTranslationDataType> list, Menu options) {
                var dt = random(list);
                question(dt, options);
        }

}
