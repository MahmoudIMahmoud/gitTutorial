package cucumbertut;

import java.io.IOException;

public class TestReadCSVUtiity {

	public static void main(String[] args) throws IOException {
		String[][] data=CSVReaderUtil.csv2array("./data/data.csv", true);
		System.out.println("row count:"+data.length);
		System.out.println("col count:"+data[0].length);
		for(String[] row:data)
			for(String col:row)
				System.out.println(col);
	}
}
