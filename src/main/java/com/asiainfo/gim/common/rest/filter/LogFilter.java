/**   
* @Title: LogFilter.java 
* @Package com.asiainfo.gim.auth.api.filter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhangli
* @date 2015年7月9日 下午4:43:49 
* @version V1.0   
*/
package com.asiainfo.gim.common.rest.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhangli
 *
 */
@Priority(1)
public class LogFilter implements ContainerRequestFilter, ContainerResponseFilter
{
	private static Log log = LogFactory.getLog(LogFilter.class);
	private static ObjectMapper om = new ObjectMapper();
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException
	{
		Map<String, Object> responseInfo = new LinkedHashMap<String, Object>();
		responseInfo.put("URI", requestContext.getUriInfo().getAbsolutePath());
		responseInfo.put("Headers", responseContext.getStringHeaders());
		if(responseContext.hasEntity())
		{
			responseInfo.put("response-body", responseContext.getEntity());
		}
		log.info(om.writeValueAsString(responseInfo));
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{
		Map<String, Object> requestInfo = new LinkedHashMap<String, Object>();
		requestInfo.put("URI", requestContext.getUriInfo().getAbsolutePath());
		requestInfo.put("Headers", requestContext.getHeaders());
		
		if(requestContext.hasEntity())
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(requestContext.getEntityStream(), baos);
			
			String body = baos.toString("UTF-8");
			requestInfo.put("request-body", body);
			
			baos.close();
			requestContext.getEntityStream().close();
			requestContext.setEntityStream(new ByteArrayInputStream(body.getBytes("UTF-8")));
		}
		
		log.info(om.writeValueAsString(requestInfo));
	}

}
