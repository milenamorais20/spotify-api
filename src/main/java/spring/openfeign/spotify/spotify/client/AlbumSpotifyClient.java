package spring.openfeign.spotify.spotify.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "AlbumSpotifyCliente",
        url = "https://api.spotify.com"
)
public interface AlbumSpotifyClient {

    @GetMapping("/v1/browse/new-releases")
    AlbumReponse getReleases(@RequestHeader("Authorization") String authorization);

}
