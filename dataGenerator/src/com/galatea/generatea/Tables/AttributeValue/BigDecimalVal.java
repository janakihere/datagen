package com.galatea.generatea.Tables.AttributeValue;

import java.math.BigDecimal;

public class BigDecimalVal extends AttributeVal<BigDecimal> {
	public BigDecimalVal(BigDecimal val){
		super(val);
	}
	
	@Override
	public BigDecimal getBigDecimalValue(){
		return getVal();
	}
}
