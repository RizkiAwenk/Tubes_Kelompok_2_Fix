/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Kelompok;
import Model.Lokasi;
import Model.Mahasiswa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ulid
 */
public class Database {
    
    private String dbUser = "root";
    private String dbpswd = "";
    private java.sql.Connection connection;
    private java.sql.Statement statement;
    private ResultSet rs;
    private String query;

    public Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql//localhost/geladi", dbUser, dbpswd);
        statement = connection.createStatement();
    }

    public ResultSet getData(String SQLString) throws SQLException {
        rs = statement.executeQuery(SQLString);
        return rs;
    }
    
    public void execute(String query) throws SQLException{
        statement.execute(query);
    }
    
    public void InsertLokasi(Lokasi k) throws SQLException{
        query = "insert Nama,JumlahKelompok into lokasi values('"+k.getNamaLokasi()+"','"+k.getJumKelompok()+"')";
        execute(query);
    }
    
    public void InsertKelompok(Kelompok k) throws SQLException{
        query = "insert * into kelompok values('"+k.getNamaKel()+"','"+k.getTotal()+"')";
        execute(query);
    }
    
    public void InsertMahasiswa(Mahasiswa m){
//        query ="insert * into mahasiswa values ('"+m.getNama()+"','"+m.getNim()+"','"+m.getKelas()+"','"
    }
    
}
