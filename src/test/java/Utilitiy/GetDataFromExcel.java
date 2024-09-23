package Utilitiy;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {

	public static String Readexcelfile(String Test_keyword, String value) throws Throwable {
		String result = "";
		try {
			File file = new File(System.getProperty("user.dir") + "/Test_case.xlsx");
			FileInputStream s = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(s);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int Rows = sheet.getPhysicalNumberOfRows();
			int Columns = sheet.getRow(0).getPhysicalNumberOfCells();
			HashMap<String, String> h1 = new HashMap<>();
			for (int i = 0; i < Rows; i++) {
				System.out.println(sheet.getRow(i).getCell(0).toString());
				if (sheet.getRow(i).getCell(0).toString().equals(Test_keyword)) {
					for (int j = 0; j < Columns; j++) {
						String var = "";
						if (sheet.getRow(i).getCell(j) != null) {
							var = sheet.getRow(i).getCell(j).toString();
						}
						h1.put(sheet.getRow(0).getCell(j).toString(), var);

					}

				}
			}
			System.out.println(h1.toString());
			result = h1.get(value);

			/*
			 * FileInputStream fis = new FileInputStream(new
			 * File("D:/Scratch_Framework/Test_data.xlsx")); XSSFWorkbook wb = new
			 * XSSFWorkbook(fis); //String sheet_name =
			 * Read_config.get_from_config("test_sheet_name");
			 * //System.out.println("sheet name = " + sheet_name); XSSFSheet ws =
			 * wb.getSheet("Sheet1"); int no_of_rows = ws.getPhysicalNumberOfRows(); int
			 * no_of_cols = ws.getRow(0).getPhysicalNumberOfCells(); for(int
			 * i=0;i<no_of_rows;i++) {
			 * System.out.println(ws.getRow(i).getCell(0).toString()); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(result);
		return result;

	}

	public static HashMap<String, String> CreateExcelmap(String Sheetname) throws Throwable {
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			File file = new File(System.getProperty("user.dir") + "/Test_case.xlsx");
			FileInputStream s = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(s);
			XSSFSheet sheet = wb.getSheet(Sheetname);
			int Rows = sheet.getPhysicalNumberOfRows();
			//int Columns = sheet.getRow(0).getPhysicalNumberOfCells();
			//HashMap<String, String> h1 = new HashMap<>();
			for (int i = 1; i < Rows; i++) {

				map.put(sheet.getRow(i).getCell(0).toString(), sheet.getRow(i).getCell(1).toString());

			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		// System.out.println(result);
		return map;

	}

	public static void main(String args[]) throws Throwable {

		String var1 = Readexcelfile("TC_01", "name");
		System.out.println(var1);

	}
	public static HashMap<String, Object> read_excel_as_map(String scenario_keyword) throws Throwable{
		HashMap<String, Object> map_data = new HashMap<>();
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(
					System.getProperty("user.dir") + "/Test_case.xlsx")));
			XSSFSheet ws = wb.getSheet("Sheet1");
			int rows = ws.getPhysicalNumberOfRows();
			int cols = ws.getRow(0).getPhysicalNumberOfCells();
			for(int i = 0; i < rows; i++) {
				if(ws.getRow(i).getCell(0).toString().equals(scenario_keyword)) {
					for(int j = 0; j < cols; j++) {
						map_data.put(ws.getRow(0).getCell(j).toString(), ws.getRow(i).getCell(j));
					}
				}
			}
			wb.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return map_data;
	}
	
}
