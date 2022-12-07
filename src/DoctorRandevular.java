import Business.Concrete.DoctorService;
import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Doctor;
import Entities.Concrete.Randevu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoctorRandevular extends JFrame
{

    private JScrollPane tableScrolPane;
    private JTable table;
    private JPanel inputPanel;
    private JLabel inputRandevuNoLabel;
    private JTextField inputRandevuNo;
    private JPanel buttonPanel;
    private JButton returnButton;
    private JButton cancelledButton;
    private JPanel mainPanel;

    public DoctorRandevular(RepositoryBase repositoryBase, Doctor authDoctor)
    {
        DoctorService doctorManager = new DoctorService();
        UserService userService = new UserService();
        setTitle("DOKTOR RANDEVU EKRANI");
        setSize(1000,1000);
        add(mainPanel);
        ArrayList<Randevu> randevuList = doctorManager.randevulariGor(repositoryBase,authDoctor);
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("RANDEVU NO");
        tableModel.addColumn("HASTA ISIM SOYISIM ");
        tableModel.addColumn("RANDEVU TARIH");
        tableModel.addColumn("RANDEVU SAAT");
        for (Randevu randevu : randevuList)
        {
            System.out.println(randevu.randevuId);
            if (userService.returnUserName(randevu.userId,repositoryBase) == null)
            {
                continue;
            }
            Object[] rowData = {randevu.randevuId,userService.returnUserName(randevu.userId,repositoryBase), randevu.dateDay, randevu.dateTime};
            tableModel.addRow(rowData);
        }
        table.setModel(tableModel);
        cancelledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (inputRandevuNo.getText().length()== 0 || inputRandevuNo.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(mainPanel,"LUTFEN RANDEVU IPTAL ALANINA NUMARA GIRINIZ");
                }
            }
        });


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                DoctorScreen doctorScreen = new DoctorScreen(repositoryBase,authDoctor);
                doctorScreen.setVisible(true);

            }
        });
    };
}
