/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

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
public class ProduitFacade extends AbstractFacade<Produit> {

    @EJB
    private MarqueFacade marqueFacade;

    @PersistenceContext(unitName = "GestionDeStock-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    
    public Produit getProduit(String id)
    {
        Produit p=em.find(Produit.class,id);
        return p;
    }
    
    public boolean creer(String ref,String marque,String deno,double p,double poids,double volume)
    {
        
        Produit already=em.find(Produit.class,ref);
        
        if(already==null)
        {
        
        Produit pnew=new Produit(ref,marque,deno,p,poids,volume);
        Marque m=marqueFacade.getmarque(marque);
        pnew.setMaruqeProduit(m);
        m.add(pnew);
        em.persist(pnew);
        return true;
        }
        return false;
        
    }
    
    public boolean supprimer(String ref)
    {
        Produit pasupp=em.find(Produit.class, ref);
        
        if(pasupp!=null)
        {
            em.remove(pasupp);
            return true;
        
         }
        return false;
    }
    
    public boolean update(String ref,String marque,String deno,double p,double poids,double volume)
    {
        Produit Pupd=em.find(Produit.class,ref);
        Pupd.setDenomination(deno);
        Pupd.setPoids(poids);
        Pupd.setPrix(p);
        Pupd.setVolume(volume);
        em.merge(Pupd);
        Marque newm=marqueFacade.getmarque(marque);
        if(!newm.getId().equals(Pupd.getMaruqeProduit().getId()))
        {
            Pupd.getMaruqeProduit().getproduits().remove(Pupd);
            marqueFacade.update(Pupd.getMaruqeProduit());
            newm.add(Pupd);
            marqueFacade.update(newm);
            Pupd.setMaruqeProduit(newm);
            em.merge(Pupd);
        
        }
        
       
        
        
        return true;
    }
    
    
    public List<Produit> getAllProducts()
    {
        List<Produit> list=findAll();
        return list;
        
    }
    
}
