package com.galatea.generatea.Generators;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import org.apache.commons.math3.distribution.*;

import com.galatea.generatea.Histogram.HistogramDoubleAdapter;


public class DistributionTesting{
  public static void main(String[] args){
    double[] diInput = {2, 3, 0, 1, 0, 1, 2, .5, 10, 20, 2, 3, .1, .547723};
    DistributionInterface di = new DistributionInterface();
	boolean selectionloopflag, quitflag = false;
	Scanner input = new Scanner(System.in);
	int s1, s2, s3;
	DistributionType dtype;
	ArrayList<Double> sampleset;
	HistogramDoubleAdapter histo;
	while(!quitflag){
      System.out.println("<< Select Distribution >>-\n1)Beta\n2)Normal\n3)Cauchy\n4)ChiSquared\n5)Exponential\n6)F\n7)Gamma\n8)LogNormal");
	  s1 = inputHelper(input, 1, 8);
	  dtype = resolvedtype(s1);
	  
	  boolean redosampleFlag;
	  
      
	  System.out.println("How many values?");
	  s2 = inputHelper(input, 1, Integer.MAX_VALUE);
	  
	  do{
	    sampleset = di.doSampling(dtype, s2, true); 
	    System.out.println(sampleset);
		System.out.println("Go Again? 1)Yes 2)No");
	    s3 = inputHelper(input, 1, Integer.MAX_VALUE);
	  } while (s3 == 1);	  
	  
	  System.out.println("Graph? 1) Yes 2) No");
	  s3 = inputHelper(input, 1, 2);
	  if(s3 == 1){
	    System.out.println("How many columns?");
	    s3 = inputHelper(input, 1, sampleset.size());
		histo = new HistogramDoubleAdapter(sampleset);
		histo.printGroupedHistogram(s3);
	  } else {
		System.out.println("Your loss, I guess");
	  }   
	
	  System.out.println("Again? 1)Yes 2)No");
	  s1 = inputHelper(input, 1, 2);
	  if(s1 == 2){
	    System.out.println("KBYE");
	    quitflag = true;
	  }
	}
  }
  
  private static DistributionType resolvedtype(int s){
    switch(s){
	  case 1: return DistributionType.BETA;       
	                    
	  case 2: return DistributionType.NORMAL;  
		                
	  case 3: return DistributionType.CAUCHY;    
		                
	  case 4: return DistributionType.CHISQUARED; 
		                
	  case 5: return DistributionType.EXPONENTIAL;
		                
	  case 6: return DistributionType.F;          
		                
	  case 7: return DistributionType.GAMMA;      
		                
	  case 8: return DistributionType.LOGNORMAL;   
		                
	  default: return DistributionType.INVALID;           
	}
  }
  
  private static void doGeneration(int n, RealDistribution d){
    ArrayList<Double> reslist = new ArrayList<Double>(n);
	double tmp;
	for(int i = 0; i < n; i++){
	  tmp = d.sample();
	  //maybe do some sort of tracking here maybe?
	  reslist.add(tmp);
	}
	Collections.sort(reslist);
	System.out.println(reslist.toString());
  }
	  
  
  private static int inputHelper(Scanner input, int min, int max){
    int s1;
	while(true){	  
	  System.out.print(">>> ");
	  try{
	    s1 = input.nextInt();
		if(s1 < min || s1 > max)
		  System.out.println("Illegal input. Try again");
		else
		  return s1;
	  } catch (InputMismatchException e) {
	    System.out.println("Illegal input. Try again");
	  }
    }
  }
  }