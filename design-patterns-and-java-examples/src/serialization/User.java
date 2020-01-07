package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
 
public class User implements Serializable {
 
    private static final long serialVersionUID = 7829136421241571165L;
     
    private String firstName;
    private String lastName;
    private int accountNumber;
    private Date dateOpened;
 
    public User(String firstName, String lastName, int accountNumber, Date dateOpened) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
    }
     
    public User() {
        super();
    }
 
    //Setters and Getters
 
    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {      
        firstName = aInputStream.readUTF();
        lastName = aInputStream.readUTF();
        accountNumber = aInputStream.readInt();
        dateOpened = new Date(aInputStream.readLong());
    }
 
    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        aOutputStream.writeUTF(firstName.toLowerCase());
        aOutputStream.writeUTF(lastName);
        aOutputStream.writeInt(accountNumber);
        aOutputStream.writeLong(dateOpened.getTime());
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public Date getDateOpened()
    {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened)
    {
        this.dateOpened = dateOpened;
    }
    
    
}
