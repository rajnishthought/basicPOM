package reuseableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	String filePath;

	public ExcelOperations() throws Exception {
		// TODO Auto-generated constructor stub
		filePath = System.getProperty("user.dir")
				+ PropertiesOperations.getPropertyValueByKey("excelpath");
		System.out.println(filePath);
	}

	public HashMap<String, String> getExcelDataInMap(int rowNum) throws EncryptedDocumentException, IOException {
		File testDataFile = new File(filePath);
		Workbook wb = WorkbookFactory.create(testDataFile);
		Sheet sh = wb.getSheet("Sheet1");

		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(0).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
		return hm;
	}
	
	public static void main(String[] args) throws Exception {
		ExcelOperations eo = new ExcelOperations();
		System.out.println(eo.getExcelDataInMap(1));
	}
}
