package model;

import java.util.Scanner;
public class Distribuitor {
    protected String denumire_distribuitor;
    protected String adresa;
    protected String cod_postal;
    protected String numar_telefon;
    Scanner scanner = new Scanner(System.in);
public Distribuitor()
{

}

public void citire_distribuitor()
{
    System.out.print("Introduceti numele distribuitorului: ");
    denumire_distribuitor = scanner.nextLine();
    System.out.print("Introduceti adresa distribuitorului: ");
    adresa=scanner.nextLine();
    System.out.print("Introduceti codul postal al distribuitorului: ");
    cod_postal=scanner.nextLine();
    System.out.print("Introduceti numarul de telefon al distribuitorului: ");
    numar_telefon=scanner.nextLine();

}
public void afisare_distribuitor()
{
    System.out.println("Nume distribuitor: " + denumire_distribuitor);
    System.out.println("Adresa distribuitor: " + adresa);
    System.out.println("Cod postal distribuitor: " + cod_postal);
    System.out.println("Numar telefon distribuitor: " + numar_telefon);
}

    public Distribuitor(String denumire_distribuitor, String adresa, String cod_postal, String numar_telefon)
    {
        this.denumire_distribuitor=denumire_distribuitor;
        this.adresa=adresa;
        this.cod_postal=cod_postal;
        this.numar_telefon=numar_telefon;

    }


    public String getDenumire_distribuitor()
    {
        return denumire_distribuitor;
    }

    public String getAdresa()
    {
        return adresa;
    }

    public String getCod_postal()
    {
        return cod_postal;
    }
    public String getNumar_telefon()
    {
        return numar_telefon;
    }

    public void setDenumire_distribuitor(String denumire_distribuitor)
    {
        this.denumire_distribuitor=denumire_distribuitor;
    }
    public void setAdresa(String adresa)
    {
        this.adresa=adresa;
    }
    public void setCod_postal(String cod_postal)
    {
        this.cod_postal=cod_postal;
    }
    public void setNumar_telefon(String numar_telefon)
    {
        this.numar_telefon=numar_telefon;
    }



}

