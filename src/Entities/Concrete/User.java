package Entities.Concrete;

import Entities.Abstract.Human;

import java.util.ArrayList;

public class User extends Human
{
    public int userId;
    public User(int userId,String firstName,String lastName,String tcNo,String password)
    {
        super(firstName,lastName,tcNo,password);
        this.userId=userId;
    }
}
