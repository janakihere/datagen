package com.galatea.generatea;

import java.util.List;
import java.util.regex.Pattern;

import com.galatea.generatea.Generators.*;

public class Attribute {
	

	private String name;
	private Type type;
	private DistributionType disType;
	private Pattern regexp;
	private List<String> values;
	private boolean hasDist;
	private boolean hasPredefined;
	private boolean hasPattern;
	private Attribute dependantOn;
	private String dependancyExpression;
	
	public Attribute(String name, Type type, DistributionType disType,
			Pattern regexp, List<String> values,Attribute dependantOn,String exp) {
		super();
		this.name = name;
		this.type = type;
		this.disType = disType;
		this.regexp = regexp;
		this.values = values;
		this.dependantOn=dependantOn;
		this.dependancyExpression=exp;
		
		if(disType == null){
			hasDist = false;
		}
		if(regexp == null){
			hasPattern = false;
		}
		if(values == null){
			hasPredefined = false;
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
	public Pattern getRegexp() {
		return regexp;
	}
	public void setRegexp(Pattern regexp) {
		this.regexp = regexp;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public boolean isHasDist() {
		return hasDist;
	}
	public void setHasDist(boolean hasDist) {
		this.hasDist = hasDist;
	}
	public boolean ishasPredefined() {
		return hasPredefined;
	}
	public void sethasPredefined(boolean hasPredefined) {
		this.hasPredefined = hasPredefined;
	}
	public boolean isHasPattern() {
		return hasPattern;
	}
	public void setHasPattern(boolean hasPattern) {
		this.hasPattern = hasPattern;
	}
	
	public Generator Generator(){
		if(hasPredefined){
		   	return new ListSelectionGenerator(values);
		} else if(hasPattern) {
			return new RegexStringGenerator(regexp);
		} else if(hasDist && type == Type.BigDecimal) {
			return new BigDecimalLimitedNormalGenerator();
		} else if(!hasDist && type == Type.BigDecimal) {
			return new BigDecimalLimitedNormalGenerator();
			//return new BigDecimalLimitedUniformGenerator();
		} else if(hasDist && type == Type.Int){
			return new IntegerLimitedNormalGenerator();
		} else if(!hasDist && type == Type.Int){
			return new IntegerLimitedNormalGenerator();
			//return new IntegerLimitedUniformGenerator();
		} else if(type == Type.Boolean){
			return new BooleanGenerator();
		} else if(type == Type.String){
			return new RegexStringGenerator();
		}
		
		throw new IllegalArgumentException();
	}
	public boolean isHasPredefined() {
		return hasPredefined;
	}
	public void setHasPredefined(boolean hasPredefined) {
		this.hasPredefined = hasPredefined;
	}
	public Attribute getDependantOn() {
		return dependantOn;
	}
	public void setDependantOn(Attribute dependantOn) {
		this.dependantOn = dependantOn;
	}
	public String getDependancyExpression() {
		return dependancyExpression;
	}
	public void setDependancyExpression(String dependancyExpression) {
		this.dependancyExpression = dependancyExpression;
	}
}
