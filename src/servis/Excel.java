package servis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import koneksi_db.Koneksi;

public class Excel implements ServisExcel {
    private final Connection conn;
    
    public Excel() {
        conn = Koneksi.getConnect();
    }
    
    @Override
    public void getData(DefaultTableModel model) {
        try {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rest = stmt.executeQuery();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
           
            while (rest.next()) { 
                String no = rest.getString("id_transaksi");
                int total = rest.getInt("total_transaksi");
                String tanggal = dateFormat.format(rest.getDate("tanggal_transaksi"));
               
                Object[] rowData = {no, tanggal, total};
                model.addRow(rowData);
            }
            
            rest.close();
            stmt.close();
        } catch (Exception e) {
             Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void exportToExcel(JTable table, String filePath) {
        try {
            TableModel model = table.getModel();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Laporan");
        
            XSSFRow headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                XSSFCell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }
        
            for (int i = 0; i < model.getRowCount(); i++) {
                XSSFRow row = sheet.createRow(i + 1);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    }
            }
        
            try (FileOutputStream fileOut = new FileOutputStream(new File(filePath))) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
