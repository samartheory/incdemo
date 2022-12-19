//import org.apache.log4j.BasicConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.*;
import java.util.List;
import java.util.Properties;

//import java.util.logging.Logger;
public class hibernate {
    private final hibernateUtil hbu;
    public hibernate() throws ClassNotFoundException, SQLException {
        hbu = new hibernateUtil();
    }
    public void insert(pojo p) throws SQLException {
        System.out.println("inserting");
        hbu.createSession();
        hbu.beginTrans();
        Session s = hbu.getSession();
        s.save(p);
        hbu.commitTrans();
        hbu.closeSession();
    }
    public List<pojo> selectAll(){
        System.out.println("allselected");
        hbu.createSession();
        hbu.beginTrans();
        Session s = hbu.getSession();
        Query q = s.createQuery("select o from pojo o");
        List<pojo>list = q.getResultList();
        hbu.commitTrans();
        hbu.closeSession();
        return list;
    }
    public void printAll(){
        List<pojo>list = selectAll();
        for(pojo p :list){
            System.out.println(p.getId()+" "+p.getAge()+" "+p.getName());
        }
    }
}
