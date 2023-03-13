package org.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {

    private static char [][] lowDifficulty = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};

    private static char [][] extremeDifficulty = {
            {'2','7','.','.','.','.','.','.','8'},
            {'8','.','.','.','7','5','2','.','.'},
            {'.','.','9','8','.','.','.','.','1'},
            {'.','.','.','6','.','.','1','.','9'},
            {'1','.','.','.','.','.','4','2','.'},
            {'.','.','.','.','.','2','.','3','.'},
            {'.','6','.','.','.','.','7','.','3'},
            {'.','.','8','3','.','.','.','.','.'},
            {'.','.','5','.','9','.','.','1','.'}};

    private static char [][] template = {
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}};

    private static char [][] extremeDifficulty1 = {
            {'.','.','.','6','8','.','.','.','4'},
            {'8','.','2','.','.','3','.','5','9'},
            {'.','7','.','.','.','.','.','.','.'},
            {'.','.','6','.','4','.','7','.','.'},
            {'7','5','.','.','.','.','.','4','1'},
            {'.','.','.','.','2','.','.','.','.'},
            {'.','.','.','.','.','.','.','9','.'},
            {'.','1','.','8','.','.','4','.','6'},
            {'3','2','.','.','5','6','.','.','.'}};

    private static char [][] extremeDifficulty2 = {
            {'5','.','.','1','.','3','.','.','.'},
            {'.','.','3','7','.','8','4','.','.'},
            {'.','7','9','.','.','.','.','.','.'},
            {'6','9','.','.','1','.','.','7','3'},
            {'.','.','.','2','.','9','.','.','.'},
            {'8','4','.','.','3','.','.','2','5'},
            {'.','8','.','.','.','.','2','1','.'},
            {'.','.','.','3','.','4','5','.','.'},
            {'.','.','.','8','.','1','.','.','6'}};

    private static char [][] extremeDifficulty3 = {
            {'1','.','.','.','7','.','.','3','.'},
            {'8','3','.','6','.','.','.','.','.'},
            {'.','.','2','9','.','.','6','.','8'},
            {'6','.','.','.','.','4','9','.','7'},
            {'.','9','.','.','.','.','.','5','.'},
            {'3','.','7','5','.','.','.','.','4'},
            {'2','.','3','.','.','9','1','.','.'},
            {'.','.','.','.','.','2','.','4','3'},
            {'.','4','.','.','8','.','.','.','9'}};

    private static char [][] extremeDifficulty4 = {
            {'.','.','.','.','.','7','.','.','9'},
            {'.','4','.','.','8','1','2','.','.'},
            {'.','.','.','9','.','.','.','1','.'},
            {'.','.','5','3','.','.','.','7','2'},
            {'2','9','3','.','.','.','.','5','.'},
            {'.','.','.','.','.','5','3','.','.'},
            {'8','.','.','.','2','3','.','.','.'},
            {'7','.','.','.','5','.','.','4','.'},
            {'5','3','1','.','7','.','.','.','.'}};

    private static char [][] extremeDifficulty5 = {
            {'.','.','4','.','9','.','.','.','.'},
            {'.','9','.','5','.','.','.','6','.'},
            {'.','2','.','.','.','7','9','1','.'},
            {'.','.','1','.','5','.','.','4','.'},
            {'4','.','.','2','.','9','.','.','6'},
            {'.','3','.','.','6','.','1','.','.'},
            {'.','1','9','6','.','.','.','.','8'},
            {'.','7','.','.','.','1','4','9','.'},
            {'.','.','.','.','3','.','.','.','.'}};

    private static char [][] extremeDifficulty6 = {
            {'8','.','.','.','.','9','.','.','2'},
            {'.','.','.','4','2','7','.','.','.'},
            {'.','.','3','.','.','8','7','.','.'},
            {'5','.','4','.','.','.','.','8','.'},
            {'3','.','9','.','.','.','4','.','1'},
            {'.','7','.','.','.','.','9','.','6'},
            {'.','.','2','.','.','4','5','.','.'},
            {'.','.','.','9','8','1','.','.','.'},
            {'4','.','.','.','.','5','.','.','8'}};

    private static char [][] extremeDifficulty7 = {
            {'6','.','.','.','7','.','.','.','8'},
            {'.','5','.','.','1','9','.','3','.'},
            {'.','7','.','6','.','.','.','1','.'},
            {'.','.','4','.','9','.','8','.','.'},
            {'7','.','.','3','.','1','.','.','5'},
            {'.','.','5','.','8','.','1','.','.'},
            {'.','3','.','.','.','6','.','8','.'},
            {'.','4','.','8','2','.','.','5','.'},
            {'8','.','.','.','3','.','.','.','1'}};

    private static char [][] extremeDifficulty8 = {
            {'1','.','.','5','.','4','.','.','9'},
            {'.','3','.','.','.','.','.','6','.'},
            {'.','.','8','.','7','.','1','.','.'},
            {'2','.','.','.','9','.','.','.','1'},
            {'.','.','6','3','.','1','7','.','.'},
            {'3','.','.','.','8','.','.','.','4'},
            {'.','.','3','.','2','.','9','.','.'},
            {'.','2','.','.','.','.','.','7','.'},
            {'9','.','.','7','.','5','.','.','3'}};

    private static char [][] mediumDifficulty = {
            {'.','.','9','7','4','8','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'.','2','.','1','.','9','.','.','.'},
            {'.','.','7','.','.','.','2','4','.'},
            {'.','6','4','.','1','.','5','9','.'},
            {'.','9','8','.','.','.','3','.','.'},
            {'.','.','.','8','.','3','.','2','.'},
            {'.','.','.','.','.','.','.','.','6'},
            {'.','.','.','2','7','5','9','.','.'}};
    private static char [][] test = new char[][]{
        {'.','.','9',  '7','4','8',  '.','.','2'},
        {'7','.','.',  '6','.','2',  '.','.','9'},
        {'.','2','.',  '1','.','9',  '.','.','.'},

        {'.','.','7',  '9','8','6',  '2','4','1'},
        {'2','6','4',  '3','1','7',  '5','9','8'},
        {'1','9','8',  '5','2','4',  '3','6','7'},

        {'9','.','.',  '8','6','3',  '.','2','.'},
        {'.','.','2',  '4','9','1',  '.','.','6'},
        {'.','.','.',  '2','7','5',  '9','.','.'}};

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.solveSudoku(extremeDifficulty8);
    }
    public void solveSudoku(char[][] board) {
        try {
            System.out.println("Starting Sudoku");
            Sudoku sudoku = new Sudoku(board);
            System.out.println("Initial Layout: ");
            sudoku.printSudoku();
            if (sudoku.validate()) {
                sudoku.solve();
            } else {
                throw new Exception("This Sudoku is not valid");
            }

            sudoku.copyToBoard(board);
            System.out.println("Printing result: ");
            for(char[] line : board) {
                System.out.println(Arrays.toString(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
class Sudoku {
    public Spot[][] spots = new Spot[9][9];

    public Sudoku(char[][] matrix) {
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9 ; j++) {
                iterationsPerformed++;
                Spot spot = new Spot(j, i, matrix[j][i]);
                spots[j][i] = spot;
            }
        }
        lookupAllPossibleValuesInMatrix();
    }

    public char[][] solve() throws Exception{
        solveSudoku();
        if (!isCompleted()) {
            printSudoku();
            System.out.println("Starting Trial and Error");
            trialAndError();
        }
        System.out.println("Total iterations of solution were: " + iterationsPerformed);
        return toCharMatrix();
    }

    private void trialAndError() {
        backup();
        List<SpotTrial> spotsToTry = getAllSpotsWith2PossibleValues();
        int counter = 0;
        outer:
        for (int i = 0; i < spotsToTry.size(); i++) {
            SpotTrial currSpotTrial = spotsToTry.get(i);
            Spot currSpot = currSpotTrial.spot;
            if (currSpot.getCurrentValue() == Spot.EMPTY) {
                boolean tryWithAnotherSpot = false;
                while (currSpotTrial.attemptNumber < 2 && !tryWithAnotherSpot){
                    currSpotTrial.attemptNumber++;
                    counter++;
                    System.out.println("Attempt Number: " + counter);
                    iterationsPerformed++;
                    System.out.println("Try # " + currSpotTrial.attemptNumber);
                    System.out.println("Trying: " + currSpot.fullString());
                    System.out.println("with value : " +  currSpot.getPossibleValues().get(currSpotTrial.attemptNumber - 1));
                    currSpot.setCurrentValue(currSpot.getPossibleValues().get(currSpotTrial.attemptNumber - 1));
                    boolean isValid = false;
                    try {
                        solveSudoku();
                        isValid =  validate();
                    } catch (Exception e) {
                        //perform next attempt
                    }
                    if(isCompleted() && isValid) {
                        break outer;
                    } else if (isValid) {
                        System.out.println("NOT COMPLETED but valid need to set try with another spot");
                        System.out.println("Trying again");
                        //past trial seems to have been successful,but need to try again to solve it
                        tryWithAnotherSpot = true;
                        printSudoku();
                        backup();
                        //Adding new spots to try since Sudoku changed.
                        spotsToTry.addAll(getAllSpotsWith2PossibleValues());
                    } else {
                        System.out.println("NOT COMPLETED NOT VALID");
                        System.out.println("RESETTING");
                        // Need to try with another value, or backtrack

                        if (currSpotTrial.attemptNumber < 2) {
                            //This is the first try
                            // Need to reset once and try with the second val
                            reset();
                            printSudoku();
                        } else {
                            // this is the second try, which means this spot is not the problem but the problem was the
                            // previous spot that was tried
                            // First we do rollback the last trial
                             // At this point, the for will pick up again the same spot to try, which we don't want
                            // We want to get the last one that has not been attempted twice
                            boolean continueSearch = true;
                            while(continueSearch) {
                                i -= 1;
                                reset();
                                if(spotsToTry.get(i).attemptNumber == 2) { // second attempt
                                    continueSearch = true;
                                    tryWithAnotherSpot = true;
                                } else {
                                    continueSearch = false;
                                    tryWithAnotherSpot = false;
                                }
                            }
                            i -= 1; // need to remove 1 from i due to the loop updating with i++
                            printSudoku();
                        }
                    }
                }
            }
        }
    }

    public List<SpotTrial> getAllSpotsWith2PossibleValues(){
        List<SpotTrial> spotsToTry = new ArrayList<>();
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                iterationsPerformed++;
                Spot currSpot = spots[j][i];
                if(currSpot.getPossibleValues().size() == 2) {
                    spotsToTry.add(new SpotTrial(currSpot,0));
                }
            }
        }
        return spotsToTry;
    }

    private void solveSudoku() throws Exception {
        lookupAllPossibleValuesInMatrix();
        findAllSingleDerivedElements();
        if (!isCompleted()) {
            findUniquePossibleValuesInEachGroup();
        }
    }

    public void findUniquePossibleValuesInEachGroup() throws Exception {
        boolean continueLoop = true;
        while (continueLoop && !isCompleted()) {
            for (int i = 0; i < spots.length; i++) {
                for (int j = 0; j < spots.length; j++) {
                    iterationsPerformed++;
                    Spot currSpot = spots[j][i];
                    continueLoop = findAndFillAllPossibilitiesInAllRelatedGroupsOfGivenSpot(currSpot);
                }
            }
        }
    }

    private boolean findAndFillAllPossibilitiesInAllRelatedGroupsOfGivenSpot(Spot currSpot) throws Exception {
        boolean continueLoop;
        continueLoop = findAndFillAllPossibilitiesInGroup(getRelatedRow(currSpot));
        continueLoop |= findAndFillAllPossibilitiesInGroup(getRelatedCol(currSpot));
        continueLoop |= findAndFillAllPossibilitiesInGroup(getRelatedSquare(currSpot));
        lookupAllPossibleValuesInMatrix();
        findAllSingleDerivedElements();
        return continueLoop;
    }

    public char[][] toCharMatrix() {
        char[][] matrix = new char[9][9];
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9 ; j++) {
                char val = spots[j][i].getCurrentValue();
                matrix[j][i] = val;
            }
        }
        return matrix;
    }

    public void copyToBoard(char[][] board) {
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9 ; j++) {
                char val = spots[j][i].getCurrentValue();
                board[j][i] = val;
            }
        }
    }

    public String printSudoku() {
        StringBuilder stringBuilder = new StringBuilder();
        char[][] matrix = toCharMatrix();
        for (char[] row: matrix) {
            stringBuilder.append(Arrays.toString(row) + '\n');
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

    //Checks if the sudoku is valid, this is, if no numbers overlap in a row, column or square
    //it does NOT check if the sudoku is solvable
    public boolean validate() throws Exception{
        lookupAllPossibleValuesInMatrix();
        boolean isValid = true;
        isValid &= validateEachRow();
        isValid &= validateEachColumn();
        isValid &= validateEachSquare();
        String result = isValid ? "valid" : "invalid";
        if (!isValid) {
            System.out.println("The Sudoku is " + result );
        }
        if (!isValid) {
            printSudoku();
            throw new Exception("Invalid Sudoku");
        }
        return isValid;
    }

    public boolean isCompleted() {
        boolean result = true;
        outer:
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                iterationsPerformed++;
                if (spots[j][i].getCurrentValue() == Spot.EMPTY) {
                    result = false;
                    break outer;
                }
            }
        }
        return result;
    }

    //Validates that each column in the sudoku does not have overlapping numbers
    public boolean validateEachColumn() {
        boolean result = true;
        for (int col = 0; col < spots.length; col++) {
            result &= validateGroup(getRelatedCol(spots[0][col]));
        }
        return result;
    }

    //Validates that each square in the sudoku does not have overlapping numbers
    public boolean validateEachSquare() {
        boolean result = true;
        for (int i = 0; i < spots.length; i += Math.sqrt(spots.length)) {
            Spot[] templateGroup = null;
            for (int j = 0; j < spots.length; j += Math.sqrt(spots.length)) {
                templateGroup = getRelatedSquare(spots[j][i]);
                result &= validateGroup(templateGroup);
            }
        }
        return result;
    }

    //Validates that each row in the sudoku does not have overlapping numbers
    public boolean validateEachRow() {
        //validate each row
        boolean result = true;
        for (Spot[] row: spots) {
            result &= validateGroup(row);
        }
        return result;
    }

    //Validates that the group of fields does not have overlapping numbers
    //A group can be a square, a row or a column
    public boolean validateGroup(Spot[] group) {
        boolean[] templateRow = new boolean[9];
        for (int i = 0; i < group.length; i++) {
            iterationsPerformed++;
            Spot spot = group[i];
            if (Spot.EMPTY != spot.getCurrentValue()) {
                int intVal = Character.getNumericValue(spot.getCurrentValue());
                boolean isPresent= templateRow[intVal - 1];
                if (isPresent) {
                    System.out.println(spot.fullString());
                    System.out.println("Found duplicate value ");
                    return false;
                } else {
                    templateRow[intVal - 1] = true;
                }
            } else if (spot.getPossibleValues().size() == 0) {
                System.out.println(spot.fullString());
                System.out.println("Empty spot with 0 possibilities ");
                return false;
            }
        }
        return true;
    }

    int iterationsPerformed = 0;

    //For each group (square, col and row) get a list of all possibilities for each position
    //and find all positions that only have one possibility
    public boolean findAndFillAllPossibilitiesInGroup(Spot[] group) throws Exception{
        boolean result = false;
        Map<Integer, List<Spot>> spots = new HashMap<>(10);
        for (Spot spot : group) {
            for (char val: spot.getPossibleValues()) {
                iterationsPerformed++;
                int numericValue = Character.getNumericValue(val);
                List<Spot> spotList = spots.get(numericValue);
                if (spotList == null) {
                    spotList = new ArrayList<>();
                    spots.put(numericValue, spotList);
                }
                spotList.add(spot);
            }
        }
        for (Integer key: spots.keySet()) {
            iterationsPerformed++;
            List<Spot> spotList = spots.get(key);
            if (spotList.size() == 1) {
                Spot spot = spotList.get(0);
                System.out.println("findAllPossibilitiesInGroup");
                spot.setCurrentValue(Spot.toChar(key));
                validate();
                result = true;
            }
        }
        return result;
    }

    public void findAllSingleDerivedElements() throws Exception {
        //Find simple derived elements
        boolean loop = true;
        while (loop && !isCompleted()) {
            iterationsPerformed++;
            loop = findSingleDerivedElements();
        }
    }

    //A spot can have 9 possible Values, this method searches and sets all possible values a given Spot can have
    //Needs to be called each time the sudoku changes
    public void lookupAllPossibleValuesInMatrix() {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                iterationsPerformed++;
                Spot spot = spots[j][i];
                if (spot.getCurrentValue() == Spot.EMPTY) {
                    setAllPossibleValuesForGivenSpot(spot);
                }
            }

        }
    }

    private void setAllPossibleValuesForGivenSpot(Spot spot) {
        List<Character> result = findAllPossibleValuesForAGivenSpot(spot);
        spot.setPossibleValues(result);
    }

    public boolean findSingleDerivedElements() throws Exception{
        boolean valueFound = false;
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                iterationsPerformed++;
                Spot spot = spots[j][i];
                if (spot.getCurrentValue() == Spot.EMPTY) {
                    char result = findSingleValueInSpot(spot);
                    if (result != Spot.EMPTY) {
                        spot.setCurrentValue(result);
                        System.out.println("findSingleDerivedElements");
                        System.out.println(spot.fullString());
                        validate();
                        valueFound = true;
                        findAndFillAllPossibilitiesInAllRelatedGroupsOfGivenSpot(spot);
                    }
                }
            }

        }
        return valueFound;
    }



    //Given a Position(Row/Col), find out all possible values it can have
    public List<Character> findAllPossibleValuesForAGivenSpot(Spot spot) {
        List<Character> possibleValues = getPossibleValues();
        Spot[] relatedRow = getRelatedRow(spot);
        removePossibleValues(possibleValues, relatedRow);
        Spot[] relatedCol = getRelatedCol(spot);
        removePossibleValues(possibleValues, relatedCol);
        Spot[] relatedSquare = getRelatedSquare(spot);
        removePossibleValues(possibleValues, relatedSquare);
        return possibleValues;
    }

    private static List<Character> getPossibleValues() {
        List<Character> values = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            values.add(Spot.toChar(i));
        }
        return values;
    }

    public char findSingleValueInSpot(Spot spot) {
        List<Character> values = spot.getPossibleValues();
        if (values != null && values.size() == 1) {
            return values.get(0);
        } else {
            return Spot.EMPTY;
        }
    }

    //Removes values found in other related groups, like if there is a 3 in the group, then we remove 3 from the list
    //of possible values
    public void removePossibleValues(List<Character> values, Spot[] group) {
        //Removes single possible value if a spot contains that value
        for (int i = 0; i < group.length; i++) {
            iterationsPerformed++;
            if (Spot.EMPTY != group[i].getCurrentValue()) {
                char val = group[i].getCurrentValue();
                values.remove(Character.valueOf(val));
            }
        }

        //Checks if two spots have the same pair of values, eg. 34 34 , so that other spots can not have either
        // a 3 nor a 4
        Map<String, List<Spot>> spotsPerPossibleVal = new HashMap<>(10);
        for (int i = 0; i < group.length; i++) {
            iterationsPerformed++;
            List<Character> possibleValues = group[i].getPossibleValues();
            if (possibleValues.size() == 2) {
                List<Spot> spots = spotsPerPossibleVal.get(possibleValues.toString());
                if (spots == null) {
                    spots = new ArrayList<>();
                }
                spots.add(group[i]);
                spotsPerPossibleVal.put(possibleValues.toString(), spots);
            }
        }
        boolean doCleanup = false;
        List<Character> valuesToClean = null;
        for (String key: spotsPerPossibleVal.keySet()) {
            iterationsPerformed++;
            List<Spot> spotsList = spotsPerPossibleVal.get(key);
            if (spotsPerPossibleVal.get(key).size() == 2) {
                doCleanup = true;
                valuesToClean = spotsList.get(0).getPossibleValues();
            }
        }

        if (doCleanup && valuesToClean != null) {
            for (Spot spot: group) {
                if (spot.getPossibleValues().size() > 2) {
                    for (char possibleVal: valuesToClean) {
                        spot.removePossibleValue(possibleVal);
                    }
                }
            }
        }

        //TODO: Check for "ternas" like 123 123 23 , or 12 23 13, which means other spots in the group
        //can not have the 1 or 2 or 3... Checking for this might not be necessary?
    }

    public void reset() {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                iterationsPerformed++;
                Spot currSpot = spots[j][i];
                currSpot.reset();
            }
        }
    }

    public void backup() {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                iterationsPerformed++;
                Spot currSpot = spots[j][i];
                currSpot.backup();
            }
        }
    }

    //Gets the column of the given Position (Row=0 /startCol)
    public Spot[] getRelatedCol(Spot spot) {
        Spot[] relatedCol = new Spot[spots.length];
        for (int i = 0; i < spots.length; i++) {
            iterationsPerformed++;
            relatedCol[i] = spots[i][spot.col];
        }
        return relatedCol;
    }

    //Gets the row based on a given Position (startRow/column=0)
    public Spot[] getRelatedRow(Spot spot) {
        return spots[spot.row];
    }

    //Given a Position (row/col) return the square the position is in.
    public Spot[] getRelatedSquare(Spot spot) {
        int size = spots.length;
        Spot[] square = new Spot[size];
        int counter = 0;
        //TODO: Review Castings
        int startCol = (int) ((int)(spot.col / Math.sqrt(size)) * ((int) Math.sqrt(size)));
        int startRow = (int) ((int)(spot.row / Math.sqrt(size)) * ((int) Math.sqrt(size)));
        for (int i = startRow; i < Math.sqrt(size) + startRow; i++) {
            for (int j = startCol; j < Math.sqrt(size) + startCol; j++) {
                iterationsPerformed++;
                square[counter++] = spots[i][j];
            }
        }
        return square;
    }
}
class Spot{

