import com.hujia.mapper.EmployeeMapper;
import com.hujia.model.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

  //通用的插入操作
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void testSelect(){
        //序列化类型的 就是object类型的
        /*Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);*/

        //通过多个列查询  通过id 和 age来进行查询
        /*Employee employee = new Employee();
        employee.setAge(44);
        employee.setId(1);
        Employee selectOne = employeeMapper.selectOne(employee);
        System.out.println(selectOne);*/

        //通过多个id进行查询
        /*List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        List<Employee> employees = employeeMapper.selectBatchIds(idList);
        System.out.println(employees);*/


        //selectByMap
        Map<String,Object> columnMap = new HashMap<String, Object>();
        columnMap.put("last_name","jerry");
        columnMap.put("gender",0);
        List<Employee> employees = employeeMapper.selectByMap(columnMap);
        System.out.println(employees);
    }











    /**
     * 通用的更新操作
     */
    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("mybatisplus222");
        employee.setEmail("23456789@qq.com");
        employee.setAge(44);
        /*Integer integer = employeeMapper.updateById(employee);*/
        Integer integer = employeeMapper.updateAllColumnById(employee);
        System.out.println(integer);
    }










    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setAge(1);
      //  employee.setEmail("1232");
      //  employee.setGender(1);
        employee.setLastName("hh");
        Integer result = employeeMapper.insert(employee);
        System.out.println(result);

        //获取当前注解在数据库中的主键值
        Integer key = employee.getId();
        System.out.println(key);
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
