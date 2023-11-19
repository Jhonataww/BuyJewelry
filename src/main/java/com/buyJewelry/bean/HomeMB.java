package com.buyJewelry.bean;



import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class HomeMB implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean isLogin = false;
    private Boolean isCadastro = false;
    private Boolean isHome = true;

    public void isLogin(){
        isLogin = true;
        isCadastro = false;
        isHome = false;
    }

    public void isCadastro(){
        isLogin = false;
        isCadastro = true;
        isHome = false;
    }

    public void isHome(){
        isLogin = false;
        isCadastro = false;
        isHome = true;
    }

    public void addCadastro(){
        isCadastro = true;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }

    public Boolean getCadastro() {
        return isCadastro;
    }

    public void setCadastro(Boolean cadastro) {
        isCadastro = cadastro;
    }

    public Boolean getHome() {
        return isHome;
    }

    public void setHome(Boolean home) {
        isHome = home;
    }
}
