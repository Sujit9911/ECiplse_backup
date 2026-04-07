package hiberanatetask1;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {
    public static void main(String[] args) {

        Transaction transactionSource = null;
        Transaction transactionTarget = null;

        SessionFactory sourceFactory = null;
        SessionFactory targetFactory = null;

        try {
            Configuration sourceCfg = new Configuration();
            sourceCfg.configure("hibernate.cfg.xml"); 
            sourceCfg.addAnnotatedClass(Studentdetails.class);
            sourceFactory = sourceCfg.buildSessionFactory();
            Session sourceSession = sourceFactory.openSession();
            transactionSource = sourceSession.beginTransaction();

            Configuration targetCfg = new Configuration();
            targetCfg.configure("hibernate2.cfg.xml"); 
            targetCfg.addAnnotatedClass(Studentinfo.class);
            targetFactory = targetCfg.buildSessionFactory();
            Session targetSession = targetFactory.openSession();
            transactionTarget = targetSession.beginTransaction();

            List<Studentdetails> studentData = sourceSession.createQuery("FROM Studentdetails", Studentdetails.class).list();

            for (Studentdetails sd : studentData) {
                Studentinfo si = new Studentinfo();
                si.setFirst_name(sd.getFirst_name());
                si.setLast_name(sd.getLast_name());
                si.setAge(sd.getAge());
                si.setCity(sd.getCity());
                si.setPhone_number(sd.getPhone_number());
                targetSession.save(si);
            }

            transactionTarget.commit();
            transactionSource.commit();

            System.out.println("Aapne Hibernate Data Migration Task pura kar liya haii!!!!!!");
            sourceSession.close();
            targetSession.close();
            sourceFactory.close();
            targetFactory.close();

        } catch (Exception e) {
            System.out.println(" Migration mei kuch gadbad huiii haiii bhaiiii!!! " + e.getMessage());
            if (transactionSource != null) transactionSource.rollback();
            if (transactionTarget != null) transactionTarget.rollback();
        }
    }
}
