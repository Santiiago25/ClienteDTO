package com.application.rest.SpringBootRest.controller;

import com.application.rest.SpringBootRest.model.dto.ClienteDto;
import com.application.rest.SpringBootRest.model.entity.Cliente;
import com.application.rest.SpringBootRest.model.payload.MensajeResponse;
import com.application.rest.SpringBootRest.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private IClienteService clienteService; //se llama al servicio

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        Cliente clienteSave = null;
        try{
            clienteSave = clienteService.save(clienteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(ClienteDto.builder()
                            .idCliente(clienteSave.getIdCliente())
                            .nombre(clienteSave.getNombre())
                            .apellido(clienteSave.getApellido())
                            .correo(clienteSave.getCorreo())
                            .fechaRegistro(clienteSave.getFechaRegistro())
                            .build())
                    .build()
            , HttpStatus.CREATED);

        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED); //error en la base de datos porque no encuentra el id
        }
    }

    @PutMapping("cliente/{id}") //agregamos el id como parametro, la idea es que si el id no existe no cree uno nuevo
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Long id){
        Cliente clienteUpdate = null;
        try{
            if (clienteService.existsById(id)){ //si lo encuentra, que actualice el id
                clienteDto.setIdCliente(id); //validación
                clienteUpdate = clienteService.save(clienteDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Actualizado correctamente")
                        .object(ClienteDto.builder()
                                .idCliente(clienteUpdate.getIdCliente())
                                .nombre(clienteUpdate.getNombre())
                                .apellido(clienteUpdate.getApellido())
                                .correo(clienteUpdate.getCorreo())
                                .fechaRegistro(clienteUpdate.getFechaRegistro())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El registro que desea actualizar no existe en la base datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        //estructura basica para el ResponseEntity

        try{
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){ //en caso que no encuentre el id que se va a eliminar
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                        .mensaje(exDt.getMessage())
                        .object(null)
                        .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR); //error en la base de datos porque no encuentra el id
        }
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id){
         Cliente cliente = clienteService.findById(id);
         if (cliente == null){
             return new ResponseEntity<>(
                     MensajeResponse.builder()
                             .mensaje("El Registro que intenta buscar no existe")
                             .object(null)
                             .build()
                     , HttpStatus.INTERNAL_SERVER_ERROR); //error en la base de datos porque no encuentra el id
         }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Usuario encontrado")
                        .object(ClienteDto.builder()
                                .idCliente(cliente.getIdCliente())
                                .nombre(cliente.getNombre())
                                .apellido(cliente.getApellido())
                                .correo(cliente.getCorreo())
                                .fechaRegistro(cliente.getFechaRegistro())
                                .build())
                        .build()
                , HttpStatus.OK);
    }

}
