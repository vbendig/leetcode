package org.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    Sudoku sudoku;

    private static char [][] lowDifficulty;

    private static char [][] lowDifficultySolved;

    private static char [][] mediumDifficulty;

    private static char [][] mediumDifficultySolution;

    private static char [][] extremeDifficulty;

    private static char [][] invalidSudoku;
    private static char [][] invalidSudoku2;

    @BeforeEach
    public void setup() {
        lowDifficulty = new char[][]{
                {'5','3','.',  '.','7','.',  '.','.','.'},
                {'6','.','.',  '1','9','5',  '.','.','.'},
                {'.','9','8',  '.','.','.',  '.','6','.'},

                {'8','.','.',  '.','6','.',  '.','.','3'},
                {'4','.','.',  '8','.','3',  '.','.','1'},
                {'7','.','.',  '.','2','.',  '.','.','6'},

                {'.','6','.',  '.','.','.',  '2','8','.'},
                {'.','.','.',  '4','1','9',  '.','.','5'},
                {'.','.','.',  '.','8','.',  '.','7','9'}};

        lowDifficultySolved = new char[][]{
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

        mediumDifficulty = new char[][]{
                {'.','.','9',  '7','4','8',  '.','.','.'},
                {'7','.','.',  '.','.','.',  '.','.','.'},
                {'.','2','.',  '1','.','9',  '.','.','.'},

                {'.','.','7',  '.','.','.',  '2','4','.'},
                {'.','6','4',  '.','1','.',  '5','9','.'},
                {'.','9','8',  '.','.','.',  '3','.','.'},

                {'.','.','.',  '8','.','3',  '.','2','.'},
                {'.','.','.',  '.','.','.',  '.','.','6'},
                {'.','.','.',  '2','7','5',  '9','.','.'}};

        mediumDifficultySolution = new char[][]{
                {'.','.','9',  '7','4','8',  '.','.','2'},
                {'7','.','.',  '6','.','2',  '.','.','9'},
                {'.','2','.',  '1','.','9',  '.','.','.'},

                {'.','.','7',  '9','8','6',  '2','4','1'},
                {'2','6','4',  '3','1','7',  '5','9','8'},
                {'1','9','8',  '5','2','4',  '3','6','7'},

                {'9','.','.',  '8','6','3',  '.','2','.'},
                {'.','.','2',  '4','9','1',  '.','.','6'},
                {'.','.','.',  '2','7','5',  '9','.','.'}};

        extremeDifficulty = new char[][]{
                {'2','7','.','.','.','.','.','.','8'},
                {'8','.','.','.','7','5','2','.','.'},
                {'.','.','9','8','.','.','.','.','1'},
                {'.','.','.','6','.','.','1','.','9'},
                {'1','.','.','.','.','.','4','2','.'},
                {'.','.','.','.','.','2','.','3','.'},
                {'.','6','.','.','.','.','7','.','3'},
                {'.','.','8','3','.','.','.','.','.'},
                {'.','.','5','.','9','.','.','1','.'}};


        invalidSudoku = new char[][]{
                {'9','.','9',  '7','4','8',  '.','9','2'},
                {'7','.','.',  '6','.','2',  '.','.','9'},
                {'.','2','.',  '1','.','9',  '.','.','.'},

                {'.','.','7',  '9','8','6',  '2','4','1'},
                {'2','6','4',  '3','1','7',  '5','9','8'},
                {'1','9','8',  '5','2','4',  '3','6','7'},

                {'9','.','.',  '8','6','3',  '.','2','.'},
                {'.','.','2',  '4','9','1',  '.','.','6'},
                {'.','.','.',  '2','7','5',  '9','.','.'}};

        invalidSudoku2 = new char[][]{
                {'2', '7', '.', '.', '.', '.', '.', '.', '8'},
                {'8', '.', '.', '.', '7', '5', '2', '.', '.'},
                {'.', '.', '9', '8', '2', '.', '.', '7', '1'},
                {'.', '.', '.', '6', '.', '.', '1', '7', '9'},
                {'1', '.', '.', '.', '.', '.', '4', '2', '.'},
                {'.', '.', '.', '.', '.', '2', '8', '3', '.'},
                {'9', '6', '.', '.', '.', '.', '7', '8', '3'},
                {'.', '.', '8', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '5', '.', '9', '8', '6', '1', '.'}};

    }

    @Test
    void solveEasySudoku() {
        sudoku = new Sudoku(lowDifficulty);
        try {
            sudoku.solve();
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    void findSingleDerivedElements() {
        sudoku = new Sudoku(lowDifficulty);
        try {
            sudoku.findAllSingleDerivedElements();
        } catch (Exception e) {
            fail();
        }
        char [][] expected = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'},
        };
        assertArrayEquals(expected, sudoku.toCharMatrix());
    }

    @Test
    void findSingleValueInSpot() {
        sudoku = new Sudoku(lowDifficulty);

//        {'5','3','.',  '.','7','.',  '.','.','.'},
//        {'6','.','.',  '1','9','5',  '.','.','.'},
//        {'.','9','8',  '.','.','.',  '.','6','.'},
//
//        {'8','.','.',  '.','6','.',  '.','.','3'},
//        {'4','.','.',  '8','.','3',  '.','.','1'},
//        {'7','.','.',  '.','2','.',  '.','.','6'},
//
//        {'.','6','.',  '.','.','.',  '2','8','.'},
//        {'.','.','.',  '4','1','9',  '.','.','5'},
//        {'.','.','.',  '.','8','.',  '.','7','9'}}

        char actual = sudoku.findSingleValueInSpot(sudoku.spots[4][4]);
        assertEquals('5', actual);
        actual = sudoku.findSingleValueInSpot(sudoku.spots[6][5]);
        assertEquals('7', actual);
        actual = sudoku.findSingleValueInSpot(sudoku.spots[7][7]);
        assertEquals('3', actual);
        actual = sudoku.findSingleValueInSpot(sudoku.spots[0][0]);
        assertEquals('.', actual);
        actual = sudoku.findSingleValueInSpot(sudoku.spots[6][8]);
        assertEquals('4', actual);
    }

    private Spot[] getSpotArrayFromCharArray(char[] group) {
        Spot[] spotGroup = new Spot[group.length];
        for (int i = 0; i < group.length; i++) {
            spotGroup[i] = new Spot(0,1,group[i]);
        }
        return spotGroup;
    }

    @Test
    void removeExistingValuesFromPossibleValuesList() {
        sudoku = new Sudoku(lowDifficulty);
        List<Character> possibleValues = getValuesFrom1to9();
        Spot[] group = getSpotArrayFromCharArray(new char[]{'1','2','3','4','5','6','7','8','9'});
        sudoku.removePossibleValues(possibleValues, group);
        assertEquals(possibleValues.size(), 0);

        possibleValues = getValuesFrom1to9();
        group = getSpotArrayFromCharArray(new char[]{'1','2','3','4','.','6','7','8','9'});
        sudoku.removePossibleValues(possibleValues, group);
        assertEquals(possibleValues.size(), 1);

        possibleValues = getValuesFrom1to9();
        group = getSpotArrayFromCharArray(new char[]{'.','2','3','4','.','6','7','8','9'});
        sudoku.removePossibleValues(possibleValues, group);
        assertEquals(possibleValues.size(), 2);

        possibleValues = getValuesFrom1to9();
        group = getSpotArrayFromCharArray(new char[]{'.','2','3','4','.','6','7','.','9'});
        sudoku.removePossibleValues(possibleValues, group);
        assertEquals(possibleValues.size(), 3);

        possibleValues = getValuesFrom1to9();
        group = getSpotArrayFromCharArray(new char[]{'.','.','.','.','.','6','7','.','.'});
        sudoku.removePossibleValues(possibleValues, group);
        assertEquals(possibleValues.size(), 7);

        possibleValues = getValuesFrom1to9();
        group = getSpotArrayFromCharArray(new char[]{'.','.','.','.','.','.','.','.','.'});
        sudoku.removePossibleValues(possibleValues, group);
        assertEquals(possibleValues.size(), 9);
    }

    private static List<Character> getValuesFrom1to9() {
        List<Character> values = new ArrayList<>();
        for (byte i = 1; i <= 9; i++) {
            values.add(Spot.toChar(i));
        }
        return values;
    }

    @Test
    void getRelatedCol() {
//                {'5','3','.',  '.','7','.',  '.','.','.'},
//                {'6','.','.',  '1','9','5',  '.','.','.'},
//                {'.','9','8',  '.','.','.',  '.','6','.'},
//
//                {'8','.','.',  '.','6','.',  '.','.','3'},
//                {'4','.','.',  '8','.','3',  '.','.','1'},
//                {'7','.','.',  '.','2','.',  '.','.','6'},
//
//                {'.','6','.',  '.','.','.',  '2','8','.'},
//                {'.','.','.',  '4','1','9',  '.','.','5'},
//                {'.','.','.',  '.','8','.',  '.','7','9'}};
        sudoku = new Sudoku(lowDifficulty);
        Spot[] expected = getSpotArrayFromCharArray(new char[]{'5','6','.',  '8','4','7',  '.','.','.'});
        Spot[] actual = sudoku.getRelatedCol(sudoku.spots[0][0]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'.','.','.',  '3','1','6',  '.','5','9'});
        actual = sudoku.getRelatedCol(sudoku.spots[1][8]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'.','1','.',  '.','8','.',  '.','4','.'});
        actual = sudoku.getRelatedCol(sudoku.spots[1][3]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void getRelatedRow() {
//                {'5','3','.',  '.','7','.',  '.','.','.'},
//                {'6','.','.',  '1','9','5',  '.','.','.'},
//                {'.','9','8',  '.','.','.',  '.','6','.'},
//
//                {'8','.','.',  '.','6','.',  '.','.','3'},
//                {'4','.','.',  '8','.','3',  '.','.','1'},
//                {'7','.','.',  '.','2','.',  '.','.','6'},
//
//                {'.','6','.',  '.','.','.',  '2','8','.'},
//                {'.','.','.',  '4','1','9',  '.','.','5'},
//                {'.','.','.',  '.','8','.',  '.','7','9'}};
        sudoku = new Sudoku(lowDifficulty);
        Spot[] expected = getSpotArrayFromCharArray(new char[]{'5','3','.',  '.','7','.',  '.','.','.'});
        Spot[] actual = sudoku.getRelatedRow(sudoku.spots[0][0]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'6','.','.',  '1','9','5',  '.','.','.'});
        actual = sudoku.getRelatedRow(sudoku.spots[1][8]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'.','6','.',  '.','.','.',  '2','8','.'});
        actual = sudoku.getRelatedRow(sudoku.spots[6][2]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void getRelatedSquare() {
//                {'5','3','.',  '.','7','.',  '.','.','.'},
//                {'6','.','.',  '1','9','5',  '.','.','.'},
//                {'.','9','8',  '.','.','.',  '.','6','.'},
//
//                {'8','.','.',  '.','6','.',  '.','.','3'},
//                {'4','.','.',  '8','.','3',  '.','.','1'},
//                {'7','.','.',  '.','2','.',  '.','.','6'},
//
//                {'.','6','.',  '.','.','.',  '2','8','.'},
//                {'.','.','.',  '4','1','9',  '.','.','5'},
//                {'.','.','.',  '.','8','.',  '.','7','9'}};

        sudoku = new Sudoku(lowDifficulty);
        Spot[] expected = getSpotArrayFromCharArray(new char[]{'5','3','.',  '6','.','.',  '.','9','8'});
        Spot[] actual = sudoku.getRelatedSquare(sudoku.spots[0][0]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'.','6','.',  '8','.','3',  '.','2','.'});
        actual = sudoku.getRelatedSquare(sudoku.spots[4][4]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'2','8','.',  '.','.','5',  '.','7','9'});
        actual = sudoku.getRelatedSquare(sudoku.spots[8][8]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'.','.','.',  '.','.','.',  '.','6','.'});
        actual = sudoku.getRelatedSquare(sudoku.spots[1][8]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

        expected = getSpotArrayFromCharArray(new char[]{'8','.','.',  '4','.','.',  '7','.','.'});
        actual = sudoku.getRelatedSquare(sudoku.spots[4][2]);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void validate() {
        try {
            sudoku = new Sudoku(lowDifficulty);
            assertTrue(sudoku.validate());
        } catch (Exception e) {
            fail();
        }
        try {
            sudoku = new Sudoku(invalidSudoku);
            assertFalse(sudoku.validate());
            fail();
        } catch (Exception e) {
            //its ok to fail
        }

        try {
            sudoku = new Sudoku(invalidSudoku2);
            assertFalse(sudoku.validate());
            fail();
        } catch (Exception e) {
            //its ok to fail
        }
    }

    @Test
    void validateEachColumn() {
        sudoku = new Sudoku(lowDifficulty);
        assertTrue(sudoku.validateEachColumn());

        sudoku = new Sudoku(invalidSudoku);
        assertFalse(sudoku.validateEachColumn());
    }

    @Test
    void validateEachSquare() {
        sudoku = new Sudoku(lowDifficulty);
        assertTrue(sudoku.validateEachSquare());

        sudoku = new Sudoku(invalidSudoku);
        assertFalse(sudoku.validateEachSquare());
    }

    @Test
    void validateEachRow() {
        sudoku = new Sudoku(lowDifficulty);
        assertTrue(sudoku.validateEachRow());

        sudoku = new Sudoku(invalidSudoku);
        assertFalse(sudoku.validateEachRow());
    }

    @Test
    void validateGroup() {
        sudoku = new Sudoku(lowDifficulty);
        assertTrue(sudoku.validateGroup(sudoku.getRelatedSquare(sudoku.spots[0][0])));

        sudoku = new Sudoku(invalidSudoku);
        assertFalse(sudoku.validateGroup(sudoku.getRelatedSquare(sudoku.spots[0][0])));
    }

    @Test
    void solve() {
    }

    @Test
    void findUniquePossibleValuesInEachGroup() {
        try {
            sudoku = new Sudoku(mediumDifficulty);
            sudoku.findUniquePossibleValuesInEachGroup();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void toCharMatrix() {
    }

    @Test
    void printSudoku() {
        String actual = "[5, 3, ., ., 7, ., ., ., .]\n" +
                "[6, ., ., 1, 9, 5, ., ., .]\n" +
                "[., 9, 8, ., ., ., ., 6, .]\n" +
                "[8, ., ., ., 6, ., ., ., 3]\n" +
                "[4, ., ., 8, ., 3, ., ., 1]\n" +
                "[7, ., ., ., 2, ., ., ., 6]\n" +
                "[., 6, ., ., ., ., 2, 8, .]\n" +
                "[., ., ., 4, 1, 9, ., ., 5]\n" +
                "[., ., ., ., 8, ., ., 7, 9]\n\n";
        sudoku = new Sudoku(lowDifficulty);
        assertEquals(actual, sudoku.printSudoku());
    }

    @Test
    void isCompleted() {
        sudoku = new Sudoku(lowDifficulty);
        assertFalse(sudoku.isCompleted());

        sudoku = new Sudoku(lowDifficultySolved);
        assertTrue(sudoku.isCompleted());
    }

    @Test
    void verifySudokuCreation() {
//        {'.','.','9',  '7','4','8',  '.','.','.'},
//        {'7','.','.',  '.','.','.',  '.','.','.'},
//        {'.','2','.',  '1','.','9',  '.','.','.'},
//
//        {'.','.','7',  '.','.','.',  '2','4','.'},
//        {'.','6','4',  '.','1','.',  '5','9','.'},
//        {'.','9','8',  '.','.','.',  '3','.','.'},
//
//        {'.','.','.',  '8','.','3',  '.','2','.'},
//        {'.','.','.',  '.','.','.',  '.','.','6'},
//        {'.','.','.',  '2','7','5',  '9','.','.'}
        sudoku = new Sudoku(mediumDifficulty);
        sudoku.lookupAllPossibleValuesInMatrix();
        Spot [] row = sudoku.getRelatedRow(sudoku.spots[0][0]);
        String expected = "row: 0 col: 0 val: .[1, 3, 5, 6]\n" +
                "row: 0 col: 1 val: .[1, 3, 5]\n" +
                "row: 0 col: 2 val: 9[]\n" +
                "row: 0 col: 3 val: 7[]\n" +
                "row: 0 col: 4 val: 4[]\n" +
                "row: 0 col: 5 val: 8[]\n" +
                "row: 0 col: 6 val: .[1, 6]\n" +
                "row: 0 col: 7 val: .[1, 3, 5, 6]\n" +
                "row: 0 col: 8 val: .[1, 2, 3, 5]\n";
        StringBuilder stringBuilder = new StringBuilder();
        for (Spot spot: row) {
            stringBuilder.append("row: " + spot.row + " col: " + spot.col + " val: " + spot.getCurrentValue());
            stringBuilder.append(spot.getPossibleValues().toString() + '\n');
        }
        assertEquals(expected, stringBuilder.toString());

        row = sudoku.getRelatedRow(sudoku.spots[1][0]);
        expected = "row: 1 col: 0 val: 7[]\n" +
                "row: 1 col: 1 val: .[1, 3, 4, 5, 8]\n" +
                "row: 1 col: 2 val: .[1, 3, 5, 6]\n" +
                "row: 1 col: 3 val: .[3, 5, 6]\n" +
                "row: 1 col: 4 val: .[2, 3, 5, 6]\n" +
                "row: 1 col: 5 val: .[2, 6]\n" +
                "row: 1 col: 6 val: .[1, 4, 6, 8]\n" +
                "row: 1 col: 7 val: .[1, 3, 5, 6, 8]\n" +
                "row: 1 col: 8 val: .[1, 2, 3, 4, 5, 8, 9]\n";
        stringBuilder = new StringBuilder();
        for (Spot spot: row) {
            stringBuilder.append("row: " + spot.row + " col: " + spot.col + " val: " + spot.getCurrentValue());
            stringBuilder.append(spot.getPossibleValues().toString() + '\n');
        }
        assertEquals(expected, stringBuilder.toString());

        try {
            sudoku.findAllSingleDerivedElements();
            sudoku.findUniquePossibleValuesInEachGroup();
        } catch (Exception e) {
            fail();
        }
        sudoku.printSudoku();
        try {
            sudoku.validate();
        } catch (Exception e) {
            fail();
        }

        row = sudoku.getRelatedRow(sudoku.spots[1][0]);
        expected = "row: 1 col: 0 val: 7[]\n" +
                "row: 1 col: 1 val: .[1, 3, 4, 5, 8]\n" +
                "row: 1 col: 2 val: .[1, 3, 5]\n" +
                "row: 1 col: 3 val: 6[]\n" +
                "row: 1 col: 4 val: .[3, 5]\n" +
                "row: 1 col: 5 val: 2[]\n" +
                "row: 1 col: 6 val: .[1, 4, 8]\n" +
                "row: 1 col: 7 val: .[1, 3, 5, 8]\n" +
                "row: 1 col: 8 val: 9[]\n";
        stringBuilder = new StringBuilder();
        for (Spot spot: row) {
            stringBuilder.append("row: " + spot.row + " col: " + spot.col + " val: " + spot.getCurrentValue());
            stringBuilder.append(spot.getPossibleValues().toString() + '\n');
        }
        assertEquals(expected, stringBuilder.toString());
    }

    @Test
    void findAllPossibilitiesInGroup() {
        sudoku = new Sudoku(mediumDifficulty);
        Spot[] group = sudoku.getRelatedRow(sudoku.spots[0][0]);
        try {
            sudoku.findAndFillAllPossibilitiesInGroup(group);
            assertTrue(sudoku.validate());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void findAllSingleDerivedElements() {
    }

    @Test
    void fillAllPossibleValues() {
    }

    @Test
    void findAllPossibleValues() {
    }


    @Test
    void removePossibleValues() {
    }

}