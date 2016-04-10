/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 500Course
 */
public class DBContext {
    private EntityManagerFactory emf;
    private javax.persistence.EntityManager em;

    public DBContext() {
        emf = Persistence.createEntityManagerFactory("Week4PU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void start() {
        if (emf != null) {
            end();
        }
        emf = Persistence.createEntityManagerFactory("Week4PU");
        em = emf.createEntityManager();
    }

    public void end() {
        if (emf != null) {
            em.close();
            emf.close();
            emf = null;
        }
    }
}
