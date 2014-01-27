package com.galatea.generatea;
import java.util.ArrayList;

public class AbstractObject{
  ArrayList<Attribute> attributes;
  private int numAttributes;
  String name;
  
  public AbstractObject(String n, ArrayList<Attribute> a){
    name = n;
	attributes = a;
	numAttributes = a.size();
  }
  
  public AbstractObject(){
    name = "default";
	attributes = new ArrayList();
	numAttributes = 0;
  }
  
  public AbstractObject(String n){
    name = n;
	attributes = new ArrayList();
	numAttributes = 0;
  }
  
  public AbstractObject(ArrayList<Attribute> a){
    name = "default";
	attributes = a;
	numAttributes = a.size();
  }
  
  public void setName(String n){
    name = n;
  }
  
  public void setAttributes(ArrayList<Attribute> a){
    attributes = a;
	numAttributes = a.size();
  }
  
  public void clearAttributes(){
    attributes.clear();
	numAttributes = 0;
  }
  
  public void addAttribute(Attribute a){
    attributes.add(a);
    numAttributes++;
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder(name +  "(AbstractObject): \n");
	for(Attribute a : attributes){
	  sb.append("\t");
	  sb.append(a.toString());
	}
	
	return sb.toString();
  }
}