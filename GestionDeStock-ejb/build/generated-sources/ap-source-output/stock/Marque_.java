package stock;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import stock.Produit;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-06-20T18:47:19")
@StaticMetamodel(Marque.class)
public class Marque_ { 

    public static volatile ListAttribute<Marque, Produit> ListeDesProduits;
    public static volatile SingularAttribute<Marque, String> id;
    public static volatile SingularAttribute<Marque, String> origine;

}