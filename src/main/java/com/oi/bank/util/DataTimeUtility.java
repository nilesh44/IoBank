package com.oi.bank.util;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DataTimeUtility {
	
	public static Timestamp getSqlTimeStamp(String timeStamp) {
		return StringUtils.isNotBlank(timeStamp)
				? new Timestamp(Long.parseLong(timeStamp))
				: new Timestamp(new Date().getTime());
	}

}
