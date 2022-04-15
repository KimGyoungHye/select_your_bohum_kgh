package graph.model;

import java.util.List;

public class GraphJsonBean {
	private String myLabels;
	private String myLabel;
	private String myData;
	private String myText;
	public GraphJsonBean() {
		super();
	}
	
	public GraphJsonBean(String myLabel, String myText,List<GraphBean> graphList) {
		super();
		this.myLabel = myLabel;
		this.myText = myText;
		setMyLabels(graphList);
		setMyData(graphList);
	}

	public String getMyLabels() {
		return myLabels;
	}
	public void setMyLabels(List<GraphBean> graphList) {
		String str = "[";
		if(graphList.size()==0) {
			str+="'정보 없음'";
		}else{
			for(int i=0;i<graphList.size();i++) {
				if(i!=0)str+=",";
				str+="'"+graphList.get(i).getX()+"'";
			}
		}
		str += "]";
		this.myLabels = str;
	}
	public String getMyLabel() {
		return myLabel;
	}
	public void setMyLabel(String myLabel) {
		this.myLabel = myLabel;
	}
	public String getMyData() {
		return myData;
	}
	public void setMyData(List<GraphBean> graphList) {
		String str = "[";
		if(graphList.size()==0) {
			str+="0";
		}else{
			for(int i=0;i<graphList.size();i++) {
				if(i!=0)str+=",";
				str+=graphList.get(i).getY();
			}
		}
		str += "]";
		this.myData = str;
	}
	public String getMyText() {
		return myText;
	}
	public void setMyText(String myText) {
		this.myText = myText;
	}

	//myLabels,myLabel,myData,myText
}
