package stock;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import stock.Marque;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-06-20T18:47:19")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Double> volume;
    public static volatile SingularAttribute<Produit, Double> prix;
    public static volatile SingularAttribute<Produit, Double> poids;
    public static volatile SingularAttribute<Produit, String> id;
    public static volatile SingularAttribute<Produit, Marque> maruqeProduit;
    public static volatile SingularAttribute<Produit, String> denomination;

}