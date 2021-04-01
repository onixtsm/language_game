package LanguageGame.parser;

import lombok.Data;
import java.util.List;

@Data
public class WordTranslationDataType {

        private String sourceLanguage;
        private List<String> translationLanguage;
        private List<String> wordType;

        public void setTranslationLanguage(String s) {
                System.out.println(this);
                this.translationLanguage.add(s);
        }

        public void setWordType(String s) {
                this.wordType.add(s);
        }
}
