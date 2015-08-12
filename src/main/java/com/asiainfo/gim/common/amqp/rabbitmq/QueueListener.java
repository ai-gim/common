/**
 * 
 */
package com.asiainfo.gim.common.amqp.rabbitmq;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * @author zhangli
 *
 */
public abstract class QueueListener
{
	private static Log log = LogFactory.getLog(QueueListener.class);

	private ConnectionFactory connectionFactory;
	protected String queueName;
	private boolean autoQueue;
	protected String exchange;
	protected String routingKey;

	public void setConnectionFactory(ConnectionFactory connectionFactory)
	{
		this.connectionFactory = connectionFactory;
	}

	public void setQueueName(String queueName)
	{
		this.queueName = queueName;
	}

	public void setAutoQueue(boolean autoQueue)
	{
		this.autoQueue = autoQueue;
	}

	public void setExchange(String exchange)
	{
		this.exchange = exchange;
	}

	public void setRoutingKey(String routingKey)
	{
		this.routingKey = routingKey;
	}

	public void start()
	{
		Connection conn = null;
		Channel channel = null;

		try
		{
			conn = connectionFactory.newConnection();
			channel = conn.createChannel();

			if (autoQueue)
			{
				queueName = channel.queueDeclare().getQueue();
				channel.queueBind(queueName, exchange, routingKey);
			}

			channel.basicConsume(queueName, true, new DefaultConsumer());
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);

			close(channel);
			close(conn);

			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public abstract void execute(String consumerTag, Envelope envelope, BasicProperties basicProperties, byte[] bytes);

	private class DefaultConsumer implements Consumer
	{
		@Override
		public void handleShutdownSignal(String arg0, ShutdownSignalException arg1)
		{

		}

		@Override
		public void handleRecoverOk(String arg0)
		{

		}

		@Override
		public void handleDelivery(String arg0, Envelope arg1, BasicProperties arg2, byte[] arg3) throws IOException
		{
			execute(arg0, arg1, arg2, arg3);
		}

		@Override
		public void handleConsumeOk(String arg0)
		{

		}

		@Override
		public void handleCancelOk(String arg0)
		{

		}

		@Override
		public void handleCancel(String arg0) throws IOException
		{

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
