import Business.Concrete.DoctorService;
import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Admin;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        UserService userManager = new UserService();
        DoctorService doctorManager = new DoctorService();
        RepositoryBase repositoryBase = new RepositoryBase();
        System.out.println("*************************************");
        System.out.println("1 -> Kullanici 2 -> Doktor ");
        int secim = scanner.nextInt();
        switch (secim)
        {
            case 1:
                System.out.println("1 -> Giris yap 2 -> Kayit Ol 3 -> Sifremi Unuttum  4 -> Cikis Yap ");
                int secim2 = scanner.nextInt();
                switch (secim2)
                {
                    case 1:
                        System.out.println("TCNO ve Parola giriniz");
                        String tcNo = scanner.nextLine();
                        String password = scanner.nextLine();
                        if (userManager.userAuth(tcNo,password,repositoryBase)!=null)
                        {
                            User authUser = userManager.userAuth(tcNo,password,repositoryBase);
                            System.out.println("HOSGELDINIZ SAYIN " + authUser.firstName + " " + authUser.lastName);
                        }
                        else
                        {
                            System.out.println("HATALI GIRIS");
                            break;
                        }
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("ISIM , SOYISIM , TCNO , SIFRE GIRINIZ");
                        String registerFirstName = scanner.nextLine();
                        System.out.println("ISIM , SOYISIM , TCNO , SIFRE GIRINIZ");
                        String registerLastName = scanner.nextLine();
                        System.out.println("ISIM , SOYISIM , TCNO , SIFRE GIRINIZ");
                        String registerTcNo = scanner.nextLine();
                        System.out.println("ISIM , SOYISIM , TCNO , SIFRE GIRINIZ");
                        String registerPassword = scanner.nextLine();
                        User registerUser = new User(registerFirstName,registerLastName,registerTcNo,registerPassword);
                        repositoryBase.userListesi.add(registerUser);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                int secim3 = scanner.nextInt();
                System.out.println("1 -> Giris yap 2 -> Kayit Ol 3 -> Sifremi Unuttum  4 -> Cikis Yap ");
                switch (secim3)
                {
                    case 1:
                        System.out.println("TCNO ve Parola giriniz");
                        String kAdi = scanner.nextLine();
                        String password = scanner.nextLine();

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
                break;

        }



    }
}