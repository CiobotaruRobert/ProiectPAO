package service;
import model.*;

import java.sql.*;
import java.util.Scanner;

public class Categorie_BauturiAlcoolice_Service {
    public static void addProdusBauturaAloolica()
    {
        Categorie_BauturiAlcoolice categorie_BauturiAlcoolice = new Categorie_BauturiAlcoolice();
        categorie_BauturiAlcoolice.citire_Categorie_BauturiAlcoolice();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into produse_bauturi_alcoolice (denumire,cantitate,descriere,plante_provenienta, procentaj_alcool) values (?,?,?,?,?)");
            statement.setString(1, categorie_BauturiAlcoolice.getDenumire_produs());
            statement.setInt(2, categorie_BauturiAlcoolice.getCantitate_produs());
            statement.setString(3, categorie_BauturiAlcoolice.getDescriere_produs());
            statement.setString(4, categorie_BauturiAlcoolice.getPlante_provenienta());
            statement.setDouble(5, categorie_BauturiAlcoolice.getProcentaj_alcool());
            statement.execute();
        }catch(Exception e){e.printStackTrace();}
    }

    public static void afisare_produse_bauturialcoolice()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from produse_bauturi_alcoolice");
            ResultSet rs = statement.executeQuery();
            String aux1;
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT PRODUSE IN TABELUL BAUTURI ALCOOLICE***");
            else {System.out.println("***Bauturi alcoolice***");
                System.out.println("Id, denumire, cantitate, descriere, plante_provenienta, procentaj_alcool");}
            while(rs.next())
            {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                String descriere = rs.getString("descriere");
                String plante_provenienta = rs.getString("plante_provenienta");
                double procentaj_alcool = rs.getDouble("procentaj_alcool");
                System.out.format("%s, %s, %s, %s, %s, %s \n",id, denumire, cantitate, descriere, plante_provenienta, procentaj_alcool);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_produs_bauturialcoolice(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from produse_bauturi_alcoolice where id=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_produs_bauturialcoolice(int id_de_updatat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update produse_bauturi_alcoolice set denumire=?,cantitate=?,descriere=?,plante_provenienta=?,procentaj_alcool=? where id=?");
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
            System.out.print("Introduceti plantele de provenienta: ");
            var2=scanner.nextLine();
            statement.setString(4,var2);
            System.out.print("Introduceti procentajul de alcool: ");
            var3=scanner.nextDouble();
            statement.setDouble(5, var3);
            statement.setInt(6, id_de_updatat);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
