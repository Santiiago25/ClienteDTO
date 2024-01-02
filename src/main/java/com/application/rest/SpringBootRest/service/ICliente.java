package com.application.rest.SpringBootRest.service;

import com.application.rest.SpringBootRest.model.entity.Cliente;

public interface ICliente {

    Cliente save(Cliente cliente); //recibe como dato cliente y lo guarda (POST, PUT)

    Cliente findById(Long id); //busca por id (GET)

    void delete(Cliente cliente); //eliminar el cliente (DELETE)

}
