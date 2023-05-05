package com.sci.dao;
import com.sci.config.DBConfig;
import com.sci.models.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class DBEmployee {
    public Integer insert(Employee employee) {
        Transaction transaction = null;
        int employeeId = 0;
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            transaction = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
        return employeeId;
    }
}
//    public List<Employee> get( ){
//
//        try(Session session =DBConfig.SESSION_FACTORY.openSession()){
////         return session.createQuery("From Employee").list();
//         return session.createSQLQuery("select * from hr.employees").addEntity(Employee.class).list();
//
//        }catch (Exception ex){
//         System.err.println("DB exception");
//         return new ArrayList<>();
//        }
//
//
//    }

