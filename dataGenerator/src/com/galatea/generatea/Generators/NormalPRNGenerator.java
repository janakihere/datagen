package com.galatea.generatea.Generators;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.special.Erf;

//A class to represent a generator based on a Normal Distribution
public abstract class NormalPRNGenerator<T extends Number> extends RealPRNGenerator<T> {
  //There will be no check if you use this. I will create your specified distribution without questioning your inputs.
  public NormalPRNGenerator(double lb, double ub, double m, double sd) {
    super(lb, ub, 0, new NormalDistribution(m, sd));
  }
  //Same here, no chex bro
  public NormalPRNGenerator(NormalDistribution nd) {
    super(0, 0, 1, nd);
  }
  
  public NormalPRNGenerator() {
    super(-1, 1, 1);
  }
  
  public NormalPRNGenerator(double lb, double ub) {
    this(lb, ub, 1);
  }
  public NormalPRNGenerator(double lb, double ub, double po) {
    this.lowerBound = lb;
	this.upperBound = ub;
    percentOutlying = po;
	recalculate();
  }
  public NormalPRNGenerator(double lb, double ub, double po, RealDistribution rd) {
    lowerBound = lb;
	upperBound = ub;
    percentOutlying = po;
	distribution = rd;
  } 
  
  public void setUpperBound(Double ub){
    upperBound = ub;
	recalculate();
  }
  
  public void setLowerBound(Double lb){
    lowerBound = lb;
	recalculate();
  }
  public void setPercentOutlying(Double po){
    percentOutlying = po;
	recalculate();
  }
  
  protected void recalculate(){
    double mean = (upperBound + lowerBound) / 2;
	double standardDeviation = calculateSD(mean);
	if (standardDeviation <= 0) {
      System.out.format("ERROR: Normal Distribution cannot be less than or equal to zero. Val = %f, changing to default value of 1.%n", standardDeviation);
      standardDeviation = 1;
    }	  
	
	distribution = new NormalDistribution(mean, standardDeviation);
  }
  
  private double calculateSD(double mean){
    //Oh god I hope this works.
	//This is based on the equation I got from Wolfram for the CDF for the normal distribution
	// P(X<=x) = 1/2 erfc((mu-x)/(sqrt(2) sigma))
	//  ^pO/2             ^1 ^2              ^sd  1:mean, mean of two bounds. 2:the x val, i'm using lowerBound, pretty sure that's right.
	// which I so masterfully twisted into
	// sd = (mean - x) / inverse_erfc(pO/100) / radical2
    return ((mean - lowerBound) / Erf.erfcInv(percentOutlying/100)) / Math.sqrt(2);
  }
}
  