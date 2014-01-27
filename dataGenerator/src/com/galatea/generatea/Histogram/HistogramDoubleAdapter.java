package com.galatea.generatea.Histogram;

import java.util.ArrayList;
//import java.util.Iterator;
import java.lang.Math;
public class HistogramDoubleAdapter{
  ArrayList<Double> samples;
  double range;
  Histogram graph;
  
  public HistogramDoubleAdapter(){
    samples = null;
  }
  public HistogramDoubleAdapter(ArrayList<Double> s){
    samples = s;
	if(samples.isEmpty())
	  range = 0;
	else{
	  double l = samples.get(0);
	  double r = samples.get(samples.size() - 1);
	  if(Math.abs(l) > Math.abs(r))
         range = Math.abs(l - r);
      else 
         range = Math.abs(r - l);
   }		 
  }
  
  public void printHistogram(){
    System.out.println("printHistogram() not yet implemented");
  }  
  public void printGroupedHistogram(int groups){ 
    graph = new Histogram(groups);	
    double groupRange = range / groups;
	double current_upper_bound = samples.get(0);
    //Iterator<Double> iter = samples.iterator();
	int current_index = 0;
	for(int i = 0; i < groups; i++){
	
	  if(current_index >= samples.size()) break;
	  
   	  current_upper_bound += groupRange;
	  double current_val = samples.get(current_index);
	  
	  while(current_index < samples.size() && current_val <= current_upper_bound){
	    current_val = samples.get(current_index);
		graph.increment(i);
		current_index++;
	  }
	}
    graph.print();
  }
  
  public void printGroupedLimitedHistogram(){    
    System.out.println("printGroupedLimitedHistogram() not yet implemented");
  }
  public void printLimitedHistogram(){
    System.out.println("printLimitedHistogram() not yet implemented");
  }
  }
  
  