/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ok
 */
@Entity
public class Stock implements Serializable {
    @Id
   
    private String id;

    private ListeDeStock listestock=new ListeDeStock(new ArrayList<ElementDeStock>());

    public Stock()
    {}
    
    public Stock(String nom)
    {
        id=nom;
    }
    public ListeDeStock getListestock() {
        return listestock;
    }

    public void setListestock(ListeDeStock listestock) {
        this.listestock = listestock;
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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stock.Stock[ id=" + id + " ]";
    }
    
}
