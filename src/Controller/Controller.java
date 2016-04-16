/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import Console.Console;
import Model.Aplikasi;
import Model.Lokasi;
import Model.Pembimbing;
import View.*;
import com.sun.istack.internal.logging.Logger;
import java.awt.event.ActionEvent;
import java.io.IOException;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class Controller extends MouseAdapter implements ActionListener {

    private Aplikasi model;
    private masuk menu1;
    private menu_utama menu2;
    private awal menu3;
    private awal_kelompok menu4;
    private awal_pembimbing menu5;
    private awal_mahasiswa menu6;

    private Object view;

    public Controller() {
        model = new Aplikasi();
        menu1 = new masuk();
        menu1.addListener(this);
        menu1.setVisible(true);
        view = menu1;
    }

    public void gotoMenu2() {
        menu2 = new menu_utama();
        menu2.addListener(this);
        menu2.setVisible(true);
        view = menu2;

    }

    public void gotoMenu3() {
        menu3 = new awal();
        menu3.addListener(this);
        menu3.setVisible(true);
        view = menu3;
        refreshLokasi();


    }

    public void gotoMenu4() {
        menu4 = new awal_kelompok();
        menu4.addListener(this);
        menu4.setVisible(true);
        setComboBoxLokasi(menu4.getComboBox());
        view = menu4;

    }

    public void gotoMenu5() {
        menu5 = new awal_pembimbing();
        menu5.addListener(this);
        menu5.setVisible(true);
        setComboBoxLokasi(menu5.getComboBoxLokasi());
        view = menu5;

    }

    public void gotoMenu6() {
        menu6 = new awal_mahasiswa();
        menu6.addListener(this);
        menu6.setVisible(true);
        setComboBoxLokasi(menu6.getComboBoxLokasi());
        setComboBoxKelompok(menu6.getComboBoxKelompok(),menu6.getPilihLokasi());
        
        view = menu6;

    }
    
    public void setComboBoxLokasi(JComboBox cb){
        String[] daftar= new String[model.getDaftarLokasi().size()];
        for (int i = 0; i < model.getDaftarLokasi().size() ; i++) {
            daftar[i]= model.getDaftarLokasi().get(i).getNamaLokasi();
        }
        cb.setModel(new DefaultComboBoxModel(daftar));
    }
    
    public void setComboBoxKelompok(JComboBox cb, int index){
        String[] daftar = new String[model.getDaftarLokasi().size()];
        for (int i = 0; i < model.getDaftarLokasi().get(index).getJumKelompok(); i++) {
            daftar[i]=model.getDaftarLokasi().get(index).getKelompok(i).getNamaKel();
        }
       cb.setModel(new DefaultComboBoxModel(daftar));
    }
    
//    public void setCbMahasiswa(){
//        if 
//    }
    
            
            
    public void AddLokasi() {
           model.InsertLokasi(menu3.getNamaLokasi());
        for (int j = 0; j < model.getDaftarLokasi().size(); j++) {
            menu3.getTable().setValueAt(model.getDaftarLokasi().get(j).getNamaLokasi(), j, 0);
            menu3.getTable().setValueAt(model.getDaftarLokasi().get(j).getJumKelompok(), j, 2);
        }
    }
    public void deleteLokasi() {
        int i = 0;
        //System.out.println("aa");
        for (int j = 0; j < model.getDaftarLokasi().size(); j++) {
            //System.out.println("bb");
            if (model.getDaftarLokasi().get(j).getNamaLokasi().equals(menu3.getSearchLokasi())) {
                //System.out.println("cc");
                menu3.getTable().setValueAt(model.getDaftarLokasi().get(j).getNamaLokasi(), i, 0);
                model.deleteLokasi(j); 
                i++;
            }
            menu3.resettabel();
            for (int k = 0; k < model.getDaftarLokasi().size(); k++) {
            menu3.getTable().setValueAt(model.getDaftarLokasi().get(k).getNamaLokasi(), k, 0);
            menu3.getTable().setValueAt(model.getDaftarLokasi().get(k).getJumKelompok(), k, 2);
        }
        }
    }
    public void searchLokasi() {
        menu3.resettabel();
        int i = 0;
        //System.out.println("aa");
        for (int j = 0; j < model.getDaftarLokasi().size(); j++) {
            //System.out.println("bb");
            if (model.getDaftarLokasi().get(j).getNamaLokasi().equals(menu3.getSearchLokasi())) {
                //System.out.println("cc");
                menu3.getTable().setValueAt(model.getDaftarLokasi().get(j).getNamaLokasi(), i, 0);
                i++;
            }
            //int jumlah = model.getDaftarLokasi().size(); 
            //menu3.getTable().setValueAt(jumlah, j, 1);
        }
    }
    public void refreshLokasi(){
        for (int k = 0; k < model.getDaftarLokasi().size(); k++) {
            menu3.getTable().getValueAt(k, 0);
            menu3.getTable().getValueAt(k, 1);
            }
    }

    public void AddKelompok() {
        model.InsertKelompok(menu4.getPilihLokasi(), menu4.getNamaKelompok());
        for (int i = 0; i < model.getDaftarLokasi().size();i++) {
            for (int j = 0; j < model.getDaftarLokasi().get(i).getJumKelompok(); j++) {
            String nama = model.getDaftarLokasi().get(i).getKelompok(j).getNamaKel();
            menu4.getTable().setValueAt(nama, j, 0);
            int jumlah = model.getDaftarLokasi().get(i).getKelompok(j).getTotal();
            menu4.getTable().setValueAt(jumlah, j, 1);
        }
    }    }
     public void deleteKelompok() {
        int p = 0;
        for (int i = 0; i < model.getDaftarLokasi().size(); i++) {
        for (int j = 0; j < model.getDaftarLokasi().get(i).getJumKelompok(); j++) {
            if (model.getDaftarLokasi().get(i).getKelompok(j).getNamaKel().equals(menu4.getSearchKelompok())) {
                menu4.getTable().setValueAt(model.getDaftarLokasi().get(i).getKelompok(j).getNamaKel(), p, 0);
                model.deleteKelompok(j); 
                p++;
            }
            menu4.resettabel();
        }}
    }     
     public void searchKelompok() {
        menu4.resettabel();
        int p = 0;
        //System.out.println("aa");
        for (int i = 0; i < model.getDaftarLokasi().size(); i++) {
           for (int j = 0; j < model.getDaftarLokasi().get(i).getJumKelompok(); j++) {
            if (model.getDaftarLokasi().get(i).getKelompok(j).getNamaKel().equals(menu4.getSearchKelompok())) {
                menu4.getTable().setValueAt(model.getDaftarLokasi().get(i).getKelompok(j).getNamaKel(), p, 0);
                p++;
            }
        } 
           
    }}
     
     public void AddPembimbing(){
         model.addPembimbing(menu5.getNamaPembimbing(),Long.parseLong(menu5.getNipPemimbing()));
         Pembimbing tempPembimbing =model.getDaftarPembimbing().get(menu5.getPiliLokasi());
         model.InsertPembimbing(menu5.getPiliLokasi(),tempPembimbing );
         for (int i = 0; i < model.getDaftarLokasi().size();i++) {
                 String nama = model.getDaftarPembimbing().get(i).getNama();
                 menu5.getTable().setValueAt(nama, i, 0);
                 long nip = model.getDaftarPembimbing().get(i).getNIP();
                 menu5.getTable().setValueAt(nip, i, 1);
                 String lokasi = model.getDaftarLokasi().get(i).getNamaLokasi();
                 menu5.getTable().setValueAt(lokasi, i, 2);
             
         }
     }
    public void deletePembimbing(){
        int p = 0;
        String banding = model.getDaftarLokasi().get(0).getPembimbing().getNama();
        for (int i = 0; i < model.getDaftarLokasi().size(); i++) {
            if(banding.equals( model.getDaftarLokasi().get(i).getPembimbing().getNama())){
                String nama = model.getDaftarPembimbing().get(i).getNama();
                 menu5.getTable().setValueAt(nama, p, 0);
                 long nip = model.getDaftarPembimbing().get(i).getNIP();
                 menu5.getTable().setValueAt(nip, p, 1);
                 String lokasi = model.getDaftarLokasi().get(menu5.getPiliLokasi()).getNamaLokasi();
                 menu5.getTable().setValueAt(lokasi, p, 2);
                 model.deletePembimbing(i);
                 p++;
            }
            menu5.reset();
        }
    }
    
    public void searchPembimbing(){
        int p =  0;
        String banding = model.getDaftarLokasi().get(0).getPembimbing().getNama();
        for (int i = 0; i < model.getDaftarLokasi().size(); i++) {
            if(banding.equals( model.getDaftarLokasi().get(i).getPembimbing().getNama())){
                String nama = model.getDaftarPembimbing().get(i).getNama();
                 menu5.getTable().setValueAt(nama, p, 0);
                 long nip = model.getDaftarPembimbing().get(i).getNIP();
                 menu5.getTable().setValueAt(nip, p, 1);
                 String lokasi = model.getDaftarLokasi().get(menu5.getPiliLokasi()).getNamaLokasi();
                 menu5.getTable().setValueAt(lokasi, p, 2);
                 model.deletePembimbing(i);
                 p++;
            }
        }}
    public void AddMahasiswa() {
        model.InsertMahasiswa(menu6.getPilihLokasi(), menu6.getPilihKelompok(),menu6.getNamaMahasiswa(), menu6.getNimMahasiswa(), menu6.getKelasMahasiswa());
        for (int i = 0; i < model.getDaftarLokasi().size(); i++) {
            for(int j = 0; j < model.getDaftarLokasi().get(menu6.getPilihLokasi()).getJumKelompok(); i++){
            
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (view instanceof masuk) {
            if (source.equals(menu1.getb_masuk())) {
                menu1.dispose();
                gotoMenu2();
            }
        } else if (view instanceof menu_utama) {
            if (source.equals(menu2.getB_Lokasi())) {
                menu2.dispose();
                gotoMenu3();
            } else if (source.equals(menu2.getB_Kelompok())) {
                menu2.dispose();
                gotoMenu4();
            } else if (source.equals(menu2.getB_Pembimbing())) {
                menu2.dispose();
                gotoMenu5();
            } else if (source.equals(menu2.getB_Mahasiswa())) {
                menu2.dispose();
                gotoMenu6();
            } else if (source.equals(menu2.getEXIT())) {
                menu2.dispose();
                System.exit(0);
            }
        } else if (view instanceof awal) {

            if (source.equals(menu3.getB_Add())) {
//                try{
//                    AddLokasi();
//                    menu3.sukses();
//                }catch (IOException x){
//                    System.out.println(x);
//                    menu3.gagal();
//                }
                if(menu3.getNamaLokasi().isEmpty()){
                    menu3.gagal();
                }else{
                AddLokasi();
                menu3.sukses();
                menu3.reset();
                }
            } else if (source.equals(menu3.getB_Delete())) {
                //if(menu3.getNamaLokasi().isEmpty()){
                    //menu3.gagal();
                //}else{
                deleteLokasi();
                //menu3.sukses();
                menu3.reset();
                
                //deleteLokasi();
            } else if (source.equals(menu3.getB_search())) {
                if(menu3.getSearchLokasi().isEmpty()){
                    menu3.gagal();
                }else{
                searchLokasi();
                menu3.sukses();
                menu3.reset();
                }
                //searchLokasi();
            } else if (source.equals(menu3.getB_Exit())) {
                menu3.dispose();
                System.exit(0);
            } else if (source.equals(menu3.getD_Menu_Lokasi())) {
                menu3.dispose();
                gotoMenu3();
            } else if (source.equals(menu3.getD_Menu_Kelompok())) {
                menu3.dispose();
                gotoMenu4();
            } else if (source.equals(menu3.getD_Menu_Pembimbing())) {
                menu3.dispose();
                gotoMenu5();
            } else if (source.equals(menu3.getD_Menu_Mahasiswa())) {
                menu3.dispose();
                gotoMenu6();
            }
        } else if (view instanceof awal_kelompok) {
            if (source.equals(menu4.getB_Add())) {
                if(menu4.getNamaKelompok().isEmpty()){
                    menu4.gagal();
                }else{
                AddKelompok();
                menu4.sukses();
                menu4.reset();
                }
                //AddKelompok();
            } else if (source.equals(menu4.getB_Delete())) {
                if(menu4.getSearchKelompok().isEmpty()){
                    menu4.gagal();
                }else{
                deleteKelompok();
                menu4.sukses();
                menu4.reset();
                }
                //deleteKelompok();
            } else if (source.equals(menu4.getB_search())) {
                if(menu4.getSearchKelompok().isEmpty()){
                    menu4.gagal();
                }else{
                searchKelompok();
                menu4.sukses();
                menu4.reset();
                }
                //searchKelompok();
            } else if (source.equals(menu4.getB_Exit())) {
                System.exit(0);

            } else if (source.equals(menu4.getD_Menu_Lokasi())) {
                menu4.dispose();
                gotoMenu3();
            } else if (source.equals(menu4.getD_Menu_Kelompok())) {
                menu4.dispose();
                gotoMenu4();
            } else if (source.equals(menu4.getD_Menu_Pembimbing())) {
                menu4.dispose();
                gotoMenu5();
            } else if (source.equals(menu4.getD_Menu_Mahasiswa())) {
                menu4.dispose();
                gotoMenu6();
            }

        } else if (view instanceof awal_pembimbing) {
            if (source.equals(menu5.getB_Add())) {
                if(menu5.getNamaPembimbing().isEmpty()){
                    menu5.gagal();
                }else{
                AddPembimbing();
                menu5.sukses();
                menu5.reset();
                }
            //} else if (source.equals(menu5.getB_Add())) {
            } else if (source.equals(menu5.getB_Delete())) {
                if(menu5.getNamaPembimbing().isEmpty()){
                    menu5.gagal();
                }else{
                deletePembimbing();
                menu5.sukses();
                menu5.reset();
                }
            } else if (source.equals(menu5.getB_search())) {
                if(menu5.getSearchPembimbing().isEmpty()){
                    menu5.gagal();
                }else{
                searchPembimbing();
                menu5.sukses();
                menu5.reset();
                }
            } else if (source.equals(menu5.getB_Exit())) {
                System.exit(0);

            } else if (source.equals(menu5.getD_Menu_Lokasi())) {
                menu5.dispose();
                gotoMenu3();
            } else if (source.equals(menu5.getD_Menu_Kelompok())) {
                menu5.dispose();
                gotoMenu4();
            } else if (source.equals(menu5.getD_Menu_Pembimbing())) {
                menu5.dispose();
                gotoMenu5();
            } else if (source.equals(menu5.getD_Menu_Mahasiswa())) {
                menu5.dispose();
                gotoMenu6();
            }

        } else if (view instanceof awal_mahasiswa) {
            if (source.equals(menu6.getB_Add())) {

            } else if (source.equals(menu6.getB_Add())) {

            } else if (source.equals(menu6.getB_Delete())) {

            } else if (source.equals(menu6.getB_search())) {

            } else if (source.equals(menu6.getB_Exit())) {
                menu6.dispose();
                System.exit(0);

            } else if (source.equals(menu6.getD_Menu_Lokasi())) {
                menu6.dispose();
                gotoMenu3();
            } else if (source.equals(menu6.getD_Menu_Kelompok())) {
                menu6.dispose();
                gotoMenu4();
            } else if (source.equals(menu6.getD_Menu_Pembimbing())) {
                menu6.dispose();
                gotoMenu5();
            } else if (source.equals(menu6.getD_Menu_Mahasiswa())) {
                menu6.dispose();
                gotoMenu6();
            }

        }
    }

}
