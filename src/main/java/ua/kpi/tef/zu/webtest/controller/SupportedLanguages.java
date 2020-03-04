package ua.kpi.tef.zu.webtest.controller;

import java.util.Locale;

/**
 * Created by Anton Domin on 2020-02-11
 */

public enum SupportedLanguages {
	ENGLISH ("en", "English"),
	RUSSIAN ("ru", "Русский");

	private String code;
	private String name;

	SupportedLanguages(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static SupportedLanguages getDefault() {
		return ENGLISH;
	}

	public static Locale getDefaultLocale() {
		return determineLocale(ENGLISH);
	}

	public static Locale determineLocale(String code) {
		String codeLC = code.toLowerCase();

		for (SupportedLanguages lang: SupportedLanguages.values()) {
			if (lang.getCode().equals(codeLC)) {
				return determineLocale(lang);
			}
		}

		return determineLocale(getDefault());
	}

	@SuppressWarnings("DuplicateBranchesInSwitch")
	public static Locale determineLocale(SupportedLanguages lang) {
		switch (lang) {
			case ENGLISH:
				return new Locale("en", "US");
			case RUSSIAN:
				return new Locale("ru", "RU");
			default:
				return new Locale("en", "US");
		}
	}
}