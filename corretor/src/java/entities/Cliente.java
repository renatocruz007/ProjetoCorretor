/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rcruzsil
 */
@Entity
@Table(name = "cliente")
@XmlRootElement

public class Cliente implements Serializable {
    @Size(max = 255)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "bairrocom")
    private String bairrocom;
    @Size(max = 255)
    @Column(name = "bairrores")
    private String bairrores;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "nomeconjugue")
    private String nomeconjugue;
    @Column(name = "numcom")
    private String numcom;
    @Column(name = "numres")
    private String numres;
    @Size(max = 255)
    @Column(name = "origem")
    private String origem;
    @Size(max = 255)
    @Column(name = "produtointeresse")
    private String produtointeresse;
    @Size(max = 255)
    @Column(name = "ruacom")
    private String ruacom;
    @Size(max = 255)
    @Column(name = "ruares")
    private String ruares;
    @Id
    @SequenceGenerator(name = "cliente_id_seq",sequenceName = "cliente_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cliente_id_seq")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "idclienteId", fetch = FetchType.LAZY)
    private List<Historico> historicoList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public String getBairrocom() {
        return bairrocom;
    }

    public void setBairrocom(String bairrocom) {
        this.bairrocom = bairrocom;
    }

    public String getBairrores() {
        return bairrores;
    }

    public void setBairrores(String bairrores) {
        this.bairrores = bairrores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeconjugue() {
        return nomeconjugue;
    }

    public void setNomeconjugue(String nomeconjugue) {
        this.nomeconjugue = nomeconjugue;
    }

    public String getNumcom() {
        return numcom;
    }

    public void setNumcom(String numcom) {
        this.numcom = numcom;
    }

    public String getNumres() {
        return numres;
    }

    public void setNumres(String numres) {
        this.numres = numres;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getProdutointeresse() {
        return produtointeresse;
    }

    public void setProdutointeresse(String produtointeresse) {
        this.produtointeresse = produtointeresse;
    }

    public String getRuacom() {
        return ruacom;
    }

    public void setRuacom(String ruacom) {
        this.ruacom = ruacom;
    }

    public String getRuares() {
        return ruares;
    }

    public void setRuares(String ruares) {
        this.ruares = ruares;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Historico> getClientecontatoList() {
        return historicoList;
    }

    public void setClientecontatoList(List<Historico> clientecontatoList) {
        this.historicoList = clientecontatoList;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cliente[ id=" + id + " ]";
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
