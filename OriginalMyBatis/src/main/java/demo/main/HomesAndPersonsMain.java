package demo.main;

import demo.dao.PersonsAndHomesDao;
import demo.model.Home;
import demo.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class HomesAndPersonsMain {
    public static void main(String[] args) throws IOException {
        SqlSession session = SqlSessionUtils.getSqlSession();;

        try
        {
            PersonsAndHomesDao homeDao = session.getMapper(PersonsAndHomesDao.class);
            //one to one
            //PersonHome personHome = homeDao.getPersonHome(8);

            //Home home = homeDao.selectHome(1);
            //System.out.println(home.getHomeId() + " : " + home.getHomeAddress());

            //one to many
//            Home home = homeDao.getHomePersons(2);
//            System.out.println(home.getHomeAddress());
//            System.out.println(home.getPersons().size());
            List<Home> home = homeDao.getManyHomeAndMaps(1);
            System.out.println(home.size());
            System.out.println(home.get(0).getHomeAddress());
            System.out.println(home.get(0).getPersons().size());
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
