package model;

public class Distribuitor_Import extends Distribuitor {
    private String cod_EORI;
    private String certificat_origine;
    //String alte_taxe;

    public void citire_distribuitor_import()
    {
        super.citire_distribuitor();
        System.out.print("Introduceti codul EORI: ");
        cod_EORI = scanner.nextLine();
        System.out.print("Introduceti certificat de origine: ");
        certificat_origine = scanner.nextLine();
    }
    public void afisare_distribuitor_import()
    {
        super.afisare_distribuitor();
        System.out.print("Codul EORI: " + cod_EORI);
        System.out.print("Certificat de origine: " + certificat_origine);
    }
    public Distribuitor_Import()
    {

    }
    Distribuitor_Import(String denumire_distribuitor, String adresa, String cod_postal, String numar_telefon, String cod_EORI, String certificat_origine)
    {
        super(denumire_distribuitor,adresa,cod_postal,numar_telefon);
        this.cod_EORI=cod_EORI;
        this.certificat_origine=certificat_origine;
    }

    public String getCod_EORI()
    {
        return this.cod_EORI;
    }
    public String getCertificat_origine()
    {
        return this.certificat_origine;
    }
    public void setCod_EORI(String cod_EORI)
    {
        this.cod_EORI=cod_EORI;
    }
    public void setCertificat_origine(String certificat_origine)
    {
        this.certificat_origine=certificat_origine;
    }


}
