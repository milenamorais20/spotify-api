package spring.openfeign.spotify.spotify.client.album_track;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "AlbumTrackClient",
        url = "https://api.spotify.com"
)
public interface AlbumTrackClient {
    @GetMapping("/v1/albums/{id}/tracks")
    AlbumTrackWrapper getAlbumTrack(@PathVariable("id") String id, @RequestHeader("Authorization") String authorization);
}
