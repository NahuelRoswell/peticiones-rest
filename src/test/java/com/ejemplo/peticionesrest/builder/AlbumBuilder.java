package com.ejemplo.peticionesrest.builder;

import com.ejemplo.peticionesrest.domain.Album;
import com.somospnt.test.builder.AbstractBuilder;


public class AlbumBuilder extends AbstractBuilder<Album> {

    private AlbumBuilder(){
        instance = new Album();
        instance.setId(1L);
        instance.setIdUsuario(1L);
        instance.setTitulo("Titulo default");
    }

    public static AlbumBuilder albumValido() {
        AlbumBuilder albumBuilder = new AlbumBuilder();
        return albumBuilder;
    }

    public AlbumBuilder conTitulo(String titulo) {
        instance.setTitulo(titulo);
        return this;
    }
}
