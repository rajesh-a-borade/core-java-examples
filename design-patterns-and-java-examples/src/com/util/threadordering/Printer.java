package com.util.threadordering;

public class Printer
{
    
 // static variable single_instance of type Singleton 
    private static Printer printer = null; 
  
    
  
    // private constructor restricted to this class itself 
    private Printer() 
    { 
        
    } 
  
    // static method to create instance of Singleton class 
    public static Printer getInstance() 
    { 
        if (printer == null) 
            printer = new Printer(); 
  
        return printer; 
    }
    public void print(String s) {
        System.out.println(s);
    }
} 
    



