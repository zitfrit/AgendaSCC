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
import javax.persistence.Embeddable;

/**
 *
 * @author JTF
 */
@Embeddable
public class TelefonoPK implements Serializable {
    public static final String PROP_SERIALVERSIONUID = "serialVersionUID";
    private static final String PROP_IDCONTACTO = "idContacto";
    private static final String PROP_TELEFONO = "telefono";
    /**
     * @return the PROP_IDCONTACTO
     */
    public static String getPROP_IDCONTACTO() {
        return PROP_IDCONTACTO;
    }
    /**
     * @return the PROP_TELEFONO
     */
    public static String getPROP_TELEFONO() {
        return PROP_TELEFONO;
    }
    @Basic(optional = false)
    @Column(name = "id_contacto", nullable = false)
    private int idContacto;
    @Basic(optional = false)
    @Column(name = "telefono", nullable = false, length = 11)
    
    private static final long serialVersionUID = 1L;
    private String telefono;
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private final transient VetoableChangeSupport vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);

    public TelefonoPK() {
    }

    public TelefonoPK(int idContacto, String telefono) {
        this.idContacto = idContacto;
        this.telefono = telefono;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) getIdContacto();
        hash += (getTelefono() != null ? getTelefono().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoPK)) {
            return false;
        }
        TelefonoPK other = (TelefonoPK) object;
        if (this.getIdContacto() != other.getIdContacto()) {
            return false;
        }
        if ((this.getTelefono() == null && other.getTelefono() != null) || (this.getTelefono() != null && !this.telefono.equals(other.telefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendascc.DATA.TelefonoPK[ idContacto=" + getIdContacto() + ", telefono=" + getTelefono() + " ]";
    }
    
    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener )
    {
        this.propertyChangeSupport.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener )
    {
        this.propertyChangeSupport.removePropertyChangeListener( listener );
    }

    /**
     * @return the idContacto
     */
    public int getIdContacto() {
        return idContacto;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(int idContacto) throws PropertyVetoException {
        int oldIdContacto = this.idContacto;
        this.vetoableChangeSupport.fireVetoableChange(getPROP_IDCONTACTO(), oldIdContacto, idContacto);
        this.idContacto = idContacto;
       this.propertyChangeSupport.firePropertyChange(getPROP_IDCONTACTO(), oldIdContacto, idContacto);
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) throws PropertyVetoException {
    
        java.lang.String oldTelefono = this.telefono;
        this.vetoableChangeSupport.fireVetoableChange(getPROP_TELEFONO(), oldTelefono, telefono);
        this.telefono = telefono;
        this.propertyChangeSupport.firePropertyChange(getPROP_TELEFONO(), oldTelefono, telefono);
    }

    /**
     * @return the propertyChangeSupport
     */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    /**
     * @return the vetoableChangeSupport
     */
    public VetoableChangeSupport getVetoableChangeSupport() {
        return this.vetoableChangeSupport;
    }
    
}
