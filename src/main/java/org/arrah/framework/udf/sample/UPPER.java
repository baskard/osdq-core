package org.arrah.framework.udf.sample;

import org.arrah.framework.ndtable.ReportTableModel;
import org.arrah.framework.udf.MapUdf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***********************************************
 *     Copyright to Vivek Kumar Singh          *
 *                                             *
 * Any part of code or file can be changed,    *
 * redistributed, modified with copyright      *
 * information intact                          *
 *                                             *
 * Author$ : Vivek Singh                       *
 *                                             *
 ***********************************************/

/**
 * A sample UDF to show how to implement custom to-upper function.
 * It takes maps of String as input and calls String::toUpperCase on each element
 * and returns the List on String with upper case text
 */
public class UPPER extends MapUdf<String> {


    @Override
    public List<String> eval(ReportTableModel rtm, List<String> columnName) {
    	
    	if (columnName == null || columnName.size() ==0) return null;
    	
    	List<Object> input = Arrays.asList(rtm.getColData(columnName.get(0)) );
        return input.stream().map(e -> {return ((String)e).toUpperCase();}).collect(Collectors.toList());
    }
    
    @Override
    public String describeFunction() {
		 return "<HTML><BODY>UPPER converts String values to to UPPER Case "
				+ "<BR> Input: Column name i.e col1"
				+ "<BR> "
				+ "<BR> input - First   Output - FIRST"
				+"</HTML></BODY>";
    	
    }
}
