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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "contactos", uniqueConstraints = {
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
    public static final String PROP_PROPERTYCHANGESUPPORT = "propertyChangeSupport";
    public static final String PROP_VETOABLECHANGESUPPORT = "vetoableChangeSupport";

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto", nullable = false)
    private Integer idContacto;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 35)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 55)
    private String nombre;
    @Column(name = "pseudonimo", length = 25)
    private String pseudonimo;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 40)
    private String direccion;
    @Column(name = "direccion_referencias", length = 55)
    private String direccionReferencias;
    @Basic(optional = false)
    @Column(name = "colonia", nullable = false, length = 45)
    private String colonia;
    @Basic(optional = false)
    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;
    @Basic(optional = false)
    @Column(name = "localidad", nullable = false, length = 40)
    private String localidad;
    @Basic(optional = false)
    @Column(name = "municipio", nullable = false, length = 40)
    private String municipio;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 25)
    private String estado;
    @Basic(optional = false)
    @Column(name = "pais", nullable = false, length = 25)
    private String pais;
    @Column(name = "comentarios", length = 50)
    private String comentarios;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 55)
    private String email;
    @Basic(optional = false)
    @Column(name = "imagen", nullable = false, length = 45)
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto")
    private List<Telefono> telefonoList;
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private final transient VetoableChangeSupport vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);

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
    
    public Contacto(Contacto c){
        this.idContacto = c.idContacto;
        this.tipo = c.tipo;
        this.nombre = c.nombre;
        this.pseudonimo=c.pseudonimo;
        this.direccion = c.direccion;
        this.direccionReferencias=c.direccionReferencias;
        this.colonia = c.colonia;
        this.codigoPostal = c.codigoPostal;
        this.localidad = c.localidad;
        this.municipio = c.municipio;
        this.estado = c.estado;
        this.pais = c.pais;
        this.comentarios=c.comentarios;
        this.email=c.email;
        this.imagen=c.imagen;
        this.telefonoList=c.telefonoList;
        
    }
    /**
     * @return the idContacto
     */
    public static Contacto cloneContacto(Contacto c){
        return new Contacto(c);
    }
    
    public Integer getIdContacto() {
        return idContacto;
    }
    
    public Contacto makeContactoDummy() throws PropertyVetoException{
        Contacto dummy=new Contacto();
        dummy.setIdContacto(0);
        dummy.setTipo(this.tipo);
        dummy.setNombre(this.nombre);
        dummy.setPseudonimo(this.pseudonimo);
        dummy.setDireccion(this.direccion);
        dummy.setDireccionReferencias(this.direccionReferencias);
        dummy.setColonia(this.colonia);
        dummy.setCodigoPostal(this.codigoPostal);
        dummy.setLocalidad(this.localidad);
        dummy.setMunicipio(this.municipio);
        dummy.setEstado(this.estado);
        dummy.setPais(this.pais);
        dummy.setComentarios(this.comentarios);
        dummy.setEmail(this.email);
        dummy.setImagen(this.imagen);
        dummy.setTelefonoList(this.telefonoList);
        return dummy;
    }
    
    public void copyFromDummy(Contacto c) throws PropertyVetoException{
        //this.setIdContacto(0);
        this.setTipo(c.tipo);
        this.setNombre(c.nombre);
        this.setPseudonimo(c.pseudonimo);
        this.setDireccion(c.direccion);
        this.setDireccionReferencias(c.direccionReferencias);
        this.setColonia(c.colonia);
        this.setCodigoPostal(c.codigoPostal);
        this.setLocalidad(c.localidad);
        this.setMunicipio(c.municipio);
        this.setEstado(c.estado);
        this.setPais(c.pais);
        this.setComentarios(c.comentarios);
        this.setEmail(c.email);
        this.setImagen(c.imagen);
        this.setTelefonoList(c.telefonoList);
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(Integer idContacto) throws PropertyVetoException {
        java.lang.Integer oldIdContacto = this.idContacto;
        vetoableChangeSupport.fireVetoableChange(PROP_IDCONTACTO, oldIdContacto, idContacto);
        this.idContacto = idContacto;
        propertyChangeSupport.firePropertyChange(PROP_IDCONTACTO, oldIdContacto, idContacto);
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) throws PropertyVetoException {
        java.lang.String oldNombre = this.nombre;
        vetoableChangeSupport.fireVetoableChange(PROP_NOMBRE, oldNombre, nombre);
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }

    /**
     * @return the pseudonimo
     */
    public String getPseudonimo() {
        return pseudonimo;
    }

    /**
     * @param pseudonimo the pseudonimo to set
     */
    public void setPseudonimo(String pseudonimo) throws PropertyVetoException {
        java.lang.String oldPseudonimo = this.pseudonimo;
        vetoableChangeSupport.fireVetoableChange(PROP_PSEUDONIMO, oldPseudonimo, pseudonimo);
        this.pseudonimo = pseudonimo;
        propertyChangeSupport.firePropertyChange(PROP_PSEUDONIMO, oldPseudonimo, pseudonimo);
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) throws PropertyVetoException {
        java.lang.String oldDireccion = this.direccion;
        vetoableChangeSupport.fireVetoableChange(PROP_DIRECCION, oldDireccion, direccion);
        this.direccion = direccion;
        propertyChangeSupport.firePropertyChange(PROP_DIRECCION, oldDireccion, direccion);
    }

    /**
     * @return the direccionReferencias
     */
    public String getDireccionReferencias() {
        return direccionReferencias;
    }

    /**
     * @param direccionReferencias the direccionReferencias to set
     */
    public void setDireccionReferencias(String direccionReferencias) throws PropertyVetoException {
        java.lang.String oldDireccionReferencias = this.direccionReferencias;
        vetoableChangeSupport.fireVetoableChange(PROP_DIRECCIONREFERENCIAS, oldDireccionReferencias, direccionReferencias);
        this.direccionReferencias = direccionReferencias;
        propertyChangeSupport.firePropertyChange(PROP_DIRECCIONREFERENCIAS, oldDireccionReferencias, direccionReferencias);
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) throws PropertyVetoException {
        java.lang.String oldColonia = this.colonia;
        vetoableChangeSupport.fireVetoableChange(PROP_COLONIA, oldColonia, colonia);
        this.colonia = colonia;
        propertyChangeSupport.firePropertyChange(PROP_COLONIA, oldColonia, colonia);
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) throws PropertyVetoException {
        java.lang.String oldCodigoPostal = this.codigoPostal;
        vetoableChangeSupport.fireVetoableChange(PROP_CODIGOPOSTAL, oldCodigoPostal, codigoPostal);
        this.codigoPostal = codigoPostal;
        propertyChangeSupport.firePropertyChange(PROP_CODIGOPOSTAL, oldCodigoPostal, codigoPostal);
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) throws PropertyVetoException {
        java.lang.String oldLocalidad = this.localidad;
        vetoableChangeSupport.fireVetoableChange(PROP_LOCALIDAD, oldLocalidad, localidad);
        this.localidad = localidad;
        propertyChangeSupport.firePropertyChange(PROP_LOCALIDAD, oldLocalidad, localidad);
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) throws PropertyVetoException {
        java.lang.String oldMunicipio = this.municipio;
        vetoableChangeSupport.fireVetoableChange(PROP_MUNICIPIO, oldMunicipio, municipio);
        this.municipio = municipio;
        propertyChangeSupport.firePropertyChange(PROP_MUNICIPIO, oldMunicipio, municipio);
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) throws PropertyVetoException {
        java.lang.String oldEstado = this.estado;
        vetoableChangeSupport.fireVetoableChange(PROP_ESTADO, oldEstado, estado);
        this.estado = estado;
        propertyChangeSupport.firePropertyChange(PROP_ESTADO, oldEstado, estado);
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) throws PropertyVetoException {
        java.lang.String oldPais = this.pais;
        vetoableChangeSupport.fireVetoableChange(PROP_PAIS, oldPais, pais);
        this.pais = pais;
        propertyChangeSupport.firePropertyChange(PROP_PAIS, oldPais, pais);
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) throws PropertyVetoException {
        java.lang.String oldComentarios = this.comentarios;
        vetoableChangeSupport.fireVetoableChange(PROP_COMENTARIOS, oldComentarios, comentarios);
        this.comentarios = comentarios;
        propertyChangeSupport.firePropertyChange(PROP_COMENTARIOS, oldComentarios, comentarios);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) throws PropertyVetoException {
        java.lang.String oldEmail = this.email;
        vetoableChangeSupport.fireVetoableChange(PROP_EMAIL, oldEmail, email);
        this.email = email;
        propertyChangeSupport.firePropertyChange(PROP_EMAIL, oldEmail, email);
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) throws PropertyVetoException {
        java.lang.String oldImagen = this.imagen;
        vetoableChangeSupport.fireVetoableChange(PROP_IMAGEN, oldImagen, imagen);
        this.imagen = imagen;
        propertyChangeSupport.firePropertyChange(PROP_IMAGEN, oldImagen, imagen);
    }

    /**
     * @return the telefonoList
     */
    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    /**
     * @param telefonoList the telefonoList to set
     */
    public void setTelefonoList(List<Telefono> telefonoList) throws PropertyVetoException {
        java.util.List<agendascc.DATA.Telefono> oldTelefonoList = this.telefonoList;
        vetoableChangeSupport.fireVetoableChange(PROP_TELEFONOLIST, oldTelefonoList, telefonoList);
        this.telefonoList = telefonoList;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONOLIST, oldTelefonoList, telefonoList);
    }

    /**
     * @return the propertyChangeSupport
     */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    /**
     * @return the vetoableChangeSupport
     */
    public VetoableChangeSupport getVetoableChangeSupport() {
        return vetoableChangeSupport;
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
        return "agendascc.DATA.Contacto[ idContacto=" + getIdContacto() + " ]";
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


 //  @XmlTransient
 /*     public List<Telefono> getTelefonoList() {
        return telefonoList;
    }*/