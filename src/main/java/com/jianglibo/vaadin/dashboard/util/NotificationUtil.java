package com.jianglibo.vaadin.dashboard.util;

import org.springframework.context.MessageSource;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

public class NotificationUtil {

	public static void humanized(MessageSource messageSource, String msg, String...subs) {
		Notification.show(MsgUtil.getMsgWithSubsReturnKeyOnAbsent(messageSource, "nofitication.humanized." + msg, subs), "", Type.HUMANIZED_MESSAGE);
	}
	
	public static void tray(MessageSource messageSource,String msg, String...subs) {
		Notification.show(MsgUtil.getMsgWithSubsReturnKeyOnAbsent(messageSource, "nofitication.tray." + msg, subs), "", Type.TRAY_NOTIFICATION);
	}

	public static void warn(MessageSource messageSource,String msg, String...subs) {
		Notification.show(MsgUtil.getMsgWithSubsReturnKeyOnAbsent(messageSource, "nofitication.warn." + msg, subs), "", Type.WARNING_MESSAGE);
	}
	
	public static void error(MessageSource messageSource,String msg, String...subs) {
		Notification.show(MsgUtil.getMsgWithSubsReturnKeyOnAbsent(messageSource, "nofitication.error." + msg, subs), "", Type.ERROR_MESSAGE);
	}
}
