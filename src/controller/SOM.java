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
public class SOM {

    public int get_index(int data[][], int nilai) {
        int i, j;
        int baris, kolom;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[0].length; j++) {
                if (data[i][j] == nilai) {
                    baris = i;
                    kolom = j;
                }
            }
        }

        return nilai;
    }

    public double getIndexOfMinimum(double[] array) {
        if (array == null || array.length == 0) {
            return -1; // null or empty
        }
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min; // position of the first smallest found
    }
    
    public double getValueOfMinimum(double[] array) {
        if (array == null || array.length == 0) {
            return -1; // null or empty
        }
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        
        return array[min]; // position of the first largest found
    }
    

    public double[][] testEuclidean(double data[][], double bobot[][], double alpha, int iterasi) {
        int baris_nilai = data.length;
        int baris_bobot = bobot.length;
        int kolom = data[0].length;
        double sum = 0.0, hasil = 0.0;
        double hasil2[] = new double[baris_bobot];
        double data2[][] = new double[baris_nilai][2];
        int index_bobot = 0;
        int i, j, k,l;
        double min = 0;
        int min_bobot =0;
        Cetak ctk = new Cetak();

        for (int loop = 0; loop < iterasi; loop++) {
            System.out.println("\n---------------------Iterasi ke- " + loop + ": -------------------------");
            ctk.cetak_double(bobot);

            for (i = 0; i < baris_nilai; i++) {
                for (j = 0; j < baris_bobot; j++) {
                    for (k = 0; k < kolom; k++) {
                        sum = sum + Math.pow(data[i][k] - bobot[j][k], 2);
                        hasil = Math.sqrt(sum);
                    }
                    System.out.println("Hasil = "+hasil);
                    hasil2[j] = hasil;
                    sum=0;
                    hasil=0;
                }
                
                min_bobot = (int) getIndexOfMinimum(hasil2);
                min = getValueOfMinimum(hasil2);
                //update bobot baru (wbaru) = (wjlama) + (alpha*(xi-wjlama))
                for(l=0;l<bobot[0].length;l++){
                    bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                }
                
                System.out.println("Winners = "+min_bobot+" and value distance ="+min);
                
            }
            alpha = alpha * 0.5;
        }
        return data2;
    }

    public double[][] testManhattan(double data[][], double bobot[][], double alpha, int iterasi) {
        int baris_nilai = data.length;
        int baris_bobot = bobot.length;
        int kolom = data[0].length;
        double sum = 0.0, hasil = 0.0;
        double hasil2[] = new double[baris_bobot];
        double data2[][] = new double[baris_nilai][2];
        int index_bobot = 0;
        int i, j, k,l;
        double min = 0;
        int min_bobot =0;
        Cetak ctk = new Cetak();

        for (int loop = 0; loop < iterasi; loop++) {
            System.out.println("\n---------------------Iterasi ke- " + loop + ": -------------------------");
            ctk.cetak_double(bobot);

            for (i = 0; i < baris_nilai; i++) {
                for (j = 0; j < baris_bobot; j++) {
                    for (k = 0; k < kolom; k++) {
                        sum = sum +(Math.abs(data[i][k] - bobot[j][k]));
                        hasil = Math.sqrt(sum);
                    }
                    System.out.println("Hasil = "+hasil);
                    hasil2[j] = hasil;
                    sum=0;
                    hasil=0;
                }
                min_bobot = (int) getIndexOfMinimum(hasil2);
                min = getValueOfMinimum(hasil2);
                //update bobot baru (wbaru) = (wjlama) + (alpha*(xi-wjlama))
                for(l=0;l<bobot[0].length;l++){
                    bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                }
                
                System.out.println("Winners = "+min_bobot+" and value distance ="+min);
            }
            alpha = alpha * 0.5;
        }
        return data2;
    }

    public double[][] testChebyshev(double data[][], double bobot[][], double alpha, int iterasi) {
        int baris_nilai = data.length;
        int baris_bobot = bobot.length;
        int kolom = data[0].length;
        double sum = 0.0, hasil = 0.0;
        double hasil2[] = new double[baris_bobot];
        double data2[][] = new double[baris_nilai][2];
        int index_bobot = 0;
        int i, j, k,l;
        double min = 0;
        int min_bobot =0;
        Cetak ctk = new Cetak();

        for (int loop = 0; loop < iterasi; loop++) {
            System.out.println("\n---------------------Iterasi ke- " + loop + ": -------------------------");
            ctk.cetak_double(bobot);

            for (i = 0; i < baris_nilai; i++) {
                for (j = 0; j < baris_bobot; j++) {
                    for (k = 0; k < kolom; k++) {
                        sum = Math.abs(data[i][k] - bobot[j][k]);
                        if (sum > hasil) {
                            hasil = sum;
                        }
                    }
                    System.out.println("Hasil = "+hasil);
                    hasil2[j] = hasil;
                    sum=0;
                    hasil=0;
                }
                min_bobot = (int) getIndexOfMinimum(hasil2);
                min = getValueOfMinimum(hasil2);
                //update bobot baru (wbaru) = (wjlama) + (alpha*(xi-wjlama))
                for(l=0;l<bobot[0].length;l++){
                    bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                }
                
                System.out.println("Winners = "+min_bobot+" and value distance ="+min);
            }
            alpha = alpha * 0.5;
        }
        return data2;
    }
}
