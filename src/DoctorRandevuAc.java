import Business.Concrete.DoctorService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Entities.Concrete.Randevu.randevuCount;

public class DoctorRandevuAc extends JFrame {
    private JTextField randevuDate;
    private JTextField randevuSaatInput;
    private JButton ONAYLAButton;
    private JPanel mainPanel;
    private JButton GERIDONButton;

    public static boolean isInt(String str) {

        try {
            int x = Integer.parseInt(str);
            return false; //String is an Integer
        } catch (NumberFormatException e) {
            return true; //String is not an Integer
        }

    }
    public DoctorRandevuAc(RepositoryBase repositoryBase , Doctor authDoctor)
    {
        DoctorService doctorManager = new DoctorService();
        add(mainPanel);
        setSize(1000,1000);
        setTitle("RANDEVU AC");

        ONAYLAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //if (randevuDate.getText().isEmpty() || isInt(randevuDate.getText()) || randevuSaatInput.getText().isEmpty() || isInt(randevuSaatInput.getText()))
                //{
                //    JOptionPane.showMessageDialog(mainPanel,"LUTFEN KARAKTER GIRMEYINIZ");
                //}
                //else
                //{
                //    String valueRandevuDate = randevuDate.getText();
                //    String valueRandevuTime = randevuSaatInput.getText();
                //    Randevu randevu = new Randevu(randevuCount,authDoctor.doctorId,authDoctor.firstName+" " + authDoctor.lastName,authDoctor.doctorSkill,valueRandevuDate,valueRandevuTime);
                //    repositoryBase.doctorRandevuListesi.add(randevu);
                //    repositoryBase.randevularListesi.add(randevu);
                //    setVisible(false);
                //    DoctorScreen doctorScreen = new DoctorScreen(repositoryBase,authDoctor);
                //    doctorScreen.setVisible(true);
                //}
                String valueRandevuDate = randevuDate.getText();
                String valueRandevuTime = randevuSaatInput.getText();
                String sumDateTime = valueRandevuDate+valueRandevuTime+authDoctor.doctorId;
                if (doctorManager.compareRandevuDate(repositoryBase, sumDateTime))
                {
                    Randevu randevu = new Randevu(randevuCount,authDoctor.doctorId,authDoctor.firstName+" " + authDoctor.lastName,authDoctor.doctorSkill,valueRandevuDate,valueRandevuTime);
                    repositoryBase.doctorRandevuListesi.add(randevu);
                    repositoryBase.randevularListesi.add(randevu);
                    repositoryBase.randevuGunSaatleri.add(randevu.dateTime+randevu.dateDay+authDoctor.doctorId);
                    setVisible(false);
                    DoctorScreen doctorScreen = new DoctorScreen(repositoryBase,authDoctor);
                    doctorScreen.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(mainPanel,"BU TARIHTE VE SAATTE BOYLE BIR RANDEVU VAR");
                }

            }
        });
        GERIDONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                DoctorRandevular doctorRandevular = new DoctorRandevular(repositoryBase,authDoctor);
                doctorRandevular.setVisible(true);

            }
        });
    }
}
