import Business.Concrete.DoctorService;
import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
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
        int randevuId = 1;
        int doctorId = 1;
        int userId = 1;

        while (true)
        {
            System.out.println("*************************************");
            System.out.println("1 -> Kullanici 2 -> Doktor 3 -> DATA GOR ");
            int secim = scanner.nextInt();
            if (secim==1)
            {
                System.out.println("1 -> Giris yap 2 -> Kayit Ol 3 -> Sifremi Unuttum  4 -> Cikis Yap ");
                int secim2 = scanner.nextInt();
                if (secim2 == 1)
                {
                    scanner.nextLine();
                    System.out.println("TCNO ve Parola giriniz");
                    String tcNo = scanner.nextLine();
                    String authPassword = scanner.nextLine();
                    if (userManager.userAuth(tcNo, authPassword, repositoryBase) != null)
                    {
                        User authUser = userManager.userAuth(tcNo, authPassword, repositoryBase);
                        System.out.println("HOSGELDINIZ SAYIN " + authUser.firstName + " " + authUser.lastName +  " NE YAPMAK ISTERSINIZ ? " );
                        System.out.println("1 -> RANDEVU AL 2 -> RANDEVULARIMI GOR 3 -> CIKIS");
                        int secim4 = scanner.nextInt();
                        if (secim4==1)
                        {

                            System.out.println("HANGI RANDEVUYU ALMAK ISTIYORSUNUZ EGER RANDEVU YOK ISE RANDEVU ALAMAZSINIZ");
                            for (Randevu randevu :repositoryBase.randevularListesi)
                            {
                                System.out.println("RANDEVU NO - > " + " " + randevu.randevuId);
                                System.out.println("DOKTOR ADI " + " " + randevu.doctorName);
                                System.out.println("DOKTOR BRANSI" + " " + randevu.doctorSkill);
                                System.out.println("RANDEVU  TARIH VE SAATI " + " "+ randevu.dateDay + " " + randevu.dateTime);
                            }
                            int randevuSecim = scanner.nextInt();
                            Randevu selectedRandevu = repositoryBase.randevularListesi.get(randevuSecim);
                            selectedRandevu.userId = authUser.userId;
                            userManager.randevuAl(repositoryBase.userRandevuListesi,selectedRandevu);

                        } else if (secim4==2)
                        {
                            return;
                        } else if (secim4==3)
                        {
                            return;
                        }
                        else
                        {
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("HATALI GIRIS");

                    }
                }
                else if (secim2==2)
                {
                    scanner.nextLine();
                    System.out.println("ISIM");
                    String registerFirstName = scanner.nextLine();
                    System.out.println(" SOYISIM");
                    String registerLastName = scanner.nextLine();
                    System.out.println("TCNO ");
                    String registerTcNo = scanner.nextLine();
                    System.out.println("SIFRE GIRINIZ");
                    String registerPassword = scanner.nextLine();
                    User registerUser = new User(userId,registerFirstName, registerLastName, registerTcNo, registerPassword);
                    repositoryBase.userListesi.add(registerUser);
                    userId+=1;
                }
                else if (secim2==4)
                {
                    System.out.println("Cikis yapiliyor");

                }
                else
                {
                    System.out.println("HATALI SECIM YAPTINIZ");
                }

            }
            else if (secim==2)
            {
                System.out.println("1 -> Giris yap 2 -> Kayit Ol 3 -> Sifremi Unuttum  4 -> Cikis Yap ");
                int secim3 = scanner.nextInt();
                if (secim3 == 1)
                {
                    scanner.nextLine();
                    System.out.println("TCNO ve Parola giriniz");
                    String tcNo = scanner.nextLine();
                    String authPassword = scanner.nextLine();
                    if (doctorManager.doctorAuth(tcNo, authPassword, repositoryBase) != null)
                    {
                        Doctor authDoctor = doctorManager.doctorAuth(tcNo, authPassword, repositoryBase);
                        System.out.println("HOSGELDINIZ SAYIN  " + authDoctor.firstName + " " + authDoctor.lastName + " NE YAPMAK ISTERSINIZ ? ");
                        System.out.println("1 -> RANDEVU AC 2 -> RANDEVULARIMI GOR 3 -> CIKIS");
                        int secim4 = scanner.nextInt();
                        if (secim4==1)
                        {
                            scanner.nextLine();
                            System.out.println("Randevu Tarihini giriniz GUN/AY/YIL");
                            String newRandevuDate = scanner.nextLine();
                            System.out.println("RANDEVU SAATINI GIRINIZ");
                            String newRandevuTime = scanner.nextLine();

                            Randevu newRandevu = new Randevu(randevuId,authDoctor.doctorId,authDoctor.firstName,authDoctor.doctorSkill,newRandevuDate, newRandevuTime);
                            repositoryBase.doctorRandevuListesi.add(newRandevu);
                            repositoryBase.randevularListesi.add(newRandevu);
                            randevuId++;
                            System.out.println("RANDEVU BASARIYLA ACILDI");


                        }
                        else if (secim4==2)
                        {
                            for (Randevu r :repositoryBase.doctorRandevuListesi)
                            {
                                if (r.doctorId == authDoctor.doctorId)
                                {
                                    System.out.println(r.randevuId);
                                    System.out.println(r.doctorId);
                                    System.out.println(r.dateDay);
                                    System.out.println(r.dateTime);
                                    System.out.println(r.doctorSkill);
                                }
                            }
                        }
                        else if (secim4==3)
                        {
                            System.out.println("cikis yapiliyor");

                        }

                    }
                    else
                    {
                        System.out.println("HATALI GIRIS");

                    }
                }
                else if (secim3==2)
                {
                    scanner.nextLine();
                    System.out.println("ISIM");
                    String registerFirstName = scanner.nextLine();
                    System.out.println("SOYISIM");
                    String registerLastName = scanner.nextLine();
                    System.out.println("TCNO");
                    String registerTcNo = scanner.nextLine();
                    System.out.println("SIFRE GIRINIZ");
                    String registerPassword = scanner.nextLine();
                    System.out.println("BRANS GIRINIZ");
                    String registerBrans = scanner.nextLine();
                    Doctor registerDoctor = new Doctor(doctorId,registerFirstName, registerLastName,registerBrans,registerTcNo, registerPassword);
                    repositoryBase.doctorListesi.add(registerDoctor);

                }
                else if (secim3==4)
                {
                    System.out.println("Cikis yapiliyor");

                }
                else
                {
                    System.out.println("HATALI SECIM YAPTINIZ");

                }
            }

            else if (secim==3)
            {
                System.out.println("DOKTOR LISTESI");
                for (int i = 0; i < repositoryBase.doctorListesi.size(); i++)
                {
                    System.out.println(repositoryBase.doctorListesi.get(i).doctorId+" "+repositoryBase.doctorListesi.get(i).firstName + " " +repositoryBase.doctorListesi.get(i).tcNo);
                }
                System.out.println("USER LISTESI");
                for (int i = 0; i < repositoryBase.userListesi.size(); i++)
                {
                    System.out.println(repositoryBase.userListesi.get(i).userId+" "+repositoryBase.userListesi.get(i).firstName + " " +repositoryBase.userListesi.get(i).tcNo);
                }
                System.out.println("DOKTOR RANDEVU LISTESI");
                for (int i = 0; i < repositoryBase.doctorRandevuListesi.size(); i++)
                {
                    System.out.println(repositoryBase.doctorRandevuListesi.get(i).randevuId + " " +repositoryBase.doctorRandevuListesi.get(i).doctorId);
                }
            }
        }

    }






}