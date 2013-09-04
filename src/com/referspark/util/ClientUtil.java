package com.referspark.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.referspark.service.campaign.ValidateBusinessInterestService;

public class ClientUtil {
	@Autowired
	private  ValidateBusinessInterestService businessInterestService = null;
	
	public byte[] getImageAsBytes(String imagePath, String ipAddress, ServletConfig config, String couponCode){
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
			businessInterestService.trackEmailViewedDetails(ipAddress, couponCode);
			URL u = new URL(imagePath);
			System.out.println(imagePath+":"+ipAddress);
			int contentLength = u.openConnection().getContentLength();
			InputStream openStream = u.openStream();
			byte[] binaryData = new byte[contentLength];
			openStream.read(binaryData);
			openStream.close();
			System.out.println(binaryData);
			return binaryData;
		} catch (IOException ex) {
		}
		return null;
	}
}
