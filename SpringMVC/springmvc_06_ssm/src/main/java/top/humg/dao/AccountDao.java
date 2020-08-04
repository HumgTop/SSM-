package top.humg.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.humg.domain.Account;

import java.util.List;

/**
 * Account数据库操作接口，存入spring容器中，并整合Mybatis。
 */
@Repository("accountDao")
public interface AccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account (name, money) values (#{name}, #{money})")
    void saveAccount(Account account);
}
