/**   
* @Title: RestSession.java 
* @Package com.asiainfo.gim.common.rest 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhangli
* @date 2015年8月10日 下午2:29:56 
* @version V1.0   
*/
package com.asiainfo.gim.common.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangli
 *
 */
public class RestSession
{
	private Map<String, Object> container = new HashMap<String, Object>();
	
	public void setAttribute(String name, Object value)
	{
		container.put(name, value);
	}
	
	public Object getAttribute(String name)
	{
		return container.get(name);
	}
}