    public static final char EMPTY = '.';
    public int row;
    public int col;
    private char currentValue;
    private List<Character> possibleValues = new ArrayList<>();
    private Stack<Character> backupCurrentValues = new Stack<>();
    private Stack<List<Character>> backupPossibleValues = new Stack<>();
    public Spot(int row, int col, char currentValue){
        this.row = row;
        this.col = col;
        this.currentValue = currentValue;
        possibleValues = new ArrayList<>();
        if (currentValue == EMPTY) {
            for (int i = 1; i <= 9 ; i++) {
                possibleValues.add(Spot.toChar(i));
            }
        }
    }

    public void setCurrentValue(Character val) {
        this.currentValue = val;
        this.possibleValues.clear();
        System.out.println("--");
        System.out.println("Setting currentVal ");
        System.out.println(fullString());
        System.out.println("--");
    }

    public Character getCurrentValue() {
        return this.currentValue;
    }

    public void removePossibleValue(Character val) {
        possibleValues.remove(val);
    }

    public List<Character> getPossibleValues() {
        return this.possibleValues;
    }

    public void setPossibleValues(List<Character> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public boolean hasSinglePossibility() {
        return possibleValues.size() == 1;
    }

    public boolean isInvalid() {
        return possibleValues.size() == 0 && currentValue == Spot.EMPTY;
    }

    public static char toChar(int val) {
        return Integer.toString(val).charAt(0);
    }

    @Override
    public String toString() {
        return String.valueOf(currentValue);
    }

    public String fullString() {
        return "Spot col/row : " + col + "/" + row + " val " + currentValue;
    }

    public void clearAllPossibleValues() {
        possibleValues.clear();
    }

    public void reset() {
        clearAllPossibleValues();
        if(backupPossibleValues != null && backupPossibleValues.size() > 0) {
            currentValue = backupCurrentValues.pop();
            List<Character> lastBackup = backupPossibleValues.pop();
            possibleValues = new ArrayList<>(lastBackup);
            Collections.copy(possibleValues, lastBackup);
        }
    }

    public void backup() {
        List<Character> lastBackup = new ArrayList<>(possibleValues);
        Collections.copy(lastBackup, possibleValues);
        backupPossibleValues.push(lastBackup);
        backupCurrentValues.add(currentValue);
    }
}

class SpotTrial {
    public Spot spot;
    public int attemptNumber;

    public SpotTrial (Spot spot, int attemptNumber) {
        this.spot = spot;
        this.attemptNumber = attemptNumber;
    }
}