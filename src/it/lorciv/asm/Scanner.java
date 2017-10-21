package it.lorciv.asm;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Scanner {
	
	private StringTokenizer innerTokenizer;

	public Scanner() {
		setString("");
	}
	
	public Scanner(String str) {
		setString(str);
	}
	
	public void setString(String str) {
		innerTokenizer = new StringTokenizer(str);
	}
	
	public Token getNextToken() {
		
		Token result;
		
		try {
			result = new Token(innerTokenizer.nextToken().trim());
		} catch (NoSuchElementException e) {
			result = null;
		}
		
		return result;
	}

}
