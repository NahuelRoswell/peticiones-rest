package com.ejemplo.peticionesrest.repository;

import com.ejemplo.peticionesrest.domain.Album;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class AlbumRepository {
    @Value("${peticiones-rest.json-place-holder-url}")
    private String jsonPlaceholderUrl;
    private final RestTemplate restTemplate;

    public AlbumRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Album> obtenerAlbumes(){
        String albumesUri = UriComponentsBuilder
                .fromHttpUrl(jsonPlaceholderUrl)
                .path("albums")
                .toUriString();

        return asList(restTemplate.getForObject(albumesUri, Album[].class));
    }

}
