package com.galatea.generatea.Generators;

import nl.flotsam.xeger.Xeger;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.galatea.generatea.Tables.AttributeValue.StringVal;

public class RegexStringGenerator extends Generator<String> {

	String regex;

	public RegexStringGenerator(String regex) {
		super();
		this.regex = regex;
	}

	@Override
	public String generate() {
		String result = "";
		Xeger generator = new Xeger(this.regex);
		result = generator.generate();
		// System.out.println(result);
		return result;
	}

	@Override
	public AttributeVal<String> generateAttributeVal() {
		// TODO Auto-generated method stub
		return new StringVal(generate());
	}

}
