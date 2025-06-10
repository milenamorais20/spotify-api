package spring.openfeign.spotify.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.openfeign.spotify.spotify.client.artist.Artist;
import spring.openfeign.spotify.spotify.client.artist.ArtistSpotifyClient;
import spring.openfeign.spotify.spotify.client.login.AuthSpotifyClient;
import spring.openfeign.spotify.spotify.client.login.LoginRequest;

@RestController
@RequestMapping(value = "/spotify/api")
public class ArtistController {

    private final AuthSpotifyClient authSpotifyClient;

    private final ArtistSpotifyClient artistSpotifyClient;

    public ArtistController(AuthSpotifyClient authSpotifyClient, ArtistSpotifyClient artistSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.artistSpotifyClient = artistSpotifyClient;
    }

    @GetMapping("/artist/{id}")
    public ResponseEntity<Artist> getArtist(@PathVariable String id){
        var request = new LoginRequest(
                "client_credentials",
                "seu_client_id",
                "seu_client_secret"
        );

        var token = authSpotifyClient.login(request).getAccessToken();

        Artist artist = artistSpotifyClient.getArtist(id, "Bearer " + token);

        return ResponseEntity.ok(artist);
    }
}
