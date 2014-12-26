/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JTF
 */
@Entity
@Table(name = "telefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdContacto", query = "SELECT t FROM Telefono t WHERE t.telefonoPK.idContacto = :idContacto"),
    @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefonoPK.telefono = :telefono"),
    @NamedQuery(name = "Telefono.findByTipo", query = "SELECT t FROM Telefono t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Telefono.findByLada", query = "SELECT t FROM Telefono t WHERE t.lada = :lada"),
    @NamedQuery(name = "Telefono.findByExtension", query = "SELECT t FROM Telefono t WHERE t.extension = :extension")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefonoPK telefonoPK;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 55)
    private String tipo;
    @Column(name = "lada", length = 11)
    private String lada;
    @Column(name = "extension", length = 5)
    private String extension;
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contacto contacto;

    public Telefono() {
    }

    public Telefono(TelefonoPK telefonoPK) {
        this.telefonoPK = telefonoPK;
    }

    public Telefono(TelefonoPK telefonoPK, String tipo) {
        this.telefonoPK = telefonoPK;
        this.tipo = tipo;
    }

    public Telefono(int idContacto, String telefono) {
        this.telefonoPK = new TelefonoPK(idContacto, telefono);
    }

    public TelefonoPK getTelefonoPK() {
        return telefonoPK;
    }

    public void setTelefonoPK(TelefonoPK telefonoPK) {
        this.telefonoPK = telefonoPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLada() {
        return lada;
    }

    public void setLada(String lada) {
        this.lada = lada;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefonoPK != null ? telefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefonoPK == null && other.telefonoPK != null) || (this.telefonoPK != null && !this.telefonoPK.equals(other.telefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendascc.DATA.Telefono[ telefonoPK=" + telefonoPK + " ]";
    }
    
}
