package top.th.jackie.study.util;

import java.io.Writer;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import top.th.jackie.study.entity.MessageText;

public class TextMessageUtil implements BaseMessageUtil<MessageText> {

	protected static  String PREFIX_CDATA="<![CDATA[";
	protected static String SUFFIX_CDATA ="]]>";
	
	@Override
	public String messageToXml(MessageText t) {

		XStream stream = new XStream(new XppDriver() {
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {

					protected void writeText(QuickWriter writer, String text) {
						if (text.startsWith(PREFIX_CDATA) && text.endsWith(SUFFIX_CDATA)) {
							writer.write(text);
						} else {
							super.writeText(writer, text);
						}
					}
				};
			}
		});
		stream.alias("xml", t.getClass());
		return stream.toXML(t);
	}

	@Override
	public String initMessage(String toUserName, String fromUserName) {
		MessageText msg = new MessageText();
		msg.setToUserName(toUserName);
		msg.setFromUserName(fromUserName);
		msg.setContent("hello");
		msg.setCreateTime(new Date().getTime());
		msg.setMsgType("text");
		return messageToXml(msg);
	}
}
