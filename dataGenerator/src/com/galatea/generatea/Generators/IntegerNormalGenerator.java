package com.galatea.generatea.Generators;
import java.util.ArrayList;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.galatea.generatea.Tables.AttributeValue.IntegerVal;

public class IntegerNormalGenerator extends NormalPRNGenerator<Integer> {

	public Integer generate() {
		return new Integer((int)sample());
	}

	@Override
	public AttributeVal<Integer> generateAttributeVal() {
		return new IntegerVal(generate());
	}
}