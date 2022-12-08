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
            if (repositoryBase.doctorRandevuListesi.get(i).doctorId == authDoctor.doctorId)
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
    public void randevuSil(int randevuId, ArrayList randevuList)
    {
        randevuList.remove(randevuId);
    }
}
