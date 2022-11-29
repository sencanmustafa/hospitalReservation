import Business.Abstract.IUserService;
import Business.Concrete.UserService;
import Entities.Concrete.Admin;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;


public class Main {
    public static void main(String[] args)
    {

        UserService userManager = new UserService();
        System.out.println("Hello world!");
        Doctor doctor = new Doctor("Mustafa","Sencan","genel cerrahi","11111","12345");
        User user = new User("Abdullah","Sirma","22222","12345");
        Admin admin = new Admin("Serra","Aydin","33333","12345");
        Randevu randevu = new Randevu(1,doctor.firstName+ "" +doctor.lastName,doctor.doctorSkill,"29.11.2022","13.00");
        userManager.randevuAl(user.randevuList,randevu);
        userManager.randevuGor(randevu.randevuId,user.randevuList);

    }
}