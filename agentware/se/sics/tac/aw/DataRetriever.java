import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

public class DataRetriever {

	private double[][] ASK;
	private double[][] BID;

	DataRetriever(){

		ASK = new double[12][55];
		BID = new double[12][55];

		readData("Data/ASK.txt");
		readData("Data/BID.txt");
	}

	public void readData(String fileName){
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			String delim = "\t";
			int i = 0;

			while ((sCurrentLine = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(sCurrentLine,delim);
				int j = 0;
				while (st.hasMoreTokens()) {
					if (fileName.contains("ASK"))
						ASK[i][j] = Double.parseDouble(st.nextToken());
					else
						BID[i][j] = Double.parseDouble(st.nextToken());

					j++;
				}
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public double[][] getDataASK(){
		return ASK;
	}

	public double[][] getDataBID(){
		return BID;
	}

	public void modifyDataASK(double[][] newASK){
		File ask = new File("ASK.txt");
		ask.delete();

		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("ASK.txt"), "utf-8"));
			
			for (int i=0; i<12; i++){
				for (int j=0; j<55; j++){
					writer.write(newASK[i][j] + "\t");
				}
				writer.write("\n");
			}
		} catch (IOException ex){
			// report
		} finally {
			try {writer.close();} catch (Exception ex) {}
		}

	}

	public void modifyDataBID(double[][] newBID){
		File bid = new File("BID.txt");
		bid.delete();

		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("BID.txt"), "utf-8"));
			
			for (int i=0; i<12; i++){
				for (int j=0; j<55; j++){
					writer.write(newBID[i][j] + "\t");
				}
				writer.write("\n");
			}
		} catch (IOException ex){
			// report
		} finally {
			try {writer.close();} catch (Exception ex) {}
		}
	}

}
