package model;

import java.util.Scanner;
public class Categorie_Carne extends Produs {
    private static boolean prelucrata;
    private static boolean tratata_chimic;
    Scanner scanner = new Scanner(System.in);
    public void citire_categorie_carne(){
        super.citire_produs();
        String aux;
        System.out.print("Produsul este prelucrat? (da sau nu)");
        aux=scanner.nextLine();
        if(aux=="da")
        {
            this.prelucrata=true;
        }
        else this.prelucrata= false;
        System.out.print("Produsul este tratat chimic? (da sau nu)");
        aux=scanner.nextLine();
        if(aux=="da")
        {
            this.tratata_chimic=true;
        }
        else this.tratata_chimic= false;

    }
    public void afisare_categorie_carne()
    {
        super.afisare_produs();
        if (this.prelucrata) {
            System.out.println("Produsul este prelucrat");
        }
        else{
            System.out.println("Produsul nu este prelucrat");
        }
        if (this.tratata_chimic) {
            System.out.println("Produsul este tratat chimic");
        }
        else{
            System.out.println("Produsul nu este tratat chimic");
        }
    }

    public Categorie_Carne(){

    }
    public Categorie_Carne(String denumire_produs, int cantitate_produs, String descriere_produs, boolean prelucrata,boolean tratata_chimic)
    {
        super(denumire_produs, cantitate_produs, descriere_produs);
        this.prelucrata=prelucrata;
        this.tratata_chimic=tratata_chimic;
    }

    public static boolean getPrelucrata()
    {
        return prelucrata;
    }
    public static boolean getTratata_chimic()
    {
        return tratata_chimic;
    }
    public void setPrelucrata(boolean prelucrata)
    {
        this.prelucrata=prelucrata;
    }
    public void setTratata_chimic(boolean tratata_chimic)
    {
        this.tratata_chimic=tratata_chimic;
    }
}


