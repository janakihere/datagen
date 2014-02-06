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
	private List<String> values;
	private boolean hasDist;
	private boolean hasPredefined;
	private Attribute dependentOn;
	private String dependencyExpression;
	
	public Attribute(String name, Type type, DistributionType disType,
			String regexp, List<String> values,Attribute dependantOn,String exp) {
		super();
		this.name = name;
		this.type = type;
		this.disType = disType;
		this.regexp = regexp;
		this.values = values;
		this.dependentOn=dependantOn;
		this.dependencyExpression=exp;
		
		if(disType == null){
			hasDist = false;
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
	
	public Generator Generator(){
		if(hasPredefined){
		   	return new ListSelectionGenerator(values);
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
			return new RegexStringGenerator(regexp);
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
		return dependentOn;
	}
	public void setDependantOn(Attribute dependantOn) {
		this.dependentOn = dependantOn;
	}
	public String getDependancyExpression() {
		return dependencyExpression;
	}
	public void setDependancyExpression(String dependancyExpression) {
		this.dependencyExpression = dependancyExpression;
	}
}
