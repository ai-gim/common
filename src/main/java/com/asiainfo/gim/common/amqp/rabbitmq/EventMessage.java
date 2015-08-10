/**
 * 
 */
package com.asiainfo.gim.common.amqp.rabbitmq;

/**
 * @author zhangli
 *
 */
public class EventMessage
{
	private Context context;
	private Object message;

	public Context getContext()
	{
		return context;
	}

	public void setContext(Context context)
	{
		this.context = context;
	}

	public Object getMessage()
	{
		return message;
	}

	public void setMessage(Object message)
	{
		this.message = message;
	}

}
