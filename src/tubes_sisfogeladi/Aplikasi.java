/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisfogeladi;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author sb
 */
public class Aplikasi {

    private ArrayList<Lokasi> daftarLokasi = new ArrayList<>();
    private ArrayList<Pembimbing> daftarPembimbing = new ArrayList<>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    Scanner x = new Scanner(System.in);

    public void addPembimbing(String nama, long nip) {
        daftarPembimbing.add(new Pembimbing(nama, nip));
    }

    public void addMahasiswa(String nama, long nim, String kelas) {
        daftarMahasiswa.add(new Mahasiswa(nama, nim, kelas));
    }

    public Mahasiswa getMahasiswaMain(long nim) {
        Mahasiswa tempMahasiswaInsert = null;
        Lokasi tempLokasiInsert = null;
        Kelompok tempKelompokInsert = null;
        for (int mahasiswaByNimI = 0; mahasiswaByNimI < daftarLokasi.size(); mahasiswaByNimI++) {
            tempLokasiInsert = daftarLokasi.get(mahasiswaByNimI);
            for (int mahasiswaByNimJ = 0; mahasiswaByNimJ < tempLokasiInsert.getJumKelompok(); mahasiswaByNimJ++) {
                tempKelompokInsert = tempLokasiInsert.getKelompok(mahasiswaByNimJ);
                tempMahasiswaInsert = tempKelompokInsert.getMahasiswaByNim(nim);
            }
        }
        return tempMahasiswaInsert;
    }

    public void menuInsert() {
        System.out.println("INSERT: ");
        System.out.println("1. Lokasi ");
        System.out.println("2. Kelompok ");
        System.out.println("3. Pembimbing ");
        System.out.println("4. Mahasiswa ");
        System.out.print("Pilih: ");
        int pilMenuInsert = x.nextInt();
        System.out.println("---------------------------------------------");

        switch (pilMenuInsert) {
            case 1:
                /**
                 * INSERT LOKASI*
                 */
                InsertLokasi();
                System.out.println();
                break;
            case 2:
                /**
                 * INSERT KELOMPOK Milih lokasi dulu baru insertKelompok*
                 */
                InsertKelompok();
                System.out.println();
                break;
            case 3:
                /**
                 * INSERT PEMBIMBING MILIH LOKASI DULU BARU INSERT PEMPIMBING*
                 */
                InsertPembimbing();
                System.out.println();
                break;
            case 4:
                /**
                 * INSERT MAHASISWA milih kelompok dulu baru insert mahasiswa*
                 */
                InsertMahasiswa();
                System.out.println();
                break;
        }
    }

    public void InsertLokasi() {
        System.out.println("---------------------------------------------");
        System.out.println("INSERT LOKASI");
        System.out.print("Nama: ");
        String namaLokasi = x.next();
        daftarLokasi.add(new Lokasi(namaLokasi));
    }

    public void InsertKelompok() {
        System.out.println("---------------------------------------------");
        System.out.println("DAFTAR LOKASI");
        if (daftarLokasi.size() != 0) {
            for (int Kelompoki = 0; Kelompoki < daftarLokasi.size(); Kelompoki++) {
                System.out.println((Kelompoki + 1) + ". " + daftarLokasi.get(Kelompoki).getNamaLokasi());
            }
        } else {
            System.out.println("TIDAK ADA LOKASI");
        }
        System.out.println("---------------------------------------------");
        System.out.println("1. Pilih Lokasi");
        System.out.println("2. Kembali ");
        System.out.println("---------------------------------------------");
        System.out.print("Pilih : ");
        int pilMenuInsertKelompok = x.nextInt();
        System.out.println("---------------------------------------------");
        switch (pilMenuInsertKelompok) {
            case 1:
                System.out.print("Pilih No Lokasi : ");
                int noLokasi = x.nextInt();
                System.out.println("---------------------------------------------");
                System.out.print("Nama Kelompok : ");
                String namaK = x.next();
                daftarLokasi.get(noLokasi - 1).createKelompok(namaK);//menu 2
                break;
            case 2:
                break; // back to menu insert
        }
    }

