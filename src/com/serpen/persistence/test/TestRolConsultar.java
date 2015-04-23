package com.serpen.persistence.test;

import com.serpen.logic.entity.Role;
import com.serpen.persistence.conf.HibernateUtil;

import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class TestRolConsultar {
     public static void main(String []args){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Role role = (Role) sesion.load(Role.class, 1);
        System.out.println(role);
        sesion.close();
    }
    
}
