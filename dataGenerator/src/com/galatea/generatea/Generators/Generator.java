package com.galatea.generatea.Generators;

import java.util.ArrayList;

import com.galatea.generatea.Tables.AttributeValue.AttributeVal;

public abstract class Generator<T> {

  String name;
  public abstract T generate();
  
  public String generateString(){
	  return generate().toString();
  }
  
  public abstract AttributeVal<T> generateAttributeVal();
 
  public ArrayList<T> generate(int i) {
		ArrayList<T> result = new ArrayList(i);
		for(int j = 0; j < i; i++){
			result.add(generate());
		}
		return result;
	}
  
  public void setName(String s){
	  name = s;
  }
}
