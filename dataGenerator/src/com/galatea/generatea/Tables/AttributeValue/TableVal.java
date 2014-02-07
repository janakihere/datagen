package com.galatea.generatea.Tables.AttributeValue;

import com.google.common.collect.HashBasedTable;

public class TableVal  extends AttributeVal<HashBasedTable> {

	public TableVal(HashBasedTable val) {
		super(val);
		// TODO Auto-generated constructor stub
	}
	public HashBasedTable getTableValue(){
		return getVal();
	}
}
