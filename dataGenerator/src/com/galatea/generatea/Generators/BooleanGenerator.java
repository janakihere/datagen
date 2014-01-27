package com.galatea.generatea.Generators;

import java.util.ArrayList;
import java.util.Random;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;

public class BooleanGenerator extends Generator<Boolean>{
    Random coin;
    
	public BooleanGenerator() {
		this.coin = new Random();
	}

	@Override
	public Boolean generate() {
		return coin.nextBoolean();
	}

	@Override
	public AttributeVal<Boolean> generateAttributeVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}