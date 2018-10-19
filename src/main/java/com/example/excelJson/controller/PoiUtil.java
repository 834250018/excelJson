package com.example.excelJson.controller;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

@SuppressWarnings({ "deprecation", "resource" })
public class PoiUtil {

	// 默认单元格内容为数字时格式
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static ArrayList<ArrayList<Object>> readExcel(File file) {
		try {
			ArrayList<ArrayList<Object>> rowList = new ArrayList<>();
			ArrayList<Object> colList;
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			Object value;
			for (int i = sheet.getFirstRowNum(), rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				colList = new ArrayList<>();
				if (row == null) {
					continue;
				} else {
					rowCount++;
				}
				if(isRowEmpty(row)) {
					continue;
				}
				for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						// 当该单元格为空
						if (j != row.getLastCellNum()) {// 判断是否是该行中最后一个单元格
							colList.add("");
						}
						continue;
					}
					if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC && j == 27) {
						value = df.format(cell.getNumericCellValue());
					} else {
						value = cell.toString();
					}
					colList.add(value);
				} // end for j
				rowList.add(colList);
			} // end for i

			return rowList;
		} catch (Exception e) {
			return null;
		}
	}

	static boolean isRowEmpty(HSSFRow row) {
		for(int c = row.getFirstCellNum(); c <= row.getLastCellNum(); c++) {
			HSSFCell cell = row.getCell(c);
			if(cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
				return false;
			}
		}
		return true;
	}
}