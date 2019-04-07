package com.yingxsx.excel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


public class ExportUtils {

	/**
	 * 设置sheet表头信息
	 * @param headersInfo
	 * @param sheet
	 */
	public static void outputHeaders(String[] headersInfo ,HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headersInfo.length; i++) {
			sheet.setColumnWidth(i, 4000);
			row.createCell(i).setCellValue(headersInfo[i]);
		}
	}
	
	
	public static void outputColumns(String[] headersInfo,List columnsInfo ,HSSFSheet sheet,int rowIndex) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HSSFRow row;
		int headerSize = headersInfo.length;
		int columnSize = columnsInfo.size();
		// 循环插入多少行
		for (int i = 0; i < columnsInfo.size(); i++) {
			row = sheet.createRow(rowIndex+i);
			Object object = columnsInfo.get(i);
			// 循环每行多少列
			for (int j = 0; j < headersInfo.length; j++) {
				Object value = getFieldValueBuName(headersInfo[i],object);
				row.createCell(j).setCellValue(value.toString());
			}
		}
	}


	/**
	 * 根据对象属性获取值
	 * @param string
	 * @param object
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private static Object getFieldValueBuName(String fieldName, Object object) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String firstLetter = fieldName.substring(0,1).toUpperCase();
		String getter = "get" + firstLetter + fieldName.substring(1);
		Method method = object.getClass().getMethod(getter,new Class[] {});
		Object value = method.invoke(object, new Object[] {});
		return value;
	}
	
}
