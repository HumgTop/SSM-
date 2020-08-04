package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMybatis {

    @Test
    public void test1() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SQLSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //使用工厂生产SQLSession对象
        SqlSession sqlSession = factory.openSession();
        //使用SQLSession的方法创建dao接口的代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        //代理对象执行方法
        List<Account> all = mapper.findAll();
        System.out.println(all);
        //释放资源
        sqlSession.close();
        is.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("艾伦");
        account.setMoney(1000d);
        mapper.saveAccount(account);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
        is.close();
        System.out.println("存入成功");
    }
}
