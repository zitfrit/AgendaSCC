/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
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
    public static final String PROP_SERIALVERSIONUID = "PROP_SERIALVERSIONUID";
    public static final String PROP_TELEFONOPK = "PROP_TELEFONOPK";
    public static final String PROP_TIPO = "PROP_TIPO";
    public static final String PROP_LADA = "PROP_LADA";
    public static final String PROP_EXTENSION = "PROP_EXTENSION";
    public static final String PROP_CONTACTO = "PROP_CONTACTO";

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @EmbeddedId
    private TelefonoPK telefonoPK;
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
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private final transient VetoableChangeSupport vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);

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



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getTelefonoPK() != null ? getTelefonoPK().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.getTelefonoPK() == null && other.getTelefonoPK() != null) || (this.getTelefonoPK() != null && !this.telefonoPK.equals(other.telefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendascc.DATA.Telefono[ telefonoPK=" + getTelefonoPK() + " ]";
    }

    /**
     * @return the telefonoPK
     */
    public TelefonoPK getTelefonoPK() {
        return telefonoPK;
    }

    /**
     * @param telefonoPK the telefonoPK to set
     */
    public void setTelefonoPK(TelefonoPK telefonoPK) throws PropertyVetoException {
        agendascc.DATA.TelefonoPK oldTelefonoPK = this.telefonoPK;
        vetoableChangeSupport.fireVetoableChange(PROP_TELEFONOPK, oldTelefonoPK, telefonoPK);
        this.telefonoPK = telefonoPK;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONOPK, oldTelefonoPK, telefonoPK);
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) throws PropertyVetoException {
        java.lang.String oldTipo = this.tipo;
        vetoableChangeSupport.fireVetoableChange(PROP_TIPO, oldTipo, tipo);
        this.tipo = tipo;
        propertyChangeSupport.firePropertyChange(PROP_TIPO, oldTipo, tipo);
    }

    /**
     * @return the lada
     */
    public String getLada() {
        return lada;
    }

    /**
     * @param lada the lada to set
     */
    public void setLada(String lada) throws PropertyVetoException {
        java.lang.String oldLada = this.lada;
        vetoableChangeSupport.fireVetoableChange(PROP_LADA, oldLada, lada);
        this.lada = lada;
        propertyChangeSupport.firePropertyChange(PROP_LADA, oldLada, lada);
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) throws PropertyVetoException {
        java.lang.String oldExtension = this.extension;
        vetoableChangeSupport.fireVetoableChange(PROP_EXTENSION, oldExtension, extension);
        this.extension = extension;
        propertyChangeSupport.firePropertyChange(PROP_EXTENSION, oldExtension, extension);
    }

    /**
     * @return the contacto
     */
    public Contacto getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(Contacto contacto) throws PropertyVetoException {
        agendascc.DATA.Contacto oldContacto = this.contacto;
        vetoableChangeSupport.fireVetoableChange(PROP_CONTACTO, oldContacto, contacto);
        this.contacto = contacto;
        propertyChangeSupport.firePropertyChange(PROP_CONTACTO, oldContacto, contacto);
    }
    
    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener )
    {
        propertyChangeSupport.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener )
    {
        propertyChangeSupport.removePropertyChangeListener( listener );
    }
}
