package com.blz.codeanalyszer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CodeAnalyserTest {
	private static final String INDIA_CODE_CSV_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.csv";
    private static final String WRONG_CSV_FILE_PATH = "F:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.csv";
    private static final String WRONG_FILE_TYPE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\IndiaStateCode.txt";
    private static final String WRONG_DELIMITER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\WrongDelimiterIndiaStateCode.csv";
    private static final String WITHOUT_HEADER_FILE_PATH = "C:\\Users\\Muthyala Aishwarya\\Downloads\\WithoutHeaderIndiaStateCode.csv";

    //TC 1.1
    @Test
    public void given_IndianCodeCSVFile_ReturnsCorrectRecords() {
        try {
            CodeAnalyser codeAnalyser = new CodeAnalyser();
            int numOfRecords = codeAnalyser.loadIndiaCodeData(INDIA_CODE_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CodeAnalyserException e) { }
    }

    //TC 1.2
    @Test
    public void given_IndiaCodeData_WithWrongFilePath_ShouldThrowException() {
        try {
        	CodeAnalyser codeAnalyser = new CodeAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CodeAnalyserException.class);
            codeAnalyser.loadIndiaCodeData(WRONG_CSV_FILE_PATH);
        } catch (CodeAnalyserException e) {
            Assert.assertEquals(CodeAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    //TC 1.3
    @Test
    public void given_IndiaCodeData_WithWrongFileType_ShouldThrowException() {
        try {
            CodeAnalyser codeAnalyser = new CodeAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CodeAnalyserException.class);
            codeAnalyser.loadIndiaCodeData(WRONG_FILE_TYPE_PATH);
        } catch (CodeAnalyserException e) {
            Assert.assertEquals(CodeAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    //TC 1.4
    @Test
    public void given_IndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CodeAnalyser codeAnalyser = new CodeAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CodeAnalyserException.class);
            codeAnalyser.loadIndiaCodeData(WRONG_DELIMITER_FILE_PATH);
        } catch (CodeAnalyserException e) {
            Assert.assertEquals(CodeAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
        }
    }

    //TC 1.5
    @Test
    public void given_IndiaCodeData_WithoutHeader_ShouldThrowException() {
        try {
            CodeAnalyser codeAnalyser = new CodeAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CodeAnalyserException.class);
            codeAnalyser.loadIndiaCodeData(WITHOUT_HEADER_FILE_PATH);
        } catch (CodeAnalyserException e) {
            Assert.assertEquals(CodeAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
        }
    }
}