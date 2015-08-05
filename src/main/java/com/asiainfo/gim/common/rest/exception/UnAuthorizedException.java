/**   
 * @Title: UnAuthorizedException.java 
 * @Package com.asiainfo.gim.common.rest.exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月27日 下午4:59:06 
 * @version V1.0   
 */
package com.asiainfo.gim.common.rest.exception;

/**
 * @author zhangli
 *
 */
public class UnAuthorizedException extends RestException
{
	private static final long serialVersionUID = -2661932169047063501L;

	public UnAuthorizedException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnAuthorizedException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
