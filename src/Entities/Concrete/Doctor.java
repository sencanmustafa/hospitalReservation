package Entities.Concrete;

import Business.Concrete.DoctorService;
import Entities.Abstract.Human;

import java.util.ArrayList;

public class Doctor extends Human
{
    public ArrayList<Randevu> randevuList=new ArrayList<>();
    public String doctorSkill ;
    public Doctor(String firstName,String lastName,String doctorSkill,String tcNo,String password)
    {
        super(firstName,lastName,tcNo,password);
        this.doctorSkill=doctorSkill;

    }


}
