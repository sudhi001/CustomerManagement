/**
 * 
 */
package com.akash.spring.crm.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 1270524
 *
 */
@Controller
@SessionAttributes("authorizationRequest")
public class OAuthController {

	@Autowired
	private ClientDetailsService clientDetailService;
	
	@RequestMapping("/oauth/confirm_access")
	public ModelAndView getAccessConfirmation(Map<String, Object> model) {
		AuthorizationRequest request = (AuthorizationRequest) model.remove("authorizationRequest");
		ClientDetails client = clientDetailService.loadClientByClientId(request.getClientId());
		model.put("client", client);
		
		// request.getScope() gives us scopes that have been requested
		Map<String, String> scopes = new LinkedHashMap<>();
		for (String scope : request.getScope()) {
			scopes.put(OAuth2Utils.SCOPE_PREFIX + scope, "false");
		}
		model.put("scopes", scopes);
		return new ModelAndView("/oauthAuthorization.jsp", model);
	}
}
