/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import view.MainForm;

/**
 *
 * @author User
 */
public class Praproses {
    
    private int sKolom[];
    
    public String[][] dataValue (int kode){
        
        OlahData olDok = new OlahData();
        String filepath = olDok.readDokumenTeks(kode);
        File file = new File(filepath);
        String nilai[][] = null;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object tableLine[] = br.lines().toArray();
            int baris = tableLine.length;
            int kolom = tableLine[0].toString().trim().split(",").length;
            nilai = new String[baris][kolom];
            for(int i=0; i<baris; i++){
                String line = tableLine[i].toString().trim();
                String dataRow[] = line.split(",");
                for(int j=0; j<kolom; j++){
                    nilai[i][j] = dataRow[j];
                }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return nilai;
    }
    
    public int[] checkdata(String data[][]){
        
        String temp;
        char temp2[];
        sKolom = new int[data[0].length];
        
        for(int j=0;j<data[0].length;j++){
            int flag=0;
            for(int i=0;i<data.length;i++){
                temp = data[i][j];             
                temp2 = temp.toCharArray();
                for(int k=0;k<temp2.length;k++){
                    if(temp2[k] >='A' && temp2[k]<='z'){
                        flag = 1;
                    }
                }
            }   
            sKolom[j] = flag;
        }
        
        return sKolom;
    }
    
    public String[][] pembobotan(String nilai[][]){
        
//        int i=0, j=0,k;
        int kolom = nilai[0].length;
        int baris = nilai.length;
        String flag = "0";
        int sKolom[] = new int[nilai[0].length];
        
        sKolom = checkdata(nilai);

        for(int i=0; i<kolom; i++){
            
            if(sKolom[i] == 1){
                    List<String> tmp2 = new ArrayList<String>();

                for(int k=0; k<baris; k++){
                    tmp2.add(nilai[k][i]);
                }

                tmp2 = tmp2.stream().distinct().collect(Collectors.toList());

                for(int j=0; j<baris; j++){
                    for (int l=0; l<tmp2.size(); l++){
                        if(nilai[j][i].equals("?")){
                            flag = "?";
                            continue;
                        }
                        if(nilai[j][i].equals(tmp2.get(l)) && !tmp2.get(l).equals("?"))
                            flag = String.valueOf(l);
                    }
                    nilai[j][i]=flag;
                }
            }
        }
        return nilai;
    }
    
    public String[][] pengecekanMissingValue(String bobot[][]){
        
        int kolom = bobot[0].length;
        int baris = bobot.length;
        double max=0, sum = 0;
        String hasil[] = new String[kolom];
        String mode = null;
        
        
        for(int j=0; j<kolom; j++){
            
            if(sKolom[j] == 1){
                for(int i=0; i<baris; i++){
                    int count = 0;
                    for(int k=0; k<kolom; k++){
                        for(int l=0; l<baris; l++){
                            if(bobot[i][j].equals(bobot[l][k])){
                                count++;
                            }
                        }
                    }
                    if(count > max){
                        mode = bobot[i][j];
                        max = count;
                    }
                }
                hasil[j] = mode;
//                System.out.println(j+" "+hasil[j]);
            }
            
            else{
                int count = 0;
                for(int i=0; i<baris; i++){
                    if(bobot[i][j].equals("?")){
                        count++;
                    }
                    else{
                        sum = sum + Double.parseDouble(bobot[i][j]);
                    }

                }
                hasil[j] = String.valueOf(sum/(baris-count)) ;
//                System.out.println(sum);
//                System.out.println(baris);
//                System.out.println(count);
//                System.out.println(j+" "+hasil[j]);
                sum = 0;
            }
            
            
        }
        
        for(int i=0; i<baris; i++){
            for(int j=0; j<kolom; j++){
                if(bobot[i][j].equals("?")){
                    bobot[i][j]=hasil[j];
                }
            }
        }
        return bobot;
    }
    
    public double[][] normalisasi(String bobot[][]){
        
        int baris = bobot.length;
        int kolom = bobot[0].length;
        double hasilMax[] = new double[kolom];
        double hasilMin[] = new double[kolom];
        double value;
        double databersih[][] = new double[baris][kolom];
        
        for(int j=0; j<kolom; j++){
            String max = "0";
            for(int i=0; i<baris; i++){
                if(Double.parseDouble(bobot[i][j]) > Double.parseDouble(max)){
                    max = bobot[i][j];
                }
            }
            hasilMax[j] = Double.parseDouble(max);
        }
        
        for(int j=0; j<kolom; j++){
            String min = bobot[0][j];
            for(int i=0; i<baris; i++){
                if(Double.parseDouble(bobot[i][j]) < Double.parseDouble(min)){
                    min = bobot[i][j];
                }
            }
            hasilMin[j] = Double.parseDouble(min);
        }
        
        for(int i=0; i<baris; i++){
            for(int j=0; j<kolom; j++){
                value = (Double.parseDouble(bobot[i][j]) - hasilMin[j]) / (hasilMax[j] - hasilMin[j]);
                bobot[i][j] = String.valueOf(value);
            }
        }
        
        DecimalUtils du = new DecimalUtils();
        
        for(int i=0; i<baris; i++){
            for(int j=0; j<kolom; j++){
                databersih[i][j] = du.round(Double.parseDouble(bobot[i][j]), 3) ;
            }
        }
        
        return databersih;
    }
    
}
