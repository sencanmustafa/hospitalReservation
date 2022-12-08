import Business.Concrete.UserService;
import DataAccess.RepositoryBase;
import Entities.Concrete.Randevu;
import Entities.Concrete.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserRandevuScreen extends JFrame{
    private JPanel mainPanel;
    private JTable table;
    private JButton GERIDONButton;
    private JButton RANDEVUALButton;
    private JComboBox<Integer> comboBox;

    public UserRandevuScreen(RepositoryBase repositoryBase , User authUser)
    {
        add(mainPanel);
        setSize(900,900);
        setTitle("RANDEVU AL");
        setVisible(true);

        ArrayList<Randevu> nonSelectedRandevu = repositoryBase.returnNonSelectedRandevu();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("RANDEVU NO");
        tableModel.addColumn("DOKTOR ISMI");
        tableModel.addColumn("DOKTOR BRANS");
        tableModel.addColumn("RANDEVU TARIH");
        tableModel.addColumn("RANDEVU SAAT");


        if (nonSelectedRandevu != null)
        {
            for (Randevu randevu : nonSelectedRandevu)
            {
                comboBox.addItem(randevu.randevuId);
            }
            for (Randevu randevu : nonSelectedRandevu)
            {
                Object[] rowData = {randevu.randevuId,randevu.doctorName,randevu.doctorSkill, randevu.dateDay, randevu.dateTime};
                tableModel.addRow(rowData);
            }
        }

        table.setModel(tableModel);
        GERIDONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                UserScreen userScreen = new UserScreen(repositoryBase,authUser);
                userScreen.setVisible(true);
            }
        });
        RANDEVUALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Integer randevuId = (Integer) comboBox.getSelectedItem();
                for (Randevu selectedRandevu : repositoryBase.randevularListesi )
                {
                    if (selectedRandevu.randevuId ==randevuId)
                    {
                        selectedRandevu.userId = authUser.userId;
                        selectedRandevu.selected = true;
                        repositoryBase.userRandevuListesi.add(selectedRandevu);
                        JOptionPane.showMessageDialog(mainPanel,"RANDEVU BASARIYLA ALINDI");
                        setVisible(false);
                        UserScreen userScreen = new UserScreen(repositoryBase,authUser);
                        userScreen.setVisible(true);
                    }
                }
            }
        });
    }
}
