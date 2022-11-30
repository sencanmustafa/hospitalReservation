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
    public ArrayList randevulariGor(ArrayList randevuList) {
        return randevuList;
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
}
