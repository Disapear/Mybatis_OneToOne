import java.util.*;

import com.zhangChen.Entity.Teacher;
import com.zhangChen.Entity.c_class;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import javax.sound.midi.Soundbank;
import java.io.IOException;

public class testDemo {
    SqlSession sqlSession;
    @Before
    public void before()throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("myBatisConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void testSelectOnrToOne(){
        String sql = "com.zhangChen.Mapper.stuMapper.getClass";
        List<c_class> list = sqlSession.selectList(sql,1);
        for (c_class c : list) {
            System.out.println(c.toString());
        }
        //测试一对多
        String sql2 = "com.zhangChen.Mapper.teaMapper.getTeacherClasses";

        List<Teacher> list2 = sqlSession.selectList(sql2);
        for (Teacher teacher : list2) {
            System.out.println(teacher.toString());
            for (c_class cc : teacher.getClasses()){
                System.out.println(cc.getId());
                System.out.println(cc.getName());
            }
        }
    }

    @After
    public void after(){
        System.out.println("查询完毕！");
    }
}