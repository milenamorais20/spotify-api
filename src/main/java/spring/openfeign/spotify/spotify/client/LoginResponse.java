package spring.openfeign.spotify.spotify.client;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) Pode ser usado ao invés do @JsonProperty("access_token")
public class LoginResponse {

    @JsonProperty("access_token")
    private String accessToken;
}
