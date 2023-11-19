package com.buyJewelry.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ApplicationScoped
public class EntityProducer {

    private EntityManagerFactory emf;

    public EntityProducer() {
      emf = Persistence.createEntityManagerFactory("bancoPU");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager(){
        return this.emf.createEntityManager();
    }

    public void closeEntiyManager(@Disposes EntityManager em){
        em.close();
    }


}
