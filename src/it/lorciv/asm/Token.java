package it.lorciv.asm;

public class Token {
	
	private String str;
	
	public Token(String str) {
		this.str = str;
	}
	
	public boolean isNumber() {
		
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public int getAsInt() {
		return Integer.parseInt(str);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof String) {
			String that = (String) obj;
			return str.equals(that);
		} else if (obj instanceof Token) {
			Token that = (Token) obj;
			return str.equals(that.str);
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return str;
	}
	
}
