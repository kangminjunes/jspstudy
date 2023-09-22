package repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao {

  private SqlSessionFactory factory;
  
  private static MemberDao dao = new MemberDao();
  private MemberDao() {
    try {
      String resource = "config/mybatis-config.xml";
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static MemberDao getDao() {
    return dao;
  }
  
}