package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String[][] runReadExcelData(String workBookName, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		
		//Set path for workbook
		XSSFWorkbook wb = new XSSFWorkbook("./testdata/"+workBookName+".xlsx");
		//workBook.getSheetAt(0);
		
		//Get work sheet name
		XSSFSheet sheet =wb.getSheet(sheetName);
		
		/*String firstCellValue =sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(firstCellValue);*/
		
		
		//get row count
		int rowCount =sheet.getLastRowNum();
		System.out.println("Row Count:" + rowCount);
		
		//get column count
		int colCount =sheet.getRow(0).getLastCellNum();
		System.out.println("Col count:" + colCount);
		
		//get first row value
		XSSFRow row =sheet.getRow(0);
		XSSFCell col = row.getCell(0);
		String cellValue =col.getStringCellValue();
		System.out.println(cellValue);
		
		String[][] data = new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			XSSFRow eachRow =sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				XSSFCell eachCell=eachRow.getCell(j);
				String cellValues =eachCell.getStringCellValue();
				System.out.println(cellValues);
				data[i-1][j]=cellValues;
			
			}
			
		}
		wb.close();
	return data;
		
	}

}
