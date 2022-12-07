import Business.Concrete.DoctorService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorLoginScreen extends JFrame {
    private JTextField tcnoInput;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel mainPanel;
    private JButton GERIDONButton;

    public DoctorLoginScreen(RepositoryBase repositoryBase)
    {
        setSize(900,900);
        setTitle("DOKTOR GIRIS EKRANI");
        add(mainPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DoctorService doctorManager = new DoctorService();
                String tcNo = tcnoInput.getText();
                String password = String.valueOf(passwordInput.getPassword());
                if (doctorManager.doctorAuth(tcNo,password,repositoryBase) !=null)
                {
                    setVisible(false);
                    Doctor authDoctor = doctorManager.doctorAuth(tcNo,password,repositoryBase);
                    DoctorScreen doctorScreen = new DoctorScreen(repositoryBase,authDoctor);
                    doctorScreen.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(mainPanel,"YANLIS KULLANICI ADI");
                }
            }
        });
        GERIDONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                LoginPage loginPage = new LoginPage(repositoryBase);
                loginPage.setVisible(true);

            }
        });
    }
}
