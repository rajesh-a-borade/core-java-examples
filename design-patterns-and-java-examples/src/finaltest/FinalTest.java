 package finaltest;

public final class FinalTest
{
    final int fi;
    
    public FinalTest()
    {
        fi = 1;
        System.out.println("In constructor");
    }  
    
    public static void main(String [] args)
    {
        final int i;
        int x = 1;
        i = 1;
        System.out.println(i);
        FinalTest ft = new FinalTest();
    }
}

