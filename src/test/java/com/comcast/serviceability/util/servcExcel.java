
package com.comcast.serviceability.util;

import com.comcast.serviceability.common.pages.serviceabilityTestCore;

public class servcExcel extends serviceabilityTestCore{

//Change the location of test data sheet
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\comcast\\serviceability\\testdata\\testdata.xlsx"); 

	public static boolean isExecutable(String tcid)
	{
		for(int rowNum=2;rowNum<=excel.getRowCount("TESTCASES");rowNum++)
		{
			if(excel.getCellData("TESTCASES", "Tcid", rowNum).equals(tcid))
			  {
				if(excel.getCellData("TESTCASES", "Runmode", rowNum).equalsIgnoreCase("Y"))
					{
							return true;
					}
				
				else
	
					{
							return false;
					}
			  }
			
			

		}
		return false;

	}
	
public static Object[][] getData(String sheetName){
		
		int rows = excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ 
			
			
			
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); 
			}
		}
		
		return data;
	}
}