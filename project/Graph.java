/*
 * Written by Cian McNamara.
 */

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public String title;
    public int x = 0;
    public int y = 1;
    public String body;

    private int maxData;
    private boolean titleDisplayed = false;
    private boolean bodyDisplayed = false;

    private List<Integer> graphData = new ArrayList<Integer>();

    /// <summary>
    /// Creates a Graph which is 20 blocks wide.
    /// </summary>
    public Graph() {
        this.maxData = 20;
    }

    /// <summary>Adds an integer value to the graph and removes outdated data.</summary>
    /// @param data The integer (between 0 and 100) you want to add to the graph.
    public void AddData(int data) {
        List<Integer> tempList = graphData.reversed();

        if (graphData.size() == maxData) {
            graphData.remove(19);
        }

        tempList.add(data);
        tempList = tempList.reversed();

        this.graphData = tempList;
    }

    /// <summary>Displays the graph, its title and its body in the console.</summary>
    public void Display() {
        Integer[] graphArray = graphData.toArray(new Integer[0]);
        String[] linedGraphArray = getGraphFromArray(graphArray).split("\n");

        if (this.title != null && !this.titleDisplayed) {
            setCursorPosition(this.x, this.y - 1);
            System.out.println(this.title);
            this.titleDisplayed = true;
        }

        for (int row = 0; row < linedGraphArray.length; row++) {
            setCursorPosition(this.x, row + y);
            System.out.println(linedGraphArray[row] + " " + (100 - (5 * (row)) + "%"));
        }

        if (this.body != null && !this.bodyDisplayed) {
            String[] splitBody = this.body.split("\n");

            for (int offset = 0; offset < splitBody.length; offset++) {
                setCursorPosition(this.x, this.y + offset + 20);
                System.out.println(splitBody[offset]);
            }

            //this.bodyDisplayed = true;
        }
    }

    /// <summary>Hides the graph.</summary>
    public void Hide() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void ClearBodyFirstLine() {
        setCursorPosition(this.x, this.y + 20);
        System.out.print(repeatCharacter(' ', 100));
        this.bodyDisplayed = false;
    }

    /// <summary>Creates an array of graph characters from a given input int[] array.</summary>
    /// @param array Integer array of values between 0 and 100.
    /// <returns></returns>
    private String getGraphFromArray(Integer[] array) {
        String graph = "";

        for (int i = 0; i < array.length; i++) {
            int currentEntry = array[i];
            int characterCount = 0;

            if (currentEntry >= 5) {
                characterCount = currentEntry / 5 >= 20 ? 20 : currentEntry / 5;
                graph = graph + repeatCharacter('█', characterCount) + repeatCharacter('░', 20 - characterCount) + "\n";
                graph = graph + repeatCharacter('█', characterCount) + repeatCharacter('░', 20 - characterCount);
            } else {
                graph = graph + repeatCharacter('░', 20) + "\n";
                graph = graph + repeatCharacter('░', 20);
            }
            graph = graph + "\n";
        }

        return flipString90Left(graph);
    }

    /// <summary>Flips a string (in this case a graph) 90 degrees counter clockwise.</summary>
    /// @param str The string you want to flip.
    /// <returns></returns>
    private String flipString90Left(String str) {
        String[] linedString = str.split("\n");
        String flippedString = "";
        int character = 19;

        while (character >= 0) {
            for (int col = linedString.length - 1; col >= 0; col--) {
                if (!linedString[col].isEmpty()) {
                    int length = linedString[col].length();
                    flippedString = flippedString + linedString[col].charAt(character);
                }
            }

            flippedString = flippedString + "\n";
            character--;
        }

        return  flippedString;
    }

    ///<summary>Repeats a character n times and assigns it to a string.</summary>
    /// @param character The character you want to repeat.
    /// @param count The number of times you want the character repeated.
    /// <returns></returns>
    private String repeatCharacter(char character, int count) {
        String tempString = "";

        for (int i = 0; i < count; i++) {
            tempString = tempString + character;
        }

        return tempString;
    }

    /// <summary>Moves the cursor to a certain column and row position in the console.</summary>
    /// @param col The column you want the cursor on.
    /// @param row The row you want the cursor on.
    private void setCursorPosition(int col, int row) {
        char escapeCode = 0x1B;
        System.out.printf("%c[%d;%df", escapeCode, row, col);
    }
}
