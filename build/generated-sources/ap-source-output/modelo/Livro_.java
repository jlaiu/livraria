package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Autor;
import modelo.Categoria;
import modelo.Compralivro;
import modelo.Editora;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-20T19:42:53")
@StaticMetamodel(Livro.class)
public class Livro_ { 

    public static volatile SingularAttribute<Livro, Float> preco;
    public static volatile SingularAttribute<Livro, String> sinopse;
    public static volatile ListAttribute<Livro, Compralivro> compraLivroList;
    public static volatile SingularAttribute<Livro, String> imagem3;
    public static volatile SingularAttribute<Livro, String> imagem2;
    public static volatile SingularAttribute<Livro, Categoria> categoria;
    public static volatile SingularAttribute<Livro, String> nome;
    public static volatile SingularAttribute<Livro, String> imagem1;
    public static volatile SingularAttribute<Livro, Integer> id;
    public static volatile SingularAttribute<Livro, Date> datapublicacao;
    public static volatile SingularAttribute<Livro, Editora> editora;
    public static volatile ListAttribute<Livro, Autor> autorList;

}