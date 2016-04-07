package tubes_sisfogeladi;

public class Pembimbing extends Orang {

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
