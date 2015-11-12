/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fabregas
 */
@Entity
@Table(name = "quiz")
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q")})
public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquiz")
    private Integer idquiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publicar")
    private boolean publicar;
    @Column(name = "inicio_quiz")
    @Temporal(TemporalType.DATE)
    private Date inicioQuiz;
    @Column(name = "final_quiz")
    @Temporal(TemporalType.DATE)
    private Date finalQuiz;
    @JoinTable(name = "usuario_has_quiz", joinColumns = {
        @JoinColumn(name = "idquiz", referencedColumnName = "idquiz")}, inverseJoinColumns = {
        @JoinColumn(name = "iduser", referencedColumnName = "iduser")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquiz", fetch = FetchType.EAGER)
    private List<Questionario> questionarioList;

    public Quiz() {
    }

    public Quiz(Integer idquiz) {
        this.idquiz = idquiz;
    }

    public Quiz(Integer idquiz, boolean publicar) {
        this.idquiz = idquiz;
        this.publicar = publicar;
    }

    public Integer getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Integer idquiz) {
        this.idquiz = idquiz;
    }

    public boolean getPublicar() {
        return publicar;
    }

    public void setPublicar(boolean publicar) {
        this.publicar = publicar;
    }

    public Date getInicioQuiz() {
        return inicioQuiz;
    }

    public void setInicioQuiz(Date inicioQuiz) {
        this.inicioQuiz = inicioQuiz;
    }

    public Date getFinalQuiz() {
        return finalQuiz;
    }

    public void setFinalQuiz(Date finalQuiz) {
        this.finalQuiz = finalQuiz;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Questionario> getQuestionarioList() {
        return questionarioList;
    }

    public void setQuestionarioList(List<Questionario> questionarioList) {
        this.questionarioList = questionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquiz != null ? idquiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.idquiz == null && other.idquiz != null) || (this.idquiz != null && !this.idquiz.equals(other.idquiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quiz[ idquiz=" + idquiz + " ]";
    }
    
}
