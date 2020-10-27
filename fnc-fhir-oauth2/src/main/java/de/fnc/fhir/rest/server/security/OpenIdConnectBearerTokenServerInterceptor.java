package de.fnc.fhir.rest.server.security;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;

import ca.uhn.fhir.rest.api.server.RequestDetails;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


@Interceptor
public class OpenIdConnectBearerTokenServerInterceptor {


	public OpenIdConnectBearerTokenServerInterceptor() {}
	
	@Hook(Pointcut.SERVER_INCOMING_REQUEST_PRE_PROCESSED)
	public boolean authenticate(RequestDetails theRequest, HttpServletResponse theResponse) throws IOException {
		
		theResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		theResponse.setContentType("text/plain");
		theResponse.getWriter().append("Access not authorized!");
		theResponse.getWriter().close();
		
		return false;
	}
}
