/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author User
 */
public class SaveDatatoFile {
    
    public SaveDatatoFile(){}
    
    public void saveData(int kodeData, int kodeCluster, double alpha, int iterasi,
            double dbiE, double dbiM, double dbiC, long timeE, long timeM, long timeC){
        
        File file = new File("src/output/"+kodeData + kodeCluster+".txt");
        try(FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)) {
            out.println(alpha+" "+iterasi+" "+dbiE+" "+dbiM+" "+dbiC+" "+timeE+" "+timeM+" "+timeC);
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }
}
