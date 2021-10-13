package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getExcelData(String sheetname, int row, int cell) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public Object[][] getExcelData2(String sheetName) throws Throwable, IOException 
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sht = wb.getSheet(sheetName);
		int lastRow = sht.getLastRowNum();
		short lastCell = sht.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for (int i=0; i<lastRow; i++) {
			for (int j=0; j<lastCell; j++) {
				data[i][j]=sht.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	public void writeExcelData (String sheetName, int rownum, int column, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstant.EXCEL_FILEPATH);
		wb.write(fos);
	}

}
