package LanguageGame.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.Reader;
import java.util.ArrayList;
import java.io.File;

import com.opencsv.CSVReader;

public class CsvParser {

	public List<WordTranslationDataType> parseFile(File file) {
		try {
			FileReader fileReader = new FileReader(file);
			List<String[]> lines =  readAll(fileReader);
 	           var list = new ArrayList<WordTranslationDataType>();
        	    for (String[] line : lines) {
                	WordTranslationDataType data = map(line);
                	list.add(data);
		    }
		    return list;
            	} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private List<String[]> readAll(Reader reader) throws IOException {
		CSVReader csvReader = new CSVReader(reader);
		List<String[]> list = csvReader.readAll();
		reader.close();
		csvReader.close();
		return list;
	}

	private WordTranslationDataType map(String[] line) {
		String source = line[0];
		String[] translated = line[1].split("(;)|(,)");
		String[] type = line[2].split("(;)|(,)");
		var to = new WordTranslationDataType();

	        to.setSourceLanguage(source);

		for (String s : translated) {
        		to.setTranslationLanguage(s);
		}
		for (String s : type) {
        		to.setWordType(s);
		}

		return to;
	}
	
}
