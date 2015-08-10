/**   
 * @Title: RestContext.java 
 * @Package com.asiainfo.gim.common.rest 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年8月10日 下午2:28:50 
 * @version V1.0   
 */
package com.asiainfo.gim.common.rest;

/**
 * @author zhangli
 *
 */
public class RestContext
{
	private static ThreadLocal<RestSession> restSessionTl = new ThreadLocal<RestSession>();

	public static RestSession getSession()
	{
		RestSession session = restSessionTl.get();
		if (session == null)
		{
			session = new RestSession();
			restSessionTl.set(session);
		}
		return session;
	}
}
