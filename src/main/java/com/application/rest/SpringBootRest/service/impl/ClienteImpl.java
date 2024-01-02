package com.application.rest.SpringBootRest.service.impl;

import com.application.rest.SpringBootRest.model.dao.ClienteDao;
import com.application.rest.SpringBootRest.model.entity.Cliente;
import com.application.rest.SpringBootRest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteImpl implements ICliente {

    @Autowired //inyeccion de dependencia, la otra forma es creando el constructor
    private ClienteDao clienteDao;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        //orElse --> si el objeto no existe lo marca como null
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
