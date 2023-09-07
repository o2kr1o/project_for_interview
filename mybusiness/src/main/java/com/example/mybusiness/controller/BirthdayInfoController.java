package com.example.mybusiness.controller;

import static com.example.mybusiness.common.constants.EnumConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mybusiness.common.exception.InternalServerError;
import com.example.mybusiness.common.exception.UnprocessableEntityException;
import com.example.mybusiness.form.BirthdayInfoForm;
import com.example.mybusiness.response.BirthdayInfoResponse;
import com.example.mybusiness.service.BirthdayInfoService;

/** コントローラークラス */
@Controller
public class BirthdayInfoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BirthdayInfoService birthdayInfoService;

	@GetMapping("/birthdayInput")
	public String index() {
		return "birthdayInput";
	}

	/**
	 * 誕生日関連情報をリストに格納し、画面へ返す
	 * @param form 画面から受け取った生年月日情報
	 * @param response 画面へ返すための情報（誕生日から今日までの日数、星座、干支）
	 * @return birthdayInfo.htmlファイル
	 */
	@PostMapping("/birthdayInput")
	public String getRelatedInfo(@Valid BirthdayInfoForm form, BindingResult bindingResult,
			BirthdayInfoResponse response, Model model) {
		// バリデーションチェック
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors()) {
				logger.error(FIELD_NAME.getValue() + error.getField() + MESSAGE.getValue() + error.getDefaultMessage());
			}
			throw new UnprocessableEntityException(HttpStatus.UNPROCESSABLE_ENTITY, VALIDATION_MESSAGE.getValue());
		}
		try {
			List<BirthdayInfoResponse> responseList = new ArrayList<>();
			response = birthdayInfoService.calculateRelatedInfo(form, response);
			responseList.add(response);
			// 誕生日関連情報をリストに格納し、画面へ返す
			model.addAttribute("responseList", responseList);
			return "birthdayInfo";
		} catch (Exception e) {
			logger.error(INTERNAL_SERVER_ERROR_MESSAGE.getValue());
			throw new InternalServerError(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE.getValue());
		}
	}

	@GetMapping("/birthdayInfo")
	public String birthdayInfo() {
		return "birthdayInfo";
	}

}
