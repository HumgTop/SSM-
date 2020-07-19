package test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * mybatis的入门案例
 */
public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDaoProxy;

    @Before//测试方法执行前执行
    public void init() {
        //1.读取配置文件
        in = null;
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        //4.使用SqlSession创建Dao接口的代理对象
    }

//    @After//测试方法执行后执行
//    public void close() {
////        session.commit();
//        session.close();
//        try {
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @Test
    public void findAllTest(){
        List<User> list = userDaoProxy.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void firstLevelCacheTest(){
        User user1 = userDaoProxy.findById(41);
        System.out.println(user1);

        session.clearCache();

        User user2 = userDaoProxy.findById(41);
        System.out.println(user2);

        System.out.println(user1==user2);//判断user1和user2是否为同一个对象
    }

    @Test
    public void secondLevelCacheTest(){
        SqlSession session1 = factory.openSession(true);
        IUserDao dao1 = session1.getMapper(IUserDao.class);
        User user1 = dao1.findById(41);
        session1.close();//一级缓存消失

        SqlSession session2 = factory.openSession(true);
        IUserDao dao2 = session2.getMapper(IUserDao.class);
        User user2 = dao2.findById(41);
        session2.close();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1==user2);
    }
}
