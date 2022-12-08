import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserScreen extends JFrame {
    private JTable table;
    private JButton cancelledButton;
    private JButton returnButton;
    private JLabel inputRandevuNoLabel;
    private JScrollPane tableScrolPane;
    private JPanel tablePanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JLabel userName;
    private JLabel userLastName;
    private JLabel userRandevuCount;
    private JButton RANDEVUALButton;
    private JComboBox<Integer> comboBox1;

    public UserScreen(RepositoryBase repositoryBase, User authUser)
    {
        System.out.println("deneme");
        UserService userManager = new UserService();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900,900);
        add(mainPanel);
        ArrayList<Randevu> randevuList = userManager.randevulariGor(repositoryBase,authUser);
        for (Randevu randevu : randevuList)
        {
            comboBox1.addItem(randevu.randevuId);
        }
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("AD");
        tableModel.addColumn("SOYAD");
        tableModel.addColumn("TCNO");
        tableModel.addColumn("RANDEVU NO");
        tableModel.addColumn("DOKTOR ISMI");
        tableModel.addColumn("DOKTOR BRANS");
        tableModel.addColumn("RANDEVU TARIH");
        tableModel.addColumn("RANDEVU SAAT");
        userName.setText(authUser.firstName);
        userLastName.setText(authUser.lastName);
        userRandevuCount.setText("MEVCUT RANDEVU SAYISI -> " + " " + randevuList.size());
        for (Randevu randevu : randevuList)
        {
            System.out.println(randevu.randevuId);
            Object[] rowData = {authUser.firstName,authUser.lastName,authUser.tcNo,randevu.randevuId,randevu.doctorName, randevu.doctorSkill, randevu.dateDay, randevu.dateTime};
            tableModel.addRow(rowData);
        }
        table.setModel(tableModel);
        cancelledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int randevuId = (Integer) comboBox1.getSelectedItem();
                Randevu selectedRandevuUserList = userManager.returnRandevuUserList(repositoryBase,randevuId);
                repositoryBase.userRandevuListesi.remove(selectedRandevuUserList);
                Randevu randevuRandevuList = userManager.returnRandevuRandevuList(repositoryBase,randevuId);
                Randevu randevuDoctorList = userManager.returnRandevuDoctorList(repositoryBase,randevuId);
                randevuDoctorList.userId = 0;
                randevuDoctorList.selected = false;
                randevuRandevuList.selected = false;
                randevuRandevuList.userId = 0;
                JOptionPane.showMessageDialog(mainPanel,"RANDEVU SILINDI");
                setVisible(false);
                UserScreen userScreen = new UserScreen(repositoryBase,authUser);
                userScreen.setVisible(true);

            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        RANDEVUALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                UserRandevuScreen userRandevuScreen = new UserRandevuScreen(repositoryBase,authUser);
                userRandevuScreen.setVisible(true);
            }
        });
        returnButton.addActionListener(new ActionListener() {
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
