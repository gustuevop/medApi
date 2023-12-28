package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public record TokenRecord (
        String token,
        String dataExpiracao
) {
    public TokenRecord(String tokenJWT) {
        this(tokenJWT, pegaDataExpiracao(tokenJWT));
    }

    private static String pegaDataExpiracao(String tokenJWT) {
        Date dataExpiracao = JWT.decode(tokenJWT).getExpiresAt();
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dataExpiracao);
    }

}

