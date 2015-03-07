/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.UI;

import org.jdesktop.swingx.JXPanel;
import agendascc.DATA.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author JTF
 */
public final class ContactosPanel extends JXPanel implements Serializable {
    private String tipoContacto="%";
    private Contacto selectedContacto;
    private Contacto unEditedContacto;
    private List<Telefono> unEdittedTelefonoList;
    
    public static final String PROP_SELECTEDCONTACTO = "selectedContacto";
    public static final String PROP_CONTACTOSLIST = "contactosList";
    public static final String PROP_TIPOCONTACTO = "tipoContacto";
    
    private transient final java.beans.PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    public ContactosPanel()
    {
        super();
        initComponents();
        
        BeanProperty selectedContactoProperty =BeanProperty.create(PROP_SELECTEDCONTACTO);
        ELProperty selectedElementProperty=ELProperty.create("${selectedElement}");
        Binding selectedContactoBinding=Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, contactosTabla, selectedElementProperty, this, selectedContactoProperty);
        bindingGroup.addBinding(selectedContactoBinding);
        selectedContactoBinding.bind();
        this.propertyChangeSupport.addPropertyChangeListener(PROP_TIPOCONTACTO, new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                contactosQuery=mainEntityManager.createQuery("SELECT c FROM Contacto c WHERE c.tipo LIKE :tipo").setParameter("tipo", getTipoContacto());
                //contactosQuery.setParameter("tipo", evt.getNewValue().toString());
                setContactosList(ObservableCollections.observableList(contactosQuery.getResultList()));
//                System.out.println("YA BOTA EL EVENTO el tipo ha cambiado de ["+evt.getOldValue()+"] a ["+evt.getNewValue()+"]");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        mainEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AgendaSCCPU").createEntityManager();
        contactosQuery = java.beans.Beans.isDesignTime() ? null : mainEntityManager.createQuery("SELECT c FROM Contacto c WHERE c.tipo LIKE :tipo").setParameter("tipo", this.tipoContacto);
        contactosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(contactosQuery.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        imagenTipoContacto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        telefonosTabla = new org.jdesktop.swingx.JXTable();
        pseudonimoTF = new javax.swing.JTextField();
        nombreTF = new javax.swing.JTextField();
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

        imagenTipoContacto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenTipoContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendascc/RESOURCES/todos80.png"))); // NOI18N
        imagenTipoContacto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TODOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N

        telefonosTabla.setColumnControlVisible(true);
        telefonosTabla.setEditable(false);
        telefonosTabla.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        telefonosTabla.setMinimumSize(new java.awt.Dimension(300, 360));
        telefonosTabla.setPreferredSize(new java.awt.Dimension(300, 360));
        telefonosTabla.setShowVerticalLines(false);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.telefonoList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, telefonosTabla);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefono}"));
        columnBinding.setColumnName("Telefono");
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

        pseudonimoTF.setFont(new java.awt.Font("Calibri", 2, 20)); // NOI18N
        pseudonimoTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pseudonimoTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pseudonimoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        pseudonimoTF.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.pseudonimo}"), pseudonimoTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        nombreTF.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        nombreTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreTF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nombreTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.nombre}"), nombreTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenTipoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(pseudonimoTF)
                    .addComponent(nombreTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pseudonimoTF))
                        .addComponent(imagenTipoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.comentarios}"), comentariosTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane3.setViewportView(comentariosTA);

        paisTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        paisTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        paisTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.pais}"), paisTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelColonia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelColonia.setText("Colonia:");

        codigoPostalTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        codigoPostalTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        codigoPostalTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.codigoPostal}"), codigoPostalTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        emailTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        emailTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        emailTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.email}"), emailTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        referenciasDireccionTF.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        referenciasDireccionTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        referenciasDireccionTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.direccionReferencias}"), referenciasDireccionTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        coloniaTF.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        coloniaTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        coloniaTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.colonia}"), coloniaTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        localidadTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        localidadTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        localidadTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.localidad}"), localidadTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelEstado.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelEstado.setText("Estado:");

        direccionTF.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        direccionTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        direccionTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.direccion}"), direccionTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelComentarios.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelComentarios.setText("Comentarios:");

        estadoTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        estadoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        estadoTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.estado}"), estadoTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelPais.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        labelPais.setText("Pais:");

        municipioTF.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        municipioTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        municipioTF.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${selectedContacto.municipio}"), municipioTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
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

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${contactosList}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, contactosTabla);
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
        unEdittedTelefonoList= org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Telefono>());
        editarContacto();
    }//GEN-LAST:event_editarJBActionPerformed
    private void cancelarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJBActionPerformed
        cancelarEdicion();
    }//GEN-LAST:event_cancelarJBActionPerformed
    private void guardarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarJBActionPerformed
        try {
            mainEntityManager.getTransaction().begin();
            mainEntityManager.merge(selectedContacto);
            mainEntityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if(mainEntityManager.getTransaction().isActive())
                mainEntityManager.getTransaction().rollback();
        }finally{
            if(mainEntityManager.getTransaction().isActive())
                mainEntityManager.getTransaction().commit();
        }
        disableFields();
        editarJB.setEnabled(true);
        cancelarJB.setEnabled(false);
        guardarJB.setEnabled(false);
    }//GEN-LAST:event_guardarJBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarJB;
    private javax.swing.JTextField codigoPostalTF;
    private javax.swing.JTextField coloniaTF;
    private javax.swing.JTextArea comentariosTA;
    private java.util.List<Contacto> contactosList;
    private javax.persistence.Query contactosQuery;
    private org.jdesktop.swingx.JXTable contactosTabla;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JButton editarJB;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField estadoTF;
    private javax.swing.JButton guardarJB;
    private javax.swing.JLabel imagenTipoContacto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCPostal;
    private javax.swing.JLabel labelColonia;
    private javax.swing.JLabel labelComentarios;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelLocalidad;
    private javax.swing.JLabel labelMunicipio;
    private javax.swing.JLabel labelPais;
    private javax.swing.JTextField localidadTF;
    private javax.persistence.EntityManager mainEntityManager;
    private javax.swing.JTextField municipioTF;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTextField paisTF;
    private javax.swing.JTextField pseudonimoTF;
    private javax.swing.JTextField referenciasDireccionTF;
    private org.jdesktop.swingx.JXTable telefonosTabla;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