    public void InsertPembimbing() {
        System.out.println("---------------------------------------------");
        System.out.println("DAFTAR LOKASI");
        if (daftarLokasi.size() != 0) {
            for (int i = 0; i < daftarLokasi.size(); i++) {
                System.out.println((i + 1) + ". " + daftarLokasi.get(i).getNamaLokasi());
            }
        } else {
            System.out.println("TIDAK ADA LOKASI");
        }
        System.out.println("---------------------------------------------");
        System.out.println("1. Pilih Lokasi");
        System.out.println("2. Kembali ");
        System.out.print("Pilih : ");
        int pilMenuInsertPembimbing = x.nextInt();
        System.out.println("---------------------------------------------");
        switch (pilMenuInsertPembimbing) {
            case 1:
                System.out.print("Pilih No Lokasi : ");
                int noLokasiInsertPembimbing = x.nextInt();
                System.out.println("---------------------------------------------");
                System.out.print("Nama Pembimbing: ");
                String InsertNamaPembimbing = x.next();
                System.out.print("NIP Pembimbing: ");
                long InsertNipPembimbing = x.nextLong();
                addPembimbing(InsertNamaPembimbing, InsertNipPembimbing);
                int tempCounter = daftarPembimbing.size() - 1;
                Pembimbing tempPembimbing = daftarPembimbing.get(tempCounter);
                daftarLokasi.get(noLokasiInsertPembimbing - 1).setPembimbing(tempPembimbing);//menu 2
                break;
        }
    }

    public void InsertMahasiswa() {
        System.out.println("---------------------------------------------");
        System.out.println("DAFTAR LOKASI");
        if (daftarLokasi.size() != 0) {
            for (int i = 0; i < daftarLokasi.size(); i++) {
                System.out.println((i + 1) + " " + daftarLokasi.get(i).getNamaLokasi());
            }
        } else {
            System.out.println("TIDAK ADA LOKASI");
        }
        System.out.println("---------------------------------------------");
        System.out.println("1. Pilih Lokasi");
        System.out.println("2. Kembali ");
        System.out.print("Pilih : ");
        int pilMenuLokasiInsertMahasiswa = x.nextInt();
        System.out.println("---------------------------------------------");
        switch (pilMenuLokasiInsertMahasiswa) {
            case 1:
                System.out.println("---------------------------------------------");
                System.out.print("Pilih No Lokasi : ");
                int LokasiInsertMahasiswa = x.nextInt() - 1;
                System.out.println("---------------------------------------------");
                System.out.println("Daftar Kelompok");
                int tempInsertMahasiswa = daftarLokasi.get(LokasiInsertMahasiswa).getJumKelompok();
                if (tempInsertMahasiswa != 0) {
                    for (int i = 0; i < daftarLokasi.get(LokasiInsertMahasiswa).getJumKelompok(); i++) {
                        System.out.println((i + 1) + daftarLokasi.get(LokasiInsertMahasiswa).getKelompok(i).getNamaKel());
                    }
                } else {
                    System.out.println("Tidak Ada Kelompok");
                }
                System.out.println("---------------------------------------------");
                System.out.println("1. Pilih Kelompok");
                System.out.println("2. Kembali ");
                System.out.print("Pilih : ");
                int pilMenuInsertMahasiswa = x.nextInt() - 1;
                System.out.println("---------------------------------------------");
                System.out.println("Kelompok " + daftarLokasi.get(LokasiInsertMahasiswa).getKelompok(pilMenuInsertMahasiswa).getNamaKel());
                System.out.println();
                System.out.print("Nama Mahasiswa  : ");
                String NamaInsertMahasiswa = x.next();
                System.out.print("NIM Mahasiswa : ");
                long NimInsertMahasiswa = x.nextLong();
                System.out.print("Kelas Mahasiswa: ");
                String KelasInsertMahasiswa = x.next();
                addMahasiswa(NamaInsertMahasiswa, NimInsertMahasiswa, KelasInsertMahasiswa);
                int dasda = daftarMahasiswa.size() - 1;
                Mahasiswa tempMahasiswaInsertMahasiswa = daftarMahasiswa.get(dasda);
                daftarLokasi.get(LokasiInsertMahasiswa).getKelompok(pilMenuInsertMahasiswa).addMahasiswa(tempMahasiswaInsertMahasiswa);
                break;
        }
    }

