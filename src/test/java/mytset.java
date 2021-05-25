import cn.kgc.dao.DeptDao;
import cn.kgc.domain.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class mytset {
    @Test
    public void fun()throws Exception{
//      1.  获取SQLSessionFactory
//        构建sqlSessionFactory的创建器
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
//        Rescources.getresourceAsStream("全局配置文件的url地址")
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = builder.build(in);
//        2.通过SqlSessionFactory获得Sqlsession
        SqlSession sqlSession = factory.openSession();
        //3.调用SqlSession的方法，执行配置的sql语句
        //使用代理设计模式，自动创建一个指定接口的实现类
        DeptDao dao = sqlSession.getMapper(DeptDao.class);
        List<Dept> depts = dao.selectAll();//方法名称发生变化

        for(Dept d:depts){
            System.out.println(d);
        }

        //释放资源
        sqlSession.close();
    }
    @Test
    public void fun1() throws Exception{
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession(true);
        DeptDao dao = sqlSession.getMapper(DeptDao.class);
        Dept d=new Dept();
        d.setDeptNo(50);
        d.setdName("咨询部");
        d.setLoc("仙桃");
        int x = dao.insert(d);
        System.out.println(x);
        System.out.println(x==1?"添加成功":"添加失败");
        sqlSession.commit();

    }
}
