package model;

import java.util.Scanner;
public class Produs {
    protected static String denumire_produs;
    protected static int cantitate_produs;
    protected static String descriere_produs;
    Scanner scanner = new Scanner(System.in);

    public void citire_produs()
    {
        System.out.print("Introduceti denumirea produsului: ");
        denumire_produs=scanner.nextLine();
        do {
            System.out.print("Introduceti cantitatea produsului(de tip int): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Va rugam introduceti o valoare de tip int! ");
                scanner.next();
            }
            cantitate_produs = scanner.nextInt();
        }while(cantitate_produs<=0);
        scanner.nextLine();
        System.out.print("Introduceti descrierea produsului: ");
        descriere_produs=scanner.nextLine();
    }

    public void afisare_produs()
    {
        System.out.println("Denumirea produsului: " + denumire_produs);
        System.out.println("Cantitatea produsului: " + cantitate_produs);
        System.out.println("Descrierea produsului: " + descriere_produs);
    }
    public Produs(String denumire_produs, int cantitate_produs, String descriere_produs)
    {
        this.denumire_produs=denumire_produs;
        this.cantitate_produs=cantitate_produs;
        this.descriere_produs=descriere_produs;
    }
    public Produs()
    {

    }

    public static String getDenumire_produs()
    {
        return denumire_produs;
    }

    public static int getCantitate_produs()
    {
        return cantitate_produs;
    }

    public static String getDescriere_produs()
    {
        return descriere_produs;
    }
    public void setDenumire_produs(String denumire_produs)
    {
        this.denumire_produs=denumire_produs;
    }
    public void setCantitate_produs(int cantitate_produs)
    {
        this.cantitate_produs=cantitate_produs;
    }
    public void setDescriere_produs(String descriere_produs)
    {
        this.descriere_produs=descriere_produs;
    }
}
