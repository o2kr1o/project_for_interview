package com.example.mybusiness.service;

import static com.example.mybusiness.common.constants.EnumConstants.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.mybusiness.form.BirthdayInfoForm;
import com.example.mybusiness.response.BirthdayInfoResponse;

/** サービスクラス */
@Service
public class BirthdayInfoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 誕生日関連情報をレスポンスクラスに格納する
	 * @param form 画面から受け取った生年月日情報
	 * @param response 画面へ返すための情報
	 * @return 誕生日から今日までの日数、星座、干支
	 */
	public BirthdayInfoResponse calculateRelatedInfo(BirthdayInfoForm form, BirthdayInfoResponse response) {
		// 画面から受け取った生年月日情報からLocalDate型の情報を取得
		LocalDate date = LocalDate.of(form.getYear(), form.getMonth(), form.getDay());

		// 誕生日から今日までの日数を計算
		int days = daysBetween(date, LocalDate.now());
		// 星座を計算
		String zodiacSign = calculateZodiacSign(date);
		// 干支を計算
		String chineseZodiac = calculateChineseZodiac(date);

		// 結果をコンソールに表示
		System.out.println("生まれた日から今日までの日数：" + days + "日");
		System.out.println("星座：" + zodiacSign);
		System.out.println("干支：" + chineseZodiac);

		// 成功時にログ出力
		logger.info(OK.getValue());

		// 誕生日関連情報をレスポンスクラスに格納
		response.setDays(days);
		response.setZodiacSign(zodiacSign);
		response.setChineseZodiac(chineseZodiac);

		return response;
	}

	/**
	 * 引数で指定された日付間の日数を求める
	 * @param startDate 開始日付
	 * @param endDate 終了日付
	 * @return 開始日付から終了日付までの日数
	 */
	public int daysBetween(LocalDate startDate, LocalDate endDate) {
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		return (int) daysBetween;
	}

	/**
	 * 引数で指定された日付の星座を計算する
	 * @param date 日付
	 * @return 星座
	 */
	public String calculateZodiacSign(LocalDate date) {
		String[] zodiacSigns = {
				"牡羊座", "牡牛座", "双子座", "蟹座", "獅子座", "乙女座",
				"天秤座", "蠍座", "射手座", "山羊座", "水瓶座", "魚座"
		};

		// 各星座の開始日と終了日を月と日で表します
		int[][] zodiacDates = {
				{ 3, 21, 4, 19 }, // 牡羊座 (3月21日から4月19日)
				{ 4, 20, 5, 20 }, // 牡牛座 (4月20日から5月20日)
				{ 5, 21, 6, 20 }, // 双子座 (5月21日から6月20日)
				{ 6, 21, 7, 22 }, // 蟹座 (6月21日から7月22日)
				{ 7, 23, 8, 22 }, // 獅子座 (7月23日から8月22日)
				{ 8, 23, 9, 22 }, // 乙女座 (8月23日から9月22日)
				{ 9, 23, 10, 22 }, // 天秤座 (9月23日から10月22日)
				{ 10, 23, 11, 21 }, // 蠍座 (10月23日から11月21日)
				{ 11, 22, 12, 21 }, // 射手座 (11月22日から12月21日)
				{ 12, 22, 1, 19 }, // 山羊座 (12月22日から1月19日)
				{ 1, 20, 2, 18 }, // 水瓶座 (1月20日から2月18日)
				{ 2, 19, 3, 20 } // 魚座 (2月19日から3月20日)
		};

		int month = date.getMonthValue();
		int day = date.getDayOfMonth();

		for (int i = 0; i < zodiacSigns.length; i++) {
			int startMonth = zodiacDates[i][0];
			int startDay = zodiacDates[i][1];
			int endMonth = zodiacDates[i][2];
			int endDay = zodiacDates[i][3];

			if ((month == startMonth && day >= startDay) || (month == endMonth && day <= endDay)) {
				return zodiacSigns[i];
			}
		}

		return "不明";
	}

	/**
	 * 引数で指定された日付の干支を計算する
	 * @param date 日付
	 * @return 干支
	 */
	public String calculateChineseZodiac(LocalDate date) {
		int year = date.getYear();
		// 干支の始まりの年
		int startYear = 1900;
		String[] zodiacSigns = { "ネズミ", "ウシ", "トラ", "ウサギ", "ドラゴン", "ヘビ", "馬", "羊", "猿", "鶏", "犬", "ブタ" };
		int zodiacIndex = (year - startYear) % 12;
		return zodiacSigns[zodiacIndex];
	}

}
