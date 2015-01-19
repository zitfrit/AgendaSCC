/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.UI;
import agendascc.DATA.*;
import agendascc.DATA.exceptions.NonexistentEntityException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author JTF
 */
public class Tries2 extends javax.swing.JFrame {

    private agendascc.DATA.Contacto contactoActual;
    public static final String PROP_CONTACTOACTUAL = "contactoActual";
    public static final String PROP_CONTACTOSELECCIONADO = "contactoSeleccionado";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private transient final VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);
    private List<Contacto> oContactosList;
    public static final String PROP_OCONTACTOSLIST = "oContactosList";
    private Contacto contactoFromList;
    ContactoJpaController contactoController;


    public Tries2() {
        
        initComponents();
        jXTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        //setContactoActual(oContactosList.get((Integer)contactosTabla.getModel().getValueAt(contactosTabla.convertRowIndexToModel(contactosTabla.getSelectedRow()), 0)-1));
                       // contactoActual=new Contacto(contactoActual.getIdContacto(), contactoActual.getTipo(), contactoActual.getNombre(), contactoActual.getDireccion(), contactoActual.getColonia(), contactoActual.getCodigoPostal(), contactoActual.getLocalidad(), contactoActual.getMunicipio(), contactoActual.getEstado(), contactoActual.getPais());

                       //jXTable1.getSelectionModel().getLeadSelectionIndex();
                        if(!jXTable1.getSelectionModel().isSelectionEmpty())
                        {
                            try {
                                setContactoActual(contactoController.findContacto((Integer)jXTable1.getModel().getValueAt(jXTable1.convertRowIndexToModel(jXTable1.getSelectedRow()),0)));
                            } catch (PropertyVetoException ex) {
                                Logger.getLogger(Tries2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
        
                jXTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        //setContactoActual(oContactosList.get((Integer)contactosTabla.getModel().getValueAt(contactosTabla.convertRowIndexToModel(contactosTabla.getSelectedRow()), 0)-1));
                       // contactoActual=new Contacto(contactoActual.getIdContacto(), contactoActual.getTipo(), contactoActual.getNombre(), contactoActual.getDireccion(), contactoActual.getColonia(), contactoActual.getCodigoPostal(), contactoActual.getLocalidad(), contactoActual.getMunicipio(), contactoActual.getEstado(), contactoActual.getPais());

                       //jXTable1.getSelectionModel().getLeadSelectionIndex();
                        if(!jXTable2.getSelectionModel().isSelectionEmpty())
                        {
                            contactoActualJL.setText(contactoActual.getTelefonoList().get(0).getTelefonoPK().getTelefono());
                        }
                    }
                });
          //      org.jdesktop.beansbinding.BeanProperty.create("text")
    }

    public Contacto getContactoSeleccionado() {
        return contactoSeleccionado;
    }

    public void setContactoSeleccionado(Contacto contactoSeleccionado) throws PropertyVetoException {
        Contacto oldContactoSeleccionado = this.contactoSeleccionado;
        vetoableChangeSupport.fireVetoableChange(PROP_CONTACTOSELECCIONADO, oldContactoSeleccionado, contactoSeleccionado);
        this.contactoSeleccionado = contactoSeleccionado;
        propertyChangeSupport.firePropertyChange(PROP_CONTACTOSELECCIONADO, oldContactoSeleccionado, contactoSeleccionado);
    }
    
    public int getSelectedElementIndex()
    {
       return (Integer) jXTable1.getModel().getValueAt(jXTable1.convertRowIndexToModel(jXTable1.getSelectedRow()), jXTable1.convertColumnIndexToModel(0));
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

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AgendaSCCPU").createEntityManager();
        contactoController = java.beans.Beans.isDesignTime() ? null : new ContactoJpaController(entityManager1.getEntityManagerFactory());
        query1 = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT C FROM Contacto C");
        contactoSeleccionado = new agendascc.DATA.Contacto();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        contactoActualJL = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        oContactosListCJL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectedElementJL = new javax.swing.JLabel();
        contactoActualTF = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        oContactosListCTF = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        selectedElementTF = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jXTable3 = new org.jdesktop.swingx.JXTable();

        oContactosList= java.beans.Beans.isDesignTime() ? null : ObservableCollections.observableList((List<Contacto>) query1.getResultList());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${oContactosList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jXTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idContacto}"));
        columnBinding.setColumnName("IdContacto");
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
        jScrollPane1.setViewportView(jXTable1);

        jButton1.setText("ShowContactoActual");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ShowOcontactosList.C.Pseudonimo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Show");

        jLabel1.setText("ContactoActual.Telefono(0).TelefonoPK");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${contactoActual.telefonoList.telefonoPK.telefono}"), contactoActualJL, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel3.setText("OcontactosList.C.Pseudonimo");

        jLabel5.setText("contactoSeleccionado");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contactoSeleccionado, org.jdesktop.beansbinding.ELProperty.create("${nombre}"), selectedElementJL, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        contactoActualTF.setText("jTextField1");

        jButton4.setText("set");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jXTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombre}"), oContactosListCTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jButton5.setText("set");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        selectedElementTF.setText("jTextField3");

        jButton6.setText("set");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefonoList}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jXTable1, eLProperty, jXTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contacto}"));
        columnBinding.setColumnName("Contacto");
        columnBinding.setColumnClass(agendascc.DATA.Contacto.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefonoPK.telefono}"));
        columnBinding.setColumnName("Telefono PK");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lada}"));
        columnBinding.setColumnName("Lada");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${extension}"));
        columnBinding.setColumnName("Extension");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jXTable2);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${contactoActual.telefonoList}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jXTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contacto}"));
        columnBinding.setColumnName("Contacto");
        columnBinding.setColumnClass(agendascc.DATA.Contacto.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefonoPK.telefono}"));
        columnBinding.setColumnName("Telefono PK");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lada}"));
        columnBinding.setColumnName("Lada");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${extension}"));
        columnBinding.setColumnName("Extension");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(jXTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectedElementJL, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(selectedElementTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oContactosListCJL, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(oContactosListCTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contactoActualJL, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(contactoActualTF, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(0, 98, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(oContactosListCJL))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(contactoActualTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(contactoActualJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(oContactosListCTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectedElementJL)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectedElementTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jLabel3, oContactosListCJL});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, jLabel5, selectedElementJL});

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            //List<Telefono> oldTelefonoList=contactoActual.getTelefonoList();
            String oldTelefono = contactoActual.getTelefonoList().get(0).getTelefonoPK().getTelefono();
            contactoActual.getTelefonoList().get(0).getTelefonoPK().setTelefono(contactoActualTF.getText());
            propertyChangeSupport.firePropertyChange("contactoActual.telefonoList.telefonoPK.telefono", oldTelefono, contactoActual.getTelefonoList().get(0).getTelefonoPK().getTelefono());
            // contactoController.edit(contactoActual);
            
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Tries2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Tries2.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        contactoActualJL.setText(contactoActual.getTelefonoList().get(0).getTelefonoPK().getTelefono());
        System.out.println("contactoActual.getTelefonoList().get(0).getTelefonoPK().getTelefono()) = " + contactoActual.getTelefonoList().get(0).getTelefonoPK().getTelefono());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        for(int i=0;i<oContactosList.size();i++)
        {
           if((contactoFromList=oContactosList.get(i)).getIdContacto()==getSelectedElementIndex())
               oContactosListCJL.setText(contactoFromList.getPseudonimo());
               
        }
//        oContactosListCJL.setText(oContactosList.get(x));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
                for(int i=0;i<oContactosList.size();i++)
                {
                   if((oContactosList.get(i)).getIdContacto()==getSelectedElementIndex())
                       
                       oContactosList.get(i).setPseudonimo(oContactosListCTF.getText());
                      

                }
            
//            contactoFromList.setPseudonimo(oContactosListCTF.getText());        // TODO add your handling code here:
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Tries2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    public Contacto getContactoActual() {
        return contactoActual;
    }
    /**
     * Set the value of contactoActual
     *
     * @param contactoActual new value of contactoActual
     * @throws java.beans.PropertyVetoException
     */
    public void setContactoActual(Contacto contactoActual) throws PropertyVetoException {
        Contacto oldContactoActual = this.contactoActual;
        vetoableChangeSupport.fireVetoableChange(PROP_CONTACTOACTUAL, oldContactoActual, contactoActual);
        this.contactoActual = contactoActual;
        propertyChangeSupport.firePropertyChange(PROP_CONTACTOACTUAL, oldContactoActual, contactoActual);
    }
    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    /**
     * Add VetoableChangeListener.
     *
     * @param listener
     */
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }
    /**
     * Remove VetoableChangeListener.
     *
     * @param listener
     */
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }
    /**
     * Get the value of oContactosList
     *
     * @return the value of oContactosList
     */
    public List<Contacto> getoContactosList() {
        return oContactosList;
    }
    /**
     * Set the value of oContactosList
     *
     * @param oContactosList new value of oContactosList
     * @throws java.beans.PropertyVetoException
     */
    public void setoContactosList(List<Contacto> oContactosList) throws PropertyVetoException {
        List<Contacto> oldoContactosList = this.oContactosList;
        vetoableChangeSupport.fireVetoableChange(PROP_OCONTACTOSLIST, oldoContactosList, oContactosList);
        this.oContactosList = oContactosList;
        propertyChangeSupport.firePropertyChange(PROP_OCONTACTOSLIST, oldoContactosList, oContactosList);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contactoActualJL;
    private javax.swing.JTextField contactoActualTF;
    private agendascc.DATA.Contacto contactoSeleccionado;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXTable jXTable2;
    private org.jdesktop.swingx.JXTable jXTable3;
    private javax.swing.JLabel oContactosListCJL;
    private javax.swing.JTextField oContactosListCTF;
    private javax.persistence.Query query1;
    private javax.swing.JLabel selectedElementJL;
    private javax.swing.JTextField selectedElementTF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables















}
