/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Dell
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private String username;
    private String password;
    private String token;

//    private static final Key SECRET_KEY = (Key) Keys.secretKeyFor(SignatureAlgorithm.HS256);
//    public String login() {
//        if ("admin".equals(username) && "admin".equals(password)) {
//            this.token = generateToken(username);
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("jwt", token);
//            return "home.xhtml?faces-redirect=true";
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null,
//                new jakarta.faces.application.FacesMessage("Invalid credentials"));
//            return null;
//        }
//    }
//    
//    private String generateToken(String user) {
//        return Jwts.builder()
//                .setSubject(user)
//                .setIssuer("jsf-jwt-app")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
//                .signWith((java.security.Key) SECRET_KEY)
//                .compact();
//    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

}
