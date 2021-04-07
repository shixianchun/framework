package com.jchj.jwt;

import com.jchj.entity.UserInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class JwtBaseUtil {
	    public static final String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
	    public static final String TOKEN_PREFIX = "rlt";
	    public static final String HEADER_AUTH = "Authorization";


    public static String generateToken(String user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", new Random().nextInt());
        map.put("user", user);
        map.put("ts", Instant.now().getEpochSecond());
        String jwt = Jwts.builder()
                .setSubject("user info").setClaims(map)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        String finalJwt = TOKEN_PREFIX + " " +jwt;
        return finalJwt;
    }

    public static String generateToken(UserInfo user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("user", user.getUserName());
        map.put("ts", Instant.now().getEpochSecond());
        String jwt = Jwts.builder()
              .setSubject("user info").setClaims(map)
              .signWith(SignatureAlgorithm.HS512, SECRET)
              .compact();
        String finalJwt = TOKEN_PREFIX + " " +jwt;
        return finalJwt;
    }

    public static Map<String,String> validateToken(String token) {
        if (token != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            Map<String,Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX+" ", ""))
                    .getBody();
            String id =  String.valueOf(body.get("id"));
            String user = (String) (body.get("user"));
            map.put("id", id);
            map.put("user", user);
            if(StringUtils.isEmpty(user)) {
                throw new PermissionBaseException("user is error, please check");
            }
            return map;
        } else {
            throw new PermissionBaseException("token is error, please check");
        }
    }


    public static String getCurrentUserId(HttpServletRequest request){
        return  request.getHeader(JwtConstant.HEADER_USER_ID);

    }

    public static String getCurrentUserName(HttpServletRequest request){
        return  request.getHeader(JwtConstant.HEADER_USER_NAME);

    }

    public static String getCurrentServiceName(HttpServletRequest request){
        return  request.getHeader(JwtConstant.HEADER_SERVICENAME);

    }












}
