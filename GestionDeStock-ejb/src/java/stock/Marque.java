/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ok
 */
@Entity
public class Marque implements Serializable {

    
    @Id
    private String id;
    
    private String origine;
    @OneToMany
    public List<Produit> ListeDesProduits=new ArrayList<>(); 
    
    public List<Produit> getproduits()
    {
        return ListeDesProduits;
    }
    public void add(Produit p)
    {
        ListeDesProduits.add(p);
    }
   
    
    public Marque()
    {}
    
    public Marque(String nom,String or)
    {
        this.id=nom;
        this.origine=or;
    }
    /**
     * Get the value of origine
     *
     * @return the value of origine
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Set the value of origine
     *
     * @param origine new value of origine
     */
    public void setOrigine(String origine) {
        this.origine = origine;
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
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stock.Marque[ id=" + id + " ]";
    }
    
}
