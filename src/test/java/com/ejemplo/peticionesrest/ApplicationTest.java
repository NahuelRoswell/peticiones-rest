package com.ejemplo.peticionesrest;

import com.ejemplo.peticionesrest.builder.AlbumBuilder;
import com.ejemplo.peticionesrest.domain.Album;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
public class ApplicationTest {
    protected MockRestServiceServer mockRestServiceServer;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    protected ObjectMapper objectMapper;
    @Value("${peticiones-rest.json-place-holder-url}")
    private String jsonPlaceHolderUri;

    @BeforeEach
    public void setUp() {
        mockRestServiceServer = MockRestServiceServer
                .bindTo(restTemplate)
                .ignoreExpectOrder(true)
                .build();
    }

    protected void mockJsonPlaceHolder() throws JsonProcessingException {
        String albumesUri = UriComponentsBuilder
                .fromHttpUrl(jsonPlaceHolderUri)
                .path("albums")
                .toUriString();

        List<Album> albumes = crearListadoAlbumes();

        mockRestServiceServer
                .expect(method(HttpMethod.GET))
                .andExpect(requestTo(albumesUri))
                .andRespond(withSuccess(objectMapper.writeValueAsString(albumes), MediaType.APPLICATION_JSON));
    }

    private List<Album> crearListadoAlbumes() {
        Album primerAlbum = AlbumBuilder
                .albumValido()
                .build();

        Album segundoAlbum = AlbumBuilder
                .albumValido()
                .conTitulo("Segundo Album")
                .build();

        return List.of(primerAlbum, segundoAlbum);
    }

    @Test
    void contextLoads() {
    }

}
