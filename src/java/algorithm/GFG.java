/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author DLK-F2
 */
public class GFG  
{ 
    // Method to print n equal parts of str 
     public void divideString(String str, int n) 
    { 
        int str_size = str.length(); 
        int part_size; 
      
    // Check if string can be divided in 
    // n equal parts  
    
      
    // Calculate the size of parts to find  
    // the division points 
    part_size = str_size / n; 
          
    for (int i = 0; i< str_size; i++) 
    { 
        if(i % part_size == 0) 
            System.out.println();  
        System.out.print(str.charAt(i));
        
        
    } 
    } 
      
    // Driver Code 
    public static void main(String[] args) 
    { 
        // length od string is 28 
        String str = "Hi Good morning how are you"; 
        GFG splt=new GFG();
        // Print 4 equal parts of the string 
        splt.divideString(str, 5); 
    } 
} 

