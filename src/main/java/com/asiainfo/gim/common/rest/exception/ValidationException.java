/**   
 * @Title: ValidationException.java 
 * @Package com.asiainfo.gim.common.rest.exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月27日 下午2:02:27 
 * @version V1.0   
 */
package com.asiainfo.gim.common.rest.exception;

/**
 * @author zhangli
 *
 */
public class ValidationException extends RestException
{
	private static final long serialVersionUID = -9085440052398822925L;

	public ValidationException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ValidationException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValidationException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValidationException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
