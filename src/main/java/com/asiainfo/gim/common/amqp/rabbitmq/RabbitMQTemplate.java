/**
 * 
 */
package com.asiainfo.gim.common.amqp.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP.Queue.BindOk;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author zhangli
 *
 */
public class RabbitMQTemplate
{
	private ConnectionFactory connectionFactory;
	private ObjectMapper om = new ObjectMapper();

	public void setConnectionFactory(ConnectionFactory connectionFactory)
	{
		this.connectionFactory = connectionFactory;
	}

	public void send(String exchange, String routingKey, Object obj)
	{
		Connection conn = null;
		Channel channel = null;

		try
		{
			conn = connectionFactory.newConnection();
			channel = conn.createChannel();
			channel.basicPublish(exchange, routingKey, null, format(obj));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(channel);
			close(conn);
		}
	}

	public DeclareOk queueDeclare(String queue)
	{
		Connection conn = null;
		Channel channel = null;

		try
		{
			conn = connectionFactory.newConnection();
			channel = conn.createChannel();
			return channel.queueDeclare(queue, false, false, false, null);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage(), e);
		}
		finally
		{
			close(channel);
			close(conn);
		}
	}

	public com.rabbitmq.client.AMQP.Exchange.DeclareOk exchangeDeclare(String exchange, String type)
	{
		Connection conn = null;
		Channel channel = null;

		try
		{
			conn = connectionFactory.newConnection();
			channel = conn.createChannel();
			return channel.exchangeDeclare(exchange, type);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage(), e);
		}
		finally
		{
			close(channel);
			close(conn);
		}
	}

	public BindOk bind(String exchange, String queue, String routingKey)
	{
		Connection conn = null;
		Channel channel = null;

		try
		{
			conn = connectionFactory.newConnection();
			channel = conn.createChannel();
			return channel.queueBind(queue, exchange, routingKey);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage(), e);
		}
		finally
		{
			close(channel);
			close(conn);
		}
	}

	private byte[] format(Object message)
	{
		try
		{
			return om.writeValueAsBytes(message);
		}
		catch (JsonProcessingException e)
		{
			return String.valueOf(message).getBytes();
		}
	}

	private void close(Channel channel)
	{
		if (channel != null)
		{
			try
			{
				channel.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void close(Connection conn)
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
