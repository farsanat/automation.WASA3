package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains generic methods related to excel file
 * @author farsana
 *
 */
public class ExcelFileUtility {
	public String readDataFromExcel(String sheet,int row,int cel) throws IOException
	{
		
		FileInputStream fls = new FileInputStream(IConstantsUtility.excelfilepath);
    Workbook wb = WorkbookFactory.create(fls);
	Sheet sh = wb.getSheet(sheet);
	Row rw = sh.getRow(row);
	Cell cell = rw.getCell(cel);
	String value = cell.getStringCellValue();
	wb.close();
	
	return value;
	

}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
		
		
	}
	public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Row rw = wb.getSheet(sheet).getRow(row);
		rw.createCell(cel).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.excelfilepath);
		wb.write(fos);
		System.out.println(value+" --> data added");
		wb.close();
	}
	public Object[][] readMultipleData(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		int lastcel=sh.getRow(0).getLastCellNum();
		Object data[][]=new Object[lastrow][lastcel];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}}
		return data;
			}
		}
	

