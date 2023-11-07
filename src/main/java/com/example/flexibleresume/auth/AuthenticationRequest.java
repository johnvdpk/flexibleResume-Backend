package com.example.flexibleresume.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private String email;
    String password;
    String role;

}


// Zonder @Data en @AllArgsConstructor

//@Builder
//@NoArgsConstructor
//public class AuthenticationRequest {
//
//    private String email;
//    private String password;
//
//    // Constructor met alle argumenten (vervangt @AllArgsConstructor)
//    public AuthenticationRequest(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    // Getters en setters (vervangt de functionaliteit van @Data)
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    // equals() en hashCode() methoden (ook onderdeel van @Data)
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        AuthenticationRequest that = (AuthenticationRequest) o;
//
//        if (!email.equals(that.email)) return false;
//        return password.equals(that.password);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = email.hashCode();
//        result = 31 * result + password.hashCode();
//        return result;
//    }
//
//    // toString() methode (ook onderdeel van @Data)
//    @Override
//    public String toString() {
//        return "AuthenticationRequest{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}
