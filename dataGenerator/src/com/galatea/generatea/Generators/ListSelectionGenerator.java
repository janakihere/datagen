package com.galatea.generatea.Generators;

import java.util.List;
import java.util.Random;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.galatea.generatea.Tables.AttributeValue.StringVal;

public class ListSelectionGenerator extends Generator<String>{
	Random randomizer;
	List<String> source;
	int num;
	
	public ListSelectionGenerator(List<String> source) {
		super();
		this.source = source;
		num = source.size();
		randomizer = new Random();
	}

	@Override
	public String generate(){
		return source.get(randomizer.nextInt(num));
	}

	@Override
	public AttributeVal<String> generateAttributeVal() {
		return new StringVal(generate());
	}	
}