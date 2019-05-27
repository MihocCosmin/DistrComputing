package org.gae.project;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("GAE");

    private EMF() {
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}
