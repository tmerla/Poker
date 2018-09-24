package com.info.exception;

public class InvalidDistribution extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;
	public InvalidDistribution(String errorMessage) {
		this.errorMessage = errorMessage;
	}
@Override
public String toString() {
	return errorMessage;
}

}
