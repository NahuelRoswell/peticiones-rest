package com.ejemplo.peticionesrest.web.controller.rest;

import com.ejemplo.peticionesrest.business.service.AlbumService;
import com.ejemplo.peticionesrest.domain.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/album")
public class AlbumRestController {
    private final AlbumService albumService;

    @GetMapping("/")
    public List<Album> obtenerAlbumes(){
        return albumService.obtenerAlbumes();
    }

}
