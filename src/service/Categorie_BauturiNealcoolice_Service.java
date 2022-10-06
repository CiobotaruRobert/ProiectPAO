package service;
import model.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Categorie_BauturiNealcoolice_Service {
    public static void addProdusBauturaNealcoolica()
    {
        Categorie_BauturiNealcoolice categorie_BauturiNealcoolice = new Categorie_BauturiNealcoolice();
        categorie_BauturiNealcoolice.citire_categorie_bauturinealcoolice();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("insert into produse_bauturi_nealcoolice (denumire,cantitate,descriere,contine_indulcitori_artificiali, carbogazoasa, naturala) values (?,?,?,?,?,?)");
            statement.setString(1, Categorie_BauturiNealcoolice.getDenumire_produs());
            statement.setInt(2, Categorie_BauturiNealcoolice.getCantitate_produs());
            statement.setString(3, Categorie_BauturiNealcoolice.getDescriere_produs());
            statement.setBoolean(4, Categorie_BauturiNealcoolice.getContine_indulcitori_artificiali());
            statement.setBoolean(5, Categorie_BauturiNealcoolice.getCarbogazoasa());
            statement.setBoolean(6, Categorie_BauturiNealcoolice.getNaturala());
            statement.execute();
        }catch(Exception e){e.printStackTrace();}
    }
    public static void afisare_produse_bauturinealcoolice()
    {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from produse_bauturi_nealcoolice");
            ResultSet rs = statement.executeQuery();
            String aux1,aux2,aux3;
            if(!rs.isBeforeFirst()) System.out.println("***NU MAI SUNT PRODUSE IN TABELUL BAUTURI NEALCOOLICE***");
            else {System.out.println("***PRODUSE BAUTURI NEALCOOLICE***");

                System.out.println("Id, denumire, cantitate, descriere, contine_indulcitori_artificiali, carbogazoasa, naturala");}
            while(rs.next())
            {
                int id = rs.getInt("id");
                String denumire = rs.getString("denumire");
                int cantitate = rs.getInt("cantitate");
                String descriere = rs.getString("descriere");
                boolean contine_indulcitori_artificiali = rs.getBoolean("contine_indulcitori_artificiali");
                boolean carbogazoasa = rs.getBoolean("carbogazoasa");
                boolean naturala = rs.getBoolean("naturala");
                if(contine_indulcitori_artificiali) aux1="Contine indulcitori artificiali";
                else aux1="Nu contine indulcitori artificiali";
                if(carbogazoasa) aux2="Este carbogazoasa";
                else aux2="Nu este carbogazoasa";
                if(naturala) aux3="Este naturala";
                else aux3="Nu este naturala";
                System.out.format("%s, %s, %s, %s, %s, %s, %s \n", id, denumire, cantitate, descriere, aux1, aux2, aux3);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stergere_produs_bauturanealcoolica(int id_de_sters) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("delete from produse_bauturi_nealcoolice where id=?");
            statement.setInt(1, id_de_sters);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizeaza_produs_bauturanealcoolica(int id_de_updatat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectpao", "root", "root");
            PreparedStatement statement = connection.prepareStatement("update produse_bauturi_nealcoolice set denumire=?,cantitate=?,descriere=?,contine_indulcitori_artificiali=?,carbogazoasa=?, naturala=? where id=?");
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
            System.out.print("Produsul contine indulcitori artificiali? (da sau nu): ");
            var2=scanner.next();
            var3= var2.toLowerCase().equals("da");
            statement.setBoolean(4, var3);
            System.out.print("Produs carbogazos? (da sau nu): ");
            var2=scanner.next();
            var3= var2.toLowerCase().equals("da");
            statement.setBoolean(5, var3);
            System.out.print("Produs natural? (da sau nu): ");
            var2=scanner.next();
            var3= var2.toLowerCase().equals("da");
            statement.setBoolean(6, var3);
            statement.setInt(7, id_de_updatat);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
