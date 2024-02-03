package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains all reusable methods to read/write data from/to excel
 * @author KRISHNAVENI
 * 
 */
public class ExcelUtility {
	private Workbook wb;
	private Sheet sh;
	private DataFormatter df;
	public void excelInit(String excelPath, String sheetName) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sh = wb.getSheet(sheetName);
		df= new DataFormatter();
		
	}
	/**
	 * This method is used 9999to read data from Excel
	 * @param exceptedTestName
	 * @return
	 */
	public HashMap<String, String> readFromExcel(String exceptedTestName) {
		HashMap<String, String> map = new HashMap<String,String>();
		for(int i=0;i<=sh.getLastRowNum();i++) {
			if(df.formatCellValue(sh.getRow(i).getCell(1)).equals(exceptedTestName)) {
				for(int j=i;j<=sh.getLastRowNum();j++) {
					map.put(df.formatCellValue(sh.getRow(j).getCell(2)), df.formatCellValue(sh.getRow(j).getCell(3)));
					if(df.formatCellValue(sh.getRow(j).getCell(2)).equals("####"))
						break;
				}
				break; 
				}
			}
		return map; 
		}
	/**
	 * This method is used to write to excel
	 * @param exceptedTestName
	 * @param status
	 * @param excelPath
	 */
	public void updateTestStatus(String exceptedTestName,String status,String excelPath) {
		for (int i=0;i<=sh.getLastRowNum();i++) {
			DataFormatter df = new DataFormatter();
			if(df.formatCellValue(sh.getRow(i).getCell(1)).equals(exceptedTestName)) {
				Cell c=sh.getRow(i).createCell(4);
				c.setCellValue(status);
				break;
			}
		}
		FileOutputStream fos =null;
		try {
			fos = new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close excel
	 */
	public void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
}
