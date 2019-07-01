package com.zhangsan.app.model;

public class BodyShipAppModel {
   /**
    * 计算bmi的值
    * @param  height 身高 单位米
    * @param  weight 体重 单位kg
    * @param  country 国家标识 0=中国 1=美国 2=日本
    * @return bmi值
    * @throws IllegalArgumentException  如果身高和体重为负数或0
    * @throws IllegalArgumentException  如果身高和体重为NaN
    * @throws IllegalArgumentException  如果country的值无法识别
    */
	private static void bmi(Double height, Double weight)throws IllegalArgumentException {
   //1.验证清理参数
	if(height<=0) {
		throw new IllegalArgumentException("height不能小于等于0");
	}
	if(weight<=0) {
		throw new IllegalArgumentException("weight不能小于等于0");
	}
	if(Double.isNaN(height)||Double.isFinite(height)) {
		throw new IllegalArgumentException("height不能是NaN或无穷");
	}
	if(Double.isNaN(weight)||Double.isFinite(weight)) {
		throw new IllegalArgumentException("weight不能是NaN或无穷");
	}
   //2.执行业务逻辑
	double bmi=weight/(height*height);	
   //3.组装业务结果
		
	}
	 /**
	    * 计算bodyship的值
	    * @param  height 身高 单位米
	    * @param  weight 体重 单位kg
	    * @param  country 国家标识 0=中国 1=美国 2=日本
	    * @return 
	    * 0=偏瘦
	    * 1=正常
	    * 2=胖
	    * @throws IllegalArgumentException  如果身高和体重为负数或0
	    * @throws IllegalArgumentException  如果身高和体重为NaN
	    * @throws IllegalArgumentException  如果country的值无法识别
	    */
	public static int bodyship(Double height, Double weight, int countryId) {
		//1.验证清理参数
		if(height<=0) {
			throw new IllegalArgumentException("height不能小于等于0");
		}
		if(weight<=0) {
			throw new IllegalArgumentException("weight不能小于等于0");
		}
		if(Double.isNaN(height)||Double.isFinite(height)) {
			throw new IllegalArgumentException("height不能是NaN或无穷");
		}
		if(Double.isNaN(weight)||Double.isFinite(weight)) {
			throw new IllegalArgumentException("weight不能是NaN或无穷");
		}
		if(countryId<0||countryId>3) {
			throw new IllegalArgumentException("country无法识别");
		}
		//2.执行业务逻辑
		//2.1计算bmi
		double bmi=weight/(height*height);
		//2.2根据bmi判断体型
		int bodyShip=judgeBodyShip(bmi,countryId);
		return bodyShip;
       
	}
	public static int judgeBodyShip(double bmi,int countryId) {
		switch(countryId) {
		case 0:return judgeChineseBodyShipByBIM(bmi);
		case 1:return judgeAmeicanBodyShipByBIM(bmi);
		case 2:return judgeJapanBodyShipByBIM(bmi);
        default:return judgeOtherBodyShipByBIM(bmi);
        	} 
		
	}
	private static int judgeChineseBodyShipByBIM(double bmi) {
		if(bmi<18.5) {
			return 0;
		}
		if(bmi>18.5&&bmi<23.9) {
			return 1;
		}
			return 2;
	}
		private static int judgeAmeicanBodyShipByBIM(double bmi) {
			if(bmi<18.5) {
				return 0;
			}
			if(bmi>18.5&&bmi<24.9) {
				return 1;
			}
				return 2;
		}	
			private static int judgeJapanBodyShipByBIM(double bmi) {
				if(bmi<18.5) {
					return 0;
				}
				if(bmi>18.5&&bmi<22.9) {
					return 1;
				}
				
					return 2;
			}
				private static int judgeOtherBodyShipByBIM(double bmi) {
					if(bmi<18.5) {
						return 0;
					}
					if(bmi>18.5&&bmi<22.9) {
						return 1;
					}
					
						return 2;
					
				
	}
}
