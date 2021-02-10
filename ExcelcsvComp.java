package SelniumPractice.WebAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ExcelcsvComp extends csvUtils{

	public static void main(String[] args) throws Exception  {
		
		//Converts Excel to CSV file as per the parameters provided in Config file
		
		String configPropertyFilePath = "C:\\Users\\ankit\\Desktop\\selenium\\workspace\\WebAutomation\\src\\test\\java\\SelniumPractice\\WebAutomation\\config.properties";
		String envPropertyFilePath = "C:\\Users\\ankit\\Desktop\\selenium\\workspace\\WebAutomation\\src\\test\\java\\SelniumPractice\\WebAutomation\\env.properties";

		FileInputStream fis = new FileInputStream(configPropertyFilePath);
		Properties prop = new Properties();
		prop.load(fis);

		FileInputStream envPropfile = new FileInputStream(envPropertyFilePath);
		Properties envP = new Properties();
		envP.load(envPropfile);

		int t1NoOfCols = Integer.parseInt(prop.getProperty("noOfColumnsInTable1"));
		int t2NoOfCols = Integer.parseInt(prop.getProperty("noOfColumnsInTable2"));

		int t1NoOfRows = Integer.parseInt(prop.getProperty("noOfRowsInTable1"));
		int t2NoOfRows = Integer.parseInt(prop.getProperty("noOfRowsInTable2"));

		String t1FirstColHeader = prop.getProperty("firstColumnHeaderTable1");
		String t1LastColHeader = prop.getProperty("LastColumnHeaderTable1");

		String t2FirstColHeader = prop.getProperty("firstColumnHeaderTable2");
		String t2LastColHeader = prop.getProperty("LastColumnHeaderTable2");

		String path = envP.getProperty("folderPathforInputExcel");
		String inputExcelFileName = envP.getProperty("inputExcelFileName");
		String ouputCSVFileName = envP.getProperty("ouputCSVFileName");

		StringBuffer table1 = csvGenrator(t1FirstColHeader, t1LastColHeader, t1NoOfCols, t1NoOfRows);
		
		System.out.println("PFB, the table data from table 1.");
		System.out.println(table1+"\n");
		
		StringBuffer table2 = csvGenrator(t2FirstColHeader, t2LastColHeader, t2NoOfCols, t2NoOfRows);
		
		System.out.println("PFB, the table data from table 2.");
		System.out.println(table2+"\n");

		StringBuffer finalData = table1.append(table2);
		
		System.out.println("CSV File generated on the Below Location : - ");
		System.out.println(path + ouputCSVFileName+"\n");

		FileOutputStream fileOut = new FileOutputStream(path + ouputCSVFileName);
		
		
		fileOut.write(finalData.toString().getBytes());
		fileOut.close();

		
		//Compare Actual and Baseline CSV and Generates a 3rd CSV 
		csvComparison();
		System.out.println("Actual and Baseline CSV comparison completed.\n");
//		
//		//Converts Back the CSV to Excel
		csvtoExcelCOnverion();
		System.out.println("csv to Excel conversion completed.\n");
		
		
	}

}
