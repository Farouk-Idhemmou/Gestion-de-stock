/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import  javax.persistence.ManyToOne;

/**
 *
 * @author ok
 */
@Entity
public class Produit implements Serializable {

    
    @Id
    private String id;
    @ManyToOne
    private Marque maruqeProduit;

    /**
     * Get the value of maruqeProduit
     *
     * @return the value of maruqeProduit
     */
    public Marque getMaruqeProduit() {
        return maruqeProduit;
    }

    /**
     * Set the value of maruqeProduit
     *
     * @param maruqeProduit new value of maruqeProduit
     */
    public void setMaruqeProduit(Marque maruqeProduit) {
        this.maruqeProduit = maruqeProduit;
    }

    
    private String denomination;
    
    private double prix;
    
    private double poids;
    
    private double volume;

    public Produit()
    {}
    
    public Produit(String ref,String marque,String deno,double p,double poids,double volume)
    {
        this.id=ref;
        this.denomination=deno;
        this.prix=p;
        this.poids=poids;
        this.volume=volume;
    }
    /**
     * Get the value of volume
     *
     * @return the value of volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Set the value of volume
     *
     * @param volume new value of volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }


    /**
     * Get the value of poids
     *
     * @return the value of poids
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Set the value of poids
     *
     * @param poids new value of poids
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }


    /**
     * Get the value of prix
     *
     * @return the value of prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Set the value of prix
     *
     * @param prix new value of prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }


    /**
     * Get the value of denomination
     *
     * @return the value of denomination
     */
    public String getDenomination() {
        return denomination;
    }

    /**
     * Set the value of denomination
     *
     * @param denomination new value of denomination
     */
    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stock.Produit[ id=" + id + " ]";
    }
    
}
