package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readdatasheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// open document in java readable format
		FileInputStream fls = new FileInputStream("./src/test/resources/organisation.xlsx");
		
		//create workbook
		Workbook wb = WorkbookFactory.create(fls);
		
		//get control of sheet
		Sheet sh = wb.getSheet("organisation");
		//get control of row
		Row rw = sh.getRow(3);
		
		//get control of cell
		Cell cell = rw.getCell(2);
		//read the data inside the cell
		String value = cell.getStringCellValue();
		System.out.println(value);

	}

}
