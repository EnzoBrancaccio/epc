package filecontentretriever;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Retrieves the content from a CSV file
 * and turns it into a list of HashMaps.
 * 
 * @author Enzo Brancaccio
 *
 */
public class CSVFileContentRetriever {
	ArrayList<HashMap<String, String>> listOfHashMaps;
	
	/**
	 * 
	 * Takes the name of a CSV-file and the delimiter,
	 * opens the file and turns its contents into a list of string arrays,
	 * calls a helper method to turn the list
	 * into a list of HashMaps (keys: column names, values: rest)
	 * and returns the list of HashMaps for further processing.
	 * 
	 * @param fileName (String, name of CSV-file)
	 * @param delimiter (String, how to split the strings)
	 * @return csvContent (ArrayList<HashMap<String, String>>)
	 */
	public ArrayList<HashMap<String, String>> csvToHashMap(String fileName, String delimiter) {
		// if no delimiter is given, comma is the default delimiter
		if (delimiter.isEmpty()) {
			delimiter = ",";
		}
		
		ArrayList<String[]> preStrings = new ArrayList<String[]>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			try {
				String line = "";
				String[] csvStrings;
				while ((line = br.readLine()) != null) {
					// save every line and array of strings
					csvStrings = line.split(delimiter);
					// save arrays of strings in list
					preStrings.add(csvStrings);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<HashMap<String, String>> csvContent = listOfStringsToListOfHashMaps(preStrings);
		
		return csvContent;
	}
	
	/**
	 * 
	 * Helper method to turn a list of String arrays
	 * (that store the content of the CSV file as strings)
	 * into
	 *  1) HashMap (keys from first element, values from every other element)
	 *  2) List of those HashMaps
	 * 
	 * @param csvStrings (ArrayList<String[]>, CSV file content as list of string arrays)
	 * @return listOfHashMaps (ArrayList<HashMap<String, String>>)
	 */
	private ArrayList<HashMap<String, String>> listOfStringsToListOfHashMaps(ArrayList<String[]> csvStrings) {
		ArrayList<HashMap<String, String>> listOfHashMaps = new ArrayList<HashMap<String, String>>();
		
		if (!csvStrings.isEmpty()) {
			// first entry is first line of CSV, i. e. column names
			String[] keys = csvStrings.get(0);
			// the rest are the CSV entries, i. e. the values
			for (int i = 1; i < csvStrings.size(); i++) {
				HashMap<String, String> tempHashMap = new HashMap<String,String>();
				String[] tempValues = csvStrings.get(i);
				for (int j = 0; j < keys.length; j++) {
					// create HashMap from first and each subsequent line
					tempHashMap.put(keys[j], tempValues[j]);
				}
				listOfHashMaps.add(tempHashMap);
			}
		}
		
		return listOfHashMaps;	
	}
}
