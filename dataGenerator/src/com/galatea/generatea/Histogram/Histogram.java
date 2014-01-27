package com.galatea.generatea.Histogram;

public class Histogram{
  int entries, maxval, maxval_col;
  int[] record;
    
  public Histogram(){
    entries = 5;
	record = new int[5];
	maxval = 0;
	maxval_col = 0;
  }
  public Histogram(int n){
    entries = n;
	record = new int[n];
	maxval = 0;
	maxval_col = 0;
  }
  public void reset(){
    for(int i = 0; i < record.length; i++){
	  record[i] = 0;
	  maxval = 0;
	  maxval_col = 0;
	}
  }
  
  public int increment(int c){
    if(c < 0 || c >= record.length)
	  return -1;
    //System.out.format("Incrementing col %d, %d -> ", c, record[c]);
	record[c]++;
	//System.out.format("%d, maxval %d, ", record[c], maxval);
	if(record[c] > maxval){
	  //System.out.println("new maxval!");
	  maxval = record[c];
	  maxval_col = c;
	} //else {
	  //System.out.println("same maxval");
	  //}
	return record[c];
  }
  
  public String toString(){
    StringBuilder bucket = new StringBuilder("Histogram: [");
	for(int i = 0; i < entries; i++){
	  if(i != 0) bucket.append(',');
	  bucket.append(record[i]);
	}
	bucket.append(']');
	return bucket.toString();
  }
  
  public void print(){
   /* int y_label_digits = 1;
	int maxval_counter = maxval;
	String maxval_label = " "+ (maxval + 2) +" |";
	StringBuilder y_label_nolabel = new StringBuilder("   ");
	while (maxval_counter > 10 ) {
	  y_label_nolabel.append(" ");
	  y_label_digits++;
      maxval_counter /= 10;
	}
	y_label_nolabel.append("|");
	
	System.out.print(maxval_label);
	boolean first_done = false;
	*/
    for(int i = maxval + 2; i > 0; i--){
	 // if(i == 1) 
	 // else if(first_done) System.out.print(y_label_nolabel);
	  
	  
	  for(int j = 0; j < entries; j++){
	    //if(record[j]+1 == i)
          //System.out.print("");		
		if(record[j] >= i) 
		  System.out.print("|");
		else 
		  System.out.print(".");
	  }
	  System.out.print("\n");
	  //first_done = true;
    }
  }
 }
  