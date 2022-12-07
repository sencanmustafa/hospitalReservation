import Business.Concrete.DoctorService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorScreen extends JFrame {
    private JButton randevuAcButton;
    private JPanel mainPanel;
    private JLabel doctorSkill;
    private JLabel countRandevu;
    private JLabel nameDoctor;
    private JButton randevulariGorButton;
    private JButton CIKISYAPButton;

    public DoctorScreen(RepositoryBase repositoryBase, Doctor authDoctor)
    {
        DoctorService doctorManager = new DoctorService();
        add(mainPanel);
        setSize(900,900);
        setTitle("Doctor Ekrani");
        doctorSkill.setText(authDoctor.doctorSkill);
        countRandevu.setText(String.valueOf(doctorManager.randevulariGor(repositoryBase,authDoctor).size()));
        nameDoctor.setText(authDoctor.firstName + " " + authDoctor.lastName);
        randevulariGorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        randevulariGorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                DoctorRandevular doctorRandevular = new DoctorRandevular(repositoryBase,authDoctor);
                doctorRandevular.setVisible(true);
            }
        });
        randevuAcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                DoctorRandevuAc doctorRandevuAc = new DoctorRandevuAc(repositoryBase,authDoctor);
                doctorRandevuAc.setVisible(true);

            }
        });
        CIKISYAPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                DoctorLoginScreen doctorLoginScreen = new DoctorLoginScreen(repositoryBase);
                doctorLoginScreen.setVisible(true);

            }
        });
    }
}
