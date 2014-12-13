/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

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
    @NamedQuery(name = "Contacto.findByComentarios", query = "SELECT c FROM Contacto c WHERE c.comentarios = :comentarios")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto")
    private List<Telefono> telefonoList;

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

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionReferencias() {
        return direccionReferencias;
    }

    public void setDireccionReferencias(String direccionReferencias) {
        this.direccionReferencias = direccionReferencias;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendascc.DATA.Contacto[ idContacto=" + idContacto + " ]";
    }
    
}
