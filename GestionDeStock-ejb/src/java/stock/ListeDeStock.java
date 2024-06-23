/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ok
 */
public class ListeDeStock implements Serializable{
    private List<ElementDeStock> listeStock=new ArrayList<>();

    
    public ListeDeStock()
    {}
    
    public ListeDeStock(List<ElementDeStock> l)
    {
        listeStock=l;
    }
    
    
    public List<ElementDeStock> getListeStock() {
        return listeStock;
    }

    public void setListeStock(List<ElementDeStock> listeStock) {
        this.listeStock = listeStock;
    }
    
    
    
}
