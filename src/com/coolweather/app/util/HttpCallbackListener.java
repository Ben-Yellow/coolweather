package com.coolweather.app.util;
//HttpUtil����ʹ�õ���HttpCallbackListener�ӿ����ص����񷵻صĽ��
public interface HttpCallbackListener {
	void onFinish(String response);

	void onError(Exception e);
}
