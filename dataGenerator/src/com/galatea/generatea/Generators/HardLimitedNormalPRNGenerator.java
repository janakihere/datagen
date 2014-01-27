package com.galatea.generatea.Generators;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;


public abstract class HardLimitedNormalPRNGenerator<T extends Number> extends NormalPRNGenerator<T> {
  public HardLimitedNormalPRNGenerator() {
    super();
	percentOutlying = (double)0;
  }
  
  public HardLimitedNormalPRNGenerator(double lb, double ub, double m, double sd) {
    super(lb, ub, 0, new NormalDistribution(m, sd));
  }
  
  public HardLimitedNormalPRNGenerator(double lb, double ub) {
    lowerBound = lb;
	upperBound = ub;
	recalculate();
  }

  public HardLimitedNormalPRNGenerator(double lb, double ub, RealDistribution rd) {
    lowerBound = lb;
	upperBound = ub;
    percentOutlying = (double)0;
	distribution = rd;
  }
  
  //This method runs in a non-deterministic time. I do not know of any better way to do this. There's no way to guarantee a
  //sampled number will be in a specified range, so you must just keep sampling until you get something in the range.
  //With distributions created by this class, it will be very unlikely that a value will be outside the range at all, but it is still possible
  //to theoretically get infinitely many samples out of the range.
  
  public double sample(){
    double result;
	do{
	  result = distribution.sample();
	} while (result > upperBound || result < lowerBound);
	return result;
  }
  
/*  protected void recalculate(){
    double standardDeviation = calculateSD(mean);
	distribution = new NormalDistribution(mean, standardDeviation);
  }
 */ 
  private double calculateSD(double mean){
    //This should be the equivalent of the NormalDistribution one, but with a pre-calculated part, assuming percentAllowed == .1(%)
    return ((mean - lowerBound) / 2.3267537655) / Math.sqrt(2);
  }
 
}
	  

  