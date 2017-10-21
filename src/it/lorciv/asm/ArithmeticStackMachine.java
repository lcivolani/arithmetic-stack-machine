package it.lorciv.asm;

import java.io.PrintWriter;
import java.util.Stack;

public class ArithmeticStackMachine {
	
	private Stack<Integer> stack;
	private PrintWriter output;
	
	private Scanner scanner;
	
	public ArithmeticStackMachine(Scanner scanner, PrintWriter output) {
		stack = new Stack<Integer>();
		this.output = output;
		this.scanner = scanner;
	}
	
	public void executeCommand() {
		
		switch (scanner.getNextToken().toString()) {
		case "PUSH":
			push();
			break;
		case "POP":
			pop();
			break;
		case "ADD":
			add();
			break;
		case "SUB":
			sub();
			break;
		case "MUL":
			mul();
			break;
		case "DIV":
			div();
			break;
		default:
			throw new IllegalArgumentException("invalid command");
		}
	}
	
	private void push() {
		
		Token currentToken = scanner.getNextToken();
		
		if (!currentToken.isNumber())
			throw new IllegalArgumentException("expected a number");
		
		int value = currentToken.getAsInt();
		
		stack.push(new Integer(value));
		
		System.out.println("push " + value + "\t" + stack);
	}
	
	private void pop() {
		output.println(stack.pop());
		
		System.out.println("pop\t" + stack);
	}
	
	private void add() {
		
		int n2 = stack.pop().intValue();
		int n1 = stack.pop().intValue();
		
		stack.push(new Integer(n1 + n2));
		
		System.out.println("add\t" + stack);
	}
	
	private void sub() {
		
		int n2 = stack.pop().intValue();
		int n1 = stack.pop().intValue();
		
		stack.push(new Integer(n1 - n2));
		
		System.out.println("sub\t" + stack);
	}
	
	private void mul() {
		
		int n2 = stack.pop().intValue();
		int n1 = stack.pop().intValue();
		
		stack.push(new Integer(n1 * n2));
		
		System.out.println("mul\t" + stack);
	}
	
	private void div() {
		
		int n2 = stack.pop().intValue();
		int n1 = stack.pop().intValue();
		
		stack.push(new Integer(n1 / n2));
		
		System.out.println("div\t" + stack);
	}

}
