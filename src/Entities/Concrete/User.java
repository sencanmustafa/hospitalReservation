package Entities.Concrete;

import Entities.Abstract.Human;

import java.util.ArrayList;

public class User extends Human
{
    public ArrayList<Randevu> randevuList = new ArrayList<>();
    public User(String firstName,String lastName,String tcNo,String password)
    {
        super(firstName,lastName,tcNo,password);

    }
}
