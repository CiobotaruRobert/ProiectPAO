package service;

import model.Categorie_BauturiAlcoolice;
import model.Categorie_Carne;
import model.Categorie_Cereale;

import java.util.Scanner;

public class SystemService {

    public static void meniu_aplicatie()

    {

        Scanner scanner = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n ***Gestiune stocuri magazin***");
            System.out.println("1. Afiseaza toate produsele si detalii");
            System.out.println("2. Afiseaza toate produsele lactate");
            System.out.println("3. Afiseaza toate produsele cereale");
            System.out.println("4. Afiseaza toate produsele fructe si legume");
            System.out.println("5. Afiseaza toate produsele din carne");
            System.out.println("6. Afiseaza toate bauturile nealcoolice");
            System.out.println("7. Afiseaza toate bauturile alcoolice");
            System.out.println("8. Afiseaza toti distribuitorii interni");
            System.out.println("9. Afiseaza toti distribuitorii straini");
            System.out.println("10. Insereaza produs lactat");
            System.out.println("11. Insereaza un fruct sau o leguma");
            System.out.println("12. Insereaza cereale");
            System.out.println("13. Insereaza un produs din carne");
            System.out.println("14. Insereaza o bautura nealcoolica");
            System.out.println("15. Insereaza o bautura alcoolica");
            System.out.println("16. Insereaza distribuitor intern");
            System.out.println("17. Insereaza distribuitor strain");
            System.out.println("18. Sterge un produs lactat");
            System.out.println("19. Sterge un produs din categoria fructe si legume");
            System.out.println("20. Sterge un produs din categoria cereale");
            System.out.println("21. Sterge un produs din categoria carne");
            System.out.println("22. Sterge un produs din categoria bauturi nealcoolice");
            System.out.println("23. Sterge un produs din categoria bauturi alcoolice");
            System.out.println("24. Sterge un distribuitor intern");
            System.out.println("25. Sterge un distribuitor strain");
            System.out.println("26. Actualizeaza un produs din categoria lactate");
            System.out.println("27. Actualizeaza un produs din categoria fructe si legume");
            System.out.println("28. Actualizeaza un produs din categoria cereale");
            System.out.println("29. Actualizeaza un produs din categoria carne");
            System.out.println("30. Actualizeaza un produs din categoria bauturi nealcoolice");
            System.out.println("31. Actualizeaza un produs din categoria bauturi alcoolice");
            System.out.println("32. Actualizeaza un distribuitor intern");
            System.out.println("33. Actualizeaza un distribuitor strain");
            System.out.println("99. Iesire");
            int id_aux;
            ch = scanner.nextInt();
            switch (ch) {

                case 1:
                    ProduseService.afisare_produse();
                    AuditService.write_logs("Afisarea tuturor produselor");
                    break;
                case 2:
                    Categorie_Lactate_Service.afisare_produse_lactate();
                    AuditService.write_logs("Afisare produse lactate");
                    break;
                case 3:
                    Categorie_Cereale_Service.afisare_produse_cereale();
                    AuditService.write_logs("Afisare produse cereale");
                    break;
                case 4:
                    Categorie_FructeLegume_Service.afisare_produse_fructelegume();
                    AuditService.write_logs("Afisarea fructelor si legumelor");
                    break;
                case 5:
                    Categorie_Carne_Service.afisare_produse_carne();
                    AuditService.write_logs("Afisarea produselor din carne");
                    break;
                case 6:
                    Categorie_BauturiNealcoolice_Service.afisare_produse_bauturinealcoolice();
                    AuditService.write_logs("Afisarea bauturilor nealcoolice");
                    break;
                case 7:
                    Categorie_BauturiAlcoolice_Service.afisare_produse_bauturialcoolice();
                    AuditService.write_logs("Afisarea bauturilor alcoolice");
                    break;
                case 8:
                    DistribuitorService.afiseaza_distribuitori();
                    AuditService.write_logs("Afisarea distribuitorilor");
                    break;
                case 9:
                    Distribuitor_Import_Service.afiseaza_distribuitori_import();
                    AuditService.write_logs("Afisarea distribuitorilor straini");
                    break;
                case 10:
                    Categorie_Lactate_Service.addProdusLactat();
                    AuditService.write_logs("Adaugare produs lactat in baza de date");
                    break;
                case 11:
                    Categorie_FructeLegume_Service.addProdusFructeLegume();
                    AuditService.write_logs("Adaugare fruct sau leguma in baza de date");
                    break;
                case 12:
                    Categorie_Cereale_Service.addProdusCereale();
                    AuditService.write_logs("Adaugare cereale in baza de date");
                    break;
                case 13:
                    Categorie_Carne_Service.addProdusCarne();
                    AuditService.write_logs("Adaugare produs din carne in baza de date");
                    break;
                case 14:
                    Categorie_BauturiNealcoolice_Service.addProdusBauturaNealcoolica();
                    AuditService.write_logs("Adaugare bautura nealcoolica in baza de date");
                    break;
                case 15:
                    Categorie_BauturiAlcoolice_Service.addProdusBauturaAloolica();
                    AuditService.write_logs("Adaugare bautura alcoolica in baza de date");
                    break;
                case 16:
                    DistribuitorService.addDistribuitor();
                    AuditService.write_logs("Adaugare distribuitor intern in baza de date");
                    break;
                case 17:
                    Distribuitor_Import_Service.addDistribuitor_Import();
                    AuditService.write_logs("Adaugare distribuitor strain in baza de date");
                    break;
                case 18:
                    Categorie_Lactate_Service.afisare_produse_lactate();
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    Categorie_Lactate_Service.stergere_produs_lactat(id_aux);
                    AuditService.write_logs("Stergere produs din categoria lactate");
                    break;
                case 19:
                    Categorie_FructeLegume_Service.afisare_produse_fructelegume();
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    Categorie_FructeLegume_Service.stergere_produs_fructelegume(id_aux);
                    AuditService.write_logs("Stergere produs din categoria fructe si legume");
                    break;
                case 20:
                    Categorie_Cereale_Service.afisare_produse_cereale();
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    Categorie_Cereale_Service.stergere_produs_cereale(id_aux);
                    AuditService.write_logs("Stergere produs din categoria cereale");
                    break;
                case 21:
                    Categorie_Carne_Service.afisare_produse_carne();
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    Categorie_Carne_Service.stergere_produs_carne(id_aux);
                    AuditService.write_logs("Stergere produs din categoria carne");
                    break;
                case 22:
                    Categorie_BauturiNealcoolice_Service.afisare_produse_bauturinealcoolice();
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    Categorie_BauturiNealcoolice_Service.stergere_produs_bauturanealcoolica(id_aux);
                    AuditService.write_logs("Stergere produs din categoria bauturi nealcoolice");
                    break;
                case 23:
                    Categorie_BauturiAlcoolice_Service.afisare_produse_bauturialcoolice();
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    Categorie_BauturiAlcoolice_Service.stergere_produs_bauturialcoolice(id_aux);
                    AuditService.write_logs("Stergere produs din categoria bauturi alcoolice");
                    break;
                case 24:
                    DistribuitorService.afiseaza_distribuitori();
                    System.out.print("Introduceti id-ul distribuitorului pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    DistribuitorService.stergere_distribuitor(id_aux);
                    AuditService.write_logs("Stergere distribuitor intern");
                    break;
                case 25:
                    Distribuitor_Import_Service.afiseaza_distribuitori_import();
                    System.out.print("Introduceti id-ul distribuitorului strain pe care doriti sa il stergeti:");
                    id_aux=scanner.nextInt();
                    Distribuitor_Import_Service.stergere_distribuitor_import(id_aux);
                    AuditService.write_logs("Stergere distribuitor strain");
                    break;
                case 26:
                    Categorie_Lactate_Service.afisare_produse_lactate();
                    if (ProduseService.nullCheck("produse_lactate")!=0) {
                        System.out.print("Introduceti id-ul produsului pe care doriti sa il modificati:");
                        id_aux = scanner.nextInt();
                        Categorie_Lactate_Service.actualizeaza_produs_lactat(id_aux);
                        AuditService.write_logs("Update produs din categoria lactate");
                    }
                    else{
                        System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;
                case 27:
                    Categorie_FructeLegume_Service.afisare_produse_fructelegume();
                    if (ProduseService.nullCheck("produse_fructe_legume")!=0) {
                        System.out.print("Introduceti id-ul produsului pe care doriti sa il modificati:");
                        id_aux = scanner.nextInt();
                        Categorie_FructeLegume_Service.actualizeaza_produs_fructelegume(id_aux);
                        AuditService.write_logs("Update produs din categoria fructe si legume");
                    }else{
                            System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;
                case 28:
                    Categorie_Cereale_Service.afisare_produse_cereale();
                    if (ProduseService.nullCheck("produse_cereale")!=0) {
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il modificati:");
                    id_aux=scanner.nextInt();
                    Categorie_Cereale_Service.actualizeaza_produs_cereale(id_aux);
                    AuditService.write_logs("Update produs din categoria cereale");
                    }else{
                        System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;
                case 29:
                    Categorie_Carne_Service.afisare_produse_carne();
                    if (ProduseService.nullCheck("produse_carne")!=0) {
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il modificati:");
                    id_aux=scanner.nextInt();
                    Categorie_Carne_Service.actualizeaza_produs_carne(id_aux);
                    AuditService.write_logs("Update produs din categoria carne");
                    }else{
                        System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;
                case 30:
                    Categorie_BauturiNealcoolice_Service.afisare_produse_bauturinealcoolice();
                    if (ProduseService.nullCheck("produse_bauturi_nealcoolice")!=0) {
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il modificati:");
                    id_aux=scanner.nextInt();
                    Categorie_BauturiNealcoolice_Service.actualizeaza_produs_bauturanealcoolica(id_aux);
                    AuditService.write_logs("Update produs din categoria bauturi nealcoolice");
                    }else{
                        System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;
                case 31:
                    Categorie_BauturiAlcoolice_Service.afisare_produse_bauturialcoolice();
                    if (ProduseService.nullCheck("produse_bauturi_alcoolice")!=0) {
                    System.out.print("Introduceti id-ul produsului pe care doriti sa il modificati:");
                    id_aux=scanner.nextInt();
                    Categorie_BauturiAlcoolice_Service.actualizeaza_produs_bauturialcoolice(id_aux);
                    AuditService.write_logs("Update produs din categoria bauturi alcoolice");
                    }else{
                        System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;
                    case 32:
                    DistribuitorService.afiseaza_distribuitori();
                    if (ProduseService.nullCheck("distribuitor")!=0) {
                    System.out.print("Introduceti id-ul distribuitorului pe care doriti sa il modificati:");
                    id_aux=scanner.nextInt();
                    DistribuitorService.actualizeaza_distribuitor(id_aux);
                    AuditService.write_logs("Update distribuitor intern");
                    }else{
                        System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;
                case 33:
                    Distribuitor_Import_Service.afiseaza_distribuitori_import();
                    if (ProduseService.nullCheck("distribuitor_import")!=0) {
                    System.out.print("Introduceti id-ul distribuitorului pe care doriti sa il modificati:");
                    id_aux=scanner.nextInt();
                    Distribuitor_Import_Service.actualizeaza_distribuitor_import(id_aux);
                    AuditService.write_logs("Update distribuitor strain");
                    }else{
                        System.out.println("Nu puteti actualiza un tabel gol!");}
                    break;

            }
        }
        while (ch != 99);
    }
}
