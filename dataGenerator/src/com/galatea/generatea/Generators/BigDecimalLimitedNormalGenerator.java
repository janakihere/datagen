package com.galatea.generatea.Generators;

import java.math.BigDecimal;

import org.apache.commons.math3.distribution.RealDistribution;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.galatea.generatea.Tables.AttributeValue.BigDecimalVal;

public class BigDecimalLimitedNormalGenerator extends HardLimitedNormalPRNGenerator<BigDecimal>{
	public BigDecimalLimitedNormalGenerator() {
	    super();
		percentOutlying = (double)0;
	  }
	  
	  public BigDecimalLimitedNormalGenerator(double lb, double ub, double m, double sd) {
	    super(lb, ub, m, sd);
	  }
	  
	  public BigDecimalLimitedNormalGenerator(double lb, double ub) {
	    lowerBound = lb;
		upperBound = ub;
		recalculate();
	  }

	  public BigDecimalLimitedNormalGenerator(double lb, double ub, RealDistribution rd) {
	    lowerBound = lb;
		upperBound = ub;
	    percentOutlying = (double)0;
		distribution = rd;
	  }
	public BigDecimal generate(){
		return new BigDecimal(sample());
	}

	@Override
	public AttributeVal<BigDecimal> generateAttributeVal() {
		return new BigDecimalVal(generate());
	}
}