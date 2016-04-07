package tubes_sisfogeladi;

public abstract class Orang {

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
