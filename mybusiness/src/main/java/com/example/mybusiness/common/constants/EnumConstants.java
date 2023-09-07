package com.example.mybusiness.common.constants;

import lombok.Getter;

/** 定数クラス */
public enum EnumConstants {

	FIELD_NAME(ControllerConstants.FIELD_NAME),
	MESSAGE(ControllerConstants.MESSAGE),
	VALIDATION_MESSAGE(ControllerConstants.VALIDATION_MESSAGE),
	INTERNAL_SERVER_ERROR_MESSAGE(ControllerConstants.INTERNAL_SERVER_ERROR_MESSAGE),

	OK(ServiceConstants.OK),

	BAD_REQUEST(ExceptionHandlerConstants.BAD_REQUEST),
	NOT_FOUND(ExceptionHandlerConstants.NOT_FOUND),
	METHOD_NOT_ALLOWED(ExceptionHandlerConstants.METHOD_NOT_ALLOWED),
	UNSUPPORTED_MEDIA_TYPE(ExceptionHandlerConstants.UNSUPPORTED_MEDIA_TYPE),
	UNPROCESSABLE_ENTITY(ExceptionHandlerConstants.UNPROCESSABLE_ENTITY),
	INTERNAL_SERVER_ERROR(ExceptionHandlerConstants.INTERNAL_SERVER_ERROR);

	@Getter
	private final String value;

	private EnumConstants(String value) {
		this.value = value;
	}

	/** バリデーション用定数 */
	public final class ValidationConstants {
		// インスタンス化させないためにコンストラクタの修飾子はprivate
		private ValidationConstants() {}
		public static final String VALIDATION_INTEGER = "数値のみ許可されています。";
		public static final String VALIDATION_REQUIRED = "入力必須項目です。";
		public static final String VALIDATION_YEAR_MIN = "数値1919以上の数値である必要があります。";
		public static final String VALIDATION_YEAR_MAX = "数値2019以下の数値である必要があります。";
		public static final String VALIDATION_MONTH_MIN = "数値1以上の数値である必要があります。";
		public static final String VALIDATION_MONTH_MAX = "数値12以下の数値である必要があります。";
		public static final String VALIDATION_DAY_MIN = "数値1以上の数値である必要があります。";
		public static final String VALIDATION_DAY_MAX = "数値31以下の数値である必要があります。";
	}

	/** コントローラークラス用定数 */
	private final class ControllerConstants {
		// インスタンス化させないためにコンストラクタの修飾子はprivate
		private ControllerConstants() {}
		public static final String FIELD_NAME = "フィールド: ";
		public static final String MESSAGE = " メッセージ: ";
		public static final String VALIDATION_MESSAGE = "バリデーションエラーです。";
		public static final String INTERNAL_SERVER_ERROR_MESSAGE = "サーバエラーが発生しました。";
	}

	/** サービスクラス用定数 */
	private final class ServiceConstants {
		// インスタンス化させないためにコンストラクタの修飾子はprivate
		private ServiceConstants() {}
		public static final String OK = "200 OK";
	}

	/** エラーハンドリングクラス用定数 */
	private final class ExceptionHandlerConstants {
		// インスタンス化させないためにコンストラクタの修飾子はprivate
		private ExceptionHandlerConstants() {}
		public static final String BAD_REQUEST = "400 Bad Request";
		public static final String NOT_FOUND = "404 Not Found";
		public static final String METHOD_NOT_ALLOWED = "405 Method Not Allowed";
		public static final String UNSUPPORTED_MEDIA_TYPE = "415 Unsupported Media Type";
		public static final String UNPROCESSABLE_ENTITY = "422 Unprocessable Entity";
		public static final String INTERNAL_SERVER_ERROR = "500 Internal Server Error";
	}

	/** ログ出力クラス用定数 */
	public final class LoggingAspectConstants {
		// インスタンス化させないためにコンストラクタの修飾子はprivate
		private LoggingAspectConstants() {}
		public static final String START = "メソッド処理開始";
		public static final String END = "メソッド処理終了";
		public static final String EXECUTE_METHOD_INFO = "実行中メソッド情報：";
		public static final String EXECUTE_CALCULATE_RELATED_INFO = "calculateRelatedInfoメソッドを実行中";
		public static final String BIRTHDAY_INFO_CONTROLLER = "within(com.example.mybusiness.controller.BirthdayInfoController)";
		public static final String EXECUTE_GET_RELATED_INFO = "execution(* com.example.mybusiness.controller.BirthdayInfoController.getRelatedInfo*(..))";
	}

}
