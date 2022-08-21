package com.gustavomp.springboot.chat.springbootchatsocketback.models.services;

import com.gustavomp.springboot.chat.springbootchatsocketback.models.dao.ChatRepository;
import com.gustavomp.springboot.chat.springbootchatsocketback.models.documents.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements IChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Mensaje> findFirst10ByOrderByFechaDesc() {
        return this.chatRepository.findFirst10ByOrderByFechaDesc();
    }

    @Override
    public Mensaje guardar(Mensaje mensaje) {
        return this.chatRepository.save(mensaje);
    }
}
