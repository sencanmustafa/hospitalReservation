package DataAccess;

import Entities.Concrete.Admin;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import javax.print.Doc;
import java.security.PublicKey;
import java.util.ArrayList;

public class RepositoryBase
{
    public ArrayList<Randevu> randevularListesi;
    public ArrayList<Randevu> userRandevuListesi;
    public ArrayList<Randevu> doctorRandevuListesi;

    public ArrayList<Doctor> doctorListesi;
    public ArrayList<User> userListesi;
    public ArrayList<Admin> adminListesi;
    public ArrayList<String> randevuGunSaatleri;

    public RepositoryBase()
    {
        this.userListesi = new ArrayList<>();
        this.randevularListesi= new ArrayList<>();
        this.adminListesi= new ArrayList<>();
        this.doctorListesi= new ArrayList<>();
        this.doctorRandevuListesi= new ArrayList<>();
        this.userRandevuListesi= new ArrayList<>();
        this.randevuGunSaatleri = new ArrayList<>();

    }

    public ArrayList<Randevu> returnNonSelectedRandevu()
    {
        ArrayList<Randevu> nonSelectedRandevu = new ArrayList<>();
        for (Randevu randevu : this.randevularListesi)
        {
            if (!randevu.selected)
            {
                nonSelectedRandevu.add(randevu);
            }

        }
        if (nonSelectedRandevu.size() == 0)
        {
            return null;
        }
        else
        {
            return nonSelectedRandevu;
        }
    }
}
