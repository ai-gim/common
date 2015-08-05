/**   
* @Title: ResourceNotFoundException.java 
* @Package com.asiainfo.gim.common.rest.exception 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhangli
* @date 2015年7月27日 下午1:52:49 
* @version V1.0   
*/
package com.asiainfo.gim.common.rest.exception;

/**
 * @author zhangli
 *
 */
public class ResourceNotFoundException extends RestException
{
	private static final long serialVersionUID = -8308324826675079123L;

	public ResourceNotFoundException()
	{
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ResourceNotFoundException(String message)
	{
		super(message);
	}

	public ResourceNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
