package Entities.Abstract;

import java.util.ArrayList;

public abstract class Human
{
    public String firstName;
    public String lastName;
    public String tcNo;
    public String password;
    public Human(String firstName,String lastName,String tcNo,String password)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.tcNo = tcNo;
        this.password=password;
    }
}
