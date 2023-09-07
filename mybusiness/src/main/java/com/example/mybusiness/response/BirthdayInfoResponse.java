package com.example.mybusiness.response;

import lombok.Data;

/** レスポンスクラス */
@Data
public class BirthdayInfoResponse {
	// 誕生日から今日までの日数
	private int days;
	// 星座
	private String zodiacSign;
	// 干支
	private String chineseZodiac;
}
