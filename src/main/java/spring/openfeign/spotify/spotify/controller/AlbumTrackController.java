package spring.openfeign.spotify.spotify.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.openfeign.spotify.spotify.client.album_track.AlbumTrack;
import spring.openfeign.spotify.spotify.client.album_track.AlbumTrackClient;
import spring.openfeign.spotify.spotify.client.album_track.AlbumTrackWrapper;
import spring.openfeign.spotify.spotify.client.login.AuthSpotifyClient;
import spring.openfeign.spotify.spotify.client.login.LoginRequest;

import java.util.List;

@RestController
@RequestMapping(value = "/spotify/api")
public class AlbumTrackController {
    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumTrackClient albumTrackClient;

    public AlbumTrackController(AuthSpotifyClient authSpotifyClient, AlbumTrackClient albumTrackClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.albumTrackClient = albumTrackClient;
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<List<AlbumTrack>> getAlbumTrack(@PathVariable String id){

        var request = new LoginRequest(
                "client_credentials",
                "seu_client_id",
                "seu_client_secret"
        );

        var token = authSpotifyClient.login(request).getAccessToken();

        AlbumTrackWrapper response = albumTrackClient.getAlbumTrack(id, "Bearer " + token);

        return ResponseEntity.ok(response.getItems());
    }
}
