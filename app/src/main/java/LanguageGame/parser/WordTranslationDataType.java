package LanguageGame.parser;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WordTranslationDataType {

        private String sourceLanguage;
        private List<String> translationLanguage = new ArrayList<>();
        private List<String> wordType = new ArrayList<>();

        public void setTranslationLanguage(String s) {
                this.translationLanguage.add(s.strip());
        }

        public void setWordType(String s) {
                this.wordType.add(s.strip());
        }
}
