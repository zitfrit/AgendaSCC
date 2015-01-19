/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JTF
 */
@Entity
@Table(name = "contactos", catalog = "agendascc", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_contacto"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByIdContacto", query = "SELECT c FROM Contacto c WHERE c.idContacto = :idContacto"),
    @NamedQuery(name = "Contacto.findByTipo", query = "SELECT c FROM Contacto c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByPseudonimo", query = "SELECT c FROM Contacto c WHERE c.pseudonimo = :pseudonimo"),
    @NamedQuery(name = "Contacto.findByDireccion", query = "SELECT c FROM Contacto c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Contacto.findByDireccionReferencias", query = "SELECT c FROM Contacto c WHERE c.direccionReferencias = :direccionReferencias"),
    @NamedQuery(name = "Contacto.findByColonia", query = "SELECT c FROM Contacto c WHERE c.colonia = :colonia"),
    @NamedQuery(name = "Contacto.findByCodigoPostal", query = "SELECT c FROM Contacto c WHERE c.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Contacto.findByLocalidad", query = "SELECT c FROM Contacto c WHERE c.localidad = :localidad"),
    @NamedQuery(name = "Contacto.findByMunicipio", query = "SELECT c FROM Contacto c WHERE c.municipio = :municipio"),
    @NamedQuery(name = "Contacto.findByEstado", query = "SELECT c FROM Contacto c WHERE c.estado = :estado"),
    @NamedQuery(name = "Contacto.findByPais", query = "SELECT c FROM Contacto c WHERE c.pais = :pais"),
    @NamedQuery(name = "Contacto.findByComentarios", query = "SELECT c FROM Contacto c WHERE c.comentarios = :comentarios"),
    @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email"),
    @NamedQuery(name = "Contacto.findByImagen", query = "SELECT c FROM Contacto c WHERE c.imagen = :imagen")})
