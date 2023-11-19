package com.buyJewelry.bean;


import com.buyJewelry.service.UsuarioService;
import com.buyJewelry.util.Transacional;
import com.buyJewelry.model.Usuario;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class LoginMB implements Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioService service;
    private Usuario usuario = new Usuario();
    private Boolean loginStatus = Boolean.FALSE;
    private String email;
    private String senha;


    public void limparFiltro(){
        usuario = new Usuario();
        email = null;
        senha = null;
    }

    @Transacional
    public void cadastrar (){
       service.salvar(usuario);
       limparFiltro();
    }

    public List<Usuario> findall(){
        return service.findAll();
    }

    public void login(){
        try {
            loginStatus = service.Login(email, senha);
        } catch (Exception e) {
            System.out.println("---------------------------------------------------------------------");;
        }
        limparFiltro();
    }

    public void sair(){
        loginStatus = Boolean.FALSE;
        limparFiltro();
    }

    public UsuarioService getService() {
        return service;
    }

    public void setService(UsuarioService service) {
        this.service = service;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
