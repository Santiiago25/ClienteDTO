package com.application.rest.SpringBootRest.service;

import com.application.rest.SpringBootRest.model.dto.ClienteDto;
import com.application.rest.SpringBootRest.model.entity.Cliente;

public interface ICliente {

    ClienteDto save(ClienteDto cliente); //recibe como dato cliente y lo guarda (POST, PUT)

    ClienteDto findById(Long id); //busca por id (GET)

    void delete(ClienteDto cliente); //eliminar el cliente (DELETE)

}
