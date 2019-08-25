/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author junut
 */
@Entity
@Table(name = "compralivro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compralivro.findAll", query = "SELECT c FROM Compralivro c"),
    @NamedQuery(name = "Compralivro.findById", query = "SELECT c FROM Compralivro c WHERE c.id = :id"),
    @NamedQuery(name = "Compralivro.findByQtdade", query = "SELECT c FROM Compralivro c WHERE c.qtdade = :qtdade"),
    @NamedQuery(name = "Compralivro.findByValoruni", query = "SELECT c FROM Compralivro c WHERE c.valoruni = :valoruni")})
public class Compralivro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qtdade")
    private Integer qtdade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valoruni")
    private Float valoruni;

    @JoinColumn(name = "compra", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Compra compra;
    @JoinColumn(name = "livro", referencedColumnName = "cnpj")
    @ManyToOne(optional = false)
    private Livro livro;
    
    public Compralivro() {
    }

    public Compralivro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdade() {
        return qtdade;
    }

    public void setQtdade(Integer qtdade) {
        this.qtdade = qtdade;
    }

    public Float getValoruni() {
        return valoruni;
    }

    public void setValoruni(Float valoruni) {
        this.valoruni = valoruni;
    }
    
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
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
        if (!(object instanceof Compralivro)) {
            return false;
        }
        Compralivro other = (Compralivro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Compralivro[ id=" + id + " ]";
    }
    
}
