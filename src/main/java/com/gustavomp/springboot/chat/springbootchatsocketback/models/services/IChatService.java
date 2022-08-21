package com.gustavomp.springboot.chat.springbootchatsocketback.models.services;

import com.gustavomp.springboot.chat.springbootchatsocketback.models.documents.Mensaje;

import java.util.List;

public interface IChatService {
    public List<Mensaje> findFirst10ByOrderByFechaDesc();
    public Mensaje guardar(Mensaje mensaje);
}
