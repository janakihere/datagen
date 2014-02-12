package com.galatea.generatea;

import java.util.Stack;

public class Constraint {

	private enum Comparator{
		LESS_THAN,EQUAL,GREATER_THYAN
	}
	private enum Operator{
		MULTIPLY,SUMMATION,SUM
	}
	
	private Comparator condition;
	private Operator operator;
	private Stack<String> terms;
	public Comparator getCondition() {
		return condition;
	}
	public void setCondition(Comparator condition) {
		this.condition = condition;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Stack<String> getTerms() {
		return terms;
	}
	public void setTerms(Stack<String> terms) {
		this.terms = terms;
	}
	
}
