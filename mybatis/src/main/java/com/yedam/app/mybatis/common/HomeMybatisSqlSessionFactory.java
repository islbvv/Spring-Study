package com.yedam.app.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HomeMybatisSqlSessionFactory {
	// DAO 역할을 해줄 클래스 : 싱글톤
	private static SqlSessionFactory sqlSessionFactory;

	private HomeMybatisSqlSessionFactory() {
		String resource = "config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			new HomeMybatisSqlSessionFactory();
		}
		return sqlSessionFactory;
	}
}
