package com.galatea.generatea.Generators;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.galatea.generatea.Tables.AttributeValue.BigDecimalVal;

public class BigDecimalNormalGenerator extends NormalPRNGenerator<BigDecimal>{
	public BigDecimalNormalGenerator(double lb, double ub, double m, double sd) {
	    super(lb, ub, 0, new NormalDistribution(m, sd));
	  }
	  //Same here, no chex bro
	  public BigDecimalNormalGenerator(NormalDistribution nd) {
	    super(0, 0, 1, nd);
	  }
	  
	  public BigDecimalNormalGenerator() {
	    super(-1, 1, 1);
	  }
	  
	  public BigDecimalNormalGenerator(double lb, double ub) {
	    this(lb, ub, 1);
	  }
	  public BigDecimalNormalGenerator(double lb, double ub, double po) {
	    this.lowerBound = lb;
		this.upperBound = ub;
	    percentOutlying = po;
		recalculate();
	  }
	  public BigDecimalNormalGenerator(double lb, double ub, double po, RealDistribution rd) {
	    lowerBound = lb;
		upperBound = ub;
	    percentOutlying = po;
		distribution = rd;
	  } 
	public BigDecimal generate() {
		return new BigDecimal(sample());
	}
	@Override
	public AttributeVal<BigDecimal> generateAttributeVal() {
		return new BigDecimalVal(generate());
	}
	
}