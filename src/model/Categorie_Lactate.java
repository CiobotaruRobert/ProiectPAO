package model;

import java.util.Scanner;

public class Categorie_Lactate extends Produs {
    private double procentaj_grasime;
    Scanner scanner = new Scanner(System.in);
    public void citire_categorie_lactate()
    {
        super.citire_produs();
        do {
            System.out.print("Introduceti procentajul de grasime(tip double): ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Va rugam introduceti o valoare de tip double! ");
                scanner.next();
            }
            procentaj_grasime = scanner.nextDouble();
        }while(procentaj_grasime<=0);
    }
    public void afisare_categorie_lactate()
    {
        super.afisare_produs();
        System.out.println("Procentaj grasime al produsului: " + procentaj_grasime);
    }
    public Categorie_Lactate(String denumire_produs,int cantitate_produs,String descriere_produs,double procentaj_grasime)
    {
        super(denumire_produs, cantitate_produs, descriere_produs);
        this.procentaj_grasime=procentaj_grasime;
    }
    public Categorie_Lactate()
    {

    }

    public double getProcentaj_grasime()
    {
        return procentaj_grasime;
    }
    public void setProcentaj_grasime(double procentaj_grasime)
    {
        this.procentaj_grasime=procentaj_grasime;
    }

}
