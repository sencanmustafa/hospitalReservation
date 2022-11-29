package Entities.Concrete;

import Entities.Abstract.Human;

import java.util.ArrayList;

public class Admin extends Human
{
    public Admin(String firstName,String lastName,String tcNo,String password)
    {
        super(firstName,lastName,tcNo,password);
    }
}
