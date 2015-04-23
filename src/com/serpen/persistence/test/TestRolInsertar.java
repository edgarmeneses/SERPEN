/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpen.persistence.test;

import com.serpen.logic.entity.Role;
import com.serpen.persistence.conf.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author USER
 */
public class TestRolInsertar {
    public static void main(String[] args) {
        try {
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            Role rol = (Role) sesion.load(Role.class, 5);
            rol = new Role(1,"eliana" );    
            sesion.save(rol);       
            transaction.commit();
            sesion.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }   
}
