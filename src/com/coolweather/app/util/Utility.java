package com.coolweather.app.util;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.Country;
import com.coolweather.app.model.Province;

import android.text.TextUtils;

//���ڷ��������ص�ʡ�������ݶ��ǡ�����|���У�����|���С����ָ�ʽ������������ṩһ������������ʹ�����������
//�����Ĺ������Ȱ�,�ָ����ٰ�|�ָ������Ž������������������õ�ʵ�����У�������CoolWeatherDB�е�����save()���������ݴ洢����Ӧ�ı���
public class Utility {
	/**
	 * �����ʹ������������ص�ʡ������
	 * */
	public synchronized static boolean handleProvinceResponse(
			CoolWeatherDB coolWeatherDB, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceName(array[0]);
					province.setProvinceCode(array[1]);
					// ���������������ݴ��浽Province��
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * �����ʹ������������ص��м�����
	 * */
	public static boolean handleCitiesResponse(
			CoolWeatherDB coolWeatherDB, String response, int provinceId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCities = response.split(",");
			if (allCities != null && allCities.length > 0) {
				for (String c : allCities) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityName(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					// ���������������ݴ��浽City��
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * �����ʹ������������ص��ؼ�����
	 * */
	public static synchronized boolean handleCountriesResponse(
			CoolWeatherDB coolWeatherDB, String response, int cityId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCountries = response.split(",");
			if (allCountries != null && allCountries.length > 0) {
				for (String c : allCountries) {
					String[] array = c.split(",");
					Country country = new Country();
					country.setCountryName(array[0]);
					country.setCountryCode(array[1]);
					country.setCityId(cityId);
					// ���������������ݴ��浽Country��
					coolWeatherDB.saveCountry(country);

				}
				return true;
			}
		}
		return false;
	}
}