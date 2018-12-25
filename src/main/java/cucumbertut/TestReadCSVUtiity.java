package cucumbertut;

import java.io.IOException;

public class TestReadCSVUtiity {

	public static void main(String[] args) throws IOException {
		String[][] data=CSVReaderUtil.csv2array("./data/data.csv", true);
		for(String[] row:data)
			for(String col:row)
				System.out.println(col);
	}
}
