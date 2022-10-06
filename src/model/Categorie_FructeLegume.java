package model;

import java.util.Scanner;

public class Categorie_FructeLegume extends Produs {
    private boolean bio;
    private boolean romanesc;
    Scanner scanner = new Scanner(System.in);
    public void citire_categorie_fructelegume()
    {
        String aux;
        super.citire_produs();
        System.out.print("Produsul este bio? (Da sau Nu) : ");
        aux=scanner.nextLine();
        bio= aux.toLowerCase().equals("da");
        System.out.print("Produsul este romanesc? (Da sau Nu) : ");
        aux=scanner.nextLine();
        romanesc= aux.toLowerCase().equals("da");
    }
    public void afisare_categorie_fructelegume()
    {
        super.afisare_produs();
        if (this.bio) {
            System.out.println("Produs bio: Da");
        }
        else
        {
            System.out.println("Produs bio: Nu");
        }
        if (this.romanesc) {
            System.out.println("Produs romanesc: Da");
        }
        else
        {
            System.out.println("Produs romanesc: Nu");
        }
    }

    public Categorie_FructeLegume(String denumire_produs,int cantitate_produs,String descriere_produs,boolean bio, boolean romanesc)
    {
        super(denumire_produs, cantitate_produs, descriere_produs);
        this.bio=bio;
        this.romanesc=romanesc;
    }
    public Categorie_FructeLegume()
    {

    }

    public boolean getBio()
    {
        return bio;
    }
    public void setBio(boolean bio)
    {
        this.bio=bio;
    }

    public boolean getRomanesc()
    {
        return romanesc;
    }
    public void setRomanesc(boolean romanesc)
    {
        this.romanesc=romanesc;
    }


}
