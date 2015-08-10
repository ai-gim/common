/**
 * 
 */
package com.asiainfo.gim.common.amqp.rabbitmq;

import java.util.Date;

/**
 * @author zhangli
 *
 */
public class Context
{
	private String tag;
	private Date time;
	private String resourceType;
	private String resourceId;

	/**
	 * 0: collector 1: agent
	 */
	private int collector;

	public Context()
	{
		super();
	}

	public Context(String tag, Date time, String resourceType, String resourceId, int collector)
	{
		super();
		this.tag = tag;
		this.time = time;
		this.resourceType = resourceType;
		this.resourceId = resourceId;
		this.collector = collector;
	}

	public String getTag()
	{
		return tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

	public String getResourceType()
	{
		return resourceType;
	}

	public void setResourceType(String resourceType)
	{
		this.resourceType = resourceType;
	}

	public String getResourceId()
	{
		return resourceId;
	}

	public void setResourceId(String resourceId)
	{
		this.resourceId = resourceId;
	}

	public int getCollector()
	{
		return collector;
	}

	public void setCollector(int collector)
	{
		this.collector = collector;
	}

}
