package com.application.rest.SpringBootRest.model.dao;

import com.application.rest.SpringBootRest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
