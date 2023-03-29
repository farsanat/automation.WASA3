package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writedatasheet {

	public static void main(String[] args) throws IOException {
		// open document in java readable formatx"
				FileInputStream fls = new FileInputStream("./src/test/resources/organisation.xlsx");
				
				//create workbook
				Workbook wb = WorkbookFactory.create(fls);
				
				//get control of sheet
				Sheet sh = wb.getSheet("organisation");
				//get control of row
				Row rw = sh.getRow(3);
				
				//create cell in that row
				Cell cell = rw.createCell(5);
				//set the value to cell
				cell.setCellValue("wasa");
				//open the document in write mode
				 FileOutputStream fos = new FileOutputStream("./src/test/resources/organisation.xlsx");
				//write the data
				wb.write(fos);
				System.out.println("data added");
               wb.close();
	}

}
