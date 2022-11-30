package Business.Concrete;

import Business.Abstract.IDoctorService;
import Entities.Concrete.Randevu;

import java.util.ArrayList;

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
}
