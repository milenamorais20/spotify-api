package spring.openfeign.spotify.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.openfeign.spotify.spotify.client.*;

import java.util.List;

@RestController
@RequestMapping(value = "/spotify/api")
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;

    public AlbumController(AuthSpotifyClient authSpotifyClient, AlbumSpotifyClient albumSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.albumSpotifyClient = albumSpotifyClient;
    }

    @GetMapping("/albums")
    ResponseEntity<List<Album>> helloWorld(){
        var request = new LoginRequest(
                "client_credentials",
                "0b79a7973e0e4edeb4278ea8da96c6b7",
                "8ed8e38c2e8a4bd0aa601a7629378d3f"
        );

        var token = authSpotifyClient.login(request).getAccessToken();
        AlbumReponse response = albumSpotifyClient.getReleases("Bearer " + token);

        return ResponseEntity.ok(response.getAlbums().getItems());
    }
}
