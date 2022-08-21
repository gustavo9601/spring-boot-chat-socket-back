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
    public void recibeMensaje(Mensaje mensaje) {

        System.out.println("Mensaje original=\t" + mensaje.getTexto());

        mensaje.setFecha(new Date().getTime());
        mensaje.setTexto("Mensaje recibido en el broker=\t" + mensaje.getTexto());

        System.out.println("Mensaje modificado=\t" + mensaje.getTexto());

    }

}
