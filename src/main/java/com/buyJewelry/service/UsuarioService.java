package com.buyJewelry.service;

import com.buyJewelry.model.Usuario;
import com.buyJewelry.util.Transacional;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    @Transacional
    public void salvar(Usuario obj){
        obj.setDesativado("N");
        em.persist(obj);
    }

    public List<Usuario> findAll(){
      return  em.createQuery("from Usuario", Usuario.class).getResultList();
    }

    public Usuario findId(Long id) {
        return em.find(Usuario.class, id);
    }

    public Boolean Login(String loginEmail, String LoginSenha) throws Exception {

        String jpql = "from Usuario where email like :email and senha like :senha";

        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

        query.setParameter("email", loginEmail);
        query.setParameter("senha", LoginSenha);

        Usuario recebe = query.getSingleResult();

        if (recebe.getEmail().equals(loginEmail) && recebe.getSenha().equals(LoginSenha)) {
            System.out.println("Login efetuado com sucesso");
            return Boolean.TRUE;
        } else {
            System.out.println("Login ou senha incorretos");
            return Boolean.FALSE;
        }
    }

}
