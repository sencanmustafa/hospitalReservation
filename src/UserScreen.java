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
    private JTextField inputRandevuNo;

    public UserScreen(RepositoryBase repositoryBase, User authUser)
    {
        System.out.println("deneme");
        UserService userManager = new UserService();
        this.setSize(900,900);

        this.add(mainPanel);
        this.add(tablePanel);
        this.add(tableScrolPane);
        this.add(inputPanel);
        this.add(buttonPanel);
        ArrayList<Randevu> randevuList = userManager.randevulariGor(repositoryBase,authUser);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("AD");
        tableModel.addColumn("SOYAD");
        tableModel.addColumn("TCNO");
        tableModel.addColumn("TCNO");
        tableModel.addColumn("RANDEVU NO");
        tableModel.addColumn("DOKTOR ISMI");
        tableModel.addColumn("DOKTOR BRANS");
        tableModel.addColumn("RANDEVU TARIH");
        tableModel.addColumn("RANDEVU SAAT");

        for (Randevu randevu : randevuList)
        {
            Object[] rowData = {authUser.firstName,authUser.lastName,authUser.tcNo,randevu.randevuId, randevu.doctorId, randevu.doctorName, randevu.doctorSkill, randevu.dateDay, randevu.dateTime};
            tableModel.addRow(rowData);
        }


        table.setModel(tableModel);

        tablePanel.add(table);

        cancelledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.setVisible(true);
    }
}
