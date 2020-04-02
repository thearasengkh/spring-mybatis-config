package com.theara.spring.model.cbc;

public class HEADER
{
	private String RUN_NO;

	private String MEMBER_ID;

	private String USER_ID;

	private String TOT_ITEMS;

	public String getRUN_NO ()
	{
		return RUN_NO;
	}

	public void setRUN_NO (String RUN_NO)
	{
		this.RUN_NO = RUN_NO;
	}

	public String getMEMBER_ID ()
	{
		return MEMBER_ID;
	}

	public void setMEMBER_ID (String MEMBER_ID)
	{
		this.MEMBER_ID = MEMBER_ID;
	}

	public String getUSER_ID ()
	{
		return USER_ID;
	}

	public void setUSER_ID (String USER_ID)
	{
		this.USER_ID = USER_ID;
	}

	public String getTOT_ITEMS ()
	{
		return TOT_ITEMS;
	}

	public void setTOT_ITEMS (String TOT_ITEMS)
	{
		this.TOT_ITEMS = TOT_ITEMS;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [RUN_NO = "+RUN_NO+", MEMBER_ID = "+MEMBER_ID+", USER_ID = "+USER_ID+", TOT_ITEMS = "+TOT_ITEMS+"]";
	}
}
