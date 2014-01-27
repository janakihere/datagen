package com.galatea.generatea.Histogram;

import java.util.Random;
public class HistoTest{
  static int COLS = 26;
  public static void main(String[] args){
    syntaxcheck(args);
    Histogram h = new Histogram(COLS);
	Random r = new Random();
	for(int i = 0; i <= 200; i++){
	  h.increment(r.nextInt(COLS));
	}
	System.out.println(h);
	h.print();
  }
  
   private static void syntaxcheck(String[] args){
    if(args[0].equals("/?")){
	  System.out.println("Does testing for Histogram.");
	  System.out.println("Does not touch HistogramDoubleAdapter");
	  System.exit(0);
	}    
  }
}