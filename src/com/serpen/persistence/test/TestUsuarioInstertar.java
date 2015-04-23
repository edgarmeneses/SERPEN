/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpen.persistence.test;

import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.StateType;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USER
 */
public class TestUsuarioInstertar {

    public static void main(String[] args) {
        
        try {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
             Role  role  = (Role) sesion.load(Role.class,1);
            //Role rol = new Role();
             //rol.setId(1);
             //rol.setName("Andrea");
            User user = new User( );
            user.setNickname(2);
            user.setPassword("mi contraseña");
            user.setEstado('A');
            user.setRol(role);
            user.setAnswer("mi respuesta Seguridad");
            //sesion.save(rol);
            sesion.save(user);
            transaction.commit();
            sesion.close();
        } catch (Exception e) {
            System.err.println("no se puede ingresar aca"+e);
        }
    }

}
