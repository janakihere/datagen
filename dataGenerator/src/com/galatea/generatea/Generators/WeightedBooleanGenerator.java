package com.galatea.generatea.Generators;

public class WeightedBooleanGenerator extends BooleanGenerator{
    int trueWeight;
    public WeightedBooleanGenerator(){
    	this(50);
    }

    public WeightedBooleanGenerator(int weight){
    	trueWeight = weight; 
    }
    public WeightedBooleanGenerator(double weight){
    	trueWeight = (int)weight; 
    }
    
	@Override
	public Boolean generate() {
		return (trueWeight < (coin.nextInt(100) + 1));
	}
	
}