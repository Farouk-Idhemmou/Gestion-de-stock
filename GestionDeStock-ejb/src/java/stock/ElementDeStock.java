/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.io.Serializable;

/**
 *
 * @author ok
 */
public class ElementDeStock implements Serializable {
    
    private String referenceProduit;
    
    private int Quantite;

    public ElementDeStock()
    {
        
    }
    public ElementDeStock(String ref,int q)
    {
        referenceProduit=ref;
        Quantite=q;
    }
    /**
     * Get the value of Quantite
     *
     * @return the value of Quantite
     */
    public int getQuantite() {
        return Quantite;
    }

    /**
     * Set the value of Quantite
     *
     * @param Quantite new value of Quantite
     */
    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }


    /**
     * Get the value of referenceProduit
     *
     * @return the value of referenceProduit
     */
    public String getReferenceProduit() {
        return referenceProduit;
    }

    /**
     * Set the value of referenceProduit
     *
     * @param referenceProduit new value of referenceProduit
     */
    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    
}
