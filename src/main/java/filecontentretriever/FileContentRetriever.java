package filecontentretriever;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * For all conversions from file content to a list of HashMaps
 * for further processing.
 * Currently only CSV-files can be read.
 * 
 * @author Enzo Brancaccio
 *
 */
public class FileContentRetriever {
	
	/**
	 * 
	 * Determines the file extension, 
	 * then opens the appropriate FileContentRetriever
	 * and returns a list of HashMaps containing the file contents.
	 * 
	 * @param fileName (String, name of file to read from)
	 * @return fileContents (ArrayList<HashMap<String, String>>)
	 */
	public ArrayList<HashMap<String, String>> getFileContent(String fileName) {
		ArrayList<HashMap<String, String>> fileContent = new ArrayList<HashMap<String, String>>();
		
		String csvExtension = ".csv";
		
		if (fileName.endsWith(csvExtension)) {
			CSVFileContentRetriever csvftc = new CSVFileContentRetriever();
			fileContent = csvftc.csvToHashMap(fileName, ",");
		}
		
		return fileContent;
	}
}
