package Model;

import java.io.Serializable;

public class Pembimbing extends Orang implements Serializable{

    private long NIP;

    public Pembimbing(String nama, long nip) {
        super(nama);
        this.NIP = nip;
    }

    public void setNIP(long nip) {
        this.NIP = nip;
    }

    public long getNIP() {
        return NIP;
    }

    public String getStatus() {
        return "Pembimbing";
    }
}
