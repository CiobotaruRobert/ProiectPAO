package service;
import model.Categorie_Cereale;
import model.Categorie_FructeLegume;
import model.Categorie_Lactate;
import model.Produs;

import java.sql.*;
import java.util.Scanner;

public class Categorie_Cereale_Service {
    public static void addProdusCereale()
    {
        Categorie_Cereale categorie_cereale = new Categorie_Cereale();
        categorie_cereale.citire_categorie_cereale();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into produse_cereale (denumire,cantitate,descriere,contine_gluten, alergeni) values (?,?,?,?,?)");
            statement.setString(1, categorie_cereale.getDenumire_produs());
            statement.setInt(2, categorie_cereale.getCantitate_produs());
            statement.setString(3, categorie_cereale.getDescriere_produs());
            statement.setBoolean(4, categorie_cereale.getContine_gluten());
            statement.setString(5, categorie_cereale.getAlergeni());
            statement.execute();
        }catch(Exception e){e.printStackTrace();}
    }

    public static void afisare_produse_cereale()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from produse_cereale");
            ResultSet rs = statement.executeQuery();
            String aux1;
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT PRODUSE IN TABELUL CEREALE***");
            else{System.out.println("***Cereale si derivate***");
                System.out.println("Id, denumire, cantitate, descriere, gluten, alergeni");}

            while(rs.next())
            {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                String descriere = rs.getString("descriere");
                boolean contine_gluten = rs.getBoolean("contine_gluten");
                String alergeni = rs.getString("alergeni");
                if(contine_gluten) aux1="Contine gluten";
                else aux1="Nu contine gluten";
                System.out.format("%s, %s, %s, %s, %s, %s \n",id, denumire, cantitate, descriere, aux1, alergeni);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_produs_cereale(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from produse_cereale where id=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_produs_cereale(int id_de_updatat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update produse_cereale set denumire=?,cantitate=?,descriere=?,contine_gluten=?,alergeni=? where id=?");
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
            System.out.print("Produsul contine gluten? (da sau nu): ");
            var2=scanner.next();
            var3= var2.toLowerCase().equals("da");
            statement.setBoolean(4,var3);
            scanner.nextLine();
            System.out.print("Introduceti alergenii: ");
            var2=scanner.nextLine();
            statement.setString(5, var2);
            statement.setInt(6, id_de_updatat);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
