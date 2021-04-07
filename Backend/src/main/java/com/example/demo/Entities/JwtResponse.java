package com.example.demo.Entities;

public class JwtResponse {
  private   String jwt_token;

    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwt_token='" + jwt_token + '\'' +
                '}';
    }

    public String getJwt_token() {
        return jwt_token;
    }

    public void setJwt_token(String jwt_token) {
        this.jwt_token = jwt_token;
    }

    public JwtResponse() {
    }

    public JwtResponse(String jwt_token) {
        this.jwt_token = jwt_token;
    }
}
