package com.bankaya.pokeapiwrapper.infraestructure.utils;

import jakarta.servlet.http.HttpServletRequest;

public class DataComplementUtils {

	public static String getIpAddress(HttpServletRequest request) {
		String clientIp = request.getHeader("X-Forwarded-For");
		if (clientIp == null) {
            clientIp = request.getRemoteAddr();
        }
		return clientIp;
	}
	
}
