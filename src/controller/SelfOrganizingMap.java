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
public class SelfOrganizingMap {
    
    public int[] testEuclidean(double data[][], double bobot[][], double alpha, int iterasi){
        
        int baris_nilai = data.length;
        int baris_bobot = bobot.length;
        int kolom = data[0].length;
        double sum = 0.0, hasil = 0.0;
        double hasil2[] = new double[baris_bobot];
        int data2[] = new int[baris_nilai];
        int index_bobot = 0;
        
        for(int loop=0; loop<iterasi; loop++){
            for(int i=0; i<baris_nilai; i++){
//                System.out.println("Data ke-"+i);
                double min = 0;
                for(int j=0; j<baris_bobot; j++){
                    for(int k=0; k<kolom; k++){
                        sum = sum + Math.pow(data[i][k]-bobot[j][k], 2);
                        hasil = Math.sqrt(sum);
//                        System.out.println(data[i][k]+"     "+bobot[j][k]);
                    }
                    hasil2[j] = hasil;

                    if(min == 0){
                        min = hasil2[j];
                        index_bobot = j;
                    }
                    else{
                        if(min > hasil2[j]){
                            min = hasil2[j];
                            index_bobot = j;
                        }
                    }
//                    System.out.println("\nmin :"+ min);
//                    System.out.println("index :"+ index_bobot);
//                    System.out.println("sum = " + sum + " and hasil = "+hasil+"\n");
                    sum = 0;
                    hasil = 0;
                }
                data2[i] = index_bobot;
                bobot = updateBobot(data, bobot, alpha, index_bobot, i);
            }
            alpha = alpha * 0.5;
        }
        return data2;
    }
    
    public int[] testManhattan(double data[][], double bobot[][], double alpha, int iterasi){
        
        int baris_nilai = data.length;
        int baris_bobot = bobot.length;
        int kolom = data[0].length;
        double sum = 0.0, hasil = 0.0;
        double hasil2[] = new double[baris_bobot];
        int data2[] = new int[baris_nilai];
        int index_bobot = 0;

        for(int loop=0; loop<iterasi; loop++){
            for(int i=0; i<baris_nilai; i++){
//                System.out.println("Data ke-"+i);
                double min = 0;
                for(int j=0; j<baris_bobot; j++){
                    for(int k=0; k<kolom; k++){
                        hasil = hasil + Math.abs(data[i][k]-bobot[j][k]);
//                        System.out.println(data[i][k]+"     "+bobot[j][k]);
                    }
                    hasil2[j] = hasil;

                    if(min == 0){
                        min = hasil2[j];
                        index_bobot = j;
                    }
                    else{
                        if(min > hasil2[j]){
                            min = hasil2[j];
                            index_bobot = j;
                        }
                    }
//                    System.out.println("\nmin :"+ min);
//                    System.out.println("index :"+ index_bobot);
//                    System.out.println("sum = " + sum + " and hasil = "+hasil+"\n");
                    sum = 0;
                    hasil = 0;
                }
                data2[i] = index_bobot;
                bobot = updateBobot(data, bobot, alpha, index_bobot, i);
            }
            alpha = alpha * 0.5;
        }
        return data2;
    }
    
    public int[] testChebyshev(double data[][], double bobot[][], double alpha, int iterasi){
        
        int baris_nilai = data.length;
        int baris_bobot = bobot.length;
        int kolom = data[0].length;
        double sum = 0.0, hasil = 0.0;
        double hasil2[] = new double[baris_bobot];
        int data2[] = new int[baris_nilai];
        int index_bobot = 0;

        for(int loop=0; loop<iterasi; loop++){
            for(int i=0; i<baris_nilai; i++){
//                System.out.println("Data ke-"+i);
                double min = 0;
                for(int j=0; j<baris_bobot; j++){
                    for(int k=0; k<kolom; k++){
                            sum = Math.abs(data[i][k]-bobot[j][k]);
//                            System.out.println(data[i][k]+"     "+bobot[j][k]);
                            if(sum > hasil){
                                hasil = sum;
                            }
                        }
                    hasil2[j] = hasil;

                    if(min == 0){
                        min = hasil2[j];
                        index_bobot = j;
                    }
                    else{
                        if(min > hasil2[j]){
                            min = hasil2[j];
                            index_bobot = j;
                        }
                    }
//                    System.out.println("\nmin :"+ min);
//                    System.out.println("index :"+ index_bobot);
//                    System.out.println("sum = " + sum + " and hasil = "+hasil+"\n");
                    sum = 0;
                    hasil = 0;
                }
                data2[i] = index_bobot;
                bobot = updateBobot(data, bobot, alpha, index_bobot, i);
            }
            alpha = alpha * 0.5;
        }
        return data2;
    }
    
    public double[][] updateBobot(double data[][], double bobot[][], double alpha, int index_bobot, int index_data){
        
        int baris = bobot.length;
        int kolom = bobot[0].length;
        
        for(int j=0; j<kolom; j++){
            bobot[index_bobot][j] = bobot[index_bobot][j] + alpha * (data[index_data][j] - bobot[index_bobot][j]);
        }
        
        return bobot;
    }
    
}
