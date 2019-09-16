package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import domain.EmpBean;

public class ExcelPrint {



	public void setXls(List<EmpBean> eb_list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet hs = wb.createSheet();
		HSSFRow hr = hs.createRow(0);

		HSSFCell hc;


		EmpBean eb;
		
		for(int rowidx=0; rowidx<eb_list.size(); rowidx++) {
			eb = eb_list.get(rowidx);
			
			hr = hs.createRow(rowidx+1);
			
			hc = hr.createCell(0);
			hc.setCellValue(eb.getEmpno());
			
			hc = hr.createCell(1);
			hc.setCellValue(eb.getEname());
			
			hc = hr.createCell(2);
			hc.setCellValue(eb.getHiredate());
			
			hc = hr.createCell(3);
			hc.setCellValue(eb.getJob());
			
			hc = hr.createCell(4);
			hc.setCellValue(eb.getSal());
			
			hc = hr.createCell(5);
			hc.setCellValue(eb.getMgr());
			
			hc = hr.createCell(6);
			hc.setCellValue(eb.getDeptno());
		
		
		}
		
		File file = new File("c:/Test/TestExcel2.xls");
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
