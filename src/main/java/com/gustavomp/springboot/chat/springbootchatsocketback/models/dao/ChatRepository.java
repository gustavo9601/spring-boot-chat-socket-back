package com.gustavomp.springboot.chat.springbootchatsocketback.models.dao;

import com.gustavomp.springboot.chat.springbootchatsocketback.models.documents.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Mensaje, String> {
    public List<Mensaje> findFirst10ByOrderByFechaDesc();
}
