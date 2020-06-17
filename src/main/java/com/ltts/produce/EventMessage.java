package com.ltts.produce;

import org.json.simple.JSONObject;

public class EventMessage {
	public static JSONObject createEventMessage(String server, int id, String timestamp, String eventId) {
		JSONObject message = new JSONObject();
		// Combination of Server Name and EventID
		System.out.println(eventId + "#" + server);
		message.put("gDAServerEventID", id + "#" + server);
		// From defined SERVERS variable
		message.put("dsaServerName", server);
		// Random "Invalid reader" or ""
		message.put("accessReason", ((id % 2 == 0) ? "Invalid reader" : "Authorized"));
		message.put("action", ((id % 2 == 0) ? "OK" : ""));
		message.put("alarmLimit", 0);
		message.put("alertAccess", 0);
		message.put("areaName", ((id % 2 == 0) ? "$ASSETMODEL" : "MUMPWBMB1_9F"));
		// 2 or 52 or 48 or 61 or 49
		message.put("areaNumber", ((id % 2 == 0) ? 52 : 48));
		message.put("author", "");
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
		// 7 or 22
		message.put("category", ((id % 2 == 0) ? 7 : 22));
		// Point Alarm or Access Alarm or Operator Change
		message.put("categoryName", ((id % 2 == 0) ? "Point Alarm" : "Operator Change"));
		message.put("changedTime", timestamp);
		message.put("classification", "");
		message.put("comment", "");
		// START or PROGRESS
		message.put("condition", ((id % 2 == 0) ? "START" : "PROGRESS"));
		message.put("controllerSpecificAlarmData", 0);
		// CH4C4_DigitalPoint(number)
		message.put("description", ((id % 2 == 0) ? "CH4C4_DigitalPoint(" + (id - 200) + ")"
				: "OP - changed by Automation Rules using Application Services"));
		// SERVER name
		message.put("dsaConnectionName", server);
		// SERVER name
		message.put("dsaServerAlias", server);
		// 0 or 280
		message.put("eEInitId", ((id % 2 == 0) ? 0 : 280));
		message.put("executionId", 0);
		message.put("fieldTime", timestamp);
		message.put("flags", 0);
		// U 00 or J 00 or NONE
		message.put("fullPriorityString", ((id % 2 == 0) ? "U 00" : "NONE"));
		message.put("gdaConnectionNumber", 0);
		message.put("gdaOriginalConnectionNumber", 0);
		message.put("hostTime", timestamp);
		// EventId
		message.put("id", id);
		message.put("ioLimEE", 0);
		message.put("link1", ((id % 2 == 0) ? "" : "https://%servername%/systemdisplays/activator/rule.h"));
		message.put("link1Type", 0);
		message.put("link2", "");
		message.put("link2Type", 0);
		message.put("link3", "");
		message.put("link3Type", 0);
		// /Facility or /System Components
		message.put("locationFullName", ((id % 2 == 0) ? "/Facility" : "/System Components"));
		// Facility or MUMPWBMB1_9F or MUMPWBMB1_GF
		message.put("locationTagName", ((id % 2 == 0) ? "FACILITY" : "MUMPWBMB1_7F"));
		message.put("operator", ((id % 2 == 0) ? ".\\mngr" : ""));
		// 0 or 3
		message.put("previousValueType", ((id % 2 == 0) ? 0 : 3));
		// 3 or 6
		message.put("priority", ((id % 2 == 0) ? 3 : 6));
		message.put("quality", 192);
		message.put("reason", "");
		message.put("receivedDelay", 0);
		message.put("sequenceId", 0);
		message.put("severity", 0);
		message.put("shelveReason", "");
		message.put("signature2Level", 0);
		message.put("signatureMeaning", "");
		message.put("signatureMeaning2", "");
		// CH4C4_DigitalPoint(number)
		message.put("source",
				((id % 2 == 0) ? "CH4C4_DigitalPoint(" + (id - 236) + ")" : "CH4C4_DigitalPoint(" + (id - 258) + ")"));
		// same as source key's value
		message.put("sourceEntityName",
				((id % 2 == 0) ? "CH4C4_DigitalPoint(" + (id - 236) + ")" : "CH4C4_DigitalPoint(" + (id - 258) + ")"));
		message.put("station", "");
		message.put("subCondition", "");
		message.put("subPriority", 0);
		// Random big number
		message.put("transactionId", ((id % 2 == 0) ? id + 2589 : id + 3698));
		message.put("transitDirection", "");
		message.put("transitType", "");
		message.put("units", ((id % 2 == 0) ? "" : "Hz"));
		// 3 or 1
		message.put("valueType", ((id % 2 == 0) ? 3 : 1));
		// POWB_MB1_G_FB04I or POWB_MB1_7_HUBI or PWAMB1_09_MDRI or POWB_MB1_12_AYI
		message.put("zoneEntered", ((id % 2 == 0) ? "POWB_MB1_G_FB04I" : "POWB_MB1_12_AYI"));
		return message;
	}
}
