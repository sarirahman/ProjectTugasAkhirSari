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
    double[][] data;
    int iterasi;
    Cetak ctk = new Cetak();
    
    public SOM(){}
    
    public SOM(double[][] data, int iterasi){
        this.data = data;
        this.iterasi = iterasi;
    }

    public double getIndexOfMinimum(double[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }
    
    public double getValueOfMinimum(double[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return array[min];
    }

    public double[][] testEuclidean(double[][] bobot, double alpha) {
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
        ctk.cetak_double(bobot);
        for (int loop = 0; loop < iterasi; loop++) {
            for (i = 0; i < baris_nilai; i++) {
                for (j = 0; j < baris_bobot; j++) {
                    for (k = 0; k < kolom; k++) {
                        sum = sum + Math.pow(data[i][k] - bobot[j][k], 2);
                    }
                    hasil = Math.sqrt(sum);
                    hasil2[j] = hasil;
                    sum=0;
                    hasil=0;
                }
                
                min_bobot = (int) getIndexOfMinimum(hasil2);
                min = getValueOfMinimum(hasil2);
                data2[i][0]= min_bobot;
                data2[i][1]= min;

//                if(min_bobot-1 < 0 && min_bobot+1 < baris_bobot){
//                    for(l=0;l<bobot[0].length;l++){
//                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
//                        bobot[min_bobot+1][l] = bobot[min_bobot+1][l]+(alpha *(data[i][l]-bobot[min_bobot+1][l]));
//                    }
//                }
//                else if(min_bobot-1 >= 0 && min_bobot+1 > baris_bobot-1){
//                    for(l=0;l<bobot[0].length;l++){
//                        bobot[min_bobot-1][l] = bobot[min_bobot-1][l]+(alpha *(data[i][l]-bobot[min_bobot-1][l]));
//                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
//                    }
//                }
//                else{
//                    for(l=0;l<bobot[0].length;l++){
//                        bobot[min_bobot-1][l] = bobot[min_bobot-1][l]+(alpha *(data[i][l]-bobot[min_bobot-1][l]));
//                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
//                        bobot[min_bobot+1][l] = bobot[min_bobot+1][l]+(alpha *(data[i][l]-bobot[min_bobot+1][l]));
//                    }
//                }
                
                for(l=0;l<bobot[0].length;l++){
                    bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                }
            }
            alpha = alpha * 0.5;
        }
        ctk.cetak_double(data2);
        return data2;
    }

    public double[][] testManhattan(double[][] bobot, double alpha) {
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
        for (int loop = 0; loop < iterasi; loop++) {
            for (i = 0; i < baris_nilai; i++) {
                for (j = 0; j < baris_bobot; j++) {
                    for (k = 0; k < kolom; k++) {
                        hasil = hasil + Math.abs(data[i][k]-bobot[j][k]);
                    }
                    hasil2[j] = hasil;
                    sum=0;
                    hasil=0;
                }
                min_bobot = (int) getIndexOfMinimum(hasil2);
                min = getValueOfMinimum(hasil2);
                data2[i][0]= min_bobot;
                data2[i][1]= min;
                
                if(min_bobot-1 < 0 && min_bobot+1 < baris_bobot){
                    for(l=0;l<bobot[0].length;l++){
                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                        bobot[min_bobot+1][l] = bobot[min_bobot+1][l]+(alpha *(data[i][l]-bobot[min_bobot+1][l]));
                    }
                }
                else if(min_bobot-1 >= 0 && min_bobot+1 > baris_bobot-1){
                    for(l=0;l<bobot[0].length;l++){
                        bobot[min_bobot-1][l] = bobot[min_bobot-1][l]+(alpha *(data[i][l]-bobot[min_bobot-1][l]));
                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                    }
                }
                else{
                    for(l=0;l<bobot[0].length;l++){
                        bobot[min_bobot-1][l] = bobot[min_bobot-1][l]+(alpha *(data[i][l]-bobot[min_bobot-1][l]));
                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                        bobot[min_bobot+1][l] = bobot[min_bobot+1][l]+(alpha *(data[i][l]-bobot[min_bobot+1][l]));
                    }
                }
                
//                for(l=0;l<bobot[0].length;l++){
//                    bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
//                }
            }
            alpha = alpha * 0.5;
        }
        return data2;
    }

    public double[][] testChebyshev(double[][] bobot, double alpha) {
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

        for (int loop = 0; loop < iterasi; loop++) {
            for (i = 0; i < baris_nilai; i++) {
                for (j = 0; j < baris_bobot; j++) {
                    for (k = 0; k < kolom; k++) {
                        sum = Math.abs(data[i][k] - bobot[j][k]);
                        if (sum > hasil) {
                            hasil = sum;
                        }
                    }
                    hasil2[j] = hasil;
                    sum=0;
                    hasil=0;
                }
                min_bobot = (int) getIndexOfMinimum(hasil2);
                min = getValueOfMinimum(hasil2);
                data2[i][0]= min_bobot;
                data2[i][1]= min;
                
                if(min_bobot-1 < 0 && min_bobot+1 < baris_bobot){
                    for(l=0;l<bobot[0].length;l++){
                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                        bobot[min_bobot+1][l] = bobot[min_bobot+1][l]+(alpha *(data[i][l]-bobot[min_bobot+1][l]));
                    }
                }
                else if(min_bobot-1 >= 0 && min_bobot+1 > baris_bobot-1){
                    for(l=0;l<bobot[0].length;l++){
                        bobot[min_bobot-1][l] = bobot[min_bobot-1][l]+(alpha *(data[i][l]-bobot[min_bobot-1][l]));
                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                    }
                }
                else{
                    for(l=0;l<bobot[0].length;l++){
                        bobot[min_bobot-1][l] = bobot[min_bobot-1][l]+(alpha *(data[i][l]-bobot[min_bobot-1][l]));
                        bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
                        bobot[min_bobot+1][l] = bobot[min_bobot+1][l]+(alpha *(data[i][l]-bobot[min_bobot+1][l]));
                    }
                }
                
//                for(l=0;l<bobot[0].length;l++){
//                    bobot[min_bobot][l] = bobot[min_bobot][l]+(alpha *(data[i][l]-bobot[min_bobot][l]));
//                }
            }
            alpha = alpha * 0.5;
        }
        
        return data2;
    }
    
    
    public double[][] clusteringESOM(double[][] bobot, double alpha){
        double[][] hasilESOM = new double[data.length][2];
        hasilESOM = testEuclidean(bobot, alpha);
        return hasilESOM;
    }
    
    public double[][] clusteringMSOM(double[][] bobot, double alpha){
        double[][] hasilMSOM = new double[data.length][2];
        hasilMSOM = testManhattan(bobot, alpha);
        return hasilMSOM;
    }
    
    public double[][] clusteringCSOM(double[][] bobot, double alpha){
        double[][] hasilCSOM = new double[data.length][2];
        hasilCSOM = testChebyshev(bobot, alpha);
        return hasilCSOM;
    }
}
