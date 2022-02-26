import com.mapper.UserMapper;
import com.system.XSqlSession;
import org.junit.Test;

public class XWTest {
    @Test
    public void test() {
        XSqlSession xSqlSession = new XSqlSession("src/main/resources/xuwei-mybatis.xml");
        UserMapper userMapper = (UserMapper) xSqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findById(2));
        System.out.println(userMapper.findAll());
    }
}
