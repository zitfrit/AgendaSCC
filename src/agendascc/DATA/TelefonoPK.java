/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

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
    @Basic(optional = false)
    @Column(name = "id_contacto", nullable = false)
    private int idContacto;
    @Basic(optional = false)
    @Column(name = "telefono", nullable = false, length = 11)
    private String telefono;

    public TelefonoPK() {
    }

    public TelefonoPK(int idContacto, String telefono) {
        this.idContacto = idContacto;
        this.telefono = telefono;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idContacto;
        hash += (telefono != null ? telefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoPK)) {
            return false;
        }
        TelefonoPK other = (TelefonoPK) object;
        if (this.idContacto != other.idContacto) {
            return false;
        }
        if ((this.telefono == null && other.telefono != null) || (this.telefono != null && !this.telefono.equals(other.telefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendascc.DATA.TelefonoPK[ idContacto=" + idContacto + ", telefono=" + telefono + " ]";
    }
    
}
