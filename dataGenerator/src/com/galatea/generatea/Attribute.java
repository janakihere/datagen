package com.galatea.generatea;

import java.util.List;

import com.galatea.generatea.Generators.BigDecimalLimitedNormalGenerator;
import com.galatea.generatea.Generators.BooleanGenerator;
import com.galatea.generatea.Generators.DistributionType;
import com.galatea.generatea.Generators.Generator;
import com.galatea.generatea.Generators.IntegerLimitedNormalGenerator;
import com.galatea.generatea.Generators.ListSelectionGenerator;
import com.galatea.generatea.Generators.RegexStringGenerator;

public class Attribute {
	

	private String name;
	private Type type;
	private DistributionType disType;
	private String regexp;
	private Double lowerBound;
	private Double upperBound;
	private Double percentOutlying; 
	private List<String> values;
	private boolean isHasDist;
	private boolean isHasPredefined;
	private Attribute dependentOn;
	private String dependencyExpression;
	
	public Attribute(String name, Type type, DistributionType disType,Double lb,Double ub,Double po,
			String regexp, List<String> values,Attribute dependantOn,String exp) {
		super();
		this.name = name;
		this.type = type;
		this.disType = disType;
		this.regexp = regexp;
		this.values = values;
		this.dependentOn=dependantOn;
		this.dependencyExpression=exp;
		this.lowerBound = lb;
		this.upperBound= ub;
		this.percentOutlying= po;
		if(disType == null){
			isHasDist = false;
		}

		if(values == null){
			isHasPredefined = false;
		}

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public DistributionType getDisType() {
		return disType;
	}
	public void setDisType(DistributionType disType) {
		this.disType = disType;
	}
	public String getRegexp() {
		return regexp;
	}
	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public boolean isDistributed() {
		return isHasDist;
	}
	public void setHasDist(boolean hasDist) {
		this.isHasDist = hasDist;
	}
	public boolean isPredefined() {
		return isHasPredefined;
	}
	public void sethasPredefined(boolean hasPredefined) {
		this.isHasPredefined = hasPredefined;
	}
	
	public Generator Generator(){
		if(isHasPredefined){
		   	return new ListSelectionGenerator(values);
		} else if(isHasDist && type == Type.BigDecimal) {
			return new BigDecimalLimitedNormalGenerator();
		} else if(!isHasDist && type == Type.BigDecimal) {
			return new BigDecimalLimitedNormalGenerator();
			//return new BigDecimalLimitedUniformGenerator();
		} else if(isHasDist && type == Type.Int){
			return new IntegerLimitedNormalGenerator();
		} else if(!isHasDist && type == Type.Int){
			return new IntegerLimitedNormalGenerator();
			//return new IntegerLimitedUniformGenerator();
		} else if(type == Type.Boolean){
			return new BooleanGenerator();
		} else if(type == Type.String){
			return new RegexStringGenerator(regexp);
		}
		
		throw new IllegalArgumentException();
	}
	public Attribute getDependantOn() {
		return dependentOn;
	}
	public void setDependentOn(Attribute dependentOn) {
		this.dependentOn = dependentOn;
	}
	public String getDependencyExpression() {
		return dependencyExpression;
	}
	public void setDependencyExpression(String dependencyExpression) {
		this.dependencyExpression = dependencyExpression;
	}
	public Double getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}
	public Double getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}
	public Double getPercentOutlying() {
		return percentOutlying;
	}
	public void setPercentOutlying(Double percentOutlying) {
		this.percentOutlying = percentOutlying;
	}
}
