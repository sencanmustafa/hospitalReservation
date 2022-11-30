package Entities.Concrete;

public class Randevu
{
    public int doctorId;
    public int randevuId;
    public int userId;
    public String doctorName;
    public String doctorSkill;
    public String dateDay;
    public String dateTime;

    public Randevu(int randevuId,int doctorId,String doctorName,String doctorSkill,String dateDay,String dateTime)
    {
        this.doctorId=doctorId;
        this.doctorName=doctorName;
        this.doctorSkill=doctorSkill;
        this.randevuId=randevuId;
        this.dateDay=dateDay;
        this.dateTime=dateTime;
    }
    public Randevu(int userId,int randevuId,int doctorId,String doctorName,String doctorSkill,String dateDay,String dateTime)
    {
        this.userId=userId;
        this.doctorId=doctorId;
        this.doctorName=doctorName;
        this.doctorSkill=doctorSkill;
        this.randevuId=randevuId;
        this.dateDay=dateDay;
        this.dateTime=dateTime;
    }

}
