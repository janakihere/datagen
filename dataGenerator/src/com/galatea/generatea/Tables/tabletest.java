package com.galatea.generatea.Tables;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.galatea.generatea.Attribute;
import com.galatea.generatea.Type;
import com.galatea.generatea.Generators.DistributionType;
import com.galatea.generatea.Generators.Generator;
import com.galatea.generatea.Tables.AttributeValue.*;
import com.google.common.collect.*;

public class tabletest{
	
/*
 * 
 * String name, Type type, DistributionType disType,
			Pattern regexp, List<String> values
 */
public static void main(){
  HashBasedTable<String, Attribute, AttributeVal> table = HashBasedTable.create();
  ArrayList<Attribute> alist = new ArrayList();
  ArrayList<String> symlist = new ArrayList(7);
  symlist.add("IBM");
  symlist.add("GOOG");
  symlist.add("ABC");
  symlist.add("X");
  symlist.add("O");
  symlist.add("BUTTS");
  symlist.add("LOL");
  
//  alist.add(new Attribute("id_int", Type.Int, DistributionType.NORMAL, null, null));
//  alist.add(new Attribute("price", Type.BigDecimal, DistributionType.NORMAL, null, null, null, null));
//  alist.add(new Attribute("symbol", Type.String, null, null, symlist));
//  alist.add(new Attribute("somebool", Type.Boolean, null, null, null));
//  
//  ArrayList<Generator> genlist = new ArrayList(alist.size());
//  for(Attribute a : alist){
//	  Generator g = a.Generator();
//	  g.fieldName(a.getName())
//  }
//  
  for(int i = 0; i < 10; i++){
	  
  }
}
}
