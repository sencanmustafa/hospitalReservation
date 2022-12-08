package Business.Concrete;

import Business.Abstract.IUserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import java.util.ArrayList;
import java.util.Objects;


public class UserService implements IUserService {
    @Override
    public ArrayList<Randevu> randevulariGor(RepositoryBase repositoryBase,User authUser)
    {
        ArrayList<Randevu> userRandevuList = new ArrayList<>();
        for (int i = 0; i < repositoryBase.userRandevuListesi.size(); i++)
        {
            if (repositoryBase.userRandevuListesi.get(i).userId == authUser.userId)
            {
                userRandevuList.add(repositoryBase.userRandevuListesi.get(i));
            }

        }
        return userRandevuList;
    }

    @Override
    public void randevuAl(ArrayList<Randevu> randevuList,Randevu randevu)
    {
        randevuList.add(randevu);
    }

    @Override
    public void randevuSil(Randevu randevu, ArrayList<Randevu> randevuList)
    {
        randevuList.remove(randevu);
    }


    @Override
    public void randevuGor(int randevuId, ArrayList<Randevu> randevuList) {
        Randevu randevu = null;
        for (Randevu i : randevuList)
        {
            if (i.randevuId==randevuId)
            {
                randevu=i;
            }
        }

        System.out.println(randevu.randevuId + "" +randevu.doctorName + "" +randevu.doctorSkill + "" +randevu.dateDay + "" + randevu.dateTime);
    }

    @Override
    public User userAuth(String tcNo, String password, RepositoryBase repositoryBase)
    {

        for (int i=0;i<repositoryBase.userListesi.size();i++)
        {
            if (Objects.equals(repositoryBase.userListesi.get(i).tcNo, tcNo))
            {
                if (Objects.equals(repositoryBase.userListesi.get(i).password, password))
                {
                    return repositoryBase.userListesi.get(i);
                }

            }
        }
        return null;
    }

    @Override
    public void randevuSil(int randevuId, ArrayList<Randevu> randevuList)
    {
        
        randevuList.remove(randevuId);
    }

    @Override
    public String returnUserName(int userId, RepositoryBase repositoryBase)
    {
        for (User user : repositoryBase.userListesi)
        {
            if (user.userId == userId)
            {
                String fullName = user.firstName + " " + user.lastName;
                return fullName;
            }
        };
        return null;
    }

    @Override
    public Randevu returnRandevuUserList(RepositoryBase repositoryBase, int randevuId)
    {
        for (Randevu randevu:repositoryBase.userRandevuListesi)
        {
            if (randevu.randevuId == randevuId)
            {
                return randevu;
            }
        }
        return null;
    }

    @Override
    public Randevu returnRandevuDoctorList(RepositoryBase repositoryBase, int randevuId) {
        for (Randevu randevu:repositoryBase.doctorRandevuListesi)
        {
            if (randevu.randevuId == randevuId)
            {
                return randevu;
            }
        }
        return null;
    }

    @Override
    public Randevu returnRandevuRandevuList(RepositoryBase repositoryBase, int randevuId) {
        for (Randevu randevu:repositoryBase.randevularListesi)
        {
            if (randevu.randevuId == randevuId)
            {
                return randevu;
            }
        }
        return null;
    }
}
