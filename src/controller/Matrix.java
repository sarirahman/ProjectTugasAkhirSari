/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author User
 */
public class Matrix {
    
    public Matrix(){}
    
    public double[][] randomValue(int jlhCluster, double[][] data){
        int kolom = data[0].length;
        return random(jlhCluster, kolom);
    }
    
    public double[][] random(int jlhCluster, int jlhAtribut){
        DecimalUtils du = new DecimalUtils();
        Random rnd = new Random();
        double[][] d= new double[jlhCluster][jlhAtribut];
        for(int i=0; i<jlhCluster; i++){
            for(int j=0; j<jlhAtribut; j++){
                d[i][j]= du.round(rnd.nextDouble(), 3);
            }
        }
        return d;
    }
}
