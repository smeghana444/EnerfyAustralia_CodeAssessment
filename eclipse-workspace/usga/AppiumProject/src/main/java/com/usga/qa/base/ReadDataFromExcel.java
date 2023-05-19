package com.usga.qa.base;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadDataFromExcel

{
    @DataProvider(name = "getTestData")
    public Object[][] getData()
    {
        String path="/Users/someghana/eclipse-workspace/usga/AppiumProject/src/main/java/com/usga/qa/testdata/PlayersData.xlsx";
        String[][] data=null;

        try{
            File file=new File(path);
            FileInputStream fis=new FileInputStream(file);
            XSSFWorkbook wb=new XSSFWorkbook(fis);
            XSSFSheet sheet=wb.getSheet("Sheet1");
            //Get physical no of rows
            int rows=sheet.getPhysicalNumberOfRows();
            //Get physical no of cells
            int cells=sheet.getRow(0).getPhysicalNumberOfCells();
            data= new String[rows-1][cells];
            for(int i=1;i<rows;i++)
            {
                for(int j=0;j<cells;j++)
                {
                 String cellData=sheet.getRow(i).getCell(j).getStringCellValue();
                 data[i-1][j]=cellData;
                }
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }
}
//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