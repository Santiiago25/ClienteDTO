package com.application.rest.SpringBootRest.controller;

import com.application.rest.SpringBootRest.model.entity.Cliente;
import com.application.rest.SpringBootRest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ICliente clienteService; //se llama al servicio

    @PostMapping("cliente")
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("cliente")
    public Cliente update(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping("cliente/{id}")
    public void delete(@PathVariable Long id){
        Cliente clienteDelete = clienteService.findById(id);
        clienteService.delete(clienteDelete);
    }

    @GetMapping("cliente/{id}")
    public Cliente showById(@PathVariable Long id){
        return clienteService.findById(id);
    }

}
