/**
 * @File: CustomJsonMapTypeHandler.java 
 * @Package  com.asiainfo.gim.common.mybatis.typehandler
 * @Description: 
 * @author luyang
 * @date 2015年7月28日 下午4:30:27 
 * @version V1.0
 * 
 */
/**
 * @File: CustomJsonMapTypeHandler.java 
 * @Package  com.asiainfo.gim.common.mybatis.typehandler
 * @Description: 
 * @author luyang
 * @date 2015年7月28日 下午4:30:27 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.common.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luyang
 *
 */
public class CustomJsonMapTypeHandler implements TypeHandler<Map<String, String>>
{
	@Override
	public Map<String, String> getResult(ResultSet rs, String name) throws SQLException
	{
		String json = rs.getString(name);
		if(!StringUtils.isEmpty(json))
		{
			ObjectMapper om = new ObjectMapper();
			try
			{
				return (Map<String, String>)om.readValue(json, Map.class);
			}
			catch (Exception e)
			{
				return null;
			}
		}
		
		return null;
	}

	@Override
	public Map<String, String> getResult(ResultSet rs, int index) throws SQLException
	{
		String json = rs.getString(index);
		if (!StringUtils.isEmpty(json))
		{
			ObjectMapper om = new ObjectMapper();
			try
			{
				return (Map<String, String>)om.readValue(json, Map.class);
			}
			catch (Exception e)
			{
				return null;
			}
		}
		
		return null;
	}

	@Override
	public Map<String, String> getResult(CallableStatement cs, int index) throws SQLException
	{
		String json = cs.getString(index);
		if(!StringUtils.isEmpty(json))
		{
			ObjectMapper om = new ObjectMapper();
			try
			{
				return (Map<String, String>)om.readValue(json, Map.class);
			}
			catch (Exception e)
			{
				return null;
			}
		}
		
		return null;
	}

	@Override
	public void setParameter(PreparedStatement ps, int index, Map<String, String> map, JdbcType jdbcType)
			throws SQLException
	{
		ObjectMapper om = new ObjectMapper();
		try
		{
			ps.setString(index, om.writeValueAsString(map));
		}
		catch (Exception e)
		{
			ps.setString(index, null);
		}
	}

}
