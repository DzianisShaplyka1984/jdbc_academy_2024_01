package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.DefaultDao;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

public class DefaultDaoImpl<T, I> implements DefaultDao<T, I> {
  private Class<T> type;

  public DefaultDaoImpl(Class<T> type) {
    this.type = type;
  }
  @Override
  public void saveOrUpdate(T entity) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    entityManager.getTransaction().commit();

//    Session session = DataSource.getInstance().getSession();
//    session.getTransaction().begin();
//    session.saveOrUpdate(entity);
//    session.getTransaction().commit();
  }

  @Override
  public void delete(T entity) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();
    entityManager.getTransaction().begin();
    entity = entityManager.merge(entity);
    entityManager.remove(entity);
    entityManager.getTransaction().commit();
  }

  @Override
  public List<T> getAll() {
    return null;
  }

  @Override
  public T getById(I id) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();
    return entityManager.find(type, id);
  }
}
