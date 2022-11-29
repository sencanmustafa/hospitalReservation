package Business.Concrete;

import Business.Abstract.IUserService;
import Entities.Concrete.Randevu;

import java.util.ArrayList;

public class UserService implements IUserService {
    @Override
    public ArrayList<Randevu> randevulariGor(ArrayList<Randevu> randevuList) {
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
}
