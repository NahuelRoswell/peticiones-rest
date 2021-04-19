package com.ejemplo.peticionesrest.business.service;

import com.ejemplo.peticionesrest.ApplicationTest;
import com.ejemplo.peticionesrest.domain.Album;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumServiceTest extends ApplicationTest {
    @Autowired
    private AlbumService albumService;

    @Test
    public void obtenerAlbumes_conJsonPlaceHolderLevantado_retornaListadoDeAlbumes() throws JsonProcessingException {
        mockJsonPlaceHolder();

        List<Album> albumes = albumService.obtenerAlbumes();

        mockRestServiceServer.verify();
    }
}
