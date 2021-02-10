package SelniumPractice.WebAutomation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReaderBuilder;

public class csvUtils {
	static String configPropertyFilePath="C:\\Users\\ankit\\Desktop\\selenium\\workspace\\WebAutomation\\src\\test\\java\\SelniumPractice\\WebAutomation\\config.properties";
	static String envPropertyFilePath="C:\\Users\\ankit\\Desktop\\selenium\\workspace\\WebAutomation\\src\\test\\java\\SelniumPractice\\WebAutomation\\env.properties";

	public static StringBuffer csvGenrator(String firstHeader,String lastHeader,int numberOfCOlumns,int numberOfRows) throws IOException {

		
		FileInputStream fileInStream = new FileInputStream("C:\\Users\\ankit\\Desktop\\Excel\\Book1.xlsx");

		int rowcount = 1;
		
		
		// Open the xlsx and get the requested sheet from the workbook
		XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
		// Get Sheet from WorkBook
		XSSFSheet s1 = workBook.getSheetAt(0);
		
		
		// String buffer to be written in CSV file
		StringBuffer sb = new StringBuffer();

		// Get number of rows from sheet 0
		int rc = s1.getLastRowNum();
//		System.out.println("Last Number of Rows" + rc);

		// start iteration in rowise
		for (int i = s1.getFirstRowNum(); i < rc;i++ ) {
//			System.out.println("Value of i for the row" + i);
			
			if(s1.getRow(i) != null) {
			
			
			// Get Number of cell in the first row i=0
			int cc = s1.getRow(i).getLastCellNum();
//			System.out.println("last of cell" + cc);

			// Start iteration in the first row
			for (int j = 0; j < cc;j++ ) {

				if (s1.getRow(i).getCell(j) != null) {

					int temp = j;

					
					if((s1.getRow(i).getCell(j)) != null && (s1.getRow(i).getCell(j + (numberOfCOlumns-1))) != null) {
//						System.out.println("Not null validation for j"+s1.getRow(i).getCell(j));
		
				if((s1.getRow(i).getCell(j).getCellType() == s1.getRow(i).getCell(j).getCellType().NUMERIC) ||(s1.getRow(i).getCell(j + (numberOfCOlumns-1)).getCellType()==s1.getRow(i).getCell(j + (numberOfCOlumns-1)).getCellType().NUMERIC) ) {
//					System.out.println("value is numeric"+s1.getRow(i).getCell(j));
				}
				else if (((s1.getRow(i).getCell(j).getStringCellValue()).equals(firstHeader))
							&& ((s1.getRow(i).getCell(j + (numberOfCOlumns-1)).getStringCellValue()).equals(lastHeader))) {

						for (int k = 0; k < numberOfCOlumns;) {
//							System.out.println("j values is--------- " + j);
							Cell c1 = s1.getRow(i).getCell(j);

//							System.out.println(c1);
//							System.out.println("k value is under k loop " + k);
//							System.out.println("i value is under k loop" + i);

							if (c1 != null) {
								switch (c1.getCellType()) {

								case STRING:
//									System.out.println("k value is under switch string" + k);
//									System.out.println("i value is under switch string" + i);

									sb.append(c1.getStringCellValue() + ",");
									break;
								case NUMERIC:
//									System.out.println("k value is under switch numeric" + k);
//									System.out.println("i value is under switch numeric" + i);

									sb.append(c1.getNumericCellValue() + ",");
									break;
								case BOOLEAN:
									sb.append(c1.getBooleanCellValue() + ",");
									break;

								case _NONE:
									break;

								case BLANK:
									break;

								default:
									break;
								}
							}
							k++;
							j++;
//							System.out.println("J value is "+j);
							if (k % numberOfCOlumns == 0 && rowcount != numberOfRows) {
//								System.out.println("in rowcount loop k value" + k);
								rowcount++;
								k = 0;
								j = temp;
								i++;
//								System.out.println("in rowcount loop i value" + i);
							}
						}
						
						break;

					}
					
					}
					
				}
		

			}
			}

		}
		
		return sb;
//		System.out.println(sb.toString());
//		fileOut.write(sb.toString().getBytes());
//		fileOut.close();
	}

	
	
	
//	public static void convertSelectedSheetInXLXSFileToCSV() throws Exception {
//		
//		FileInputStream configPropFile=new FileInputStream(configPropertyFilePath);
//		Properties prop=new Properties();
//		prop.load(configPropFile);
//		
//		FileInputStream envPropfile=new FileInputStream(envPropertyFilePath);
//		Properties envP=new Properties();
//		envP.load(envPropfile);
//		
//		String path = envP.getProperty("folderPathforInputExcel");
//		String inputExcelFileName = envP.getProperty("inputExcelFileName");
//		String ouputCSVFileName=envP.getProperty("ouputCSVFileName");
//
//		FileInputStream fileInStream = new FileInputStream(path+inputExcelFileName);
////		FileInputStream fileInStream = new FileInputStream("C:\\Users\\ankit\\Desktop\\Excel\\Book1.xlsx");		
//		FileOutputStream fileOut = new FileOutputStream(path+ouputCSVFileName);
//
//		// Open the xlsx and get the requested sheet from the workbook
//		XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
//		XSSFSheet selSheet = workBook.getSheetAt(0);
//
//		// Iterate through all the rows in the selected sheet
//		Iterator<Row> rowIterator = selSheet.iterator();
//	
//		while (rowIterator.hasNext()) {
//
//			Row row = rowIterator.next();
//
//			// Iterate through all the columns in the row and build ","
//			// separated string
//			Iterator<Cell> cellIterator = row.cellIterator();
//			StringBuffer sb = new StringBuffer();
//			while (cellIterator.hasNext()) {
//				Cell cell = cellIterator.next();
//
//				switch (cell.getCellType()) {
//				case STRING:
//					sb.append(cell.getStringCellValue() + ",");
//					break;
//				case NUMERIC:
//					sb.append(cell.getNumericCellValue() + ",");
//					break;
//				case BOOLEAN:
//					sb.append(cell.getBooleanCellValue() + ",");
//					break;
//
//				default:
//
//				}
//
//			}
//
//			System.out.println(sb.toString());
//			fileOut.write(sb.toString().getBytes());
//
//		}
//
//		fileOut.close();
//
//	}
	
	
	public static void csvComparison() throws IOException {
		
		FileInputStream envPropfile=new FileInputStream(envPropertyFilePath);
		Properties envP=new Properties();
		envP.load(envPropfile);
		
		String path = envP.getProperty("folderPathforCSVComparison");
		String file1 = envP.getProperty("ouputCSVFileName");
		String file2 =  envP.getProperty("baseLineCSVFileName");
		String file3 = envP.getProperty("ResultCSVFileName");
		ArrayList al1 = new ArrayList();
		ArrayList al2 = new ArrayList();
		
		
		FileInputStream fis=new FileInputStream(configPropertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		
		int table1ColCount = Integer.parseInt(prop.getProperty("noOfColumnsInTable1"));
		int table2ColCount = Integer.parseInt(prop.getProperty("noOfColumnsInTable2"));

		FileWriter writer = new FileWriter(path + "\\" + file3);
		// ArrayList al3=new ArrayList();

		BufferedReader CSVFile1 = new BufferedReader(new FileReader(path + "\\" + file1));
		String dataRow1 = CSVFile1.readLine();
		while (dataRow1 != null) {
			String[] dataArray1 = dataRow1.split(",");
			for (String item1 : dataArray1) {
				al1.add(item1);
			}

			dataRow1 = CSVFile1.readLine(); // Read next line of data.
		}

		CSVFile1.close();

		BufferedReader CSVFile2 = new BufferedReader(new FileReader(path + "\\" + file2));
		String dataRow2 = CSVFile2.readLine();
		while (dataRow2 != null) {
			String[] dataArray2 = dataRow2.split(",");
			for (String item2 : dataArray2) {
				al2.add(item2);

			}
			dataRow2 = CSVFile2.readLine(); // Read next line of data.
		}
		CSVFile2.close();

		for (int i = 0; i < al1.size();) {
		

			if ((al1.get(i).equals(prop.getProperty("firstColumnHeaderTable1")) && al1.get(i + table1ColCount - 1).equals(prop.getProperty("LastColumnHeaderTable1")))
					|| (al1.get(i).equals(prop.getProperty("firstColumnHeaderTable2")) && al1.get(i + table2ColCount - 1).equals(prop.getProperty("LastColumnHeaderTable2")))) {

				if (al1.get(i).equals(prop.getProperty("firstColumnHeaderTable1")) && al1.get(i + table1ColCount - 1).equals(prop.getProperty("LastColumnHeaderTable1"))) {

					for (int k = i; k < table1ColCount;) {
						writer.append("" + al1.get(k));
						writer.append(",");
						k++;
						i++;
					}
				} else if (al1.get(i).equals(prop.getProperty("firstColumnHeaderTable2")) && al1.get(i + table2ColCount - 1).equals(prop.getProperty("LastColumnHeaderTable2"))) {

					int counter = i + table2ColCount;
					for (int k = i; k < counter;) {

						writer.append("" + al1.get(k));
						writer.append(",");
						k++;
						i++;

					}

				}

			}
			else if (al1.get(i).equals(al2.get(i))) {
				
				System.out.println(al1.get(i) + " == " + al2.get(i));
				writer.append("" + "--");
				writer.append(",");
				i++;
			} else {

				System.out.println(al1.get(i) + " != " + al2.get(i));
				writer.append("" + al1.get(i));
				writer.append(",");
				i++;
			}

		}
		writer.flush();
		writer.close();

		System.out.println("File Created Successfully.");
		System.out.println("PLease Check the File on Below Location");
		System.out.println(path + "\\" + file3);

		for (Object bs : al2) {
			al1.remove(bs);
		}

		int size = al1.size();
		System.out.println("Number of Values found diff are  " + size);

	}
	
	
	public static void csvtoExcelCOnverion() throws IOException {
		// Data from CSV inserted into array
				
		FileInputStream fis=new FileInputStream(configPropertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		
		FileInputStream envPropfile=new FileInputStream(envPropertyFilePath);
		Properties envP=new Properties();
		envP.load(envPropfile);
		String finalExcelFolderPath=envP.getProperty("finalExcelFolderPath");
		String finalOutputExcelFile=envP.getProperty("finalOutputExcelFile");
		
		String[] line;
				
				//Row increment
				int r = 0;
				
				// No. of columns in tables
//				int table1ColCount = 5;
//				int table2ColCount = 4;
				
				int table1ColCount = Integer.parseInt(prop.getProperty("noOfColumnsInTable1"));
				int table2ColCount = Integer.parseInt(prop.getProperty("noOfColumnsInTable2"));

				// No of row in table
				int table1RowCount = Integer.parseInt(prop.getProperty("noOfRowsInTable1"));
				int table2RowCount = Integer.parseInt(prop.getProperty("noOfRowsInTable2"));

				int rowCount = 1;

				Workbook wb = new HSSFWorkbook();
				CreationHelper helper = wb.getCreationHelper();
				Sheet sheet = wb.createSheet("new sheet");

				// Border for Cell
				HSSFCellStyle style = (HSSFCellStyle) wb.createCellStyle();
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);

				// CSV file reader
				CSVReaderBuilder reader = new CSVReaderBuilder(
						new FileReader("C:\\Users\\ankit\\Desktop\\Excel\\Book4CSV.csv"));


				while ((line = reader.build().readNext()) != null) {
					// Creating a new row
					Row row = sheet.createRow((short) r++);

					for (int i = 0; i < line.length;) {

						// Checking for A1 and A5
						if (line[i].equals(prop.getProperty("firstColumnHeaderTable1")) && line[i + 4].equals(prop.getProperty("LastColumnHeaderTable1"))) {

							// iteration till the no. of columns in table 1
							for (int k = 0; k < table1ColCount;) {
								if (!line[i].equals(prop.getProperty("firstColumnHeaderTable2"))) {

									Cell cell = row.createCell(k);
									cell.setCellStyle(style);
									cell.setCellValue(helper.createRichTextString(line[i]));
									k++;
									i++;

									// Creating row on inserting every 5th Element in 5th Column
									if (i % 5 == 0 && rowCount != table1RowCount) {
										rowCount++;
										k = 0;
										row = sheet.createRow((short) r++);

									}
								}
							}

						}
						// checking the combination of B1 and B4 for second Table
						else if ((line[i].equals(prop.getProperty("firstColumnHeaderTable2"))) && (line[i + 3].equals(prop.getProperty("LastColumnHeaderTable2")))) {

							// Creating two rows.--One for Gap b/w 2 tables and another for data insertion
							row = sheet.createRow((short) r++);
							row = sheet.createRow((short) r++);

							int temp = i;
							rowCount = 1;

							// iteration for 2nd table with respect to number of columns
							for (int k = 0; k < table2ColCount;) {
								Cell cell = row.createCell(k);
								cell.setCellStyle(style);
								cell.setCellValue(helper.createRichTextString(line[i]));
								k++;
								i++;

								if ((i == temp + 4) && rowCount != table2RowCount) {
									rowCount++;
									k = 0;
									row = sheet.createRow((short) r++);
									temp = temp + 4;

								}

							}

						} else {

							break;
						}

					}

					// Write the output to a file
					FileOutputStream fileOut = new FileOutputStream(finalExcelFolderPath+finalOutputExcelFile);
					wb.write(fileOut);
					fileOut.close();
				}

				System.out.println("File Created sucessfully.");
			}
	}
		
	



