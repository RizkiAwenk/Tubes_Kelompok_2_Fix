package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Kelompok implements Serializable {

    private ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
    private String namaKelompok;
    private int JumAnggota = 0;

    public Kelompok(String namaKelompok) {
        this.namaKelompok = namaKelompok;
    }

    public void addMahasiswa(String nama, long nim, String Kelas) {
        if (mahasiswa.size() == 5) {
            System.out.println("Kelompok sudah penuh!");
        } else {
            mahasiswa.add(new Mahasiswa(nama, nim , Kelas));
        }
    }

    public void minMahasiswa(int i) {
        if (mahasiswa.size() <= 0) {
            System.out.println("Tidak ada data.");
        } else {
            mahasiswa.remove(i);
        }
    }

    public int getTotal() {
        return mahasiswa.size();
    }

    public Mahasiswa getMahasiswa(int i) {
        return mahasiswa.get(i);
    }

    public String getNamaKel() {
        return namaKelompok;
    }

    public Mahasiswa getMahasiswaByNim(long nim) {
        Mahasiswa m = null;
        for (int i = 0; i < mahasiswa.size(); i++) {
            if (nim == mahasiswa.get(i).getNim()) {
                m = mahasiswa.get(i);
            } else {
                m = null;
            }
        }
        return m;
    }
}
