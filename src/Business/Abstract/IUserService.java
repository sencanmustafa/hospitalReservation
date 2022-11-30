package Business.Abstract;

import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import java.util.ArrayList;

public interface IUserService
{
    public ArrayList<Randevu> randevulariGor(ArrayList<Randevu> randevuList);
    public void randevuAl(ArrayList<Randevu> randevuList,Randevu randevu);
    public void randevuSil(Randevu randevu,ArrayList<Randevu> randevuList);
    public void randevuGor(int randevuId,ArrayList<Randevu> randevuList);
    public User userAuth(String tcNo, String password, RepositoryBase repositoryBase);
}
