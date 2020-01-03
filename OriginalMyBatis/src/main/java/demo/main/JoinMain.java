package demo.main;

import demo.dao.PersonHomeDao;
import demo.model.Home;
import demo.model.PersonHome;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class JoinMain {
    public static void main(String[] args) throws IOException {
        String path = "config/mybatis.xml";

        InputStream is = Resources.getResourceAsStream(path);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        try
        {
            PersonHomeDao homeDao = session.getMapper(PersonHomeDao.class);
            //one to one
            //PersonHome personHome = homeDao.getPersonHome(8);

            //Home home = homeDao.selectHome(1);
            //System.out.println(home.getHomeId() + " : " + home.getHomeAddress());

            //one to many
//            Home home = homeDao.getHomePersons(2);
//            System.out.println(home.getHomeAddress());
//            System.out.println(home.getPersons().size());
            Home home = homeDao.getHome(2);
            System.out.println(home.getHomeAddress());
            System.out.println(home.getPersons().size());
            session.commit();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
