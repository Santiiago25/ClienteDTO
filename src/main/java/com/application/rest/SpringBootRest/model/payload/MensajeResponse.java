package com.application.rest.SpringBootRest.model.payload;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor //genera los contructores
@NoArgsConstructor //genera contructor vacio
@ToString
@Builder //nos permite enviar datos en vez de usar los constructores
public class MensajeResponse implements Serializable {

    private String mensaje;

    private Object object;

}
