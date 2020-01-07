package mutithreading.examples;

public class Printer
{

    private static Printer PRINTER = new Printer(); 
    private Printer() {}
    
    public void print(long thread_id, int value) {
        System.out.println("\t\t\t Printer : Thread " + thread_id + " printing " + value);
    }
    
    public static Printer getPrinter() {
        return PRINTER;
    }
}

