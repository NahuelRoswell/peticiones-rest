package com.ejemplo.peticionesrest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Album {
    private Long id;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("userId")
    private Long idUsuario;
}
