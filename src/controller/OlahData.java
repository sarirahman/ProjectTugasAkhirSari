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
    
    public String readDokumenTeks(int kodefile){
        String filepath = "";
        switch(kodefile){
            case 0 : filepath = "C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectTA\\src\\dataset\\iris.txt"; break;
            case 1 : filepath = "C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectTA\\src\\dataset\\wine.txt"; break;
            case 2 : filepath = "C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectTA\\src\\dataset\\cardata.txt"; break;
            case 3 : filepath = "C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectTA\\src\\dataset\\abaloneData.txt"; break;
        }
        return filepath;
    }
    
    public int readJumlahIterasi(int kode){
        int jlhIterasi = 0;
        switch(kode){
            case 0 : jlhIterasi = 100; break;
            case 1 : jlhIterasi = 200; break;
            case 2 : jlhIterasi = 300; break;
            case 3 : jlhIterasi = 400; break;
            case 4 : jlhIterasi = 500; break;
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
    
    public int readJumlahCluster(int kode){
        int jlhCluster = 0;
        switch(kode){
            case 0 : jlhCluster = 3; break;
            case 1 : jlhCluster = 4; break;
            case 2 : jlhCluster = 5; break;
            case 3 : jlhCluster = 6; break;
            case 4 : jlhCluster = 7; break;
            case 5 : jlhCluster = 8; break;
            case 6 : jlhCluster = 9; break;
            case 7 : jlhCluster = 10; break;
            case 8 : jlhCluster = 11; break;
            case 9 : jlhCluster = 12; break;
            case 10 : jlhCluster = 13; break;
            case 11 : jlhCluster = 14; break;
            case 12 : jlhCluster = 15; break;            
        }
        return jlhCluster;
    }
}
