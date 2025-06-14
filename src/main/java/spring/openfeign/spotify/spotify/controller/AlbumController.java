package spring.openfeign.spotify.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.openfeign.spotify.spotify.client.albums_realeases.Album;
import spring.openfeign.spotify.spotify.client.albums_realeases.AlbumReponse;
import spring.openfeign.spotify.spotify.client.albums_realeases.AlbumSpotifyClient;
import spring.openfeign.spotify.spotify.client.login.AuthSpotifyClient;
import spring.openfeign.spotify.spotify.client.login.LoginRequest;

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
                "seu_client_id",
                "seu_client_secret"
        );

        var token = authSpotifyClient.login(request).getAccessToken();
        AlbumReponse response = albumSpotifyClient.getReleases("Bearer " + token);

        return ResponseEntity.ok(response.getAlbums().getItems());
    }
}
