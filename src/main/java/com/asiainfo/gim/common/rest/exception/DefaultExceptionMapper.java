/**   
 * @Title: DefaultExceptionMapper.java 
 * @Package com.asiainfo.gim.auth.api 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月9日 下午3:56:04 
 * @version V1.0   
 */
package com.asiainfo.gim.common.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.gim.common.rest.Error;

/**
 * @author zhangli
 *
 */
public class DefaultExceptionMapper implements ExceptionMapper<Exception>
{
	private static Log log = LogFactory.getLog(DefaultExceptionMapper.class);

	@Override
	public Response toResponse(Exception e)
	{
		log.error(e.getMessage(), e);
		Error error = new Error();

		if (e instanceof ResourceNotFoundException)
		{
			error.setStatus(Response.Status.NOT_FOUND);
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		else if (e instanceof ValidationException)
		{
			error.setStatus(Response.Status.BAD_REQUEST);
			error.setMessage(e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
		}
		else if(e instanceof UnAuthorizedException)
		{
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		else
		{
			error.setStatus(Response.Status.INTERNAL_SERVER_ERROR);
			error.setMessage(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
}
