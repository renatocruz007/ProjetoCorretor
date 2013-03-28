/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rcruzsil
 */
@Entity
@Table(name = "clientecontato")
@XmlRootElement

public class Clientecontato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "desccontato")
    private String desccontato;
    @Size(max = 255)
    @Column(name = "siglatipo")
    private String siglatipo;
    @Size(max = 255)
    @Column(name = "siglatipocontato")
    private String siglatipocontato;
    @Id
    @SequenceGenerator(name = "clientecontato_id_seq",sequenceName = "clientecontato_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "clientecontato_id_seq")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idcliente_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente idclienteId;

    public Clientecontato() {
    }

    public Clientecontato(Integer id) {
        this.id = id;
    }

    public String getDesccontato() {
        return desccontato;
    }

    public void setDesccontato(String desccontato) {
        this.desccontato = desccontato;
    }

    public String getSiglatipo() {
        return siglatipo;
    }

    public void setSiglatipo(String siglatipo) {
        this.siglatipo = siglatipo;
    }

    public String getSiglatipocontato() {
        return siglatipocontato;
    }

    public void setSiglatipocontato(String siglatipocontato) {
        this.siglatipocontato = siglatipocontato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getIdclienteId() {
        return idclienteId;
    }

    public void setIdclienteId(Cliente idclienteId) {
        this.idclienteId = idclienteId;
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
        if (!(object instanceof Clientecontato)) {
            return false;
        }
        Clientecontato other = (Clientecontato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clientecontato[ id=" + id + " ]";
    }
    
}
