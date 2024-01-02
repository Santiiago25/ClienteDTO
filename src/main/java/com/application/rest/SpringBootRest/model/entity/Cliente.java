package com.application.rest.SpringBootRest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor //genera los contructores
@NoArgsConstructor //genera contructor vacio
@ToString
@Entity //definiendo que la clase es una entidad
@Builder
@Table(name = "clientes") //nombre de la tabla
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}