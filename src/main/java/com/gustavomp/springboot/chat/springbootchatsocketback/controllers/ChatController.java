package com.gustavomp.springboot.chat.springbootchatsocketback.controllers;

import com.gustavomp.springboot.chat.springbootchatsocketback.models.documents.Mensaje;
import com.gustavomp.springboot.chat.springbootchatsocketback.models.services.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    IChatService chatService;


    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/mensaje") // prefijo + el evento // donde el cliente consumira para publicar
    @SendTo("/chat/mensaje") // prefijo + el canal // notificara a todos los clientes
    public Mensaje recibeMensaje(Mensaje mensaje) {

        System.out.println("Mensaje original=\t" + mensaje);
        mensaje.setFecha(new Date().getTime());
        System.out.println("Mensaje modificado=\t" + mensaje);

        if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
            mensaje.setTexto("Nuevo usuario");
            mensaje.setColor("#" + Integer.toHexString(new Double(Math.random() * 0xFFFFFF).intValue()));
        }else{
            System.out.println("Guardando mensaje");
            this.chatService.guardar(mensaje);
        }

        return mensaje;
    }


    @MessageMapping("/escribiendo") // prefijo + el evento // donde el cliente consumira para publicar
    @SendTo("/chat/escribiendo") // prefijo + el canal // notificara a todos los clientes
    public String escribiendo(String username) {
        return username + " esta escribiendo...";
    }


    @MessageMapping("/historial") // prefijo + el evento // donde el cliente consumira para publicar
    public void historial(String clienteId){

        List<Mensaje> mensajes = this.chatService.findFirst10ByOrderByFechaDesc();
        /*
        * No usamos el @SendTo, ya que debemos notificar unicamente a los nuevos clientes que se van uniendo
        * Manejando el id para identificarlos
        * */
        template.convertAndSend("/chat/historial/" + clienteId, mensajes);
    }
}
