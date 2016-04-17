package Model;

import java.io.Serializable;

public class Mahasiswa extends Orang implements Serializable {

    private long nim;
    private String kelas;

    public Mahasiswa(String nama, long nim, String kelas) {
        super(nama);
        this.nim = nim;
        this.kelas = kelas;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public long getNim() {
        return nim;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKelas() {
        return kelas;
    }

   

    public String getStatus() {
        return "Mahasiswa";
    }
}
