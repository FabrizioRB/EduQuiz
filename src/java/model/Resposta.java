/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fabregas
 */
@Entity
@Table(name = "resposta")
@NamedQueries({
    @NamedQuery(name = "Resposta.findAll", query = "SELECT r FROM Resposta r")})
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresposta")
    private Integer idresposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "resposta")
    private String resposta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verdadeira")
    private boolean verdadeira;
    @JoinColumn(name = "idquestionario", referencedColumnName = "idquestionario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Questionario idquestionario;

    public Resposta() {
    }

    public Resposta(Integer idresposta) {
        this.idresposta = idresposta;
    }

    public Resposta(Integer idresposta, String resposta, boolean verdadeira) {
        this.idresposta = idresposta;
        this.resposta = resposta;
        this.verdadeira = verdadeira;
    }

    public Integer getIdresposta() {
        return idresposta;
    }

    public void setIdresposta(Integer idresposta) {
        this.idresposta = idresposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public boolean getVerdadeira() {
        return verdadeira;
    }

    public void setVerdadeira(boolean verdadeira) {
        this.verdadeira = verdadeira;
    }

    public Questionario getIdquestionario() {
        return idquestionario;
    }

    public void setIdquestionario(Questionario idquestionario) {
        this.idquestionario = idquestionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresposta != null ? idresposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idresposta == null && other.idresposta != null) || (this.idresposta != null && !this.idresposta.equals(other.idresposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Resposta[ idresposta=" + idresposta + " ]";
    }
    
}
