package cn.web.entity;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test {
	@org.junit.Test
	public void testName() throws Exception {
		//mybatis配置文件
		String resource ="mybatis.xml" ;
		//得到流对象
		InputStream inputStream = Resources.getResourceAsStream(resource) ;
		//创建会话工厂
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(inputStream);
		//通过会话工厂得到会话
		SqlSession sqs= ssf.openSession();
		//通过会话创建数据库
		User user=sqs.selectOne("cn.web.findUserid",40);
		System.out.println(user);
		//List<User> list= sqs.selectList("cn.web.findUname", "张"+"%");
		//sqs.insert("cn.web.insert",new User(40,"Make","2",new Date(),"珠海"));
		//sqs.update("cn.web.update", new User(40,"小杨",null,null,null));
		//sqs.delete("cn.web.deleteByid",30);
		//SELECT LAST_INSERT_ID()
		sqs.commit();
		//关闭会话
		sqs.close();
	}
	
}
