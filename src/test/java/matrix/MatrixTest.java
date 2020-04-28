package matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Locale;

import matrix.Matrix;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static java.util.Scanner.*;

public class MatrixTest {

    @Test
    public void AddSimpleTest() {
        double[][] arr1 = {{2, 4}, {6, 8}};
        double[][] arr2 = {{1, 3}, {5, 7}};
        double[][] arr3 = {{3, 7}, {11, 15}};

        assertArrayEquals(arr3, Matrix.add(arr1, arr2));
    }

    @Test
    public void SubSimpleTest() {
        double[][] arr1 = {{2, 4}, {6, 8}};
        double[][] arr2 = {{1, 3}, {5, 7}};
        double[][] arr3 = {{1, 1}, {1, 1}};

        assertArrayEquals(arr3, Matrix.sub(arr1, arr2));
    }

    @Test
    public void MulSimpleTest() {
        double[][] arr1 = {{2, 4}, {6, 8}};
        double[][] arr2 = {{1, 3}, {5, 7}};
        double[][] arr3 = {{22, 34}, {46, 74}};

        assertArrayEquals(arr3, Matrix.multiply(arr1, arr2));
    }

    @Test
    public void MulByValueSimpleTest() {
        double[][] arr1 = {{2, 4}, {6, 8}};
        double val = 4;
        double[][] arr2 = {{8, 16}, {24, 32}};

        assertArrayEquals(arr2, Matrix.multiply(arr1, val));
    }

    @Test
    public void AddFileTest() {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(getClass().getResourceAsStream("/AddTestInfo.txt"));
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr3 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr3[i][j] = in.nextDouble();

        in.close();

        assertEquals(arr1.length, arr2.length);
        assertEquals(arr1[0].length, arr2[0].length);
        assertArrayEquals(arr3, Matrix.add(arr1, arr2));
    }

    @Test
    public void SubFileTest() {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(getClass().getResourceAsStream("/SubTestInfo.txt"));
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr3 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr3[i][j] = in.nextDouble();

        in.close();

        assertEquals(arr1.length, arr2.length);
        assertEquals(arr1[0].length, arr2[0].length);
        assertArrayEquals(arr3, Matrix.sub(arr1, arr2));
    }

    @Test
    public void MulFileTest() {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(getClass().getResourceAsStream("/MulTestInfo.txt"));
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr3 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr3[i][j] = in.nextDouble();

        in.close();

        assertEquals(arr1[0].length, arr2.length);
        assertArrayEquals(arr3, Matrix.multiply(arr1, arr2));
    }

    @Test
    public void MulByValueFileTest() {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(getClass().getResourceAsStream("/MulByValueTestInfo.txt"));
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        double val = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        in.close();

        assertArrayEquals(arr2, Matrix.multiply(arr1, val));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 3 9 9 5 7 5 2 2 5 1 3 3 6 9 2 5 6 4 2.5 5 6 3 3 15 18 7 12 11 6 4.5 10 7",
            "1 2 6.6 3 1 2 4.4 -8 1 2 11 -5",
            "2 2 0 0 0 0 2 2 4 2 0 -3 2 2 4 2 0 -3"})
    public void AddParamsTest(String str) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(str);
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr3 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr3[i][j] = in.nextDouble();

        in.close();

        assertEquals(arr1.length, arr2.length);
        assertEquals(arr1[0].length, arr2[0].length);
        assertArrayEquals(arr3, Matrix.add(arr1, arr2));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 3 9 9 5 7 5 2 2 5 1 3 3 6 9 2 5 6 4 2.5 5 6 3 3 3 0 3 2 -1 -2 -0.5 0 -5",
            "1 2 6.4 3 1 2 4.4 -8 1 2 2 11",
            "2 2 0 0 0 0 2 2 4 2 0 -3 2 2 -4 -2 0 3"})
    public void SubParamsTest(String str) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(str);
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr3 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr3[i][j] = in.nextDouble();

        in.close();

        assertEquals(arr1.length, arr2.length);
        assertEquals(arr1[0].length, arr2[0].length);
        assertArrayEquals(arr3, Matrix.sub(arr1, arr2));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 3 9 9 5 7 5 2 2 5 1 3 3 6 9 2 5 6 4 2.5 5 6 3 3 111.5 160 84 72 103 46 39.5 53 30",
            "1 2 6.6 3 2 1 5 -8 1 1 9",
            "2 2 1 0 0 1 2 2 4 2 0 -3 2 2 4 2 0 -3"})
    public void MulParamsTest(String str) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(str);
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr3 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr3[i][j] = in.nextDouble();

        in.close();

        assertEquals(arr1[0].length, arr2.length);
        assertArrayEquals(arr3, Matrix.multiply(arr1, arr2));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 3 9 9 5 7 5 2 2 5 1 5 3 3 45 45 25 35 25 10 10 25 5",
            "1 2 6.6 3 -1 1 2 -6.6 -3",
            "2 2 4 2 0 -3 1 2 2 4 2 0 -3"})
    public void MulByValueParamsTest(String str) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(str);
        int size1, size2;

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr1 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr1[i][j] = in.nextDouble();

        double val = in.nextDouble();

        size1 = in.nextInt();
        size2 = in.nextInt();
        double[][] arr2 = new double[size1][size2];
        for (int i = 0; i < size1; ++i)
            for (int j = 0; j < size2; ++j)
                arr2[i][j] = in.nextDouble();

        in.close();

        assertArrayEquals(arr2, Matrix.multiply(arr1, val));
    }

}
