/**   
 * @Title: RestException.java 
 * @Package com.asiainfo.gim.common.rest.exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月27日 下午1:52:01 
 * @version V1.0   
 */
package com.asiainfo.gim.common.rest.exception;

/**
 * @author zhangli
 *
 */
public class RestException extends RuntimeException
{
	private static final long serialVersionUID = -4257914324118279980L;

	public RestException()
	{
		super();
	}

	public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RestException(String message)
	{
		super(message);
	}

	public RestException(Throwable cause)
	{
		super(cause);
	}

}
