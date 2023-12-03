package springHibernate.configuration;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import springHibernate.model.Mahasiswa;

/**
 * Table model for Mahasiswa entity.
 */
public class MahasiswaTableModel extends AbstractTableModel {
    private List<Mahasiswa> mahasiswas = new ArrayList<>();
    private final String[] HEADER = {"NPM", "Nama", "Kelas", "Tugas", "UTS", "UAS", "Total"};

    public MahasiswaTableModel(List<Mahasiswa> mahasiswas){
        this.mahasiswas = mahasiswas;
    }

    @Override
    public int getRowCount() {
        return mahasiswas.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return HEADER[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mahasiswa mahasiswa = mahasiswas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return mahasiswa.getNpm();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getKelas();
            case 3:
                return mahasiswa.getTugas();
            case 4:
                return mahasiswa.getUTS();
            case 5:
                return mahasiswa.getUAS();
            case 6:
                return mahasiswa.getTotal();  // Assuming a method to calculate total in Mahasiswa class
            default:
                return null;
        }
    }
}
