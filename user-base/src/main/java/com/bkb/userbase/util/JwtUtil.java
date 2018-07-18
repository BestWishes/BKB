package com.bkb.userbase.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class JwtUtil {
    /*我刚开始变量设置的BKB 但是TextCodec.BASE64.decode(“BKB”)编码后是空,需要去研究下BASE64编码*/
    public static final String SECRET = "bkbGoFly";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String USER_ID = "userId";
    public static final long EXPIRATION_TIME = 3600_000_000L; // 1000 hour
    public static final String HEADER_Authorization = "Authorization";

    public static String generateToken(String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(USER_ID, userId);
        String jwt = Jwts.builder().setClaims(map).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return TOKEN_PREFIX + jwt;
    }

    public static HttpServletRequest validateToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER_Authorization);
        try {
            Map<String, Object> body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return new BKBHttpServletRequest(request, body);
        } catch (Exception e) {
            throw new IllegalStateException("Invalid Token." + e.getMessage());
        }
    }

    public static class BKBHttpServletRequest extends HttpServletRequestWrapper {
        private Map<String, String> claims;

        public BKBHttpServletRequest(HttpServletRequest request, Map<String, Object> claims) {
            super(request);
            this.claims = new HashMap<>();
            claims.forEach((k, v) -> this.claims.put(k, String.valueOf(v)));
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            if (claims != null && claims.containsKey(name)) {
                return Collections.enumeration(Arrays.asList(claims.get(name)));
            }
            return super.getHeaders(name);
        }

        public Map<String, String> getClaims() {
            return this.claims;
        }
    }

    static class TokenValidationException extends RuntimeException {
        public TokenValidationException(String msg) {
            super(msg);
        }
    }
}
