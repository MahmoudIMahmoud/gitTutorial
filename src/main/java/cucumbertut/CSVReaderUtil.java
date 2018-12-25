package cucumbertut;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVReaderUtil {

	public static String[][] csv2array(String filePath, boolean headers) throws IOException {
		Reader in = new FileReader(filePath);
		int numRows = 0;
		int numCols = 0;
		Iterable<CSVRecord> records = null;
		if (headers) 
			records = CSVFormat.EXCEL.withSkipHeaderRecord(true).parse(in);
		else
			records = CSVFormat.EXCEL.parse(in);

		//collect all records.
		ArrayList<CSVRecord> allRecords = new ArrayList<CSVRecord>();

		//get all rows
		for (CSVRecord record : records)
			allRecords.add(record);
		
		CSVRecord rcrd0=allRecords.get(0);
		//get number of columns
		numCols=rcrd0.size();
		
		if (headers)
			allRecords.remove(0);
		//get number of rows
		numRows=allRecords.size();
		
		String[][] my2darray=new String[numRows][numCols];
		for(int r=0;r<numRows;r++)
			for(int c=0;c<numCols;c++)
				my2darray[r][c]=allRecords.get(r).get(c);
		
		return my2darray;
	}
	
	public static String[][] csv2array(String filePath, String[] headers) throws IOException {
		Reader in = new FileReader(filePath);
		int numRows = 0;
		int numCols = 0;
		Iterable<CSVRecord> records = null;
		if (headers != null) 
			records = CSVFormat.EXCEL.withHeader(headers).parse(in);
		else
			records = CSVFormat.EXCEL.parse(in);

		//collect all records.
		ArrayList<CSVRecord> allRecords = new ArrayList<CSVRecord>();

		//get all rows
		for (CSVRecord record : records)
			allRecords.add(record);
		
		CSVRecord rcrd0=allRecords.get(0);
		//get number of columns
		numCols=rcrd0.size();
		
		//Remove the headers' row
		if (headers != null)
			allRecords.remove(0);
		
		//get number of rows
		numRows=allRecords.size();
		
		String[][] my2darray=new String[numRows][numCols];
		for(int r=0;r<numRows;r++)
			for(int c=0;c<numCols;c++)
				my2darray[r][c]=allRecords.get(r).get(c);
		
		return my2darray;
	}

	public static void main(String[] args) throws IOException {
		String filePath = "./data/data.csv";
		String[] header = new String[] { "op1", "op2", "operation", "expected" };

		Reader in = new FileReader(filePath);

		// Iterable<CSVRecord> records =
		// CSVFormat.EXCEL.withHeader("op1","op2","operation","expected").parse(in);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader(header).parse(in);

		ArrayList<CSVRecord> allRecords = new ArrayList<CSVRecord>();

		for (CSVRecord record : records) {
			allRecords.add(record);
			// String op1 = record.get("op1");
			// String op2 = record.get("op2");
			// String operation = record.get("operation");
			// String expected = record.get("expected");
			// System.out.printf("%s\t%s\t%s\t%s\n", op1, op2, operation,
			// expected);
		}

		allRecords.remove(0);// remove the header
		int numRows = allRecords.size();
		int numCols = header.length;
		String[][] _2darr = new String[numRows][numCols];
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++)
				_2darr[r][c] = allRecords.get(r).get(c);
		}

		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				System.out.print(_2darr[r][c] + ",");// =allRecords.get(r).get(c);
			}
			System.out.println("");
		}

	}

}
