/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khlifi
 */
@Entity
@Table(name = "rv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rv.findAll", query = "SELECT r FROM Rv r"),
    @NamedQuery(name = "Rv.findById", query = "SELECT r FROM Rv r WHERE r.id = :id"),
    @NamedQuery(name = "Rv.findByJour", query = "SELECT r FROM Rv r WHERE r.jour = :jour")})
public class Rv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "JOUR")
    private String jour;
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Clients idClient;
    @JoinColumn(name = "ID_MEDECIN", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Medecins idMedecin;

    public Rv() {
    }

    public Rv(Long id) {
        this.id = id;
    }

    public Rv(Long id, String jour) {
        this.id = id;
        this.jour = jour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Medecins getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Medecins idMedecin) {
        this.idMedecin = idMedecin;
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
        if (!(object instanceof Rv)) {
            return false;
        }
        Rv other = (Rv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Rv[ id=" + id + " ]";
    }
    
}
