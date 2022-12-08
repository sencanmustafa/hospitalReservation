package Business.Abstract;

import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import java.util.ArrayList;

public interface IUserService
{
    public ArrayList<Randevu> randevulariGor(RepositoryBase repositoryBase,User authUser);
    public void randevuAl(ArrayList<Randevu> randevuList,Randevu randevu);
    public void randevuSil(Randevu randevu,ArrayList<Randevu> randevuList);
    public void randevuGor(int randevuId,ArrayList<Randevu> randevuList);
    public User userAuth(String tcNo, String password, RepositoryBase repositoryBase);
    public void randevuSil(int randevuId,ArrayList<Randevu> randevuList);
    public String returnUserName(int userId , RepositoryBase repositoryBase);
    public Randevu returnRandevuUserList(RepositoryBase repositoryBase , int randevuId);
    public Randevu returnRandevuDoctorList(RepositoryBase repositoryBase , int randevuId);

    public Randevu returnRandevuRandevuList(RepositoryBase repositoryBase , int randevuId);
}
