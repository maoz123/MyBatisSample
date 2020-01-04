package demo.main;

import demo.dao.PersonHomeDao;
import demo.model.Home;
import demo.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class JoinMain {
    public static void main(String[] args) throws IOException {
        SqlSession session = SqlSessionUtils.getSqlSession();

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
