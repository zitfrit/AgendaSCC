/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

import java.beans.PropertyChangeSupport;
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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JTF
 */
@Entity
@Table(name = "telefonos", catalog = "agendascc", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"telefono"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.idTelefono = :idTelefono"),
    @NamedQuery(name = "Telefono.findByTelefono", query = "SELECT t FROM Telefono t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Telefono.findByTipo", query = "SELECT t FROM Telefono t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Telefono.findByLada", query = "SELECT t FROM Telefono t WHERE t.lada = :lada"),
    @NamedQuery(name = "Telefono.findByExtension", query = "SELECT t FROM Telefono t WHERE t.extension = :extension")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PROP_IDTELEFONO = "idTelefono";
    public static final String PROP_TELEFONO = "telefono";
    public static final String PROP_TIPO = "tipo";
    public static final String PROP_LADA = "lada";
    public static final String PROP_EXTENSION = "extension";
    public static final String PROP_IDCONTACTO = "idContacto";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_telefono", nullable = false)
    private Integer idTelefono;
    @Basic(optional = false)
    @Column(nullable = false, length = 11)
    private String telefono;
    @Basic(optional = false)
    @Column(nullable = false, length = 55)
    private String tipo;
    @Column(length = 11)
    private String lada;
    @Column(length = 5)
    private String extension;
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto", nullable = false)
    @ManyToOne(optional = false)
    private Contacto idContacto;
    
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    public Telefono() {
    }

    public Telefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Telefono(Integer idTelefono, String telefono, String tipo) {
        this.idTelefono = idTelefono;
        this.telefono = telefono;
        this.tipo = tipo;
    }
    public Telefono(Telefono t) {
        this.idTelefono = t.getIdTelefono();
        this.idContacto=t.getIdContacto();
        this.tipo = t.getTipo();
        this.telefono = t.getTelefono();
        this.lada=t.getLada();
        this.extension=t.getExtension();
    }
    
  /*  @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }*/

   /* @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }else{
            if(this.telefono.equals(other.telefono))
                return true;
        }
        return false;
    }*/

    @Override
    public String toString() {
        return "agendascc.DATA.Telefono[ idTelefono=" + idTelefono + " ]:"+telefono;
    }

    /**
     * @return the idTelefono
     */
    public Integer getIdTelefono() {
        return idTelefono;
    }

    /**
     * @param idTelefono the idTelefono to set
     */
    public void setIdTelefono(Integer idTelefono) {
        java.lang.Integer oldIdTelefono = this.idTelefono;
        this.idTelefono = idTelefono;
        propertyChangeSupport.firePropertyChange(PROP_IDTELEFONO, oldIdTelefono, idTelefono);
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
    public void setTelefono(String telefono) {
        java.lang.String oldTelefono = this.telefono;
        this.telefono = telefono;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONO, oldTelefono, telefono);
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
    public void setTipo(String tipo) {
        java.lang.String oldTipo = this.tipo;
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
    public void setLada(String lada) {
        java.lang.String oldLada = this.lada;
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
    public void setExtension(String extension) {
        java.lang.String oldExtension = this.extension;
        this.extension = extension;
        propertyChangeSupport.firePropertyChange(PROP_EXTENSION, oldExtension, extension);
    }

    /**
     * @return the idContacto
     */
    public Contacto getIdContacto() {
        return idContacto;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(Contacto idContacto) {
        agendascc.DATA.Contacto oldIdContacto = this.idContacto;
        this.idContacto = idContacto;
        propertyChangeSupport.firePropertyChange(PROP_IDCONTACTO, oldIdContacto, idContacto);
    }
    
    public Long getSerialVersionUID(){
        return Telefono.serialVersionUID;
    }
}
