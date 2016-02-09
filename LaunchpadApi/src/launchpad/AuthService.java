package launchpad;

import java.net.URL;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.SignatureType;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Verifier;
import com.github.scribejava.core.oauth.OAuthService;

import launchpad.LaunchPadApi;


public class AuthService {
	
		private static final String PROTECTED_RESOURCE_URL = "https://api.staging.launchpad.net/";
		public static void main(String[] args) { 

			OAuthService service = new ServiceBuilder()
	                .provider(LaunchPadApi.class)
	                .apiKey("LW0mTGSTRRlXntqjQMw5")
	                .apiSecret("Sg6cLg2JTl34RHWV4f5rwkrKmZFzkKSmwwNtTqRHfSKLgxtlTNG0s4WZ0qdpmCQTN7gklbqhGwkSp7T8")
	                .signatureType(SignatureType.Header)
	                .debug()
	                .build();
			System.out.println("+++++++++ Launchpad OAuth workflow ++++++++");
			
			
//			
//
//			Token requestToken = service.getRequestToken();
//			String authUrl = service.getAuthorizationUrl(requestToken);
//			System.out.println(authUrl);
//
//			System.out.println("see requst token --->" + requestToken);

			Verifier verifier = null;
			Token accessToken = service.getAccessToken(service.getRequestToken(), verifier);
			OAuthRequest request =  new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
			service.signRequest(accessToken, request);
			Response response = request.send();
			System.out.println(response.getBody());
			
		}
		
}

