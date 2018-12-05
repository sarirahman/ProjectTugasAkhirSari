/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class OlahData {
    
    public int readJumlahIterasi(int kode){
        int jlhIterasi = 0;
        switch(kode){
            case 0 : jlhIterasi = 5; break;
            case 1 : jlhIterasi = 10; break;
            case 2 : jlhIterasi = 20; break;
            case 3 : jlhIterasi = 25; break;
            case 4 : jlhIterasi = 50; break;
            case 5 : jlhIterasi = 100; break;
        }
        return jlhIterasi;
    }
    
    public double readLajuAwal(int kode){
        double lajuAwal = 0;
        switch(kode){
            case 0 : lajuAwal = 0.4; break;
            case 1 : lajuAwal = 0.6; break;
            case 2 : lajuAwal = 0.7; break;
            case 3 : lajuAwal = 0.9; break;
        }
        return lajuAwal;
    }
    
    public int readJumlahCluster(int kodeCluster, int kodeData){
        int jlhCluster = 0;
        if(kodeData == 0 || kodeData == 1 || kodeData == 2){
            switch(kodeCluster){
            case 0 : jlhCluster = 3; break;
            case 1 : jlhCluster = 4; break;
            case 2 : jlhCluster = 5; break;
            case 3 : jlhCluster = 6; break;            
            }
        }
        else{
            switch(kodeCluster){
                case 0 : jlhCluster = 10; break;
                case 1 : jlhCluster = 20; break;
                case 2 : jlhCluster = 25; break;
                case 3 : jlhCluster = 29; break;
                case 4 : jlhCluster = 35; break;
            }
        }
        
        return jlhCluster;
    }
}
