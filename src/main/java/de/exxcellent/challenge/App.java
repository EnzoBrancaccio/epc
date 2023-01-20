package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.HashMap;

import filecontentretriever.FileContentRetriever;
import valuetokeyfinder.ValueToKeyFinder;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
    	
    	String pathToWeather = "./src/main/resources/de/exxcellent/challenge/weather.csv";
    	String pathToFootball = "./src/main/resources/de/exxcellent/challenge/football.csv";
    	
        FileContentRetriever fct = new FileContentRetriever();
        ValueToKeyFinder vtkf = new ValueToKeyFinder();
        ArrayList<HashMap<String, String>> fileContent = fct.getFileContent(pathToWeather);
        String weatherSolution = vtkf.findValueToKeyBasedOnMinimalDifference(fileContent, "Day", "MxT", "MnT");
        //String footballSolution = vtkf.findValueToKeyBasedOnMinimalDifference(fileContent, "Team", "Goals", "Goals Allowed");

        String dayWithSmallestTempSpread = weatherSolution;     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        //String teamWithSmallestGoalSpread = footballSolution; // Your goal analysis function call …
        //System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