    public void menuDelete() {
        System.out.println("DELETE: ");
        System.out.println("1. Pembimbing ");
        System.out.println("2. Mahasiswa ");
        System.out.println("3. Kelompok ");
        System.out.println("4. Lokasi ");
        System.out.print("Pilih: ");
        int tempPilMenuView = x.nextInt();
        System.out.println("---------------------------------------------");
        switch (tempPilMenuView) {
            case 1:
                deletePembimbing();
                break;
            case 2:
                deleteMahasiswa();
                break;
            case 3:
                deleteKelompok();
                break;
            case 4:
                deleteLokasi();
                break;
        }

    }

    public void deletePembimbing() {
        System.out.println("MENU DELETE PEMBIMBING");
        System.out.println("1. By Nip");
        System.out.println("2. By Nama Pembimbing ");
        System.out.println("3. kembali");
        System.out.print("Pilih : ");
        System.out.println("---------------------------------------------");
        int pilMenuDeletePembimbing = x.nextInt();
        switch (pilMenuDeletePembimbing) {
            case 1:
                System.out.print("Nip Pembimbing : ");
                long NipP = x.nextLong();
                System.out.println("---------------------------------------------");
                System.out.println("DAFTAR PEMBIMBING");
                if (daftarPembimbing.size() != 0) {
                    for (int i = 0; i < daftarPembimbing.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarPembimbing.get(i).getNIP());
                        if (NipP == daftarPembimbing.get(i).getNIP()) {
                            daftarPembimbing.remove(i);
                        }
                    }
                } else {
                    System.out.println("Daftar Pembimbing tidak ada");
                }
                break;
            case 2:
                System.out.print("Nama Pembimbing : ");
                String NamaP = x.next();
                System.out.println("---------------------------------------------");
                System.out.println("DAFTAR PEMBIMBING");
                if (daftarPembimbing.size() != 0) {
                    for (int i = 0; i < daftarPembimbing.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarPembimbing.get(i).getStatus());
                        if (NamaP == daftarPembimbing.get(i).getNama()) {
                            daftarPembimbing.remove(i);
                        }
                    }
                } else {
                    System.out.println("Daftar Pembimbing tidak ada");
                }
                break;
            case 3:
                break;
        }
    }

    public void deleteMahasiswa() {
        System.out.println("MENU DELETE MAHASISWA");
        System.out.println("1. By Nim");
        System.out.println("2. By Nama Mahasiswa ");
        System.out.println("3. kembali");
        System.out.print("Pilih : ");
        System.out.println("---------------------------------------------");
        int pilMenuDeleteMahasiswa = x.nextInt();
        switch (pilMenuDeleteMahasiswa) {
            case 1:
                System.out.print("Masukan Nim Mahasiswa : ");
                long NimM = x.nextLong();
                System.out.println("---------------------------------------------");
                System.out.println("DAFTAR MAHASISWA");
                if (daftarMahasiswa.size() != 0) {
                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarMahasiswa.get(i).getNim());
                        if (NimM == daftarMahasiswa.get(i).getNim()) {
                            daftarMahasiswa.remove(i);
                        }
                    }
                } else {
                    System.out.println("Daftar Mahasiswa tidak ada");
                }
                break;
            case 2:
                System.out.print("Maukan Nama mahsiswa : ");
                String NamaM = x.next();
                System.out.println("---------------------------------------------");
                System.out.println("DAFTAR MAHASISWA");
                if (daftarMahasiswa.size() != 0) {
                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarMahasiswa.get(i).getStatus());
                        if (NamaM == daftarMahasiswa.get(i).getNama()) {
                            daftarMahasiswa.remove(i);
                        }
                    }
                } else {
                    System.out.println("Daftar Pembimbing tidak ada");
                }
                break;
            case 3:
                break;
        }
    }

    public void deleteKelompok() {
        System.out.println("MENU DELETE KELOMPOK");
        System.out.println("1. By Nama Kelompok ");
        System.out.println("2. kembali");
        System.out.print("Pilih : ");
        System.out.println("---------------------------------------------");

        int pilMenuDeleteKelompok = x.nextInt();
        switch (pilMenuDeleteKelompok) {
            case 1:
                System.out.print("Masukan nama Kelompok : ");
                String NamaK = x.next();
                System.out.println("---------------------------------------------");

                System.out.println("DAFTAR Mahasiswa");
                if (daftarMahasiswa.size() != 0) {
                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarMahasiswa.get(i).getNama());
                        if (NamaK == daftarMahasiswa.get(i).getNama()) {
                            daftarMahasiswa.remove(i);
                        }
                    }
                } else {
                    System.out.println("Daftar Kelompok tidak ada");
                }
                break;
            case 2:
                break;
        }
    }

    public void deleteLokasi() {
        System.out.println("MENU DELETE LOKASI");
        System.out.println("1. Nama Lokasi ");
        System.out.println("2. kembali");
        System.out.print("Pilih : ");
        System.out.println("---------------------------------------------");

        int pilMenuDeleteLokasi = x.nextInt();
        switch (pilMenuDeleteLokasi) {
            case 1:
                System.out.print("Masukan nama Lokasi : ");
                String NamaL = x.next();
                System.out.println("---------------------------------------------");

                System.out.println("DAFTAR Lokasi");
                if (daftarLokasi.size() != 0) {
                    for (int i = 0; i < daftarLokasi.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarLokasi.get(i).getNamaLokasi());
                        if (NamaL == daftarLokasi.get(i).getNamaLokasi()) {
                            daftarLokasi.remove(i);
                        }
                    }
                } else {
                    System.out.println("Daftar Lokasi1 tidak ada");
                }
                break;
            case 2:
                break;
        }
    }

    public void menuSearch() {
        System.out.println("SEARCH MENU ");
        System.out.println("1. Pembimbing ");
        System.out.println("2. Mahasiswa ");
        System.out.println("3. Kelompok ");
        System.out.println("4. Lokasi ");
        System.out.print("Pilih: ");
        int tempPilMenuSearch = x.nextInt();
        switch (tempPilMenuSearch) {
            case 1:
                System.out.println("---------------------------------------------");
                searchPembimbing();
                break;
            case 2:
                System.out.println("---------------------------------------------");
                searchMahasiswa();
                break;
            case 3:
                System.out.println("---------------------------------------------");
                searchKelompok();
                break;
            case 4:
                System.out.println("---------------------------------------------");
                searchLokasi();
                break;
        }

    }

    public void searchLokasi() {
        boolean cariLokasi = false;
        System.out.println("MENU SEARCH LOKASI ");
        System.out.print("Nama: ");
        String namaLok = x.next();
        for (int i = 0; i < daftarLokasi.size(); i++) {
            if (namaLok.equals(daftarLokasi.get(i).getNamaLokasi())) {
                cariLokasi = true;
            }
        }
        if (cariLokasi) {
            System.out.println("Lokasi " + namaLok + " ada");
        } else {
            System.out.println("Lokasi tidak ditemukan");
        }
    }

    public void searchKelompok() {
        boolean cariKelompok = false;
        System.out.println("MENU SEARCH KELOMPOK ");
        System.out.print("Nama: ");
        String namaKel = x.next();
        for (int i = 0; i < daftarLokasi.size(); i++) {
            for (int j = 0; j < daftarLokasi.get(i).getJumKelompok(); j++) {
                if (namaKel.equals(daftarLokasi.get(i).getKelompok(j).getNamaKel())) {
                    cariKelompok = true;
                }
            }
        }
        if (cariKelompok) {
            System.out.println("Kelompok " + namaKel + " ada");
        } else {
            System.out.println("Kelompok tidak ditemukan");
        }
    }

    public void searchPembimbing() {
        boolean cariPembimbing = false;
        System.out.println("MENU SEARCH PEMBIMBING ");
        System.out.println("1. By NIP ");
        System.out.println("2. By Nama");
        System.out.print("Pilih ");
        int pilSearch = x.nextInt();
        switch (pilSearch) {
            case 1:
                System.out.println("MENU SEARCH PEMBIMBING By NIP");
                System.out.print("NIP: ");
                long nipPem = x.nextLong();
                int tmpPembimbing = 0;
                for (int i = 0; i < daftarPembimbing.size(); i++) {
                    if (nipPem == daftarPembimbing.get(i).getNIP()) {
                        cariPembimbing = true;
                        tmpPembimbing = i;
                    }
                }
                if (cariPembimbing) {
                    System.out.println("Nama: " + daftarPembimbing.get(tmpPembimbing).getNama());
                    System.out.println("NIP: " + nipPem);
                } else {
                    System.out.println("Pembimbing tidak ditemukan");
                }
                break;
            case 2:
                System.out.println("MENU SEARCH PEMBIMBING By Nama");
                System.out.print("Nama: ");
                String namaPem = x.next();
                int tmpPembimbing2 = 0;
                for (int i = 0; i < daftarPembimbing.size(); i++) {
                    if (namaPem.equals(daftarPembimbing.get(i).getNama())) {
                        cariPembimbing = true;
                        tmpPembimbing2 = i;
                    }
                }
                if (cariPembimbing) {
                    System.out.println("Nama: " + namaPem);
                    System.out.println("NIP: " + daftarPembimbing.get(tmpPembimbing2).getNIP());
                } else {
                    System.out.println("Pembimbing tidak ditemukan");
                }
                break;
            default:
                System.out.println("Inputan salah");
        }
    }

    public void searchMahasiswa() {
        boolean cariMahasiswa = false;
        System.out.println("MENU SEARCH MAHASISWA");
        System.out.println("1. By NIM");
        System.out.println("2. By Nama");
        System.out.print("Pilih: ");
        int pilSearch = x.nextInt();
        switch (pilSearch) {
            case 1:
                System.out.println("MENU SEARCH MAHASISWA BY NIM");
                System.out.print("NIM: ");
                long nim = x.nextLong();
                int tmpMahasiswa = 0;
                for (int i = 0; i < daftarMahasiswa.size(); i++) {
                    if (nim == daftarMahasiswa.get(i).getNim()) {
                        cariMahasiswa = true;
                        tmpMahasiswa = i;
                    }
                }
                if (cariMahasiswa) {
                    System.out.println("Nama: " + daftarMahasiswa.get(tmpMahasiswa).getNama());
                    System.out.println("NIM: " + nim);
                    System.out.println("Kelas: " + daftarMahasiswa.get(tmpMahasiswa).getKelas());
                } else {
                    System.out.println("Mahasiswa tidak ditemukan");
                }
                break;
            case 2:
                System.out.println("MENU SEARCH MAHASISWA BY NAMA");
                System.out.print("Nama: ");
                String namaM = x.next();
                int tmpMahasiswa2 = 0;
                for (int j = 0; j < daftarMahasiswa.size(); j++) {
                    if (namaM.equals(daftarMahasiswa.get(j).getNama())) {
                        cariMahasiswa = true;
                        tmpMahasiswa = j;
                    }
                }
                if (cariMahasiswa) {
                    System.out.println("Nama: " + namaM);
                    System.out.println("NIP: " + daftarMahasiswa.get(tmpMahasiswa2).getNim());
                    System.out.println("Kelas: " + daftarMahasiswa.get(tmpMahasiswa2).getKelas());
                } else {
                    System.out.println("Mahasiswa tidak ditemukan");
                }
                break;
            default:
                System.out.println("Inputan Salah!!");
        }
    }

    public void menuView() {
        System.out.println("VIEW MENU");
        System.out.println("1. Lokasi");
        System.out.println("2. Kelompok");
        System.out.println("3. Pembimbing");
        System.out.println("4. Mahasiswa");
        System.out.print("Pilih: ");
        System.out.println("---------------------------------------------");

        int pilMenuView = x.nextInt();
        System.out.println();
        switch (pilMenuView) {
            case 1:
                System.out.println("---------------------------------------------");

                viewLokasi();
                break;
            case 2:
                System.out.println("---------------------------------------------");

                viewKelompok();
                break;
            case 3:
                System.out.println("---------------------------------------------");

                viewPembimbing();
                break;
            case 4:
                System.out.println("---------------------------------------------");

                viewMahasiswa();
                break;
        }
    }

    public void viewMahasiswa() {
        System.out.println("VIEW MAHASISWA ");
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            System.out.println(i + " Nama : " + daftarMahasiswa.get(i).getNama());
            System.out.println("  NIM : " + daftarMahasiswa.get(i).getNim());
            System.out.println("  Kelas : " + daftarMahasiswa.get(i).getKelas());
            System.out.println();
        }
    }

    public void viewPembimbing() {
        System.out.println("VIEW PEMBIMBING ");
        for (int i = 0; i < daftarPembimbing.size(); i++) {
            System.out.println((i + 1) + " Nama : " + daftarPembimbing.get(i).getNama());
            System.out.println("  NIP : " + daftarPembimbing.get(i).getNIP());
            System.out.println();
        }
    }

    public void viewLokasi() {
        System.out.println("VIEW LOKASI ");
        for (int i = 0; i < daftarLokasi.size(); i++) {
            System.out.println((i + 1) + " Nama Lokasi : " + daftarLokasi.get(i).getNamaLokasi());
            System.out.println();
        }
    }

    public void viewKelompok() {
        System.out.println("VIEW KELOMPOK ");
        for (int i = 0; i < daftarLokasi.size(); i++) {
            for (int j = 0; j < daftarLokasi.get(i).getJumKelompok(); j++) {
                System.out.println((i + 1) + " Nama Lokasi : " + daftarLokasi.get(i).getKelompok(j).getNamaKel());
                System.out.println();
            }
        }
    }

    public void MainMenu() {
        int pilMainMenu = 9;
        do {
            try {
                System.out.println("MENU: ");
                System.out.println("1. Insert ");
                System.out.println("2. Delete ");
                System.out.println("3. Search ");
                System.out.println("4. View ");
                System.out.print("Pilih: ");
                pilMainMenu = x.nextInt();
                switch (pilMainMenu) {
                    case 1:
                        System.out.println("---------------------------------------------");
                        menuInsert();
                        break;
                    case 2:
                        System.out.println("---------------------------------------------");
                        menuDelete();
                        break;
                    case 3:
                        System.out.println("---------------------------------------------");
                        menuSearch();
                        break;
                    case 4:
                        System.out.println("---------------------------------------------");
                        menuView();
                        break;
                }
            } catch (Exception e) {
                System.out.println("------------------");
                System.out.println("Input Tidak Sesuai");
                System.out.println("------------------");
                x = new Scanner(System.in);
            }
        } while (pilMainMenu != 0);
    }
}
