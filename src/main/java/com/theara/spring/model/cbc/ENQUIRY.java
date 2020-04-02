package com.theara.spring.model.cbc;

public class ENQUIRY
{
	private String ENQUIRY_REFERENCE;

	public String getENQUIRY_REFERENCE ()
	{
		return ENQUIRY_REFERENCE;
	}

	public void setENQUIRY_REFERENCE (String ENQUIRY_REFERENCE)
	{
		this.ENQUIRY_REFERENCE = ENQUIRY_REFERENCE;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [ENQUIRY_REFERENCE = "+ENQUIRY_REFERENCE+"]";
	}
}
