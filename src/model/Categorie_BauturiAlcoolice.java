package model;

import java.util.Scanner;
public class Categorie_BauturiAlcoolice extends Produs {
    private String plante_provenienta;
    private double procentaj_alcool;
    Scanner scanner = new Scanner(System.in);
    public void citire_Categorie_BauturiAlcoolice(){
        String aux;
        super.citire_produs();
        System.out.print("Introduceti plantele din care provine bautura: ");
        plante_provenienta=scanner.nextLine();
        do {
            System.out.print("Introduceti procentajul de alcool(tip double): ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Va rugam introduceti o valoare de tip double! ");
                scanner.next();
            }
            procentaj_alcool = scanner.nextDouble();
        }while(procentaj_alcool<=0);
    }
    public void afisare_Categorie_BauturiAlcoolice()
    {
        super.afisare_produs();
        System.out.println("Plante de provenienta: " + plante_provenienta);
        System.out.println("Procentaj de alcool: " + procentaj_alcool);
    }

    public Categorie_BauturiAlcoolice(){

    }
    public Categorie_BauturiAlcoolice(String denumire_produs, int cantitate_produs, String descriere_produs, String plante_provenienta, double procentaj_alcool)
    {
        super(denumire_produs, cantitate_produs, descriere_produs);
        this.plante_provenienta=plante_provenienta;
        this.procentaj_alcool=procentaj_alcool;
    }

    public String getPlante_provenienta()
    {
        return plante_provenienta;
    }
    public double getProcentaj_alcool()
    {
        return procentaj_alcool;
    }

    public void setPlante_provenienta(String plante_provenienta)
    {
        this.plante_provenienta=plante_provenienta;
    }
    public void setProcentaj_alcool(double procentaj_alcool)
    {
        this.procentaj_alcool=procentaj_alcool;
    }

}


