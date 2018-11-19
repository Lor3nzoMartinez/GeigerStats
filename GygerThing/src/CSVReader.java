import java.util.*;
import java.io.*;


public class CSVReader {

	public static void main(String[] args) {
		//Determine our CSV file and parse output into java
		String fileName = ("C:\\Users\\Lorenzo\\Desktop\\141 Project Geiger\\GygerThing\\Supp Docs\\7_04_18.csv");
		File file = new File(fileName);
		//Declare arrat list to store data
		ArrayList<Object> listOfCounts = new ArrayList(102317);
		ArrayList listOfDates = new ArrayList(102317);
		ArrayList listOfTimes = new ArrayList(102317);
		ArrayList listOfOccurance = new ArrayList(102317);
		
		try {
			Scanner inputStream = new Scanner(file);
			int total = 0;		//init Values
			int counter = 0;	//init Values
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				listOfDates.add(values[0]);
				listOfTimes.add(values[1]);
				listOfOccurance.add(values[2]);
				listOfCounts.add(values[3]);
				double CountsPerMinute = Double.parseDouble(values[3]);
				total += CountsPerMinute;
				counter++;
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Wrong file path!");
		}
		//display(listOfCounts);
		noDupes(listOfCounts);
		
	}
	public static void display(ArrayList<Object> cpm) {
		for (int i = 0; i < cpm.size(); ++i)
			System.out.println(cpm.get(i) + "\n");
	}
	public static void noDupes(ArrayList<Object> cpm){
		int j = 0;
		for (int i = 0; i < cpm.size(); ++i)
			//for (j = cpm.get(i); j < cpm.size(); ++j)
				
	}
}

	