public class Contacto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public static final String PROP_SERIALVERSIONUID = "serialVersionUID";
    public static final String PROP_IDCONTACTO = "idContacto";
    public static final String PROP_TIPO = "tipo";
    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_PSEUDONIMO = "pseudonimo";
    public static final String PROP_DIRECCION = "direccion";
    public static final String PROP_DIRECCIONREFERENCIAS = "direccionReferencias";
    public static final String PROP_COLONIA = "colonia";
    public static final String PROP_CODIGOPOSTAL = "codigoPostal";
    public static final String PROP_LOCALIDAD = "localidad";
    public static final String PROP_MUNICIPIO = "municipio";
    public static final String PROP_ESTADO = "estado";
    public static final String PROP_PAIS = "pais";
    public static final String PROP_COMENTARIOS = "comentarios";
    public static final String PROP_EMAIL = "email";
    public static final String PROP_IMAGEN = "imagen";
    public static final String PROP_TELEFONOLIST = "telefonoList";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto", nullable = false)
    private Integer idContacto;
    @Basic(optional = false)
    @Column(nullable = false, length = 35)
    private String tipo;
    @Basic(optional = false)
    @Column(nullable = false, length = 55)
    private String nombre;
    @Column(length = 25)
    private String pseudonimo;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String direccion;
    @Column(name = "direccion_referencias", length = 55)
    private String direccionReferencias;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String colonia;
    @Basic(optional = false)
    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String localidad;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String municipio;
    @Basic(optional = false)
    @Column(nullable = false, length = 25)
    private String estado;
    @Basic(optional = false)
    @Column(nullable = false, length = 25)
    private String pais;
    @Column(length = 50)
    private String comentarios;
    @Column(length = 55)
    private String email;
    @Column(length = 45)
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto", fetch = FetchType.EAGER)
    private List<Telefono> telefonoList;
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    
    public Contacto() {
    }

    public Contacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto(Integer idContacto, String tipo, String nombre, String direccion, String colonia, String codigoPostal, String localidad, String municipio, String estado, String pais) {
        this.idContacto = idContacto;
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdContacto() != null ? getIdContacto().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.getIdContacto() == null && other.getIdContacto() != null) || (this.getIdContacto() != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testagenda.DATA.Contacto[ idContacto=" + getIdContacto() + " ]";
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
   
    ////////////////   GETTERS & SETTERS     //////////////////////
    ///////////////////////////////////////////////////////////////
    /*
    private Integer idContacto;
    private String tipo;
    private String nombre;
    private String pseudonimo;
    private String direccion;
    private String direccionReferencias;
    private String colonia;
    private String codigoPostal;
    private String localidad;
    private String municipio;
    private String estado;
    private String pais;
    private String comentarios;
    private String email;
    private String imagen;
    private List<Telefono> telefonoList;
    */
    public Integer getIdContacto() {
        return idContacto;
    }
    public void setIdContacto(Integer idContacto) {
        Integer oldIdContacto=this.idContacto;
        this.idContacto = idContacto;
        this.propertyChangeSupport.firePropertyChange(PROP_IDCONTACTO, oldIdContacto, idContacto);
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        java.lang.String oldTipo = this.tipo;
        this.tipo = tipo;
        propertyChangeSupport.firePropertyChange(PROP_TIPO, oldTipo, tipo);
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        java.lang.String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }

    public String getPseudonimo() {
        return pseudonimo;
    }
    public void setPseudonimo(String pseudonimo) {
        java.lang.String oldPseudonimo = this.pseudonimo;
        this.pseudonimo = pseudonimo;
        propertyChangeSupport.firePropertyChange(PROP_PSEUDONIMO, oldPseudonimo, pseudonimo);
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        java.lang.String oldDireccion = this.direccion;
        this.direccion = direccion;
        propertyChangeSupport.firePropertyChange(PROP_DIRECCION, oldDireccion, direccion);
    }

    public String getDireccionReferencias() {
        return direccionReferencias;
    }
    public void setDireccionReferencias(String direccionReferencias) {
        java.lang.String oldDireccionReferencias = this.direccionReferencias;
        this.direccionReferencias = direccionReferencias;
        propertyChangeSupport.firePropertyChange(PROP_DIRECCIONREFERENCIAS, oldDireccionReferencias, direccionReferencias);
    }

    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        java.lang.String oldColonia = this.colonia;
        this.colonia = colonia;
        propertyChangeSupport.firePropertyChange(PROP_COLONIA, oldColonia, colonia);
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        java.lang.String oldCodigoPostal = this.codigoPostal;
        this.codigoPostal = codigoPostal;
        propertyChangeSupport.firePropertyChange(PROP_CODIGOPOSTAL, oldCodigoPostal, codigoPostal);
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        java.lang.String oldLocalidad = this.localidad;
        this.localidad = localidad;
        propertyChangeSupport.firePropertyChange(PROP_LOCALIDAD, oldLocalidad, localidad);
    }

    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        java.lang.String oldMunicipio = this.municipio;
        this.municipio = municipio;
        propertyChangeSupport.firePropertyChange(PROP_MUNICIPIO, oldMunicipio, municipio);
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        java.lang.String oldEstado = this.estado;
        this.estado = estado;
        propertyChangeSupport.firePropertyChange(PROP_ESTADO, oldEstado, estado);
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        java.lang.String oldPais = this.pais;
        this.pais = pais;
        propertyChangeSupport.firePropertyChange(PROP_PAIS, oldPais, pais);
    }

    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        java.lang.String oldComentarios = this.comentarios;
        this.comentarios = comentarios;
        propertyChangeSupport.firePropertyChange(PROP_COMENTARIOS, oldComentarios, comentarios);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        java.lang.String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange(PROP_EMAIL, oldEmail, email);
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        java.lang.String oldImagen = this.imagen;
        this.imagen = imagen;
        propertyChangeSupport.firePropertyChange(PROP_IMAGEN, oldImagen, imagen);
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }
    public void setTelefonoList(List<Telefono> telefonoList) {
        List<Telefono> oldTelefonoList=this.telefonoList;
        this.telefonoList = org.jdesktop.observablecollections.ObservableCollections.observableList(telefonoList);
        this.propertyChangeSupport.firePropertyChange(PROP_TELEFONOLIST, oldTelefonoList, telefonoList);
    }
    
}
