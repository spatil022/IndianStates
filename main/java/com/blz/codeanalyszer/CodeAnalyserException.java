package com.blz.codeanalyszer;

public class CodeAnalyserException extends Exception {
	enum ExceptionType {
		CENSUS_FILE_PROBLEM, WRONG_FILE_TYPE, INCORRECT_DELIMITER_OR_HEADER
	}

	ExceptionType type;

	public CodeAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CodeAnalyserException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}