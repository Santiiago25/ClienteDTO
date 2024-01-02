package com.application.rest.SpringBootRest.model.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor //genera los contructores
@NoArgsConstructor //genera contructor vacio
@ToString
@Builder //nos permite enviar datos en vez de usar los constructores
public class ClienteDto {

    private Long idCliente;

    private String nombre;

    private String apellido;

    private String correo;

    private Date fechaRegistro;
}