package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compra;
import modelo.Livro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-20T19:42:53")
@StaticMetamodel(Compralivro.class)
public class Compralivro_ { 

    public static volatile SingularAttribute<Compralivro, Compra> compra;
    public static volatile SingularAttribute<Compralivro, Integer> qtdade;
    public static volatile SingularAttribute<Compralivro, Livro> livro;
    public static volatile SingularAttribute<Compralivro, Float> valoruni;
    public static volatile SingularAttribute<Compralivro, Integer> id;

}