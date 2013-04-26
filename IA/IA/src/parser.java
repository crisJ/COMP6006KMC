import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class parser {

	public parser() {

	}

	private void parse() throws FileNotFoundException {

		File folder = new File("src/gamelogs");

		try {
			FileWriter inflight1 = new FileWriter(new File("inflight1"), true);
			FileWriter inflight2 = new FileWriter(new File("inflight2"), true);
			FileWriter inflight3 = new FileWriter(new File("inflight3"), true);
			FileWriter inflight4 = new FileWriter(new File("inflight4"), true);

			FileWriter outflight2 = new FileWriter(new File("outflight2"), true);
			FileWriter outflight3 = new FileWriter(new File("outflight3"), true);
			FileWriter outflight4 = new FileWriter(new File("outflight4"), true);
			FileWriter outflight5 = new FileWriter(new File("outflight5"), true);

			File[] listOfFiles = folder.listFiles();
			String nameOfFile;
			System.out.println(folder.getAbsolutePath());

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					BufferedReader reader = new BufferedReader(new FileReader(listOfFiles[i]));
					
					inflight1.write(listOfFiles[i].getName() + "\n"+ "\n");
					inflight2.write(listOfFiles[i].getName() + "\n"+ "\n");
					inflight3.write(listOfFiles[i].getName() + "\n"+ "\n");
					inflight4.write(listOfFiles[i].getName() + "\n"+ "\n");
					
					outflight2.write(listOfFiles[i].getName() + "\n"+ "\n");
					outflight3.write(listOfFiles[i].getName() + "\n"+ "\n");
					outflight4.write(listOfFiles[i].getName() + "\n"+ "\n");
					outflight5.write(listOfFiles[i].getName() + "\n"+ "\n");
					
					while (reader.ready()) {
						
						String line = reader.readLine();
						if (line.length() > 50) {
							System.out.println(line.substring(20, 28));
							if (line.substring(11, 19).equals("MARTINOS")) {
								
								System.out.println(line); 
								
								if(line.substring(20,28).equals("inflight")){
									
									
									String day = line.substring(29,30);
									int pricesub = 41;
									while(!line.substring(pricesub, pricesub+1).equals(" ")){
										pricesub++;
									}
									String price = line.substring(41,pricesub);
									System.out.println(price);
									
									int timeInt = pricesub;
									while(!line.substring(timeInt, timeInt+1).equals("<")){
										timeInt++;
									}
									String time= "";
									time = line.substring(pricesub+7 , timeInt);
									
									System.out.println(time);
									
									
								if(day.equals("1")){
									inflight1.write(price + " " + time + "\n");
								}
								else if(day.equals("2")){
									inflight2.write(price + " " + time + "\n");
								}
								else if(day.equals("3")){
									inflight3.write(price + " " + time + "\n");
								}
								else if(day.equals("4")){
									inflight4.write(price + " " + time + "\n");
								}
								
								
								}
								else if(line.substring(20,28).equals("outflight")){
									
									
									String day = line.substring(29,30);
									int pricesub = 41;
									while(!line.substring(pricesub, pricesub+1).equals(" ")){
										pricesub++;
									}
									String price = line.substring(41,pricesub);
									System.out.println(price);
									
									int timeInt = pricesub;
									while(!line.substring(timeInt, timeInt+1).equals("<")){
										timeInt++;
									}
									String time= "";
									time = line.substring(pricesub+7 , timeInt);
									
									System.out.println(time);
									
									
								if(day.equals("1")){
									outflight2.write(price + " " + time + "\n");
								}
								else if(day.equals("2")){
									outflight3.write(price + " " + time + "\n");
								}
								else if(day.equals("3")){
									outflight4.write(price + " " + time + "\n");
								}
								else if(day.equals("4")){
									outflight5.write(price + " " + time + "\n");
								}
								
								
								}
							}

						}
						

						

					}
					inflight1.write("\n"+ "\n");
					inflight2.write("\n"+ "\n");
					inflight3.write("\n"+ "\n");
					inflight4.write("\n"+ "\n");
					
					outflight2.write("\n"+ "\n");
					outflight3.write("\n"+ "\n");
					outflight4.write("\n"+ "\n");
					outflight5.write("\n"+ "\n");
					
					inflight1.flush();
					inflight2.flush();
					inflight3.flush();
					inflight4.flush();
					
					outflight2.flush();
					outflight3.flush();
					outflight4.flush();
					outflight5.flush();
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		parser x = new parser();
		try {

			x.parse();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
