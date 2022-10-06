package service;
import com.mysql.cj.protocol.Resultset;
import model.Categorie_Lactate;
import model.Produs;

import java.sql.*;
import java.util.Scanner;

public class Categorie_Lactate_Service {
    public static void addProdusLactat() {
        Categorie_Lactate categorie_lactate = new Categorie_Lactate();
        categorie_lactate.citire_categorie_lactate();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into produse_lactate (denumire,cantitate,descriere,procentaj_grasime) values (?,?,?,?)");
            statement.setString(1, categorie_lactate.getDenumire_produs());
            statement.setInt(2, categorie_lactate.getCantitate_produs());
            statement.setString(3, categorie_lactate.getDescriere_produs());
            statement.setDouble(4, categorie_lactate.getProcentaj_grasime());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void afisare_produse_lactate() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from produse_lactate");
            ResultSet rs = statement.executeQuery();
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT PRODUSE IN TABELUL LACTATE***");
            else{System.out.println("***PRODUSE LACTATE***");
                System.out.println("Id, denumire, cantitate, descriere, procentaj de grasime");}
            while (rs.next()) {
                int id = rs.getInt("id_produse_lactate");
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                String descriere = rs.getString("descriere");
                double procentaj_grasime = rs.getDouble("procentaj_grasime");
                System.out.format("%s, %s, %s, %s, %s \n", id, denumire, cantitate, descriere, procentaj_grasime);
                System.out.println("");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_produs_lactat(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from produse_lactate where id_produse_lactate=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_produs_lactat(int id_de_updatat) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update produse_lactate set denumire=?,cantitate=?,descriere=?,procentaj_grasime=? where id_produse_lactate=?");
            Scanner scanner = new Scanner(System.in);
            int var;
            String var2;
            double var3;
            System.out.print("Introduceti denumirea produsului: ");
            var2=scanner.nextLine();
            statement.setString(1, var2);
            System.out.print("Introduceti cantitatea produsului(tip int): ");
            var=scanner.nextInt();
            statement.setInt(2, var);
            scanner.nextLine();
            System.out.print("Introduceti descrierea produsului: ");
            var2=scanner.nextLine();
            statement.setString(3, var2);
            System.out.print("Introduceti procentajul de grasime al produsului(tip double): ");
            var3=scanner.nextDouble();
            statement.setDouble(4, var3);
            statement.setInt(5, id_de_updatat);
            statement.execute();}

         catch (Exception e) {
            e.printStackTrace();
        }
    }


}

