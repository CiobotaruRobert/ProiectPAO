package service;
import model.*;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ProduseService {

    public static void afisare_produse() {
            Categorie_Lactate_Service.afisare_produse_lactate();
            Categorie_FructeLegume_Service.afisare_produse_fructelegume();
            Categorie_Cereale_Service.afisare_produse_cereale();
            Categorie_Carne_Service.afisare_produse_carne();
            Categorie_BauturiNealcoolice_Service.afisare_produse_bauturinealcoolice();
            Categorie_BauturiAlcoolice_Service.afisare_produse_bauturialcoolice();
    }

    public static int nullCheck(String nume_tabel) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String qry = "SELECT * From " + nume_tabel;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            stmt = (PreparedStatement) conn.prepareStatement(qry);
            rs =  stmt.executeQuery();
            int count = 0;
            while(rs.next()){
                count++;
            }
            if(count == 0){
                return 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }
    }


