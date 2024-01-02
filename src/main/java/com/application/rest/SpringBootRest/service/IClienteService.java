package com.application.rest.SpringBootRest.service;

import com.application.rest.SpringBootRest.model.dto.ClienteDto;
import com.application.rest.SpringBootRest.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<ClienteDto> listAll(); //listar los clientes

    Cliente save(ClienteDto cliente); //recibe como dato cliente y lo guarda (POST, PUT)

    Cliente findById(Long id); //busca por id (GET)

    void delete(Cliente cliente); //eliminar el cliente (DELETE)

    boolean existsById(Long id); //existe el id

}
