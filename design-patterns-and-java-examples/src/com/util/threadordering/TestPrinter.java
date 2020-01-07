package com.util.threadordering;

public class TestPrinter
{

    public static void main(String [] args) throws InstantiationException, IllegalAccessException
    {

        try {
           Printer cls = (Printer)Class.forName("com.util.threadordering.Printer").newInstance();

           // returns the ClassLoader object
           //ClassLoader cLoader = cls.getClassLoader();
         
           /* returns the Class object associated with the class or interface 
              with the given string name, using the given classloader. */
           //Class cls2 = Class.forName("java.lang.Thread", true, cLoader);       
            
           // returns the name of the class
           System.out.println("Printer Class Object = " + cls);
          // System.out.println("Class = " + cls2.getName()); 
        } catch(ClassNotFoundException ex) {
           System.out.println(ex.toString());
        }

    }

}

