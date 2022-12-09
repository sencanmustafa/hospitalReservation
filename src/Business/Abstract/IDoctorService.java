package Business.Abstract;

import DataAccess.RepositoryBase;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;

import java.util.ArrayList;

public interface IDoctorService<T>
{
    public ArrayList<T> randevulariGor(RepositoryBase repositoryBase,Doctor authDoctor);
    public void randevuAc(Randevu randevu , ArrayList<Randevu> randevuList);
    public Doctor doctorAuth(String tcNo, String password, RepositoryBase repositoryBase);
    public Randevu returnDoctorListRandevuByRandevuId(RepositoryBase repositoryBase , int randevuId);
    public Randevu returnRandevuListRandevuByRandevuId(RepositoryBase repositoryBase , int randevuId);
    public boolean compareRandevuDate(RepositoryBase repositoryBase , String randevuDateTime);
}
