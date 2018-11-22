import java.util.*;
import java.io.*;

public class CSVReader {

	public static void main(String[] args) {
		String fileName = ("C:\\Users\\Lorenzo\\Desktop\\141 Project Geiger\\GygerThing\\Supp Docs\\7_04_18.csv");
		File file = new File(fileName);
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
		withinFive(listOfCounts, listOfDates);
		graph(listOfCounts,listOfDates);
	}
	public static void withinFive(ArrayList<Integer> cpm, ArrayList<String> dates){
		ArrayList<Integer> listOfCounts = new ArrayList();
		int highest = 0;
		for (int counter = 0; counter < cpm.size(); ++counter)
			if (cpm.get(counter) > highest)
				highest = cpm.get(counter);
		for (int counter = 0; counter < cpm.size(); ++counter)
			for (int helper = 0; helper <= 5; ++helper)
				if (cpm.get(counter) == highest-helper) {
					listOfCounts.add(counter);
				}	
		System.out.println("  Date                 Count");
		System.out.println(" ___________________________");
		for (int x = 0; x < listOfCounts.size(); x++)
			System.out.println(" " +dates.get(listOfCounts.get(x))+ "               " +cpm.get(listOfCounts.get(x)));	
					
	}
	public static void graph(ArrayList cpm, ArrayList date) {                 
		String barGraph = "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b";
		for (int counter = 0; counter < cpm.size(); counter++)
			System.out.println(" " +barGraph.substring(0,(int) cpm.get(counter)) + " " +cpm.get(counter));
	}
}

	
