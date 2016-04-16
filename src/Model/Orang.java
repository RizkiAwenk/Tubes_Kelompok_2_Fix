package Model;

import java.io.Serializable;

public abstract class Orang implements Serializable {

    private String nama;

    public Orang(String nama) {
        this.nama = nama;
    }

    public void setNama(String Nama) {
        this.nama = Nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract String getStatus();
}
