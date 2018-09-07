package top.th.jackie.study.util;

public interface BaseMessageUtil<T> {
	
	public abstract String messageToXml(T t);
	
	public abstract String initMessage(String fromUserName, String toUserName);

}
