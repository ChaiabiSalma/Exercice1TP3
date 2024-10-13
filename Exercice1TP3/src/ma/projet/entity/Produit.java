
package ma.projet.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="produit") // Spécifie le nom de la table dans la base de données
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="marque")
    private String marque;
    @Column(name="reference", unique=true)
    private String reference;
    @Column(name="date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    @Column(name="prix")
    private double prix;
    @Column(name="designation")
    private String designation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Produit(int id, String marque, String reference, Date dateAchat, double prix, String designation) {
        this.id = id;
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
    }

    public Produit(String marque, String reference, Date dateAchat, double prix, String designation) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
    }

    public Produit() {
    }
    
}
