/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_apro_estado")
@XmlRootElement
public class PftAproEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_id")
    private Integer estId;
    @Size(max = 100)
    @Column(name = "est_estado")
    private String estEstado;
    @OneToMany(mappedBy = "aproIdEstado")
    private List<PftAprobacion> pftAprobacionList;

    public PftAproEstado() {
    }

    public PftAproEstado(Integer estId) {
        this.estId = estId;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(String estEstado) {
        this.estEstado = estEstado;
    }

    @XmlTransient
    public List<PftAprobacion> getPftAprobacionList() {
        return pftAprobacionList;
    }

    public void setPftAprobacionList(List<PftAprobacion> pftAprobacionList) {
        this.pftAprobacionList = pftAprobacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PftAproEstado)) {
            return false;
        }
        PftAproEstado other = (PftAproEstado) object;
        return !((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId)));
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftAproEstado[ estId=" + estId + " ]";
    }
    

}
