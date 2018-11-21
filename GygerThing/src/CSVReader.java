import java.util.*;
import java.io.*;

public class CSVReader {

	public static void main(String[] args) {
		//Determine our CSV file and parse output into java
		String fileName = ("C:\\Users\\Lorenzo\\Desktop\\141 Project Geiger\\GygerThing\\Supp Docs\\7_04_18.csv");
		File file = new File(fileName);
		//Declare array list to store data
		ArrayList<Integer> listOfCounts = new ArrayList();
		ArrayList<String> listOfDates = new ArrayList();
		
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				int countsPerMinute = Integer.parseInt(values[3]);
				listOfCounts.add(countsPerMinute);
				String dateOfCount = values[0];
				listOfDates.add(dateOfCount);
			}
		inputStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Wrong file path!");
		}
		//display(listOfDates, listOfCounts);
		//highestCPM(listOfCounts);
		withinFive(listOfCounts);
	}
	public static void display(ArrayList date, ArrayList cpm) {
		for (int i = 0; i < cpm.size(); ++i)
			System.out.println(date.get(i) + " " + cpm.get(i));
			
	}
	public static void highestCPM(ArrayList<Integer> cpm){
		int highest = 0;
		for (int counter = 0; counter < cpm.size(); ++counter)
			if (cpm.get(counter) > highest)
				highest = cpm.get(counter);
		System.out.println("Highest value in dataset is: " + highest);	
					
	}
	public static void withinFive(ArrayList<Integer> cpm, ArrayList<String> dates){
		ArrayList<Integer> listOfCounts = new ArrayList();
		String[] values = null;
		int highest = 0;
		for (int counter = 0; counter < cpm.size(); ++counter)
			if (cpm.get(counter) > highest)
				highest = cpm.get(counter);
		for (int counter = 0; counter < cpm.size(); ++counter)
			for (int helper = 0; helper <= 5; ++helper)
				if (cpm.get(counter) == highest-helper) 
					listOfCounts.add(cpm.get(counter));
		System.out.println("Date           Count");
		System.out.println("--------------------");
		for (int x = 0; x < listOfCounts.size(); x++)
			System.out.println("                 "+listOfCounts.get(x));	
					
	}
}

	
