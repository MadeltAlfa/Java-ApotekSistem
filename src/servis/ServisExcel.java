package servis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface ServisExcel {
    public void getData(DefaultTableModel model);
    void exportToExcel(JTable table, String filePath);
}
