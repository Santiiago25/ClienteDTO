package com.application.rest.SpringBootRest.service.impl;

import com.application.rest.SpringBootRest.model.dao.ClienteDao;
import com.application.rest.SpringBootRest.model.entity.Cliente;
import com.application.rest.SpringBootRest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteImpl implements ICliente {

    @Autowired //inyeccion de dependencia, la otra forma es creando el constructor
    private ClienteDao clienteDao;

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true) //especifica que es solo una consulta
    @Override
    public Cliente findById(Long id) {
        //orElse --> si el objeto no existe lo marca como null
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
