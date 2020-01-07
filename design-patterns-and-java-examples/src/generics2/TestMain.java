package generics2;

public class TestMain
{

    public static void main(String [] args)
    {
            Adder<Integer> adder = new Adder<>();  
            System.out.println(adder.add(new Integer(1), new Integer(2)));
            Adder<Float> adder2 = new Adder<>();  
            System.out.println(adder2.add(new Float(9.0f),new Float(2f)));
            //System.out.println(adder.add("xyz","abc"));
            
            
        

    }

}

