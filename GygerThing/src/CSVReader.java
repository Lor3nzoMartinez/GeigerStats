import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class CSVReader {

	public static <CountsPerMinute> void main(String[] args) {
		//Determine our CSV file and parse output into java
		String fileName = ("C:\\Users\\Lorenzo\\Desktop\\141 Project Geiger\\GygerThing\\Supp Docs\\7_04_18.csv");
		File file = new File(fileName);
		
		try {
			Scanner inputStream = new Scanner(file);
			ArrayList<CountsPerMinute> listOfCounts = new ArrayList();
			int total = 0;		//init Values
			int counter = 0;	//init Values
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				CountsPerMinute values = data.split(",");
				String date = values[0];
				String time = values[1];
				String howOften = values[2];
				double CountsPerMinute = Double.parseDouble(values[3]);
				listOfCounts.add(values[3]);
				total += CountsPerMinute;
				counter++;
				
	
			}
			System.out.print(listOfCounts);
			inputStream.close();
			System.out.println("Average is "+ (total / counter));
			
			
			
			
			
			
			/*for (int counter = 0; inputStream.hasNext(); counter++)
				System.out.println(data);*/
			
					
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("I don't see anything!");;
		}
	}
}
	

