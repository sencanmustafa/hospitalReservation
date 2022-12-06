import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UserCancelScreen extends JFrame
{
    public UserCancelScreen(RepositoryBase repositoryBase, User authUser)
    {
        UserService userManager = new UserService();
        JFrame frame = new JFrame("Tablo ve Butonlar");
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        String[] columnNames = {"AD", "SOYAD", "TCNO","RANDEVU NO" , "DOKTOR ISMI" , "DOKTOR BRANS" , "RANDEVU TARIH" , "RANDEVU SAAT"};


        Object[][] data = new Object[repositoryBase.randevularListesi.size()][8];
        ArrayList<Randevu> randevuList = userManager.randevulariGor(repositoryBase,authUser);

        DefaultTableModel tableModel = new DefaultTableModel();
        for (Randevu randevu : randevuList)
        {
            Object[] rowData = {authUser.firstName,authUser.lastName,authUser.tcNo,randevu.randevuId, randevu.doctorId, randevu.doctorName, randevu.doctorSkill, randevu.dateDay, randevu.dateTime};
            tableModel.addRow(rowData);
        }
        System.out.println(tableModel);
        //JTable table = new JTable(tableModel);
        //panel.add(table, BorderLayout.CENTER);

        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table),BorderLayout.CENTER);

        // TextLabel'ı oluştur
        JLabel textLabel = new JLabel("Ornek TextLabel");
        frame.add(textLabel);

        // Butonları oluştur
        JButton randevuButonu = new JButton("Randevu");
        JButton iptalButonu = new JButton("Iptal");
        JButton geriDonButonu = new JButton("Geri Don");
        frame.add(randevuButonu);
        frame.add(iptalButonu);
        frame.add(geriDonButonu);

        // Pencereyi göster
        frame.setVisible(true);
    }
}
