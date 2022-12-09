package Business.Concrete;

import Business.Abstract.IDoctorService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;

import java.util.ArrayList;
import java.util.Objects;

public class DoctorService implements IDoctorService {


    @Override
    public void randevuAc(Randevu randevu, ArrayList randevuList)
    {
        randevuList.add(randevu);

    }

    @Override
    public ArrayList<Randevu> randevulariGor(RepositoryBase repositoryBase,Doctor authDoctor)
    {
        ArrayList<Randevu> doctorRandevuList = new ArrayList<>();
        for (int i = 0; i < repositoryBase.doctorRandevuListesi.size(); i++)
        {
            if (repositoryBase.doctorRandevuListesi.get(i) == null)
            {
                continue;
            }
            if(repositoryBase.doctorRandevuListesi.get(i).doctorId == authDoctor.doctorId)
            {
                doctorRandevuList.add(repositoryBase.doctorRandevuListesi.get(i));
            }
        }
        return doctorRandevuList;
    }

    @Override
    public Doctor doctorAuth(String tcNo, String password, RepositoryBase repositoryBase)
    {
        for (int i=0;i<repositoryBase.doctorListesi.size();i++)
        {
            if (Objects.equals(repositoryBase.doctorListesi.get(i).tcNo, tcNo))
            {
                if (Objects.equals(repositoryBase.doctorListesi.get(i).password, password))
                {
                    return repositoryBase.doctorListesi.get(i);
                }

            }
        }
        return null;
    }

    @Override
    public Randevu returnRandevuListRandevuByRandevuId(RepositoryBase repositoryBase, int randevuId) {
        for (Randevu randevu:repositoryBase.randevularListesi)
        {
            if (randevu.randevuId == randevuId)
            {
                return randevu;
            }
        }
        return null;
    }

    @Override
    public boolean compareRandevuDate(RepositoryBase repositoryBase, String randevuDateTime)
    {
        for (Randevu randevu : repositoryBase.randevularListesi)
        {
            String randevuDate = randevu.dateTime+randevu.dateDay;
            if (randevuDate.equals(randevuDateTime))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public Randevu returnDoctorListRandevuByRandevuId(RepositoryBase repositoryBase, int randevuId)
    {
        for (Randevu randevu:repositoryBase.doctorRandevuListesi)
        {
            if (randevu.randevuId == randevuId)
            {
                return randevu;
            }
        }
        return null;
    }


}
