package com.theara.spring.model.cbc;

public class MESSAGE
{
	private ENQUIRY ENQUIRY;

	public ENQUIRY getENQUIRY ()
	{
		return ENQUIRY;
	}

	public void setENQUIRY (ENQUIRY ENQUIRY)
	{
		this.ENQUIRY = ENQUIRY;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [ENQUIRY = "+ENQUIRY+"]";
	}
}
