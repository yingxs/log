package com.yingxsx.excel;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * JXL解析Excel
 * @author admin
 *
 */
public class JxlReadExcel {
	
	public static void main(String[] args) throws BiffException, IOException {
		//  创建workbook
		Workbook workbook = Workbook.getWorkbook(new File("d:/jxl_test.xls"));
		// 获取第一个工作表sheet
		Sheet sheet = workbook.getSheet(0);
		
		for (int i = 0 ; i<sheet.getRows();i++) {
			for(int j = 0 ; j < sheet.getColumns() ; j++  ) {
				Cell cell = sheet.getCell(j,i);
				System.out.print(cell.getContents()+"  ");
			}
			System.out.println();
		}
		
		workbook.close();
		
		
	}
}
