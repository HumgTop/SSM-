package test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * mybatis的入门案例
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao daoProxy;

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
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
        daoProxy = session.getMapper(IUserDao.class);
    }

    @After//测试方法执行后执行
    public void close() {
//        session.commit();
        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 入门案例
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }

    @Test
    public void findAllTest(){
        List<User> all = daoProxy.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByConditionTest(){
        User user = new User();
        user.setUserName("%王%");
        user.setUserSex("女");
        List<User> users = daoProxy.findUserByCondition(user);
        System.out.println(users);
    }

    @Test
    public void findInIdsTest(){
        //创建ids集合
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(43);
        ids.add(45);
        ids.add(46);
        //将需要查询的id存入vo的集合中
        QueryVo vo = new QueryVo();
        vo.setIds(ids);
        //查询
        List<User> list = daoProxy.findInIds(vo);
        System.out.println(list);
    }

//    @Test
//    public void addTest() {
//        User user = new User("hmg", new Date(), "男", "芜湖市");
//        System.out.println(user);
//        daoProxy.add(user);//保存对象到数据库
//        System.out.println(user);
//    }
//
//    @Test
//    public void updateUserTest() {
//        User user = new User("胡民港", new Date(), "女", "芜湖市");
//        user.setUserId(52);
//        daoProxy.updateUser(user);//保存对象到数据库
//    }
//
//    @Test
//    public void delUserTest() {
//        daoProxy.delUser(50);//删除数据库中的记录
//    }
//
//    @Test
//    public void findUserByIdTest(){
//        User user = daoProxy.findById(46);
//        System.out.println(user);
//    }
//
//    @Test
//    public void findByNameTest(){
//        List<User> list = daoProxy.findByName("%王%");
//        System.out.println(list);
//    }
//
//    @Test
//    public void findUserByVoTest(){
//        QueryVo vo = new QueryVo();
//        User user = new User();
//        user.setUsername("%王%");
//        vo.setUser(user);
//        List<User> list = daoProxy.findUserByVo(vo);
//        System.out.println(list);
//    }
}
