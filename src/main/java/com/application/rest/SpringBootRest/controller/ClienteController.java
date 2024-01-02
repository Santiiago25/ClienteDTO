package com.application.rest.SpringBootRest.controller;

import com.application.rest.SpringBootRest.model.dto.ClienteDto;
import com.application.rest.SpringBootRest.model.entity.Cliente;
import com.application.rest.SpringBootRest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ICliente clienteService; //se llama al servicio

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody ClienteDto clienteDto){
        Cliente clienteSave = clienteService.save(clienteDto);
        return Cliente.builder()
                .idCliente(clienteSave.getIdCliente())
                .nombre(clienteSave.getNombre())
                .apellido(clienteSave.getApellido())
                .correo(clienteSave.getCorreo())
                .fechaRegistro(clienteSave.getFechaRegistro())
                .build();
    }

    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody ClienteDto clienteDto){
        return clienteService.save(cliente);
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        //estructura basica para el ResponseEntity
        Map<String, Object> response = new HashMap<>();
        try{
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){ //en caso que no encuentre el id que se va a eliminar
            //vamos a enviar un mapa de errores
            response.put("mensaje: ", exDt.getMessage()); //enviamos la exception
            response.put("cliente: ", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); //error en la base de datos porque no encuentra el id
        }
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDto showById(@PathVariable Long id){
        return clienteService.findById(id);
    }

}
