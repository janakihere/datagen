package com.galatea.generatea.Generators;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.galatea.generatea.Tables.AttributeValue.IntegerVal;

public class IntegerLimitedNormalGenerator extends HardLimitedNormalPRNGenerator<Integer>{

	public Integer generate() {
		return new Integer((int)sample());
	}
	
	public AttributeVal<Integer> generateAttributeVal() {
		return new IntegerVal(generate());
	}
	
}