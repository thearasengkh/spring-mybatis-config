package com.theara.spring.model.cbc;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "REQUEST")
public class REQUEST
{
	private MESSAGE MESSAGE;

	private String ACTION;

	private String SERVICE;

	private HEADER HEADER;

	public MESSAGE getMESSAGE ()
	{
		return MESSAGE;
	}

	public void setMESSAGE (MESSAGE MESSAGE)
	{
		this.MESSAGE = MESSAGE;
	}

	public String getACTION ()
	{
		return ACTION;
	}

	public void setACTION (String ACTION)
	{
		this.ACTION = ACTION;
	}

	public String getSERVICE ()
	{
		return SERVICE;
	}

	public void setSERVICE (String SERVICE)
	{
		this.SERVICE = SERVICE;
	}

	public HEADER getHEADER ()
	{
		return HEADER;
	}

	public void setHEADER (HEADER HEADER)
	{
		this.HEADER = HEADER;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [MESSAGE = "+MESSAGE+", ACTION = "+ACTION+", SERVICE = "+SERVICE+", HEADER = "+HEADER+"]";
	}
}