/////////////// SETTERS ////////////////////
    public void setContactosList(List<Contacto> listaContactos){
        List<Contacto> oldList=getContactosList();
        this.contactosList=listaContactos;
//        System.out.println("old: "+ oldList+" vs "+"new: "+this.contactosList);
        propertyChangeSupport.firePropertyChange(PROP_CONTACTOSLIST, oldList, this.contactosList);
    }
    public void setSelectedContacto(Contacto contactoNuevo){ 
        Contacto oldSelectedContacto = this.selectedContacto;
        this.selectedContacto = contactoNuevo;
        propertyChangeSupport.firePropertyChange(PROP_SELECTEDCONTACTO, oldSelectedContacto, this.selectedContacto);
    }
    public void setTipoContacto(String tipo) {
        String oldType = this.tipoContacto;
        this.tipoContacto = tipo;
        propertyChangeSupport.firePropertyChange(PROP_TIPOCONTACTO, oldType, this.tipoContacto);
        if(tipoContacto.equals("%")){
            imagenTipoContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendascc/RESOURCES/todos80.png"))); // NOI18N
            imagenTipoContacto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TODOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        }
        else{
            imagenTipoContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendascc/RESOURCES/"+tipoContacto+"80.png"))); // NOI18N
            imagenTipoContacto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, tipoContacto.toUpperCase(), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        }
//        System.out.println("oldType = " + oldType);
//        System.out.println("tipoContacto = " + getTipoContacto());
//        System.out.println("listener = " + propertyChangeSupport.getPropertyChangeListeners("tipoContacto").length);
    }
    
    /////////////// GETTERS /////////////////
    public List<Contacto> getContactosList(){
        return this.contactosList;
    }
    public String getTipoContacto(){
        return this.tipoContacto;
    }
    public Contacto getSelectedContacto(){
        return this.selectedContacto;
    }
    
      ///////METODOS UTILITARIOS/////////////
    public int getSelectedElementIndex(){
       return (Integer) contactosTabla.getModel().getValueAt(contactosTabla.convertRowIndexToModel(contactosTabla.getSelectedRow()), contactosTabla.convertColumnIndexToModel(0));
    }
    private void editarContacto(){
        unEditedContacto=Contacto.cloneIntoDummy(selectedContacto);
        for(Telefono t:unEditedContacto.getTelefonoList()){
            unEdittedTelefonoList.add(new Telefono(t));
        }
        enableFields();
        guardarJB.setEnabled(true);
        cancelarJB.setEnabled(true);
        editarJB.setEnabled(false);
    }
   
    private void cancelarEdicion(){
        Contacto old=selectedContacto;
        List<Telefono> lt=selectedContacto.getTelefonoList();
        selectedContacto.copyFromDummy(unEditedContacto);
        selectedContacto.setTelefonoList(unEdittedTelefonoList);
        propertyChangeSupport.firePropertyChange(PROP_SELECTEDCONTACTO, old, unEditedContacto);
        propertyChangeSupport.firePropertyChange("selectedContacto.telefonoList", lt, unEdittedTelefonoList);
        disableFields();
        guardarJB.setEnabled(false);
        cancelarJB.setEnabled(false);
        editarJB.setEnabled(true);
    }
    private void limparCamposContacto(){
    }
    private void guardarEdicionContacto(){
    }
    private void updateListaContactos(){
//        queryContactos=mainEntityManager.createQuery("SELECT c FROM Contacto c WHERE c.tipo LIKE :tipo");
//        queryContactos.setParameter("tipo", "trabajador");
//        setContactosList(((List<Contacto>) queryContactos.getResultList()));
    }
    private void enableFields(){
        nombreTF.setEnabled(true);
        pseudonimoTF.setEnabled(true);
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
        contactosTabla.setEnabled(false);
        telefonosTabla.setEditable(true);
    }
    private void disableFields(){
        nombreTF.setEnabled(false);
        pseudonimoTF.setEnabled(false);
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
        contactosTabla.setEnabled(true);
        telefonosTabla.setEditable(false);
    }
    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener ){
        propertyChangeSupport.addPropertyChangeListener( listener );
    }
    public void addPropertyChangeListener(String propName, java.beans.PropertyChangeListener listener ){
        propertyChangeSupport.addPropertyChangeListener(propName, listener );
    }
    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener ){
        propertyChangeSupport.removePropertyChangeListener( listener );
    }
    public void removePropertyChangeListener(String propName,java.beans.PropertyChangeListener listener ){
        propertyChangeSupport.removePropertyChangeListener(propName,listener );
    }
}
