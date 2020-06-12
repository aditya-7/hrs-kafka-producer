package com.ltts.produce;

import org.json.simple.JSONObject;

public class AlarmMessage {

	public static JSONObject createAlarmsMessage(String server, int id, String timestamp) {
		JSONObject message = new JSONObject();
		// Combination of Server Name and EventID
		message.put("gDAServerEventID", id + "#" + server);
		// From defined SERVERS variable
		message.put("dsaServerName", server);
		// Random "Invalid reader" or ""
		message.put("accessReason", ((id % 2 == 0) ? "Invalid reader" : ""));
		message.put("action", "");
		// 2 or 6
		message.put("alarmCategory", ((id % 2 == 0) ? 2 : 6));
		message.put("alarmLimit", ((id % 2 == 0) ? 0 : 110));
		message.put("alarmRepeatCount", ((id % 2 == 0) ? 33691 : 18814));
		message.put("alarmTime", timestamp);
		// 2 or 6
		message.put("alarmType", ((id % 2 == 0) ? 2 : 6));
		message.put("alertAccess", 0);
		message.put("areaName", ((id % 2 == 0) ? "$ASSETMODEL" : "MUMPWBMB1_9F"));
		// 2 or 52 or 48 or 61 or 49
		message.put("areaNumber", ((id % 2 == 0) ? 52 : 48));
		message.put("author", "");
		message.put("basicBlockNumber", 0);
		message.put("block", "");
		message.put("cardEncodingId", 0);
		// Random number or ""
		message.put("cardNumber", ((id % 2 == 0) ? id + 6 : ""));
		message.put("cardholderFirstName", "Leo");
		// Random small number or 0
		message.put("cardholderId", ((id % 2 == 0) ? id - 100 : 5834));
		message.put("cardholderLastName", "DiCaprio");
		// Random Employee or ""
		message.put("cardholderType", ((id % 2 == 0) ? "" : "Employee"));
		// 2 or 15
		message.put("category", ((id % 2 == 0) ? 2 : 15));
		// Point Alarm or Access Alarm or System Alarm
		message.put("categoryName", ((id % 2 == 0) ? "Point Alarm" : "Access Alarm"));
		message.put("changedTime", timestamp);
		message.put("classification", "");
		message.put("comment", "");
		// ALARM or DENIED
		message.put("condition", ((id % 2 == 0) ? "STARTED" : "DENIED"));
		message.put("controllerSpecificAlarmData", 0);
		// CH4C4_DigitalPoint(number)
		message.put("description",
				((id % 2 == 0) ? "CH4C4_DigitalPoint(" + (id - 200) + ")" : "CH4C4_DigitalPoint(" + (id - 100) + ")"));
		// SERVER name
		message.put("dsaConnectionName", server);
		// SERVER name
		message.put("dsaServerAlias", server);
		message.put("eECode", 0);
		// 0 or 280
		message.put("eEInitId", ((id % 2 == 0) ? 0 : 280));
		message.put("executionId", 0);
		message.put("expireTime", timestamp);
		message.put("fieldTime", timestamp);
		message.put("flags", 0);		
		// U 00 or L 00 or U 02
		message.put("fullPriorityString", ((id % 2 == 0) ? "U 00" : "L 00"));
		message.put("gdaConnectionNumber", 0);
		message.put("gdaOriginalConnectionNumber", 0);
		// Random big number
		message.put("generatedCookie", id+25698);
		message.put("hostTime", timestamp);
		// EventId
		message.put("id", id);
		message.put("ioLimEE", 0);
		message.put("link1", "");
		message.put("link1Type", 0);
		message.put("link2", "");
		message.put("link2Type", 0);
		message.put("link3", "");
		message.put("link3Type", 0);
		// /Facility or /Facility/MUMPWB
		message.put("locationFullName", ((id % 2 == 0) ? "/Facility" : "/Facility/MUMPWB"));
		// Facility or MUMPWBMB1_9F or MUMPWBMB1_GF
		message.put("locationTagName", ((id % 2 == 0) ? "MUMPWBMB1_9F" : "MUMPWBMB1_GF"));		
		message.put("oldestRepeatTime", timestamp);
		message.put("operator", "");
		message.put("originalAreaNumber", 0);
		message.put("originalParentPointNumber", 0);
		message.put("parameterNumber", 1);
		message.put("parentPointNumber", 0);
		message.put("pointNumber", 0);
		// 0 or 1
		message.put("previousValueType", ((id % 2 == 0) ? 0 : 1));
		// 3 or 1
		message.put("priority", ((id % 2 == 0) ? 3 : 1));
		message.put("quality", 192);
		message.put("reason", "");
		message.put("receivedDelay", 0);
		message.put("sequenceId", 0);
		// 32 or 34
		message.put("serverAlarmState", ((id % 2 == 0) ? 32 : 34));
		message.put("serverSuppliedCookie", 0);
		message.put("severity", 0);
		message.put("shelveReason", "");
		message.put("shelveState", 0);
		message.put("shelveTime", timestamp);
		message.put("signature2Level", 0);
		message.put("signatureMeaning", "");
		message.put("signatureMeaning2", "");
		// CH4C4_DigitalPoint(number)
		message.put("source", ((id % 2 == 0) ? "CH4C4_DigitalPoint("+(id-236)+")" : "CH4C4_DigitalPoint("+(id-258)+")"));
		// same as source key's value
		message.put("sourceEntityName", ((id % 2 == 0) ? "CH4C4_DigitalPoint("+(id-236)+")" : "CH4C4_DigitalPoint("+(id-258)+")"));
		message.put("station", "");
		message.put("storedQuality", 192);
		message.put("subCondition", "");
		message.put("subPriority", 0);
		// Random big number
		message.put("transactionId", ((id % 2 == 0) ? id+2589 : id+3698));
		message.put("transitDirection", "");
		message.put("transitType", "");
		message.put("unacknowledegeTimeoutMinutes", 0);
		message.put("units", "");
		// 0 or 1
		message.put("valueType", ((id % 2 == 0) ? 0 : 1));
		// POWB_MB1_G_FB04I or POWB_MB1_7_HUBI or PWAMB1_09_MDRI or POWB_MB1_12_AYI
		message.put("zoneEntered", ((id % 2 == 0) ? "POWB_MB1_G_FB04I" : "POWB_MB1_12_AYI"));
		return message;
	}
}