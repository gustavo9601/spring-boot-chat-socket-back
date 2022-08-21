package com.gustavomp.springboot.chat.springbootchatsocketback.models.documents;

import java.io.Serializable;

public class Mensaje implements Serializable {
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

    @Override
    public String toString() {
        return "Mensaje{" +
                "texto='" + texto + '\'' +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    // serial version
    private static final long serialVersionUID = 1L;
}
