/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.UI;

import agendascc.AgendaSCC;
import javafx.collections.ObservableList;
import org.jdesktop.swingx.JXPanel;
import agendascc.DATA.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import jdk.nashorn.internal.objects.NativeArray;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author JTF
 */
public class ContactosPanel extends JXPanel {
    private Contacto contactoActual;
    public static final String PROP_CONTACTOACTUAL = "contactoActual";
    public static final String PROP_OCONTACTOSLIST = "oContactosList";
    public static final String PROP_OTELEFONOSLIST = "oTelefonosList";
    private String tipoContacto;
    private ContactoJpaController contactoController;
    private transient final java.beans.PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
   // private transient final java.beans.VetoableChangeSupport vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);

    public ContactosPanel()
    {
        super();
        tipoContacto="*";
        contactoController=new ContactoJpaController(mainEntityManager.getEntityManagerFactory());
        initComponents();
        
    }

    public List<Contacto> getOContactosList()
    {
        return this.oContactosList;
    }

    public void setOContactosList(List<Contacto> listaContactos){
        this.oContactosList.clear();
        this.oContactosList.addAll(listaContactos);
    }

    public List<Telefono> getOTelefonosList(){
        return this.oTelefonosList;
    }
    
 
    public void setOTelefonosList(List<Telefono> listaTelefonos){
        this.oTelefonosList.clear();
        this.oTelefonosList.addAll(listaTelefonos);
    }
    
    public Contacto getContactoActual(){
        return this.contactoActual;
    }
    
     public void setContactoActual(Contacto contactoNuevo) /*throws java.beans.PropertyVetoException*/ {
        Contacto oldContactoActual = this.contactoActual;
       // vetoableChangeSupport.fireVetoableChange(PROP_CONTACTOACTUAL, oldContactoActual, contactoActual);
        this.contactoActual = contactoNuevo;
        propertyChangeSupport.firePropertyChange(PROP_CONTACTOACTUAL, oldContactoActual, this.contactoActual);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener )
    {
        propertyChangeSupport.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener )
    {
        propertyChangeSupport.removePropertyChangeListener( listener );
    }
    
