package com.yc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.dao.BaseDao;

@Repository
public class BaseDaoMybatisImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

	private final String mapperPath = "com.yc.dao.";
	
	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int save(T t, String sqlId) {
		return super.getSqlSession().insert(mapperPath+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}
	
	@Override
	public int save(Class<T> clazz, String sqlId,Map<String, Object> parameterMap) {
		return super.getSqlSession().insert(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}

	@Override
	public int save(Class<T> clazz, String sqlId, List<T> list) {
		return super.getSqlSession().insert(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,list);
	}

	@Override
	public int update(T t, String sqlId) {
		return super.getSqlSession().update(mapperPath+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}

	@Override
	public int update(Class<T> clazz, String sqlId) {
		return super.getSqlSession().update(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId);
	}
	
	@Override
	public int update(Class<T> clazz, String sqlId,Map<String, Object> parameterMap) {
		return super.getSqlSession().insert(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}

	@Override
	public int update(Class<T> clazz, String sqlId, List<T> list) {
		return super.getSqlSession().insert(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,list);
	}

	@Override
	public int del(Class<T> clazz, String id, String sqlId) {
		return super.getSqlSession().delete(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,id);
	}

	@Override
	public int del(T t, String sqlId) {
		return super.getSqlSession().delete(mapperPath+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}

	@Override
	public int del(Class<T> clazz, List<Integer> ids, String sqlId) {
		return super.getSqlSession().delete(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,ids);
	}

	@Override
	public int del(Class<T> clazz, String sqlId,Map<String, Object> parameterMap) {
		return super.getSqlSession().delete(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}

	@Override
	public List<T> findAll(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectList(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId);
	}

	@Override
	public List<T> findAll(T t, String sqlId) {
		return super.getSqlSession().selectList(mapperPath+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}
	
	@Override
	public List<T> findAll(Class<T> clazz, String sqlId,Map<String, Object> parameterMap) {
		return super.getSqlSession().selectList(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}
	
	@Override
	public T findOne(Class<T> clazz, String sqlId) {
		List<T> list = super.getSqlSession().selectList(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId);
		if(list != null && list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T findOne(T t, String sqlId) {
		List<T> list = super.getSqlSession().selectList(mapperPath+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
		if(list != null && list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T findOne(Class<T> clazz, String sqlId,Map<String, Object> parameterMap) {
		List<T> list = super.getSqlSession().selectList(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
		if(list != null && list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int getCount(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectOne(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId);
	}
	
	@Override
	public int getCount(T t, String sqlId) {
		return super.getSqlSession().selectOne(mapperPath+t.getClass().getSimpleName()+"Mapper."+sqlId);
	}

	@Override
	public int getCount(Class<T> clazz,Map<String, Object> parameterMap, String sqlId) {
		return super.getSqlSession().selectOne(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}

	@Override
	public double getFunc(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectOne(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId);
	}

	@Override
	public double getFunc(T t, String sqlId) {
		return super.getSqlSession().selectOne(mapperPath+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}

	@Override
	public double getFunc(Class<T> clazz, String sqlId,Map<String, Object> parameterMap) {
		return super.getSqlSession().selectOne(mapperPath+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}
}
