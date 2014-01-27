package com.galatea.generatea.Generators;

import java.util.ArrayList;

import org.apache.commons.math3.distribution.*;

public abstract class RealPRNGenerator<T extends Number> extends Generator<T>{
  Double lowerBound;
  Double upperBound;
  Double percentOutlying;
  RealDistribution distribution;
  public RealPRNGenerator() {
    this(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
  }
  public RealPRNGenerator(double lb, double ub) {
    this(lb, ub, 0);
  }
  public RealPRNGenerator(double lb, double ub, double po) {
    lowerBound = lb;
	upperBound = ub;
    percentOutlying = po;
	recalculate();
  }
  public RealPRNGenerator(double lb, double ub, RealDistribution rd) {
    this(lb, ub, 0, rd);
  }
  public RealPRNGenerator(double lb, double ub, double po, RealDistribution rd) {
    lowerBound = lb;
	upperBound = ub;
    percentOutlying = po;
	distribution = rd;
  }  
  
  //Accessors
  public Double getLowerBound(){return lowerBound;}
  public Double getUpperBound(){return upperBound;}
  public Double getPercentOutlying(){return percentOutlying;}
  
  //Modifiers
  public abstract void setUpperBound(Double ub);
  public abstract void setLowerBound(Double lb);
  public abstract void setPercentOutlying(Double po);
  protected abstract void recalculate();  
  
  public double sample(){
    return distribution.sample();
  }
  
  
  
  public Double[] sample(int size){
    Double[] result = new Double[size];
    for(int i = 0; i < size; i++)
	  result[i] = sample();
	
	return result;
  }
  
}


	  
  
  
  
  
   