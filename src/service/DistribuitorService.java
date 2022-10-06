package service;
import model.Categorie_Cereale;
import model.Categorie_FructeLegume;
import model.Categorie_Lactate;
import model.Distribuitor;
import model.Produs;

import java.sql.*;
import java.util.Scanner;

public class DistribuitorService {
    public static void addDistribuitor()
    {
        Distribuitor distribuitor = new Distribuitor();
        distribuitor.citire_distribuitor();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into distribuitor (denumire,adresa, cod_postal, numar_telefon) values (?,?,?,?)");
            statement.setString(1, distribuitor.getDenumire_distribuitor());
            statement.setString(2, distribuitor.getAdresa());
            statement.setString(3, distribuitor.getCod_postal());
            statement.setString(4, distribuitor.getNumar_telefon());

            statement.execute();
        }catch(Exception e){e.printStackTrace();}
    }
    public static void afiseaza_distribuitori()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from distribuitor");
            ResultSet rs = statement.executeQuery();
            String aux1;
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT DISTRIBUITORI IN TABEL***");
else{System.out.println("***Distribuitori interni***");
                System.out.println("Id, denumire, adresa, cod_postal, numar_telefon");}
            while(rs.next())
            {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                String adresa = rs.getString("adresa");
                String cod_postal = rs.getString("cod_postal");
                String numar_telefon = rs.getString("numar_telefon");
                System.out.format("%s, %s, %s, %s, %s \n",id, denumire, adresa, cod_postal, numar_telefon);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_distribuitor(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from distribuitor where id=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_distribuitor(int id_de_updatat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update distribuitor set denumire=?,adresa=?,cod_postal=?,numar_telefon=? where id=?");
            Scanner scanner = new Scanner(System.in);
            String var2;
            System.out.print("Introduceti denumirea distribuitorului: ");
            var2=scanner.nextLine();
            statement.setString(1, var2);
            System.out.print("Introduceti adresa: ");
            var2=scanner.nextLine();
            statement.setString(2, var2);
            System.out.print("Introduceti codul postal: ");
            var2=scanner.nextLine();
            statement.setString(3, var2);
            System.out.print("Introduceti numarul de telefon: ");
            var2=scanner.nextLine();
            statement.setString(4,var2);
            statement.setInt(5, id_de_updatat);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
