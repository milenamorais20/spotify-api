package spring.openfeign.spotify.spotify.client.artist;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "ArtistSpotifyClient",
        url = "https://api.spotify.com"
)
public interface ArtistSpotifyClient {

    @GetMapping("/v1/artists/{id}")
    Artist getArtist(@PathVariable("id") String id, @RequestHeader("Authorization") String authorization);
}
