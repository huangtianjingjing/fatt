package com.zhangsan.app.view;


import com.zhangsan.app.model.BodyShipAppModel;
import com.zhangsan.common.util.ConsoleUtil;

public class BodyShipAppView {
	public static void paint() {
		//1.欢迎语
		System.out.println("欢迎使用胖瘦判断器v1.0");
		//2.获取用户输入
		//2.1获取身高
		double height=getHeight();
		//2.2获取体重
		double weight=getWeight();
		//2.3获取国家
		int country=getCountryId();
		//3.调用业务模型获取业务结果
		try {
		//3.1执行成功的业务结果
		int bodyship=BodyShipAppModel.bodyship(height,weight,country);
		paintBodyShip(bodyship);
		}catch(IllegalArgumentException e) {
			//3.2执行失败的业务结果
			System.out.println(e.getMessage());
		}finally {
		System.out.println("欢迎下次使用");
		}
		//4.展示业务结果
		
	}
	
private static void paintBodyShip(int bodyShip) {
	String bodyShipDesc=null;
	switch(bodyShip){
		case 0:bodyShipDesc="廋";break;
		case 1:bodyShipDesc="正常";break;
		case 2:bodyShipDesc="胖";break;
	}
System.out.println("您的体型为："+bodyShipDesc);
    }
	
private static double getHeight() {
	double heightCM=ConsoleUtil.readDouble("请输入身高(CM):170>",170);
	while(heightCM<=0) {
		heightCM=ConsoleUtil.readDouble("请输入正确的身高(CM):170>",170);
	}
	return heightCM;
}
private static double getWeight() {
	
	double weight=ConsoleUtil.readDouble("请输入体重(kg):60>",60);
	while(weight<=0) {
		weight=ConsoleUtil.readDouble("请输入正确的体重(kg):60>",60);
	}
	return weight;
}
private static int getCountryId() {
	System.out.println("请输入您的国籍");
	System.out.println("0中国");
	System.out.println("1美国");
	System.out.println("2日本");
	System.out.println("3其他");
	int countryid=ConsoleUtil.readInt("你的选择：0>", 0);
	switch(countryid) {
	case 0:
	case 1:
	case 2:
	case 3:
	 return countryid;	
	 default:
	System.out.println("您的选择有误，请重新选择");	
	return getCountryId(); 
	}
	
}

}
