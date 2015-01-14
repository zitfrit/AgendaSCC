/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

import java.beans.*;

/**
 *
 * @author JTF
 */
public class ContactoBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( agendascc.DATA.Contacto.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor
    // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_codigoPostal = 0;
    private static final int PROPERTY_colonia = 1;
    private static final int PROPERTY_comentarios = 2;
    private static final int PROPERTY_direccion = 3;
    private static final int PROPERTY_direccionReferencias = 4;
    private static final int PROPERTY_email = 5;
    private static final int PROPERTY_estado = 6;
    private static final int PROPERTY_idContacto = 7;
    private static final int PROPERTY_imagen = 8;
    private static final int PROPERTY_localidad = 9;
    private static final int PROPERTY_municipio = 10;
    private static final int PROPERTY_nombre = 11;
    private static final int PROPERTY_pais = 12;
    private static final int PROPERTY_propertyChangeSupport = 13;
    private static final int PROPERTY_pseudonimo = 14;
    private static final int PROPERTY_telefonoList = 15;
    private static final int PROPERTY_tipo = 16;
    private static final int PROPERTY_vetoableChangeSupport = 17;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[18];
    
        try {
            properties[PROPERTY_codigoPostal] = new PropertyDescriptor ( "codigoPostal", agendascc.DATA.Contacto.class, "getCodigoPostal", "setCodigoPostal" ); // NOI18N
            properties[PROPERTY_colonia] = new PropertyDescriptor ( "colonia", agendascc.DATA.Contacto.class, "getColonia", "setColonia" ); // NOI18N
            properties[PROPERTY_comentarios] = new PropertyDescriptor ( "comentarios", agendascc.DATA.Contacto.class, "getComentarios", "setComentarios" ); // NOI18N
            properties[PROPERTY_direccion] = new PropertyDescriptor ( "direccion", agendascc.DATA.Contacto.class, "getDireccion", "setDireccion" ); // NOI18N
            properties[PROPERTY_direccionReferencias] = new PropertyDescriptor ( "direccionReferencias", agendascc.DATA.Contacto.class, "getDireccionReferencias", "setDireccionReferencias" ); // NOI18N
            properties[PROPERTY_email] = new PropertyDescriptor ( "email", agendascc.DATA.Contacto.class, "getEmail", "setEmail" ); // NOI18N
            properties[PROPERTY_estado] = new PropertyDescriptor ( "estado", agendascc.DATA.Contacto.class, "getEstado", "setEstado" ); // NOI18N
            properties[PROPERTY_idContacto] = new PropertyDescriptor ( "idContacto", agendascc.DATA.Contacto.class, "getIdContacto", "setIdContacto" ); // NOI18N
            properties[PROPERTY_imagen] = new PropertyDescriptor ( "imagen", agendascc.DATA.Contacto.class, "getImagen", "setImagen" ); // NOI18N
            properties[PROPERTY_localidad] = new PropertyDescriptor ( "localidad", agendascc.DATA.Contacto.class, "getLocalidad", "setLocalidad" ); // NOI18N
            properties[PROPERTY_municipio] = new PropertyDescriptor ( "municipio", agendascc.DATA.Contacto.class, "getMunicipio", "setMunicipio" ); // NOI18N
            properties[PROPERTY_nombre] = new PropertyDescriptor ( "nombre", agendascc.DATA.Contacto.class, "getNombre", "setNombre" ); // NOI18N
            properties[PROPERTY_pais] = new PropertyDescriptor ( "pais", agendascc.DATA.Contacto.class, "getPais", "setPais" ); // NOI18N
            properties[PROPERTY_propertyChangeSupport] = new PropertyDescriptor ( "propertyChangeSupport", agendascc.DATA.Contacto.class, "getPropertyChangeSupport", null ); // NOI18N
            properties[PROPERTY_pseudonimo] = new PropertyDescriptor ( "pseudonimo", agendascc.DATA.Contacto.class, "getPseudonimo", "setPseudonimo" ); // NOI18N
            properties[PROPERTY_telefonoList] = new PropertyDescriptor ( "telefonoList", agendascc.DATA.Contacto.class, "getTelefonoList", "setTelefonoList" ); // NOI18N
            properties[PROPERTY_tipo] = new PropertyDescriptor ( "tipo", agendascc.DATA.Contacto.class, "getTipo", "setTipo" ); // NOI18N
            properties[PROPERTY_vetoableChangeSupport] = new PropertyDescriptor ( "vetoableChangeSupport", agendascc.DATA.Contacto.class, "getVetoableChangeSupport", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
    // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_propertyChangeListener = 0;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[1];
    
        try {
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( agendascc.DATA.Contacto.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events
    // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_cloneContacto0 = 0;
    private static final int METHOD_copyFromDummy1 = 1;
    private static final int METHOD_equals2 = 2;
    private static final int METHOD_getSerialVersionUID3 = 3;
    private static final int METHOD_hashCode4 = 4;
    private static final int METHOD_makeContactoDummy5 = 5;
    private static final int METHOD_toString6 = 6;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[7];
    
        try {
            methods[METHOD_cloneContacto0] = new MethodDescriptor(agendascc.DATA.Contacto.class.getMethod("cloneContacto", new Class[] {agendascc.DATA.Contacto.class})); // NOI18N
            methods[METHOD_cloneContacto0].setDisplayName ( "" );
            methods[METHOD_copyFromDummy1] = new MethodDescriptor(agendascc.DATA.Contacto.class.getMethod("copyFromDummy", new Class[] {agendascc.DATA.Contacto.class})); // NOI18N
            methods[METHOD_copyFromDummy1].setDisplayName ( "" );
            methods[METHOD_equals2] = new MethodDescriptor(agendascc.DATA.Contacto.class.getMethod("equals", new Class[] {java.lang.Object.class})); // NOI18N
            methods[METHOD_equals2].setDisplayName ( "" );
            methods[METHOD_getSerialVersionUID3] = new MethodDescriptor(agendascc.DATA.Contacto.class.getMethod("getSerialVersionUID", new Class[] {})); // NOI18N
            methods[METHOD_getSerialVersionUID3].setDisplayName ( "" );
            methods[METHOD_hashCode4] = new MethodDescriptor(agendascc.DATA.Contacto.class.getMethod("hashCode", new Class[] {})); // NOI18N
            methods[METHOD_hashCode4].setDisplayName ( "" );
            methods[METHOD_makeContactoDummy5] = new MethodDescriptor(agendascc.DATA.Contacto.class.getMethod("makeContactoDummy", new Class[] {})); // NOI18N
            methods[METHOD_makeContactoDummy5].setDisplayName ( "" );
            methods[METHOD_toString6] = new MethodDescriptor(agendascc.DATA.Contacto.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString6].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods
    // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons

    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx


//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will belong
     * to the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client
     * of getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors.
     * <P>
     * Returns -1 if there is no default property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors.
     * <P>
     * Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from this
     * method.
     * <p>
     * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
     * mono, 32x32 mono). If a bean choses to only support a single icon we
     * recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background so they can be
     * rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
    
}
