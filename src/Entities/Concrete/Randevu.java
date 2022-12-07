package Entities.Concrete;

public class Randevu
{
    public static int randevuCount = 1;
    public int doctorId;
    public int randevuId;
    public int userId;
    public String doctorName;
    public String doctorSkill;
    public String dateDay;
    public String dateTime;
    public boolean selected;

    public Randevu(int randevuId,int doctorId,String doctorName,String doctorSkill,String dateDay,String dateTime)
    {
        this.doctorId=doctorId;
        this.doctorName=doctorName;
        this.doctorSkill=doctorSkill;
        this.randevuId=randevuId;
        this.dateDay=dateDay;
        this.dateTime=dateTime;
        this.selected = false;
        randevuCount+=1;
    }
    public Randevu(int userId,int randevuId,int doctorId,String doctorName,String doctorSkill,String dateDay,String dateTime,boolean selected)
    {
        this.userId=userId;
        this.doctorId=doctorId;
        this.doctorName=doctorName;
        this.doctorSkill=doctorSkill;
        this.randevuId=randevuId;
        this.dateDay=dateDay;
        this.dateTime=dateTime;
        this.selected = selected;
        randevuCount+=1;
    }

}
