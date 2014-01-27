package com.galatea.generatea;

import java.util.List;
import java.util.regex.Pattern;

import com.galatea.generatea.Generators.BigDecimalLimitedNormalGenerator;
import com.galatea.generatea.Generators.DistributionType;
import com.galatea.generatea.Generators.Generator;
import com.galatea.generatea.Generators.ListSelectionGenerator;

public class Attribute {

	private String name;
	private Type type;
	private DistributionType disType;
	private Pattern regexp;
	private List<String> values;
	private boolean hasDist;
	private boolean hasPredefined;
	private boolean hasPattern;
	
	
	public Attribute(String name, Type type, DistributionType disType,
			Pattern regexp, List<String> values) {
		super();
		this.name = name;
		this.type = type;
		this.disType = disType;
		this.regexp = regexp;
		this.values = values;
		
		if(disType.equals(null)){
			hasDist = false;
		}
		if(regexp.equals(null)){
			hasPattern = false;
		}
		if(values.equals(null)){
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
		if(hasPattern){
		   	return new ListSelectionGenerator(values);
		} else if(hasPattern) {
			return new RegexStringGenerator(regexp);
		} else if(hasDist && type == Type.BigDecimal) {
			return new BigDecimalLimitedNormalGenerator();
		} else if(!hasDist && type == Type.BigDecimal) {
			return new BigDecimalLimitedUniformGenerator();
		} else if(hasDist && type == Type.Int){
		} else if(!hasDist && type == Type.Int){
		} else if()
		}
	
}
