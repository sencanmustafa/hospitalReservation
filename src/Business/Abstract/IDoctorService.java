package Business.Abstract;

import DataAccess.RepositoryBase;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import java.util.ArrayList;

public interface IDoctorService<T>
{
    public ArrayList<T> randevulariGor(ArrayList<Randevu> randevuList);
    public void randevuAc(Randevu randevu , ArrayList<Randevu> randevuList);
    public Doctor doctorAuth(String tcNo, String password, RepositoryBase repositoryBase);
    public void randevuSil(int randevuId,ArrayList<Randevu> randevuList);
}
