package service;
import model.Categorie_Cereale;
import model.Categorie_FructeLegume;
import model.Categorie_Lactate;
import model.Distribuitor_Import;
import model.Produs;

import java.sql.*;
import java.util.Scanner;

public class Distribuitor_Import_Service {
    public static void addDistribuitor_Import()
    {
        Distribuitor_Import distribuitor_Import = new Distribuitor_Import();
        distribuitor_Import.citire_distribuitor_import();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into distribuitor_import (denumire,adresa, cod_postal, numar_telefon, cod_eori, certificat_origine) values (?,?,?,?,?,?)");
            statement.setString(1, distribuitor_Import.getDenumire_distribuitor());
            statement.setString(2, distribuitor_Import.getAdresa());
            statement.setString(3, distribuitor_Import.getCod_postal());
            statement.setString(4, distribuitor_Import.getNumar_telefon());
            statement.setString(5, distribuitor_Import.getCod_EORI());
            statement.setString(6, distribuitor_Import.getCertificat_origine());
            statement.execute();
        }catch(Exception e){e.printStackTrace();}
    }

    public static void afiseaza_distribuitori_import()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from distribuitor_import");
            ResultSet rs = statement.executeQuery();
            String aux1;
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT DISTRIBUITORI IN TABEL***");
            else{                System.out.println("***Distribuitori straini***");
                System.out.println("Id, denumire, adresa, cod_postal, numar_telefon, cod_eori, certificat_origine");}

            while(rs.next())
            {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                String adresa = rs.getString("adresa");
                String cod_postal = rs.getString("cod_postal");
                String numar_telefon = rs.getString("numar_telefon");
                String cod_eori = rs.getString("cod_eori");
                String certificat_origine = rs.getString("certificat_origine");
                System.out.format("%s, %s, %s, %s, %s, %s, %s \n",id, denumire, adresa, cod_postal, numar_telefon, cod_eori, certificat_origine);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_distribuitor_import(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from distribuitor_import where id=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_distribuitor_import(int id_de_updatat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update distribuitor_import set denumire=?,adresa=?,cod_postal=?,numar_telefon=?,cod_eori=?,certificat_origine=? where id=?");
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
            System.out.print("Introduceti codul eori: ");
            var2=scanner.nextLine();
            statement.setString(5,var2);
            System.out.print("Introduceti certificatul de origine: ");
            var2=scanner.nextLine();
            statement.setString(6,var2);
            statement.setInt(7, id_de_updatat);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
