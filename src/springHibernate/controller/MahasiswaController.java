package springHibernate.controller;

import springHibernate.App;
import springHibernate.configuration.MahasiswaTableModel;
import springHibernate.model.Mahasiswa;
import springHibernate.view.MahasiswaView;
import java.util.List;
import javax.swing.JOptionPane;

public class MahasiswaController {
    private final MahasiswaView mahasiswaView;
    private MahasiswaTableModel mahasiswaTableModel;
    private List<Mahasiswa> mahasiswas;

    public MahasiswaController(MahasiswaView mahasiswaView){
        this.mahasiswaView = mahasiswaView;
    }

    public void tampilData(){
        mahasiswas = App.getMahasiswaService().getMahasiswas();
        mahasiswaTableModel = new MahasiswaTableModel(mahasiswas);
        this.mahasiswaView.getTable().setModel(mahasiswaTableModel);
    }

    public void show(){
        int index = this.mahasiswaView.getTable().getSelectedRow();
        this.mahasiswaView.getNpm().setText(String.valueOf(this.mahasiswaView.getTable().getValueAt(index, 0)));
        this.mahasiswaView.getNama().setText(String.valueOf(this.mahasiswaView.getTable().getValueAt(index, 1)));
        this.mahasiswaView.getKelas().setText(String.valueOf(this.mahasiswaView.getTable().getValueAt(index, 2)));
        this.mahasiswaView.getTugas().setText(String.valueOf(this.mahasiswaView.getTable().getValueAt(index, 3)));
        this.mahasiswaView.getUTS().setText(String.valueOf(this.mahasiswaView.getTable().getValueAt(index, 4)));
        this.mahasiswaView.getUAS().setText(String.valueOf(this.mahasiswaView.getTable().getValueAt(index, 5)));
    }

    public void clear(){
        this.mahasiswaView.getNpm().setText("");
        this.mahasiswaView.getNama().setText("");
        this.mahasiswaView.getKelas().setText("");
        this.mahasiswaView.getTugas().setText("");
        this.mahasiswaView.getUTS().setText("");
        this.mahasiswaView.getUAS().setText("");
    }

    public void saveMahasiswa(){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setTugas(this.mahasiswaView.getTugas().getText());
        mahasiswa.setUTS(this.mahasiswaView.getUTS().getText());
        mahasiswa.setUAS(this.mahasiswaView.getUAS().getText());
        App.getMahasiswaService().save(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }

    public void updateMahasiswa(){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setTugas(this.mahasiswaView.getTugas().getText());
        mahasiswa.setUTS(this.mahasiswaView.getUTS().getText());
        mahasiswa.setUAS(this.mahasiswaView.getUAS().getText());
        App.getMahasiswaService().update(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data Berhasil di Update", "Info",JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }

    public void deleteMahasiswa(){
        if (this.mahasiswaView.getNpm().getText() == null){
            JOptionPane.showMessageDialog(null, "Mahasiswa belum dipilih", "error", JOptionPane.ERROR_MESSAGE);
        } else {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
            int pilih = JOptionPane.showConfirmDialog(null, "Apakah data ingin dihapus ?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pilih == JOptionPane.YES_OPTION) {
                App.getMahasiswaService().delete(mahasiswa);
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus", "Info", JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}