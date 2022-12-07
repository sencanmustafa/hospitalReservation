package Entities.Concrete;

import Entities.Abstract.Human;

public class Doctor extends Human
{
    public static int doctorCount = 1;
    public int doctorId;
    public String doctorSkill ;
    public Doctor(int doctorId,String firstName,String lastName,String doctorSkill,String tcNo,String password)
    {
        super(firstName,lastName,tcNo,password);
        this.doctorId = doctorId;
        this.doctorSkill=doctorSkill;
        doctorCount+=1;
    }


}
