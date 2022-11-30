package Entities.Concrete;

import Entities.Abstract.Human;

public class Doctor extends Human
{
    public String doctorSkill ;
    public Doctor(String firstName,String lastName,String doctorSkill,String tcNo,String password)
    {
        super(firstName,lastName,tcNo,password);
        this.doctorSkill=doctorSkill;

    }


}
