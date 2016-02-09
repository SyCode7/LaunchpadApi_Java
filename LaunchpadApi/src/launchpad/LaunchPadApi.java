package launchpad;


import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.services.PlaintextSignatureService;
import com.github.scribejava.core.services.SignatureService;

public class LaunchPadApi extends DefaultApi10a {
	
//	Token myToken = "";

    private static final String AUTHORIZATION_URL = "https://launchpad.net/+authorize-token?oauth_token=%s";

    @Override
    public String getRequestTokenEndpoint() {
    	
    	return "https://launchpad.net/+request-token";
    }
    
    @Override
    public String getAccessTokenEndpoint() {
    	return "https://launchpad.net/+access-token";
    }
    
    @Override
    public String getAuthorizationUrl(Token requestToken) {

    	System.out.println("Request token ---> " + requestToken.getToken());
    	return String.format(AUTHORIZATION_URL, requestToken.getToken());
    }
    
    @Override
    public  SignatureService getSignatureService(){
    	return new PlaintextSignatureService();
        
    }


}
