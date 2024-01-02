package com.application.rest.SpringBootRest.service.impl;

import com.application.rest.SpringBootRest.model.dao.ClienteDao;
import com.application.rest.SpringBootRest.model.dto.ClienteDto;
import com.application.rest.SpringBootRest.model.entity.Cliente;
import com.application.rest.SpringBootRest.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImplService implements IClienteService {

    @Autowired //inyeccion de dependencia, la otra forma es creando el constructor
    private ClienteDao clienteDao;

    @Override
    public List<ClienteDto> listAll() {
        return (List) clienteDao.findAll();
    }

    @Transactional
    @Override
    public Cliente save(ClienteDto clienteDto) {
        //vamos a instanciar
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .fechaRegistro(clienteDto.getFechaRegistro())
                .build();
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

    @Override
    public boolean existsById(Long id) {
        return clienteDao.existsById(id);
    }
}
