/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ok
 */
@Stateless
public class MarqueFacade extends AbstractFacade<Marque> {

    @EJB
    private ProduitFacade produitFacade;

    @PersistenceContext(unitName = "GestionDeStock-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarqueFacade() {
        super(Marque.class);
    }

    public Marque getmarque(String ref)
    {
        Marque m=em.find(Marque.class, ref);
        return m;
    }
    public boolean Creer(String nom, String origin) {
        
        Marque in=em.find(Marque.class, nom);
        
        if (in==null)
        {
            Marque  m=new  Marque(nom,origin);
        em.persist(m);
        return true;
        }
        
        return false;
    }
    public void update(Marque m)
    {
        em.merge(m);
   }
     public void delete(Produit p,Marque m)
    {
        m.getproduits().remove(p);
    }
     public void empty(Marque m)
     {
         for(int i=0;i<m.getproduits().size();i++)
         {
             Produit p=m.getproduits().get(i);
             m.getproduits().remove(p);
             update(m);
             produitFacade.remove(p);
             
         }
         
     }

    public boolean supprimer(String reference) {
        
        Marque in=em.find(Marque.class, reference);
        
        if (in==null)
        {
            return false;
        }
        
        em.remove(in);
        return true;
    }
    public List<Produit> lister(String ref)
    {
        Marque m=em.find(Marque.class, ref);
        
        return m.getproduits();
    }

    public void ajouterProduit(String ref,Produit p) {
        
        Marque m=em.find(Marque.class,ref);
        
        if (m!=null)
        {
            m.add(p);
            em.merge(m);
        }
    }
    public List<Marque> getAllMarques()
    {
        List<Marque> marques=findAll();
        return marques;
    
    }
    
    
    
    
}
