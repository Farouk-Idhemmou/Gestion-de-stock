/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ok
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> {

    @PersistenceContext(unitName = "GestionDeStock-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }

    public boolean creer(String nom) {
        
        Stock s=em.find(Stock.class, nom);
        if (s==null)
        {
            Stock newStock=new Stock(nom);
            em.persist(newStock);
            return true;
        }
        return false;
    }
    public void addToStock(String nomstock,String refProduit,int quantite)
    {
        Stock s=em.find(Stock.class, nomstock);
        ElementDeStock newE=new ElementDeStock(refProduit,quantite);
        
        s.getListestock().getListeStock().add(newE);
        
        em.merge(s);
    }
    public void changeElementStock(String nomstock,String refProduit,int quantite)
    {
        Stock s=em.find(Stock.class, nomstock);
        int j=0;
        for(int i=0;i<s.getListestock().getListeStock().size();i++)
        {
            if (s.getListestock().getListeStock().get(i).getReferenceProduit().equals(refProduit))
            {
                j=i;
            }
        }
        s.getListestock().getListeStock().get(j).setQuantite(quantite);
        
        em.merge(s);
    }
    public ListeDeStock getlistestock(String nom)
            
    {
        Stock s=em.find(Stock.class, nom);
        return s.getListestock();
        
        
    }
    
    
}
