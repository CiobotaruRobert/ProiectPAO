package service;
import model.Categorie_FructeLegume;
import model.Categorie_Lactate;
import model.Produs;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Categorie_FructeLegume_Service {
    public static void addProdusFructeLegume()
    {
        Categorie_FructeLegume categorie_FructeLegume = new Categorie_FructeLegume();
        categorie_FructeLegume.citire_categorie_fructelegume();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into produse_fructe_legume (denumire,cantitate,descriere,bio, romanesc) values (?,?,?,?,?)");
            statement.setString(1, categorie_FructeLegume.getDenumire_produs());
            statement.setInt(2, categorie_FructeLegume.getCantitate_produs());
            statement.setString(3, categorie_FructeLegume.getDescriere_produs());
            statement.setBoolean(4, categorie_FructeLegume.getBio());
            statement.setBoolean(5, categorie_FructeLegume.getRomanesc());
            statement.execute();
        }catch(Exception e){e.printStackTrace();}
    }
    public static void afisare_produse_fructelegume()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from produse_fructe_legume");
            ResultSet rs = statement.executeQuery();
            String aux1,aux2;
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT PRODUSE IN TABELUL FRUCTE SI LEGUME***");
            else{System.out.println("***FRUCTE SI LEGUME***");

                System.out.println("Id, denumire, cantitate, descriere, bio, romanesc");}
            while(rs.next())
            {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                String descriere = rs.getString("descriere");
                boolean bio = rs.getBoolean("bio");
                boolean romanesc = rs.getBoolean("romanesc");
                if(bio) aux1="Este bio";
                else aux1="Nu este bio";
                if(romanesc) aux2="Este romanesc";
                else aux2="Nu este romanesc";
                System.out.format("%s, %s, %s, %s, %s, %s \n", id, denumire, cantitate, descriere, aux1, aux2);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_produs_fructelegume(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from produse_fructe_legume where id=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_produs_fructelegume(int id_de_updatat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update produse_fructe_legume set denumire=?,cantitate=?,descriere=?,bio=?,romanesc=? where id=?");
            Scanner scanner = new Scanner(System.in);
            int var;
            String var2;
            boolean var3;
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
            System.out.print("Produs bio? (da sau nu): ");
            var2=scanner.next();
            var3= var2.toLowerCase().equals("da");
            statement.setBoolean(4, var3);
            System.out.print("Produs romanesc? (da sau nu): ");
            var2=scanner.next();
            var3= var2.toLowerCase().equals("da");
            statement.setBoolean(5, var3);
            statement.setInt(6, id_de_updatat);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
