package LanguageGame.writer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import LanguageGame.parser.WordTranslationDataType;

public class Output {

        private WordTranslationDataType random(List<WordTranslationDataType> list) {
                Random random = new Random();
                int num = random.nextInt(list.size());
                return list.get(num);
        }

        private void question(WordTranslationDataType dt) {
                String rus = dt.getSourceLanguage();
                List<String> eng = dt.getTranslationLanguage();
                List<String> wt = dt.getWordType();

                Scanner scanner = new Scanner(System.in);

                System.out.println("Translate this word - " + rus);
                String answer = scanner.nextLine();
                int i = 1;
                for (String s : eng) {
                        if (answer == s) {
                                System.out.println("Correct");
                                if (i == eng.size()) {
                                        System.out.println("Write wrod type");
                                        answer = scanner.next();
                                        int j = 0;
                                        for (String w : wt) {
                                                if (answer == s) {
                                                        if (j == wt.size()) {
                                                                System.out.println("Nice");
                                                        } else {
                                                                System.out.println("Write anotherone");
                                                                answer = scanner.next();

                                                        }
                                                } else {
                                                        System.out.println("Incorrect");
                                                }
                                                j++;
                                        }
                                } else {
                                        System.out.println("Write anotherone");
                                        answer = scanner.next();
                                }
                        } else {
                                System.out.println("Incorrect");
                        }
                        i++;

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
