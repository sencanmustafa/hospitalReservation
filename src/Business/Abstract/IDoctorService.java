package Business.Abstract;

import Entities.Concrete.Randevu;

import java.util.ArrayList;

public interface IDoctorService<T>
{
    public ArrayList<T> randevulariGor(ArrayList<Randevu> randevuList);
    public void randevuAc(Randevu randevu , ArrayList<Randevu> randevuList);
}
