import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class UserCancelScreen extends JFrame
{
    private JPanel panel1;
    private JTable randevuTable;
    private JTextField inputRandevuId;
    private JButton cancelledButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JButton signOutButton;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public UserCancelScreen(User authUser, RepositoryBase repositoryBase)
    {
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(randevuTable);
        setSize(600,600);

        firstNameLabel.setText(authUser.firstName);
        lastNameLabel.setText(authUser.lastName);
        dateLabel.setText(String.valueOf(LocalDate.now()));
        timeLabel.setText(String.valueOf(LocalTime.now().getHour()));
        Randevu randevu = new Randevu(1,1,"Mustafa","genel cerrahi","26.05.2001","13.00");
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Randevu No");
        model.addColumn("Doktor Ismi");
        model.addColumn("Brans");
        model.addColumn("Tarih");
        model.addColumn("Saat");
        ArrayList<Randevu> randevuList = new ArrayList<>();
        randevuList.add(randevu);
        for (Randevu i : randevuList)
        {
            System.out.println(i.randevuId);
            model.addRow(new Object[]{i.randevuId,i.doctorName,i.doctorSkill,i.dateDay,i.dateTime});
        }
        randevuTable.setModel(model);
        cancelledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int randevuNo = Integer.parseInt(inputRandevuId.getText());
                Randevu cancelledRandevu = repositoryBase.randevularListesi.get(randevuNo);
                repositoryBase.randevularListesi.remove(cancelledRandevu);
                repositoryBase.userRandevuListesi.remove(cancelledRandevu);
                repositoryBase.doctorRandevuListesi.remove(cancelledRandevu);
            }
        });
        signOutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }


}
