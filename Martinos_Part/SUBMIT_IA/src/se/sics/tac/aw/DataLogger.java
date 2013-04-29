package se.sics.tac.aw;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DataLogger {

	File file;  
	FileWriter fwrite; 
	BufferedWriter bwrite;
	
	public DataLogger(String name){
		file = new File(name);
		try {
			fwrite = new FileWriter(file,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bwrite = new BufferedWriter(fwrite);
	}
	
	public void logData(String time, String price){
		try {
			bwrite.write(time + "   " + price + "\n");
			bwrite.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void logData(String x){
		try {
			bwrite.write(x + "\n");
			bwrite.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		
	}

	public void logData(long gameTime, int allocation) {
		// TODO Auto-generated method stub
		
	}
}
