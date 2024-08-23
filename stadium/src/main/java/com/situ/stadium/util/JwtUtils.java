package com.situ.stadium.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class JwtUtils {

    public static String encode(String admin, Map<String, Object> payload, String secret) {
        JWTCreator.Builder builder = JWT.create();

        builder.withAudience(admin);
        builder.withExpiresAt(Instant.now().plusSeconds(1800));
        builder.withIssuedAt(Instant.now());

        builder.withJWTId(UUID.randomUUID().toString());

        builder.withSubject("jwt");

        builder.withPayload(payload);

        return builder.sign(Algorithm.HMAC256(secret));
    }

    public static DecodedJWT decode(String token, String secret) {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }

    public static void main(String[] args) {
        PasswordEncryptor pe = new StrongPasswordEncryptor();
        String pwd = "1234";
        System.out.println(pe.encryptPassword(pwd));
    }

}
