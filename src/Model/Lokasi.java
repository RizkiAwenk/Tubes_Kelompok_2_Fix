package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Lokasi implements Serializable {

    private Pembimbing pembimbing;
    private ArrayList<Kelompok> kelompok = new ArrayList<>();
    private String namaLokasi;
    private int JumKelompok = 0;

    public Lokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public void createKelompok(String namaKelompok) {
        if (kelompok.size() == 10) {
            System.out.println("Lokasi sudah penuh!");
        } else {
            kelompok.add(new Kelompok(namaKelompok));
        }
    }

    public void setPembimbing(Pembimbing p) {
        this.pembimbing = p;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public Kelompok getKelompok(int i) {
        return kelompok.get(i);
    }

    public Pembimbing getPembimbing() {
        return pembimbing;
    }

    public int getJumKelompok() {
        return kelompok.size();
    }
}
