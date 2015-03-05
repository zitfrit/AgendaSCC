/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendascc.DATA;

import agendascc.DATA.exceptions.NonexistentEntityException;
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

    public void create(Telefono telefono) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contacto idContacto = telefono.getIdContacto();
            if (idContacto != null) {
                idContacto = em.getReference(idContacto.getClass(), idContacto.getIdContacto());
                telefono.setIdContacto(idContacto);
            }
            em.persist(telefono);
            if (idContacto != null) {
                idContacto.getTelefonoList().add(telefono);
                idContacto = em.merge(idContacto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Telefono telefono) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefono persistentTelefono = em.find(Telefono.class, telefono.getIdTelefono());
            Contacto idContactoOld = persistentTelefono.getIdContacto();
            Contacto idContactoNew = telefono.getIdContacto();
            if (idContactoNew != null) {
                idContactoNew = em.getReference(idContactoNew.getClass(), idContactoNew.getIdContacto());
                telefono.setIdContacto(idContactoNew);
            }
            telefono = em.merge(telefono);
            if (idContactoOld != null && !idContactoOld.equals(idContactoNew)) {
                idContactoOld.getTelefonoList().remove(telefono);
                idContactoOld = em.merge(idContactoOld);
            }
            if (idContactoNew != null && !idContactoNew.equals(idContactoOld)) {
                idContactoNew.getTelefonoList().add(telefono);
                idContactoNew = em.merge(idContactoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = telefono.getIdTelefono();
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

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefono telefono;
            try {
                telefono = em.getReference(Telefono.class, id);
                telefono.getIdTelefono();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telefono with id " + id + " no longer exists.", enfe);
            }
            Contacto idContacto = telefono.getIdContacto();
            if (idContacto != null) {
                idContacto.getTelefonoList().remove(telefono);
                idContacto = em.merge(idContacto);
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
    public List<Telefono> findTelefonosListFromContacto(Contacto c) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT t FROM Telefono t where t.idContacto=:cID");
            q.setParameter("cID", c);
            return (List<Telefono>)q.getResultList();
        } finally {
            em.close();
        }
    }
    public Telefono findTelefono(Integer id) {
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
