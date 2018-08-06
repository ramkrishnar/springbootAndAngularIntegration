package com.telus.excel.excelsheet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws EncryptedDocumentException, InvalidFormatException, IOException
    {
    	
    	ArrayList<TelusExcelexample> list=new ArrayList();
    	String SAMPLE_XLSX_FILE_PATH=args[0];
    	
    
    	
    	
    	Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
    	System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
    	System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }
        Map<String, Integer> map = new HashMap<String,Integer>();
        Sheet sheet = workbook.getSheet(args[1]);
        Row row1 = sheet.getRow(0);
      
        for(int colIx= row1.getFirstCellNum(); colIx<row1.getLastCellNum(); colIx++) { 
        	Cell cell = row1.getCell(colIx); 
        	String header=cell.getStringCellValue();
if(header.equals("Encepta ID") || header.equals("Parent Encepta ID") || header.equals("LPDS ID") || 
		header.equals("Address ID") || 
		header.equals("Central Office ID") 
|| header.equals("Building ID") 
|| header.equals("FMS ID") 
|| header.equals("Unit Number") 
|| header.equals("Street Number") 
|| header.equals("Street Number Suffix") 
|| header.equals("Directional Prefix") 
|| header.equals("Street Name") 
|| header.equals("Street Type") 
|| header.equals("Directional Suffix(vector)") 
|| header.equals("City Name") 
|| header.equals("Alternate City Name") 
|| header.equals("Province") 
|| header.equals("Postal Code") 
|| header.equals("Latitude") 
|| header.equals("Longitude") 
|| header.equals("COID DSA") 
|| header.equals("DSA") 
){
	map.put(header,cell.getColumnIndex()); 
}
        	
        	
        	}
        System.out.println("map Size"+map.size());
       
        
        
    	int Encepta = map.get("Encepta ID"); 
    	int Parent=map.get("Parent Encepta ID");
    	int lPDS=map.get("LPDS ID");
    	int Address=map.get("Address ID");
    	int Building=map.get("Building ID");
    	int Central=map.get("Central Office ID");
    	int FMS=map.get("FMS ID");
    	int Unit=map.get("Unit Number");
    	int StreetNumber=map.get("Street Number");
    	int StreetNumberSuffix=map.get("Street Number Suffix");
    	int Directional=map.get("Directional Prefix");
    	int StreetName=map.get("Street Name");
    	int StreetType=map.get("Street Type");
    	int DirectionalSuffix=map.get("Directional Suffix(vector)");
    	int City=map.get("City Name");
    	int AlternateCity=map.get("Alternate City Name");
    	int Province=map.get("Province");
    	int PostalCode=map.get("Postal Code");
    	int latitude=map.get("Latitude");
    	int longitude=map.get("Longitude");
    	int cOidDsa=map.get("COID DSA");
    	int dsa=map.get("DSA");
        
       
        System.out.println("row count"+sheet.getLastRowNum());
        DataFormatter formatter = new DataFormatter();
        
        int i=1;
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
        	Row row= sheet.getRow(rowIndex);
        	
        	TelusExcelexample tsex=new TelusExcelexample();
        	
        	i++;
        	
        
        	
        	
            
               // System.out.print(cellValue + "\t");
                tsex.setEnceptaID(formatter.formatCellValue(row.getCell(Encepta)));
                tsex.setParentEnceptaID(formatter.formatCellValue(row.getCell(Parent)));
                tsex.setlPDSId(formatter.formatCellValue(row.getCell(lPDS)));
                tsex.setAddressId(formatter.formatCellValue(row.getCell(Address)));
                tsex.setBuildingId(formatter.formatCellValue(row.getCell(Building)));
                tsex.setCentralofficeId(formatter.formatCellValue(row.getCell(Central)));
                tsex.setfMSId(formatter.formatCellValue(row.getCell(FMS)));
                tsex.setUnitNumber(formatter.formatCellValue(row.getCell(Unit)));
                tsex.setStreetNumber(formatter.formatCellValue(row.getCell(StreetNumber)));
                tsex.setStreetNumberSuffix(formatter.formatCellValue(row.getCell(StreetNumberSuffix)));
                tsex.setDirectionalPrefix(formatter.formatCellValue(row.getCell(Directional)));
                tsex.setStreetName(formatter.formatCellValue(row.getCell(StreetName)));
                tsex.setStreetType(formatter.formatCellValue(row.getCell(StreetType)));
                tsex.setDirectionalSuffix(formatter.formatCellValue(row.getCell(DirectionalSuffix)));
                tsex.setCityName(formatter.formatCellValue(row.getCell(City)));
                tsex.setAlternateCityName(formatter.formatCellValue(row.getCell(AlternateCity)));
                tsex.setProvince(formatter.formatCellValue(row.getCell(Province)));
                tsex.setPostalCode(formatter.formatCellValue(row.getCell(PostalCode)));
                tsex.setLatitude(formatter.formatCellValue(row.getCell(latitude)));
                tsex.setLongitude(formatter.formatCellValue(row.getCell(longitude)));
                tsex.setCoidDsa(formatter.formatCellValue(row.getCell(cOidDsa)));
                tsex.setDSA(formatter.formatCellValue(row.getCell(dsa)));
                
                
               
                
                
    list.add(tsex);
        }
        System.out.println("no of rows"+i+"object length "+list.size());
        System.out.println("First row values "+list.get(0).getAddressId()+" "+list.get(0).getStreetName()+list.get(0).getDSA()+" "+list.get(0).getStreetNumber());
        System.out.println("Last row values"+list.get(26477).getAddressId()+" "+list.get(26477).getStreetName()+list.get(26477).getDSA()+" "+list.get(26477).getStreetNumber());
        workbook.close();
    }
    
}
