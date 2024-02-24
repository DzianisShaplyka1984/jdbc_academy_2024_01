package com.academy.model.dao;

import com.academy.model.domain.Address;
import java.util.List;

public interface AddressDao extends DefaultDao<Address, Integer>{
  List<Address> getByCity(String city);
}
