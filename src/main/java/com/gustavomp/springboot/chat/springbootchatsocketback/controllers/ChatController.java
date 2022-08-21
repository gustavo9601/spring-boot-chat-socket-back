package com.gustavomp.springboot.chat.springbootchatsocketback.controllers;

import com.gustavomp.springboot.chat.springbootchatsocketback.models.documents.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/mensaje") // prefijo + el evento // donde el cliente consumira para publicar
    @SendTo("/chat/mensaje") // prefijo + el canal // notificara a todos los clientes
    public Mensaje recibeMensaje(Mensaje mensaje) {

        System.out.println("Mensaje original=\t" + mensaje);
        mensaje.setFecha(new Date().getTime());
        System.out.println("Mensaje modificado=\t" + mensaje);

        if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
            mensaje.setTexto("Nuevo usuario");
            mensaje.setColor("#" + Integer.toHexString(new Double(Math.random() * 0xFFFFFF).intValue()));
        }

        return mensaje;
    }


    @MessageMapping("/escribiendo") // prefijo + el evento // donde el cliente consumira para publicar
    @SendTo("/chat/escribiendo") // prefijo + el canal // notificara a todos los clientes
    public String escribiendo(String username) {
        return username + " esta escribiendo...";
    }
}