   /* public void addVetoableChangeListener(java.beans.VetoableChangeListener listener )
    {
        vetoableChangeSupport.addVetoableChangeListener( listener );
    }

    public void removeVetoableChangeListener(java.beans.VetoableChangeListener listener )
    {
        vetoableChangeSupport.removeVetoableChangeListener( listener );
    }
    */
    public String getTipoContacto(){
        return this.tipoContacto;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        queryContactos = java.beans.Beans.isDesignTime() ? null : mainEntityManager.createQuery("SELECT c FROM Contacto c ");
        queryTelefonos = java.beans.Beans.isDesignTime() ? null : mainEntityManager.createQuery("SELECT C FROM Telefono C");
        mainEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AgendaSCCPU").createEntityManager();
        oContactosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryContactos.getResultList());
        oTelefonosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryTelefonos.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        labelPseudonimo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        telefonosTabla = new org.jdesktop.swingx.JXTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jXTable3 = new org.jdesktop.swingx.JXTable();
        jPanel2 = new javax.swing.JPanel();
        labelLocalidad = new javax.swing.JLabel();
        labelMunicipio = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        comentariosTA = new javax.swing.JTextArea();
        paisTF = new javax.swing.JTextField();
        labelColonia = new javax.swing.JLabel();
        codigoPostalTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        referenciasDireccionTF = new javax.swing.JTextField();
        coloniaTF = new javax.swing.JTextField();
        localidadTF = new javax.swing.JTextField();
        labelEstado = new javax.swing.JLabel();
        direccionTF = new javax.swing.JTextField();
        labelComentarios = new javax.swing.JLabel();
        estadoTF = new javax.swing.JTextField();
        labelPais = new javax.swing.JLabel();
        municipioTF = new javax.swing.JTextField();
        labelCorreo = new javax.swing.JLabel();
        labelCPostal = new javax.swing.JLabel();
        guardarJB = new javax.swing.JButton();
        cancelarJB = new javax.swing.JButton();
        editarJB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactosTabla = new org.jdesktop.swingx.JXTable();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelPseudonimo.setFont(new java.awt.Font("Calibri", 2, 20)); // NOI18N
        labelPseudonimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pseudonimo}"), labelPseudonimo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelNombre.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombre}"), labelNombre, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendascc/RESOURCES/grupo.png"))); // NOI18N
        labelImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TODOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N

        telefonosTabla.setEditable(false);
        telefonosTabla.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        telefonosTabla.setMinimumSize(new java.awt.Dimension(300, 360));
        telefonosTabla.setPreferredSize(new java.awt.Dimension(300, 360));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefonoList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, eLProperty, telefonosTabla);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefonoPK.telefono}"));
        columnBinding.setColumnName("Numero");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lada}"));
        columnBinding.setColumnName("Lada");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${extension}"));
        columnBinding.setColumnName("Extension");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(telefonosTabla);

        jXTable3.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jXTable3.setMinimumSize(new java.awt.Dimension(300, 360));
        jXTable3.setPreferredSize(new java.awt.Dimension(300, 360));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefonoList}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, eLProperty, jXTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefonoPK.telefono}"));
        columnBinding.setColumnName("Telefono PK.telefono");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lada}"));
        columnBinding.setColumnName("Lada");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${extencion}"));
        columnBinding.setColumnName("Extencion");
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jXTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPseudonimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelPseudonimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        labelLocalidad.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelLocalidad.setText("Localidad:");

        labelMunicipio.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelMunicipio.setText("Municipio:");

        labelDireccion.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelDireccion.setText("Direccion:");

        comentariosTA.setColumns(20);
        comentariosTA.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        comentariosTA.setRows(5);
        comentariosTA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        comentariosTA.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.comentarios}"), comentariosTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane3.setViewportView(comentariosTA);

        paisTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        paisTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        paisTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.pais}"), paisTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelColonia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelColonia.setText("Colonia:");

        codigoPostalTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        codigoPostalTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codigoPostalTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoPostal}"), codigoPostalTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        emailTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        emailTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        emailTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.email}"), emailTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        referenciasDireccionTF.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        referenciasDireccionTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        referenciasDireccionTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.direccionReferencias}"), referenciasDireccionTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        coloniaTF.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        coloniaTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        coloniaTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.colonia}"), coloniaTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        localidadTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        localidadTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        localidadTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.localidad}"), localidadTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelEstado.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelEstado.setText("Estado:");

        direccionTF.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        direccionTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        direccionTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.direccion}"), direccionTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelComentarios.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelComentarios.setText("Comentarios:");

        estadoTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        estadoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        estadoTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.estado}"), estadoTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelPais.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelPais.setText("Pais:");

        municipioTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        municipioTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        municipioTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.municipio}"), municipioTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelCorreo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelCorreo.setText("Correo:");

        labelCPostal.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelCPostal.setText("C. Postal:");

        guardarJB.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        guardarJB.setText("Guardar");
        guardarJB.setEnabled(false);
        guardarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarJBActionPerformed(evt);
            }
        });

        cancelarJB.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        cancelarJB.setText("Cancelar");
        cancelarJB.setEnabled(false);
        cancelarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJBActionPerformed(evt);
            }
        });

        editarJB.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        editarJB.setText("Editar");
        editarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDireccion)
                            .addComponent(labelColonia)
                            .addComponent(labelMunicipio)
                            .addComponent(labelCPostal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(codigoPostalTF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelPais)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paisTF))
                                    .addComponent(municipioTF))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelEstado)
                                    .addComponent(labelCorreo)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(coloniaTF)
                                .addGap(10, 10, 10)
                                .addComponent(labelLocalidad))
                            .addComponent(direccionTF)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelComentarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(editarJB)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarJB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardarJB))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(referenciasDireccionTF)
                            .addComponent(emailTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estadoTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(localidadTF))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelarJB, editarJB, guardarJB});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardarJB)
                            .addComponent(editarJB)
                            .addComponent(cancelarJB))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDireccion)
                            .addComponent(direccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(referenciasDireccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelColonia)
                            .addComponent(coloniaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLocalidad)
                            .addComponent(localidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMunicipio)
                            .addComponent(municipioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEstado)
                            .addComponent(estadoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCPostal)
                            .addComponent(codigoPostalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPais)
                            .addComponent(paisTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCorreo)
                            .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelComentarios)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codigoPostalTF, coloniaTF, localidadTF});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelCPostal, labelColonia, labelLocalidad});

        contactosTabla.setColumnControlVisible(true);
        contactosTabla.setEditable(false);
        contactosTabla.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        contactosTabla.setShowVerticalLines(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${OContactosList}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, contactosTabla);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idContacto}"));
        columnBinding.setColumnName("Id Contacto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pseudonimo}"));
        columnBinding.setColumnName("Pseudonimo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${direccion}"));
        columnBinding.setColumnName("Direccion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${direccionReferencias}"));
        columnBinding.setColumnName("Direccion Referencias");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${colonia}"));
        columnBinding.setColumnName("Colonia");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(contactosTabla);
        contactosTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //setContactoActual(oContactosList.get((Integer)contactosTabla.getModel().getValueAt(contactosTabla.convertRowIndexToModel(contactosTabla.getSelectedRow()), 0)-1));
                // contactoActual=new Contacto(contactoActual.getIdContacto(), contactoActual.getTipo(), contactoActual.getNombre(), contactoActual.getDireccion(), contactoActual.getColonia(), contactoActual.getCodigoPostal(), contactoActual.getLocalidad(), contactoActual.getMunicipio(), contactoActual.getEstado(), contactoActual.getPais());

                //jXTable1.getSelectionModel().getLeadSelectionIndex();
                setContactoActual(contactoController.findContacto((Integer)contactosTabla.getModel().getValueAt(contactosTabla.convertRowIndexToModel(contactosTabla.getSelectedRow()),0)));
                telefonosTabla.packAll();
            }
        });
        contactosTabla.getColumnExt (contactosTabla.getColumnModel().getColumn(0).getIdentifier()).setVisible(false);
        contactosTabla.packAll();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void editarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarJBActionPerformed
        editarContacto();
          
    }//GEN-LAST:event_editarJBActionPerformed

    private void cancelarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJBActionPerformed
        updateListaContactos();
        //contactosTabla.revalidate();
        cancelarEdicion();
    }//GEN-LAST:event_cancelarJBActionPerformed

    private void guardarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarJBActionPerformed
        editarJB.setEnabled(true);
        cancelarJB.setEnabled(false);
        guardarJB.setEnabled(false);
        setOContactosList(getOContactosList());
    }//GEN-LAST:event_guardarJBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarJB;
    private javax.swing.JTextField codigoPostalTF;
    private javax.swing.JTextField coloniaTF;
    private javax.swing.JTextArea comentariosTA;
    private org.jdesktop.swingx.JXTable contactosTabla;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JButton editarJB;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField estadoTF;
    private javax.swing.JButton guardarJB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXTable jXTable3;
    private javax.swing.JLabel labelCPostal;
    private javax.swing.JLabel labelColonia;
    private javax.swing.JLabel labelComentarios;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelLocalidad;
    private javax.swing.JLabel labelMunicipio;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPais;
    private javax.swing.JLabel labelPseudonimo;
    private javax.swing.JTextField localidadTF;
    private javax.persistence.EntityManager mainEntityManager;
    private javax.swing.JTextField municipioTF;
    private java.util.List<Contacto> oContactosList;
    private java.util.List<Telefono> oTelefonosList;
    private javax.swing.JTextField paisTF;
    private javax.persistence.Query queryContactos;
    private javax.persistence.Query queryTelefonos;
    private javax.swing.JTextField referenciasDireccionTF;
    private org.jdesktop.swingx.JXTable telefonosTabla;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void editarContacto(){
        guardarJB.setEnabled(true);
        cancelarJB.setEnabled(true);
        editarJB.setEnabled(false);
    }
    private void cancelarEdicion(){
      
        guardarJB.setEnabled(false);
        cancelarJB.setEnabled(false);
        editarJB.setEnabled(true);
    }
    private void limparCamposContacto(){

    }
    private void guardarEdicionContacto(){
        
    }
    private void updateListaContactos(){
        
        queryContactos=mainEntityManager.createQuery("SELECT c FROM Contacto c WHERE c.tipo LIKE :tipo");
        queryContactos.setParameter("tipo", "trabajador");

        setOContactosList(((List<Contacto>) queryContactos.getResultList()));
    }
    private void enableFields(){
        direccionTF.setEnabled(true);
        referenciasDireccionTF.setEnabled(true);
        coloniaTF.setEnabled(true);
        codigoPostalTF.setEnabled(true);
        comentariosTA.setEnabled(true);
        emailTF.setEnabled(true);
        paisTF.setEnabled(true);
        localidadTF.setEnabled(true);
        municipioTF.setEnabled(true);
        estadoTF.setEnabled(true);
        contactosTabla.setEditable(true);
        telefonosTabla.setEditable(true);
    }
    private void disableFields(){
        direccionTF.setEnabled(false);
        referenciasDireccionTF.setEnabled(false);
        coloniaTF.setEnabled(false);
        codigoPostalTF.setEnabled(false);
        comentariosTA.setEnabled(false);
        emailTF.setEnabled(false);
        paisTF.setEnabled(false);
        localidadTF.setEnabled(false);
        municipioTF.setEnabled(false);
        estadoTF.setEnabled(false);
        contactosTabla.setEditable(false);
        telefonosTabla.setEditable(false);
    }
}
