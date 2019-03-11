import com.baomidou.mybatisplus.annotations.TableName;
import com.hujia.mapper.EmployeeMapper;
import com.hujia.model.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class JTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

  //通用的插入操作
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setEmail("1232");
        employee.setGender(1);
        employee.setLastName("hh");
        Integer result = employeeMapper.insert(employee);
        System.out.println(result);
    }








    //测试datasource
    @Test
    public void testDataSource() throws Exception{
        DataSource dataSource = ioc.getBean("dataSource",DataSource.class);
        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
