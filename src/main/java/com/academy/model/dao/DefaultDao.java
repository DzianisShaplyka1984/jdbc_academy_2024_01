package com.academy.model.dao;

import com.academy.model.domain.Department;
import java.util.List;

public interface DefaultDao<T, I> {
  void saveOrUpdate(T entity);
  void delete(T entity);
  List<T> getAll();
  T getById(I id);
}
