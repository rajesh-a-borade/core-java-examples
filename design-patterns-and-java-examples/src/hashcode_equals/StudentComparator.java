package hashcode_equals;

import java.util.Comparator;

public class StudentComparator implements Comparator
{
    Student student;
       
    @Override
    public int compare(Object s1,Object s2)
    {
        Student student1 = (Student)s1;
        Student student2 = (Student)s2;
              
        
        return student1.getName().compareTo(student2.getName()); 
      
    }
      
}

