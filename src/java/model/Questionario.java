/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fabregas
 */
@Entity
@Table(name = "questionario")
@NamedQueries({
    @NamedQuery(name = "Questionario.findAll", query = "SELECT q FROM Questionario q")})
public class Questionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquestionario")
    private Integer idquestionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pergunta")
    private String pergunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private double peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "materia")
    private String materia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquestionario", fetch = FetchType.EAGER)
    private List<Resposta> respostaList;
    @JoinColumn(name = "idquiz", referencedColumnName = "idquiz")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Quiz idquiz;

    public Questionario() {
    }

    public Questionario(Integer idquestionario) {
        this.idquestionario = idquestionario;
    }

    public Questionario(Integer idquestionario, String pergunta, double peso, String materia) {
        this.idquestionario = idquestionario;
        this.pergunta = pergunta;
        this.peso = peso;
        this.materia = materia;
    }

    public Integer getIdquestionario() {
        return idquestionario;
    }

    public void setIdquestionario(Integer idquestionario) {
        this.idquestionario = idquestionario;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Resposta> getRespostaList() {
        return respostaList;
    }

    public void setRespostaList(List<Resposta> respostaList) {
        this.respostaList = respostaList;
    }

    public Quiz getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Quiz idquiz) {
        this.idquiz = idquiz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquestionario != null ? idquestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionario)) {
            return false;
        }
        Questionario other = (Questionario) object;
        if ((this.idquestionario == null && other.idquestionario != null) || (this.idquestionario != null && !this.idquestionario.equals(other.idquestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Questionario[ idquestionario=" + idquestionario + " ]";
    }
    
}
