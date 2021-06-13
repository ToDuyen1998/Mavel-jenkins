package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	DecimalFormat df = new DecimalFormat("0.######");

	public String[] readExcel(String fileName,String sheetName)
	{
    	String mangRow[] = null;
    	try {
    		File file = new File (fileName);
        	FileInputStream inputStream = new FileInputStream (file);
        	
        	workbook = new XSSFWorkbook(inputStream);
            //XSSFSheet sheet = workbook.getSheetAt(0);
        	sheet = workbook.getSheet(sheetName);
    	} catch (Exception e) {
			// TODO: handle exception
		}
        	int sl = sheet.getLastRowNum();

        	mangRow = new String[sl];
        	
        	for (int i = 1; i <= sheet.getLastRowNum(); i++) 
            {
               Row row = sheet.getRow(i);
                if(i > 0)
                {
                    String dataTest = "";
                    for (int cn = 0; cn < row.getLastCellNum(); cn++) 
                    {
                    	Cell cell = row.getCell(cn,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                        if(cell != null){
                            CellType cellType = cell.getCellType();
                            if(cellType == null)
                            {
                                dataTest += "null"+"#";
                            }
                            else{
                                switch (cellType) {
                                    case NUMERIC:
                                        dataTest += df.format(cell.getNumericCellValue()) + "#";
                                        break;
                                    case STRING:
                                        if(cell.getStringCellValue().trim().equals("null"))
                                        {
                                            dataTest += "null" + "#";
                                        }
                                        else
                                        {
                                            dataTest += cell.getStringCellValue() +"#";
                                        }
                                        break;
                                    case BLANK:
                                        dataTest += "null" + "#";
                                        break;
                                }
                            }
                        }
                    }
                    mangRow[i-1] = dataTest;
                }
            }     
        return mangRow;
	}
}
