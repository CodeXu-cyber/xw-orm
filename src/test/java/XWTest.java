import com.entity.User;
import com.mapper.UserMapper;
import com.system.Configuration;
import com.system.XSqlSession;
import org.junit.Test;

public class XWTest {
    @Test
    public void test() {
        XSqlSession xSqlSession = new XSqlSession("src/main/resources/xuwei-mybatis.xml");
        UserMapper userMapper = (UserMapper) xSqlSession.getMapper(UserMapper.class);
        //先查询一下数据库
        System.out.println(userMapper.findAll());
        //创建几个对象,保存到数据库中
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setRealName("一号");
        user1.setSex("男");
        user1.setAddress("河北");
        user2.setRealName("二号");
        user2.setSex("女");
        user2.setAddress("广东");
        user3.setRealName("三号");
        user3.setSex("保密");
        user3.setAddress("北京");
        userMapper.addUser(user1);
        userMapper.addUser(user2);
        userMapper.addUser(user3);
        //再查询一下
        System.out.println(userMapper.findAll());
        //查询一个具体的,然后修改
        User queryOne = userMapper.findById(1);
        System.out.println(queryOne);
        queryOne.setSex("保密");
        userMapper.updateUser(queryOne);
        //看看是否修改成功了
        System.out.println(userMapper.findById(1));
        //删除一个
        userMapper.deleteUser(1);
        //查询
        System.out.println(userMapper.findAll());
    }
}
