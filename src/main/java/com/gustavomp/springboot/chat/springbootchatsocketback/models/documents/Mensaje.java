package com.gustavomp.springboot.chat.springbootchatsocketback.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

// Anotacion para trabajar con MongoDB
@Document(collection = "mensajes")
public class Mensaje implements Serializable {

    @Id
    private String id;

    private String texto;
    private Long fecha;

    private String tipo;
    private String color;

    private String username;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id='" + id + '\'' +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    // serial version
    private static final long serialVersionUID = 1L;
}
