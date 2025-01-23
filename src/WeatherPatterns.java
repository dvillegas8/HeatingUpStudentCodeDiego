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
        boolean[][] adjacencyMatrix = new boolean[temperatures.length][temperatures.length];
        // Creates an adjacency matrix where
        for(int i = 0; i < temperatures.length; i++){
            for(int j = i + 1; j < temperatures.length; j++){
                if(temperatures[i] < temperatures[j]){
                    adjacencyMatrix[i][j] = true;
                }
            }
        }
        int[] paths = new int[temperatures.length];
        int length = 0;
        int max = 0;
        // Go through each temperature
        for(int i = 0; i < temperatures.length; i++){
            length = longestPathTo(paths, adjacencyMatrix, i);
            paths[i] = length;
            // Keeps track of the longest path
            if(max < length){
                max = length;
            }

        }
        /*
        // FIRST SOLUTION THAT IS MORE EFFICIENT
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
        */
        return max;
    }
    public static int longestPathTo(int[] paths, boolean[][] adjacencyMatrix, int index){
        // Check to see if we have been here before
        if(paths[index] != 0){
            return paths[index];
        }
        int len = 0;
        // For each vertex leading to the current vertex temperature
        for(int i = 0; i < adjacencyMatrix[index].length; i++){
            // Check if it is an edge
            if(adjacencyMatrix[i][index]){
                len = Math.max(len, longestPathTo(paths, adjacencyMatrix, i));
            }
        }
        return len + 1;
    }
}
