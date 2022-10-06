package service;
import model.Categorie_Carne;
import model.Categorie_FructeLegume;
import model.Categorie_Lactate;
import model.Produs;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Categorie_Carne_Service {
    public static void addProdusCarne()
    {
        Categorie_Carne categorie_Carne = new Categorie_Carne();
        categorie_Carne.citire_categorie_carne();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into produse_carne (denumire,cantitate,descriere,prelucrata, tratata_chimic) values (?,?,?,?,?)");
            statement.setString(1, Categorie_Carne.getDenumire_produs());
            statement.setInt(2, Categorie_Carne.getCantitate_produs());
            statement.setString(3, Categorie_Carne.getDescriere_produs());
            statement.setBoolean(4, Categorie_Carne.getPrelucrata());
            statement.setBoolean(5, Categorie_Carne.getTratata_chimic());
            statement.execute();
        }catch(Exception e){e.printStackTrace();}
    }
    public static void afisare_produse_carne()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from produse_carne");
            ResultSet rs = statement.executeQuery();
            String aux1,aux2;
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT PRODUSE IN TABELUL CARNE***");
            else {System.out.println("***PRODUSE DIN CARNE***");

                System.out.println("Id, denumire, cantitate, descriere, prelucrata, tratata_chimic");}
            while(rs.next())
            {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                String descriere = rs.getString("descriere");
                boolean prelucrata = rs.getBoolean("prelucrata");
                boolean tratata_chimic = rs.getBoolean("tratata_chimic");
                if(prelucrata) aux1="Este prelucrata";
                else aux1="Nu este prelucrata";
                if(tratata_chimic) aux2="Este tratata chimic";
                else aux2="Nu este tratata chimic";
                System.out.format("%s, %s, %s, %s, %s, %s \n", id, denumire, cantitate, descriere, aux1, aux2);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_produs_carne(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from produse_carne where id=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_produs_carne(int id_de_updatat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update produse_carne set denumire=?,cantitate=?,descriere=?,prelucrata=?,tratata_chimic=? where id=?");
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
            System.out.print("Produs prelucrat? (da sau nu): ");
            var2=scanner.next();
            var3= var2.toLowerCase().equals("da");
            statement.setBoolean(4, var3);
            System.out.print("Produs tratat chimic? (da sau nu): ");
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
