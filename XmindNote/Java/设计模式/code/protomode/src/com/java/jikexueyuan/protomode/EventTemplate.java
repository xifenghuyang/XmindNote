package com.java.jikexueyuan.protomode;

/**
 * 事件模板
 * 标题
 * 内容
 */
public class EventTemplate {
	private String eventSubject, eventContent;

	public EventTemplate(String eventSubject, String eventContent) {
		this.eventSubject = eventSubject;
		this.eventContent = eventContent;
	}

	public String geteventSubject() {
		return eventSubject;
	}

	public String geteventContent() {
		return eventContent;
	}
}
