package com.galatea.generatea.Tables.AttributeValue;

public class BooleanVal extends AttributeVal<Boolean> {
	public BooleanVal(Boolean val){
		super(val);
	}
	
	@Override
	public Boolean getBooleanValue(){
		return getVal();
	}
}
