/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author User
 */
public class Cetak {
    public void cetak(String data[][]) {
        int i, j;
        int row = 0, col = 0;
        row = data.length;
        col = data[0].length;

        System.out.println("row = " + row + " col = " + col + "\n");

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public void cetak_double(double data[][]) {
        int i, j;
        int row = 0, col = 0;
        row = data.length;
        col = data[0].length;

        System.out.println("\nrow = " + row + " col = " + col + "\n");

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    
    public void cetak_int(int data[]){
        int i;
        int row = 0;
        row = data.length;
        System.out.println("\nrow = "+row);
        
        for(i=0; i<row; i++){
            System.out.println(data[i]);
        }
    }
}
