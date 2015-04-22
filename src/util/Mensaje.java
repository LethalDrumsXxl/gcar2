package util;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="mensaje")
public class Mensaje {
	
	private String style;
	private String styleClass;
	private String content;
	
	public Mensaje(){
		super();
	}
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style= style;
	}
	public String getStyleClass() {
		return styleClass;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
