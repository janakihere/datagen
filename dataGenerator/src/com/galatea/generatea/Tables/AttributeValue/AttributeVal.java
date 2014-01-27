package com.galatea.generatea.Tables.AttributeValue;

import java.math.BigDecimal;

public abstract class AttributeVal<E> {
	
	E val;
	public AttributeVal(E val){
		this.val = val;
	}
	public String getStringValue(){
		raiseException("String");
		return null;
	}
	public Boolean getBooleanValue(){
		raiseException("Boolean");
		return null;
	}
	public Integer getIntegerValue(){
		raiseException("Integer");
		return null;
	}
	public BigDecimal getBigDecimalValue(){
		raiseException("BigDecimal");
		return null;
	}
	private void raiseException(String m){
		throw new UnsupportedOperationException("Attemped to get a "+ m +" from a "+ val.getClass().getName());
	}
	protected E getVal(){
		return val;
	}
} 