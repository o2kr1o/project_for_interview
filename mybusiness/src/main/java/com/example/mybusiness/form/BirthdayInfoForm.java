package com.example.mybusiness.form;

import static com.example.mybusiness.common.constants.EnumConstants.ValidationConstants.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

/** フォームクラス */
@Data
public class BirthdayInfoForm {
	@NotNull(message = VALIDATION_REQUIRED)
	@Positive(message = VALIDATION_INTEGER)
	@Min(value = 1919, message = VALIDATION_YEAR_MIN)
	@Max(value = 2019, message = VALIDATION_YEAR_MAX)
	private int year;

	@NotNull(message = VALIDATION_REQUIRED)
	@Positive(message = VALIDATION_INTEGER)
	@Min(value = 1, message = VALIDATION_MONTH_MIN)
	@Max(value = 12, message = VALIDATION_MONTH_MAX)
	private int month;

	@NotNull(message = VALIDATION_REQUIRED)
	@Positive(message = VALIDATION_INTEGER)
	@Min(value = 1, message = VALIDATION_DAY_MIN)
	@Max(value = 31, message = VALIDATION_DAY_MAX)
	private int day;
}
