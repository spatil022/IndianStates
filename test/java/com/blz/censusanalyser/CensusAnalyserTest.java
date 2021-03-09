package com.blz.censusanalyser;


import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "F:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.csv";
    private static final String WRONG_FILE_TYPE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCensusData.txt";
    private static final String WRONG_DELIMITER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\WrongDelimiterIndiaStateCensusData.csv";
    private static final String WITHOUT_HEADER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\WithoutHeaderIndiaStateCensusData.csv";

    //TC 1.1
    @Test
    public void given_IndianCensusCSVFile_ReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    //TC 1.2
    @Test
    public void given_IndiaCensusData_WithWrongFilePath_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    //TC 1.3
    @Test
    public void given_IndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_FILE_TYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    //TC 1.4
    @Test
    public void given_IndiaCensusData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_DELIMITER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
        }
    }

    //TC 1.5
    @Test
    public void given_IndiaCensusData_WithoutHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WITHOUT_HEADER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
        }
    }
}