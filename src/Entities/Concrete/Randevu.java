package Entities.Concrete;

public class Randevu
{
    public int randevuId;
    public String doctorName;
    public String doctorSkill;
    public String dateDay;
    public String dateTime;

    public Randevu(int randevuId,String doctorName,String doctorSkill,String dateDay,String dateTime)
    {
        this.doctorName=doctorName;
        this.doctorSkill=doctorSkill;
        this.randevuId=randevuId;
        this.dateDay=dateDay;
        this.dateTime=dateTime;
    }
}
