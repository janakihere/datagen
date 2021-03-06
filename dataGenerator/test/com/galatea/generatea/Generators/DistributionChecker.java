package com.galatea.generatea.Generators;


import org.apache.commons.math3.distribution.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class DistributionChecker{
   
	/*BetaDistribution bettafishd;	
    NormalDistribution normald;
	CauchyDistribution cauchyd; 
	ChiSquaredDistribution chid;	
	ExponentialDistribution exponentiald;
	FDistribution fd;
	GammaDistribution gammad; 
	LogNormalDistribution lognormald; */
	

  //public DistributionInterface() {
    
  public static void main(String[] args){
    int argc = 14;
	System.out.println("-parsing args-");

    if(args.length != argc) {
	  System.out.println("Wrong args, real = " + args.length + " expected = " + argc);
	  return;
	}
	
	double[] argd = new double[argc];
	//Parse doubles
	for(int i = 0; i < argc; i++){
	  if(args[i] == null){
	    System.out.println("null argument, index = " + i);
	    return;
	  }
	  
	  try {
	    argd[i] = Double.parseDouble(args[i]);
	  } catch(NumberFormatException e) {
	    System.out.println("Arg parsing error. index " + i + " '" + args[i] + "' could not be parsed");
	    return;
	  }
	}
	System.out.println("Parsing all clear");
	
	System.out.println("-creating distribution objects-");
	System.out.format("Beta Distribution, alpha = %f, beta = %f%n", argd[0], argd[1]);
	BetaDistribution bettafishd = new BetaDistribution(argd[0], argd[1]);
	
	System.out.format("Normal Distribution, mean = %f sd = %f%n", argd[2], argd[3]);
    NormalDistribution normald = new NormalDistribution(argd[2], argd[3]);

	System.out.format("Cauchy Distribution, median = %f scale= %f%n", argd[4], argd[5]);
	CauchyDistribution cauchyd = new CauchyDistribution(argd[4], argd[5]);

	System.out.format("Chi-Squared Distribution, freedom = %f%n", argd[6]);
	ChiSquaredDistribution chid = new ChiSquaredDistribution(argd[6]);

	System.out.format("Exponential Distribution, mean = %f%n", argd[7]);
	ExponentialDistribution exponentiald = new ExponentialDistribution(argd[7]);

	System.out.format("F Distribution, num_freedom = %f, den_freedom = %f%n", argd[8], argd[9]);
	FDistribution fd = new FDistribution(argd[8], argd[9]);

	System.out.format("Gamma Distribution, shape = %f, scale = %f%n", argd[10], argd[11]);
	GammaDistribution gammad = new GammaDistribution(argd[10], argd[11]);

	System.out.format("LogNormal Distribution, scale = %f, shape = %f%n", argd[12], argd[13]);
	LogNormalDistribution lognormald = new LogNormalDistribution(argd[12], argd[13]);
	System.out.println("done");
	
	boolean selectionloopflag, quitflag = false;
	Scanner input = new Scanner(System.in);
	int s1, s2;
	while(!quitflag){
      System.out.println("<< Select Distribution >>-\n1)Beta\n2)Normal\n3)Cauchy\n4)ChiSquared\n5)Exponential\n6)F\n7)Gamma\n8)LogNormal");
	  s1 = inputHelper(input, 1, 8);
	  System.out.println("How many values?");
	  s2 = inputHelper(input, 1, Integer.MAX_VALUE);
	  
	  RealDistribution selectedD;
	  switch(s1){
	    case 1: selectedD = bettafishd;
		        break;
		case 2: selectedD = normald;
		        break;
		case 3: selectedD = cauchyd;
		        break;
		case 4: selectedD = chid;
		        break;
		case 5: selectedD = exponentiald;
		        break;
		case 6: selectedD = fd;
		        break;
		case 7: selectedD = gammad;
		        break;
		case 8: selectedD = lognormald;
		        break;
	    default: System.out.println("Somehow got to the switch statement with an illegal value? I checked this already doe.\nI CHOOSE TO DIE HORRIBLY");
		         selectedD = new NormalDistribution();
		         int goodbyecruelworld = 1 / 0;
				 break;
	}
	
	doGeneration(s2, selectedD);
	  
	
	System.out.println("Again? 1)Yes 2)No");
	s1 = inputHelper(input, 1, 2);
	if(s1 == 2){
	  System.out.println("KBYE");
	  quitflag = true;
	}
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

	

	