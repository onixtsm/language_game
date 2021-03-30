package LanguageGame.writer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import LanguageGame.parser.WordTranslationDataType;

public class Output {
	
	public WordTranslationDataType random(List<WordTranslationDataType> list) {
		Random random = new Random();
		int num = random.nextInt(list.size());
		return list.get(num);
	}

	public void question(WordTranslationDataType dt) {
		String rus = dt.getSourceLanguage();
		String eng = dt.getTranslationLanguage();
		String wt = dt.getWordType();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Translate this word - " + rus);
		String answer = scanner.nextLine();
		if (answer == eng) {
			System.out.println("Correct");
			System.out.println("Write rod type");
			answer = scanner.next();
			if (answer == wt) {
				System.out.println("Nice");
			} else {
				System.out.println("Not correct. Correct is - " + eng);
		}
		} else {
			System.out.println("Not correct. Correct is - " + eng);
		}
	}
}
