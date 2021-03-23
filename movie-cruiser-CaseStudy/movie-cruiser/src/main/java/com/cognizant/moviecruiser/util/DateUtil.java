package com.cognizant.moviecruiser.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

public static Date convertToDate(String date)
	{
		try {
			return	new SimpleDateFormat("dd/MM/yyyy").parse(date);
			 
		}
		catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		return null;
	}
}
