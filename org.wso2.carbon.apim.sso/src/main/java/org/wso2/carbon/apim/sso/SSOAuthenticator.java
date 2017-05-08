package org.wso2.carbon.apim.sso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.kernel.context.PrivilegedCarbonContext;
import org.wso2.carbon.security.caas.api.CarbonPrincipal;
import org.wso2.carbon.uuf.api.config.Configuration;
import org.wso2.carbon.uuf.core.API;
import org.wso2.carbon.uuf.exception.UUFException;
import org.wso2.carbon.uuf.spi.HttpRequest;
import org.wso2.carbon.uuf.spi.HttpResponse;
import org.wso2.carbon.uuf.spi.auth.Authenticator;
import org.wso2.carbon.uuf.spi.auth.Authenticator.Result;
import org.wso2.carbon.uuf.spi.auth.Authenticator.Status;

public class SSOAuthenticator implements Authenticator{

    private static final Logger log = LoggerFactory.getLogger(SSOAuthenticator.class);

	
	@Override
	public Result login(Configuration config, API api, HttpRequest request, HttpResponse response) throws UUFException {
		
		log.info("------- Inside login method --------- ");
		
		// If not logged in redirect to IDP login page
		Result result = null;
		
        //CaasUser caas = new CaasUser(request.getFormParams().get(USERNAME).toString(), principal);
        //api.createSession(caas);
		log.info("------- Redirecting... --------- ");
		
		
        result = new Result(Status.REDIRECT, "https://localhost:9444/samlsso", null, null);
        
        //return result;
		return result;
	}

	@Override
	public Result logout(Configuration arg0, API arg1, HttpRequest arg2, HttpResponse arg3) throws UUFException {
		log.info("------- Inside logout method --------- ");
		return null;
	}

}
