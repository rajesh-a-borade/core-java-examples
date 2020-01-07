package comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee>
{
    public int compare(Employee c1, Employee c2)
    {
        return c1.getName().compareTo(c2.getName());
    }
}