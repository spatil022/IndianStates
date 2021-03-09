package com.blz.codeanalyszer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CodeAnalyser {
		static int namOfEateries = 0;
		public int loadIndiaCodeData(String csvFilePath) throws CodeAnalyserException {
	        try {
	            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
	            CsvToBeanBuilder<IndiaCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
	            csvToBeanBuilder.withType(IndiaCodeCSV.class);
	            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
	            CsvToBean<IndiaCodeCSV> csvToBean = csvToBeanBuilder.build();
	            Iterator<IndiaCodeCSV> codeCSVIterator = csvToBean.iterator();;
	            while (codeCSVIterator.hasNext()) {
	                namOfEateries++;
	                IndiaCodeCSV codeData = codeCSVIterator.next();
	            }
	            return namOfEateries;
	        } 
	        catch (NoSuchFileException e) {
	        	if(!csvFilePath.contains(".csv")) {
	        		throw new CodeAnalyserException(e.getMessage(), CodeAnalyserException.ExceptionType.WRONG_FILE_TYPE);
	        	}
	        }
	        catch (IOException e) {
	            throw new CodeAnalyserException(e.getMessage(),
	                    CodeAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
	        }
	        catch (RuntimeException e) {
	        	throw new CodeAnalyserException(e.getMessage(), CodeAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
	        }
	        return namOfEateries;
	    }
}
