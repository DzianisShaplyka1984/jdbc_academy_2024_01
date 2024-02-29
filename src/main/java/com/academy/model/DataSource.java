package com.academy.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class DataSource {
  private static DataSource instance = new DataSource();

  private EntityManagerFactory entityManagerFactory;

  public static DataSource getInstance() {
    return instance;
  }

  private DataSource() {
    entityManagerFactory = Persistence.createEntityManagerFactory("it_academy");
  }

  public EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
  }

  public Session getSession() {
    return getEntityManager().unwrap(Session.class);
  }
}
