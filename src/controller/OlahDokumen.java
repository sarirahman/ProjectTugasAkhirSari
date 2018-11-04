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
public class OlahDokumen {
    public String readDokumenTeks(int kodefile){
        String filepath = "";
        switch(kodefile){
            case 0 : filepath = "E:\\Tugas Akhir\\Data Set\\iris\\iris.txt"; break;
            case 1 : filepath = "E:\\Tugas Akhir\\Data Set\\wine\\wine.txt"; break;
            case 2 : filepath = "E:\\Tugas Akhir\\Data Set\\Evaluation Car\\cardata.txt"; break;
            case 3 : filepath = "E:\\Tugas Akhir\\Data Set\\abalone\\abaloneData.txt"; break;
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
        int jlhIterasi = 0;
        switch(kode){
            case 0 : jlhIterasi = 3; break;
            case 1 : jlhIterasi = 4; break;
            case 2 : jlhIterasi = 5; break;
            case 3 : jlhIterasi = 6; break;
            case 4 : jlhIterasi = 7; break;
            case 5 : jlhIterasi = 8; break;
            case 6 : jlhIterasi = 9; break;
            case 7 : jlhIterasi = 10; break;
            case 8 : jlhIterasi = 11; break;
            case 9 : jlhIterasi = 12; break;
            case 10 : jlhIterasi = 13; break;
            case 11 : jlhIterasi = 14; break;
            case 12 : jlhIterasi = 15; break;            
        }
        return jlhIterasi;
    }
}
