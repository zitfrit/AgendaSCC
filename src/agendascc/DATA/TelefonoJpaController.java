/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

import agendascc.DATA.exceptions.NonexistentEntityException;
import agendascc.DATA.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author JTF
 */
public class TelefonoJpaController implements Serializable {

    public TelefonoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Telefono telefono) throws PreexistingEntityException, Exception {
        if (telefono.getTelefonoPK() == null) {
            telefono.setTelefonoPK(new TelefonoPK());
        }
        telefono.getTelefonoPK().setIdContacto(telefono.getContacto().getIdContacto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contacto contacto = telefono.getContacto();
            if (contacto != null) {
                contacto = em.getReference(contacto.getClass(), contacto.getIdContacto());
                telefono.setContacto(contacto);
            }
            em.persist(telefono);
            if (contacto != null) {
                contacto.getTelefonoList().add(telefono);
                contacto = em.merge(contacto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTelefono(telefono.getTelefonoPK()) != null) {
                throw new PreexistingEntityException("Telefono " + telefono + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Telefono telefono) throws NonexistentEntityException, Exception {
        telefono.getTelefonoPK().setIdContacto(telefono.getContacto().getIdContacto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefono persistentTelefono = em.find(Telefono.class, telefono.getTelefonoPK());
            Contacto contactoOld = persistentTelefono.getContacto();
            Contacto contactoNew = telefono.getContacto();
            if (contactoNew != null) {
                contactoNew = em.getReference(contactoNew.getClass(), contactoNew.getIdContacto());
                telefono.setContacto(contactoNew);
            }
            telefono = em.merge(telefono);
            if (contactoOld != null && !contactoOld.equals(contactoNew)) {
                contactoOld.getTelefonoList().remove(telefono);
                contactoOld = em.merge(contactoOld);
            }
            if (contactoNew != null && !contactoNew.equals(contactoOld)) {
                contactoNew.getTelefonoList().add(telefono);
                contactoNew = em.merge(contactoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TelefonoPK id = telefono.getTelefonoPK();
                if (findTelefono(id) == null) {
                    throw new NonexistentEntityException("The telefono with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TelefonoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefono telefono;
            try {
                telefono = em.getReference(Telefono.class, id);
                telefono.getTelefonoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telefono with id " + id + " no longer exists.", enfe);
            }
            Contacto contacto = telefono.getContacto();
            if (contacto != null) {
                contacto.getTelefonoList().remove(telefono);
                contacto = em.merge(contacto);
            }
            em.remove(telefono);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Telefono> findTelefonoEntities() {
        return findTelefonoEntities(true, -1, -1);
    }

    public List<Telefono> findTelefonoEntities(int maxResults, int firstResult) {
        return findTelefonoEntities(false, maxResults, firstResult);
    }

    private List<Telefono> findTelefonoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Telefono.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Telefono findTelefono(TelefonoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telefono.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelefonoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Telefono> rt = cq.from(Telefono.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
