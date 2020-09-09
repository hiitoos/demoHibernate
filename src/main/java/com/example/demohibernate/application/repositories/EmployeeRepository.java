package com.example.demohibernate.application.repositories;

import com.example.demohibernate.application.domain.entities.EmployeeEntity;
import com.example.demohibernate.application.models.EmployeeModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface{
    private static SessionFactory dbConnection;
    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static CriteriaBuilder cb;


    public EmployeeRepository(){
        try {
            Configuration config = new Configuration();
            config.addAnnotatedClass(EmployeeEntity.class);
            config.configure();
            dbConnection = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void Insert(EmployeeEntity employee){
        Session session = dbConnection.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate (employee);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Override
    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> employees = null;
        Session session = dbConnection.openSession();
        Transaction transaction = null;

        try {
            employees = session.createQuery("FROM EmployeeEntity", EmployeeEntity.class).getResultList();
            for (EmployeeEntity empEnt : employees){
                System.out.println ("-------------------------------------");
                System.out.println ("Nombre: " + empEnt.getFirstName ());
                System.out.println ("Apellido: " + empEnt.getLastName ());
                System.out.println ("Salario: " + empEnt.getSalary ());
            }
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return employees;
    }

    @Override
    public EmployeeEntity findById(int id){
        EmployeeEntity employee = null;
        Session session = dbConnection.openSession();
        Transaction transaction = null;
        try {
            employee = session.get(EmployeeEntity.class, id);
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return employee;
    }

    @Override
    public EmployeeEntity deleteById(int id){
        EmployeeEntity employee = null;
        Session session = dbConnection.openSession();
        Transaction transaction = null;
        try {
            employee = session.get(EmployeeEntity.class, id);
            System.out.println (employee.getFirstName () + " " + employee.getLastName () +  " " + employee.getSalary ());
            transaction = session.beginTransaction ();
            session.delete (employee);
            transaction.commit ();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return employee;
    }

    @Override
    public EmployeeEntity editUser(int id) {
        EmployeeEntity employee=null;
        Session session = dbConnection.openSession();
        Transaction transaction = null;
        try {
            employee = session.get(EmployeeEntity.class, id);
            System.out.println (employee.getFirstName () + " " + employee.getLastName () +  " " + employee.getSalary ());
            transaction = session.beginTransaction ();
            session.update(employee);
            transaction.commit ();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return employee;
    }
}
