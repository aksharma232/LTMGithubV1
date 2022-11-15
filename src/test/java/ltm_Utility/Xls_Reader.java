package ltm_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public int Lastrownumber;

	public Xls_Reader(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			System.out.println("0");
		else {
			sheet = workbook.getSheetAt(index);
			Lastrownumber = sheet.getLastRowNum() + 1;
		}
		return Lastrownumber;
	}

	public String getcelldatastring(String sheetName, int rowNum, int colNum) {
		
		sheet = workbook.getSheet(sheetName);
		
		String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		
		return celldata;

	}

	public double getcellnumericdata(String sheetName, int rowNum, int colNum) {
				
		double n = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		
		return n;

	}

}