package kr.co.kil.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelPrint {
	public void setXls() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet hs = wb.createSheet();
		HSSFRow hr = hs.createRow(0);

		HSSFCell hc = null;

		hc = hr.createCell(0);
		hc.setCellValue("첫번째 셀 ");

		hc = hr.createCell(1);
		hc.setCellValue(1234.567);

		hr = hs.createRow(1);
		hc = hr.createCell(0);
		hc.setCellValue("2번째 행에 첫번째 셀 ");

		hc = hr.createCell(1);
		hc.setCellValue(9876.5433);

		File file = new File("c:/Test/TestExcel.xls");
		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				wb.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
