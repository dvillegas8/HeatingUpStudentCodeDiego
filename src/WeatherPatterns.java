/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // TODO: Write your code here!
        // Keep track of the lengths of the paths of each number
        int[] paths = new int[temperatures.length];
        int biggestPath = 0;
        for(int i = 0; i < temperatures.length; i++){
            // Look at all the numbers before and find the biggest path
            for(int j = 0; j < i; j++){
                // Compare the current temperature(j) to the current biggest and our current temp (i)
                if(paths[j] > biggestPath && temperatures[j] < temperatures[i]){
                    biggestPath = paths[j];
                }
            }
            // add the current biggest temp length to the current number + 1
            paths[i] = biggestPath + 1;
            biggestPath = 0;
        }
        for(int i = 0; i < temperatures.length; i++){
            if(paths[i] > biggestPath){
                biggestPath = paths[i];
            }
        }
        return biggestPath;
    }
}
