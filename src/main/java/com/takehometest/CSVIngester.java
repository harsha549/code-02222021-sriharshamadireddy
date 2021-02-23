package com.takehometest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CSVIngester {

	public Long parseCSV(String fileName) throws IOException,CsvException {
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		File file =new File(fileName);
		Long linesRead=null;
		if(!file.exists()) throw new FileNotFoundException("Given fileName "+fileName+" not present");
		try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).build()) {
			String[] columns= reader.readNext();
			List<String[]> r = reader.readAll();
			System.out.println("Column Names ");
			Arrays.stream(columns).forEach(x->System.out.println(x));
			// r.forEach(x -> System.out.println(Arrays.toString(x)));
			linesRead=reader.getLinesRead()-1;
			System.out.println("Lines Read "+(reader.getLinesRead()-1));
			Path path = Paths.get(fileName);
			long bytes=Files.size(path);
			System.out.println(String.format("Filesize in %d bytes", bytes));
			
		}	
		return linesRead;
	}

}
