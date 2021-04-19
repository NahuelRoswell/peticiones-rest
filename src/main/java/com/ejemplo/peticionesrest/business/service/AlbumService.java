package com.ejemplo.peticionesrest.business.service;

import com.ejemplo.peticionesrest.domain.Album;
import com.ejemplo.peticionesrest.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public List<Album> obtenerAlbumes() {
        return albumRepository.obtenerAlbumes();
    }
}
