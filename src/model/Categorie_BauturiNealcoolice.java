package model;

import java.util.Scanner;
public class Categorie_BauturiNealcoolice extends Produs {
    private static boolean contine_indulcitori_artificiali;
    private static boolean carbogazoasa;
    private static boolean naturala;
    Scanner scanner = new Scanner(System.in);
    public void citire_categorie_bauturinealcoolice(){

        String aux;
        super.citire_produs();
        System.out.print("Produsul contine indulcitori artificiali? (da sau nu)");
        aux=scanner.nextLine();
        if(aux=="da")
        {
            this.contine_indulcitori_artificiali=true;
        }
        else this.contine_indulcitori_artificiali= false;
        System.out.print("Produsul este carbogazos? (da sau nu)");
        aux=scanner.nextLine();
        if(aux=="da")
        {
            this.carbogazoasa=true;
        }
        else this.carbogazoasa= false;
        System.out.print("Produsul este natural? (da sau nu)");
        aux=scanner.nextLine();
        if(aux=="da")
        {
            this.naturala=true;
        }
        else this.naturala= false;

    }
    public void afisare_Categorie_BauturiNealcoolice()
    {
        super.afisare_produs();
        if (this.contine_indulcitori_artificiali) {
            System.out.println("Produsul contine indulcitori artificiali");
        }
        else{
            System.out.println("Produsul nu contine indulcitori artificiali");
        }
        if (this.carbogazoasa) {
            System.out.println("Produsul este carbogazos");
        }
        else{
            System.out.println("Produsul nu este carbogazos");
        }
        if (this.naturala) {
            System.out.println("Produsul este natural");
        }
        else{
            System.out.println("Produsul nu este natural");
        }
    }

    public Categorie_BauturiNealcoolice(){

    }
    public Categorie_BauturiNealcoolice(String denumire_produs, int cantitate_produs, String descriere_produs, boolean contine_indulcitori_artificiali,boolean carbogazoasa, boolean naturala)
    {
        super(denumire_produs, cantitate_produs, descriere_produs);
        this.contine_indulcitori_artificiali=contine_indulcitori_artificiali;
        this.carbogazoasa=carbogazoasa;
        this.naturala=naturala;
    }

    public static boolean getContine_indulcitori_artificiali()
    {
        return contine_indulcitori_artificiali;
    }
    public static boolean getCarbogazoasa()
    {
        return carbogazoasa;
    }
    public static boolean getNaturala()
    {
        return naturala;
    }

    public void setContine_indulcitori_artificiali(boolean contine_indulcitori_artificiali)
    {
        this.contine_indulcitori_artificiali=contine_indulcitori_artificiali;
    }
    public void setCarbogazoasa(boolean carbogazoasa)
    {
        this.carbogazoasa=carbogazoasa;
    }
    public void setNaturala(boolean naturala)
    {
        this.naturala=naturala;
    }
}


