package Business.Concrete;

import Business.Abstract.IUserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import java.util.ArrayList;
import java.util.Objects;


public class UserService implements IUserService {
    @Override
    public ArrayList<Randevu> randevulariGor(ArrayList<Randevu> randevuList)
    {
        return randevuList;
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
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
        return null;
    }
}
