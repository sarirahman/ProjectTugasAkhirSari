/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class DBI {
    
    public double value(double cluster[][]){
        List<Integer> tmp2 = new ArrayList<Integer>();
        int i,j;
        int counter=0;
        double sum = 0;
        int data2[] = new int[cluster.length];
        
        for(i=0; i<cluster.length; i++){
            data2[i] = (int) cluster[i][0];
        }
        
        Arrays.sort(data2);
        
        for(i=0;i<cluster.length;i++){
            tmp2.add(data2[i]);
        }
        
        tmp2 = tmp2.stream().distinct().collect(Collectors.toList());
        
        int list[][] = new int[tmp2.size()][2];
        
        for(i=0;i<list.length;i++){
            list[i][0] = tmp2.get(i);
        }
        
        double x[] = new double[list.length];
        x[0] = 0;
        
        for(i=0;i<list.length;i++){
            for(j=0;j<cluster.length;j++){
                if(cluster[j][0]==list[i][0]){
                    counter++;
                    sum = sum + cluster[j][1];   
                }
            }
            list[i][1] = counter;
            x[i] = sum/counter;
            counter=0;
            sum=0;
        }

//        for(i=0; i<list.length; i++){
//            System.out.println(list[i][0]+" "+list[i][1]);
//        }
//        for(i=0; i<list.length; i++){
//            System.out.println(list[i][0]+" "+x[i]);
//        }
        
        double var[] = new double[list.length];
        var[0] = 0;
        sum = 0;
        for(i=0;i<list.length;i++){
            for(j=0;j<cluster.length;j++){
                if(cluster[j][0]==list[i][0]){
                    sum = sum + Math.pow(cluster[j][1] - x[i],2);   
                }
            }
//            System.out.println(sum);
            var[i] = sum/(list[i][1]);
            sum=0;
        }
        
//        System.out.println("");
//        for(i=0; i<list.length; i++){
//            System.out.println(list[i][0]+" "+var[i]);
//        }
        
        double totVar = 0, totX = 0;
        for(i=0; i<list.length; i++){
            totVar = totVar + var[i];
            totX = x[i] - totX;
        }
        double rMax = totVar/Math.abs(totX);
        double hasil = rMax/list.length;
        return hasil;
    }
    
     public int [][] amount(double cluster[][],int jcluster){
//        int jcluster = Integer.parseInt(jc);
        int list[][] = new int [jcluster][2];
        int[] temp = new int[jcluster];
        int i,j,counter=0;
        
        for(i=0; i<jcluster; i++){
            temp[i] = i;
            list[i][0]=i;
        }
        
        for(i=0;i<jcluster;i++){
            for(j=0;j<cluster.length;j++){
                if(temp[i]==cluster[j][0]){
                    counter++;
                }
            }
            list[i][1]=counter;
            counter=0;
        }
       
        
        return list;
    }
    
}
