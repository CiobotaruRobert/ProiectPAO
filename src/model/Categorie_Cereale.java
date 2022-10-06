package model;

import java.util.Scanner;
public class Categorie_Cereale extends Produs {
    private boolean contine_gluten;
    private String alergeni;
    Scanner scanner = new Scanner(System.in);
    public void citire_categorie_cereale(){
        String aux;
        super.citire_produs();
        System.out.print("Produsul contine gluten? (da sau nu)");
        aux=scanner.nextLine();
        if(aux=="da")
        {
            this.contine_gluten=true;
        }
        else this.contine_gluten= false;
        System.out.print("Introduceti alergenii: ");
        alergeni=scanner.nextLine();

    }
public void afisare_categorie_cereale()
    {
        super.afisare_produs();
        if (this.contine_gluten) {
            System.out.println("Contine gluten");
        }
        else{
            System.out.println("Nu contine gluten");
            }
        System.out.println("Lista alergeni: " +alergeni);
    }

    public Categorie_Cereale(){

    }
    public Categorie_Cereale(String denumire_produs, int cantitate_produs, String descriere_produs, boolean contine_gluten, String alergeni)
    {
        super(denumire_produs, cantitate_produs, descriere_produs);
        this.contine_gluten=contine_gluten;
        this.alergeni=alergeni;
    }

    public boolean getContine_gluten()
    {
        return contine_gluten;
    }
    public String getAlergeni()
    {
        return alergeni;
    }
    public void setContine_gluten(boolean contine_gluten)
    {
        this.contine_gluten=contine_gluten;
    }
    public void setAlergeni(String alergeni)
    {
        this.alergeni=alergeni;
    }
    }


