package com.galatea.generatea.Generators;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

import com.galatea.generatea.Histogram.HistogramDoubleAdapter;


public class RealPRNTest {
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
	int repeat_bool = 1;
	do{
	System.out.println("How many? ");
	int numberSamples = inputHelper(input, 0, Integer.MAX_VALUE);
    
	System.out.println("Minimum Value?");
	int minVal = inputHelper(input, Integer.MIN_VALUE, Integer.MAX_VALUE - 1);
	
	System.out.println("Maximum Value?");
	int maxVal = inputHelper(input, minVal, Integer.MAX_VALUE);
	
	System.out.println("Percent Outlying");
	int percentOutlying = inputHelper(input, 0, 100);	
    
	RealPRNGenerator ng;
	if(percentOutlying == 0){
	  System.out.println("Hard Limited");
	  ng = new BigDecimalLimitedNormalGenerator((double)minVal, (double)maxVal);
	} else {
	System.out.println("Not hard limited");
      ng = new BigDecimalNormalGenerator((double)minVal, (double)maxVal, (double)percentOutlying);
	}
	Double[] samples = ng.sample(numberSamples);
    ArrayList<Double> asamples = new ArrayList<Double>(samples.length);
	Collections.addAll(asamples, samples);
	Collections.sort(asamples);
	System.out.println(asamples);
	
	System.out.println("Graph? 1) Yes 2) No");
	int graph_bool = inputHelper(input, 1, 2);	
	
    if(graph_bool == 1){
	  HistogramDoubleAdapter hda = new HistogramDoubleAdapter(asamples);
	  System.out.println("Cols? (1-235)");
	  int cols = inputHelper(input, 1, 235);
	  hda.printGroupedHistogram(cols);
	}
	
	System.out.println("Again? 1) Yes 2) No");
	repeat_bool = inputHelper(input, 1, 2);	
	} while (repeat_bool == 1);	
	
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
  
  private static void syntaxcheck(String[] args){
    if(args[0].equals("/?")){
	  System.out.println("Does testing for RealPRNGenerator and inherited classes:");
	  System.out.println("NormalPRNGenerator\nHardLimitedPRNGenerator");
	  System.exit(0);
	}    
  }
  }
	
	
    