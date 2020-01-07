package generics2;

public class Adder<T extends Number>
{    
    public double add(T x, T y){

        return Double.valueOf(x.toString()) + Double.valueOf(x.toString());
     }       
}

