package lab6_2;

import java.util.Random;

public class Matrix {
    private final double[][] data;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    public Matrix(Matrix m){
        rows = m.rows;
        columns = m.columns;
        data = new double[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                data[i][j] = m.data[i][j];
            }
        }
    }

    public static Matrix multiply(Matrix m1, Matrix m3) {
        Matrix matrix = new Matrix(m1.rows,m3.columns);
        for (int i = 0; i < matrix.rows; i++){
            for (int j = 0; j < matrix.columns; j++){
                double cells = 0;
                for (int k = 0; k < m3.rows; k++){
                    cells += m1.data[i][k] * m3.data[k][j];
                }
                matrix.data[i][j] = cells;
            }
        }
        return matrix;
    }

    public static Matrix transpose(Matrix m3) {
        Matrix matrix = new Matrix(m3.columns,m3.rows);
        for (int i = 0; i < matrix.rows; i++){
            for (int j = 0; j < matrix.columns; j++){
                matrix.data[i][j] = m3.data[j][i];
            }
        }
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fillRandom(double a, double b) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[0].length; j++){
                data[i][j] = random.nextDouble(b - a) + a;
            }
        }
    }

    public static Matrix add(Matrix m1, Matrix m2){
        Matrix matrix = new Matrix(m1.rows,m1.columns);
        for (int i = 0; i < matrix.rows; i++){
            for (int j = 0; j < matrix.columns; j++){
                matrix.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return matrix;
    }
}
