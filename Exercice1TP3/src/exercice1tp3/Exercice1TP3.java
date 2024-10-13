package exercice1tp3;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;

public class Exercice1TP3 {
    public static void main(String[] args) throws ParseException {
        HibernateUtil.getSessionFactory().openSession();
        
        ProduitService ps= new ProduitService();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

        Produit p1 = new Produit("Marque1","Ref1",sdf.parse("10/01/2022"),150.0,"Produit 1");
        Produit p2 = new Produit("Marque2","Ref2",sdf.parse("15/02/2022"),80.0,"Produit 2");
        Produit p3 = new Produit("Marque3", "Ref3", sdf.parse("20/03/2022"), 200.0, "Produit 3");
        Produit p4 = new Produit("Marque4", "Ref4", sdf.parse("25/04/2022"), 50.0, "Produit 4");
        Produit p5 = new Produit("Marque5", "Ref5", sdf.parse("30/05/2022"), 120.0, "Produit 5");
        
        ps.create(p1);
        ps.create(p2);
        ps.create(p3);
        ps.create(p4);
        ps.create(p5);
        
        System.out.println("Liste des produits: ");
        List<Produit> produits=ps.findAll();
        for(Produit p:produits){
            System.out.println(p);
        }
        
        System.out.println("\nProduit 2: ");
        Produit Pid2=ps.findById(2);
        if(Pid2 != null){
            System.out.println(Pid2);
        } else {
            System.out.println("Produit avec ID 2 introuvable.");
        }
        
        System.out.println("Suppression de produit 3 ");
        Produit Pid3=ps.findById(3);
        if(Pid3 != null){
            ps.delete(Pid3);
            System.out.println("Produit supprimé.");
        } else {
            System.out.println("Produit 3 introuvable.");
        }
        
        System.out.println("Modifaction de produit 1");
        Produit Pid1=ps.findById(1);
        if(Pid1 != null){
            Pid1.setMarque("Marque UNE");
            Pid1.setPrix(32.0);
            ps.update(Pid1);
            System.out.println("Nouvelle modification : "+Pid1);
        } else {
            System.out.println("Produit avec ID 1 introuvable.");
        }
        System.out.println("\nLes produits dont le prix est supérieur à 100 DH:");
        for (Produit p : produits) {
            if (p.getPrix() > 100.0) {
                System.out.println(p);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEntrez la date de début (dd/MM/yyyy): ");
        String DD = scanner.nextLine();
        Date dD = sdf.parse(DD);

        System.out.print("Entrez la date de fin (dd/MM/yyyy): ");
        String DF = scanner.nextLine();
        Date dF = sdf.parse(DF);

        System.out.println("\nLes produits commandés entre " + DD + " et " + DF + ":");
        for (Produit p : produits) {
            if (p.getDateAchat().after(dD) && p.getDateAchat().before(dF)) {
                System.out.println(p);
            }
        }

        scanner.close();
    }
    
}
