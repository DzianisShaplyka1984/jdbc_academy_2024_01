package com.academy.model.dao.impl;

import com.academy.model.dao.AddressDao;
import com.academy.model.domain.Address;
import java.util.List;

public class AddressDaoImpl extends DefaultDaoImpl<Address, Integer> implements AddressDao {

  public AddressDaoImpl() {
    super(Address.class);
  }

  @Override
  public List<Address> getByCity(String city) {
    return null;
  }

  @Override
  public List<Address> getAll() {
    return null;
  }

}
