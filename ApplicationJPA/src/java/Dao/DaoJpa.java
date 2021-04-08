/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Clients;
import Entity.Medecins;
import Entity.Rv;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author khlifi
 */
public class DaoJpa {

    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction tx;

    public DaoJpa() {
    }

    public void init() {
        emf = Persistence.createEntityManagerFactory("ApplicationJPAPU");
        em = emf.createEntityManager();
//tx = em.getTransaction();
//tx.begin();
    }

    public void close() {
        em.close();
        emf.close();
    }

// ajout d'un médecin 
    public Medecins Ajouter_Medecin(Medecins med) {
        try {

            em.getTransaction().begin();
            em.persist(med);
            em.getTransaction().commit();

            return med;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

// modifier un médecin
    public void Modifier_Medecin(Medecins med) {
        try {

            em.getTransaction().begin();
            med = em.merge(med);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Supprimer_Medecin(Long id) {
        try {
            Medecins m = em.find(Medecins.class, id);
            em.getTransaction().begin();
            m = em.merge(m);
            em.remove(m);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Medecins> Trouver_Med(String nom, String prenom) {
        try {
            em.getTransaction().begin();

            List<Medecins> l = em.createQuery("select h from Medecins h where h.nom='" + nom + "' and h.prenom='" + prenom + "'").getResultList();
            em.getTransaction().commit();
            return l;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // recuperer un client donnÃ©
public Clients getClientById(Long id) {
try {
    em.getTransaction().begin();
Clients ct =  em.find(Clients.class, id);
 em.getTransaction().commit();
 return ct;
} catch (Exception e) {
e.printStackTrace();
return null;
}
}
// recuperer un mÃ©decin donnÃ©
public Medecins getMedecinById(Long id) {
try {
    

             em.getTransaction().begin();
        Medecins m = em.find(Medecins.class, id);
         em.getTransaction().commit();
        return m;
} catch (Exception e) {
e.printStackTrace();
return null;
}
}
    
    public Rv Ajouter_RDV(Rv rv) {
try {
//Rv rv = new Rv(jour,client);
em.getTransaction().begin();
		em.persist(rv);
		em.getTransaction().commit();
return rv;
} catch (Exception e) {
e.printStackTrace();
return null;
}
}

}
