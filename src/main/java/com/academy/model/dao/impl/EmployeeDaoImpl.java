package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.EmployeeDao;
import com.academy.model.domain.Address;
import com.academy.model.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeDaoImpl extends DefaultDaoImpl<Employee, Integer> implements EmployeeDao {

  public EmployeeDaoImpl() {
    super(Employee.class);
  }

  public List<Employee> getAll() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("from Employee");

    return query.getResultList();
  }


  public List<Employee> getAllWithAddress() {
    return null;
  }

  public List<Employee> getByName(String name) {
    return null;
  }

  @Override
  public List<Employee> getBySalary(int salary) {
    return null;
  }

  @Override
  public List<String> getNames() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("select name from Employee");

    return query.getResultList();
  }

  @Override
  public List<Integer> getSalary() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("select salary from Employee");

    return query.getResultList();
  }

  @Override
  public List<Address> getAddress() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("select E.addresses from Employee as E");

    return query.getResultList();
  }

  @Override
  public Employee findById(Integer id) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("from Employee where id=?1");
    query.setParameter(1, id);

    return (Employee) query.getResultList().get(0);
  }

  @Override
  public List<Object> getCountNames() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("select count(id), name from Employee group by name");

    return query.getResultList();
  }

  @Override
  public void updateSalary(Integer id, Integer salary) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();
    entityManager.getTransaction().begin();
    Query query = entityManager.createQuery("update Employee set salary=:salary where id=:id");
    query.setParameter("id", id);
    query.setParameter("salary", salary);
    query.executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Override
  public void deleteEmployee(Integer id) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();
    entityManager.getTransaction().begin();
    Query query = entityManager.createQuery("delete Employee where id=:id");
    query.setParameter("id", id);
    query.executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Override
  public void insertEmployee(Integer id) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();
    entityManager.getTransaction().begin();
    Query query = entityManager.createQuery("insert into Employee(name, salary, year, email) select name, salary, year, email from Employee where id=:id");
    query.setParameter("id", id);
    query.executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Override
  public List<Integer> getMaxSalary() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("select max(salary), name from Employee group by name");

    return query.getResultList();
  }

  @Override
  public List<Employee> findSorted(boolean sort, String orderBy) {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

//    String hql = "from Employee ";
//
//    if (sort) {
//      hql += " order by id ";
//
//      if (orderBy.equalsIgnoreCase("asc")) {
//        hql += " asc";
//      } else if (orderBy.equalsIgnoreCase("desc")) {
//        hql += " desc";
//      }
//    }
//
//    Query query = entityManager.createQuery(hql);

//    return query.getResultList();

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
    Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

    if (sort) {

      Order order = null;
      if (orderBy.equalsIgnoreCase("asc")) {
        order = criteriaBuilder.asc(employeeRoot.get("id"));
      } else if (orderBy.equalsIgnoreCase("desc")) {
        order = criteriaBuilder.desc(employeeRoot.get("id"));
      }

      criteriaQuery.select(employeeRoot).orderBy(order);
    }

    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  @Override
  public List<Employee> getAllCriteria() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
    Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

    Predicate predicate = criteriaBuilder.and(
        criteriaBuilder.equal(employeeRoot.get("name"), "Ivan123"),
        criteriaBuilder.or(
            criteriaBuilder.ge(employeeRoot.get("salary"), 1000),
            criteriaBuilder.isNull(employeeRoot.get("salary"))
        )
    );

    criteriaQuery.select(employeeRoot).where(predicate);

    return entityManager.createQuery(criteriaQuery).getResultList();
  }
}
