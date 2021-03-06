package com.andlicensing.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Properties;
import java.util.Map.Entry;

import javax.crypto.Cipher;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.StreamResult;

import com.opensymphony.xwork2.ActionSupport;

@Results ({
	@Result(name="success", value="/index-html.jsp", type=ServletDispatcherResult.class),
	@Result(name="license", value="license", type=StreamResult.class, params={"inputName", "license", "contentType", "application/x-andlicensing-license"})
})
public class LicenseController 
extends ActionSupport {
	
	/**
	 * Generated serial id.
	 */
	private static final long serialVersionUID = -310173662502408686L;

	/**
	 * Fixed generator key
	 */
	private static final byte[] GENERATOR_KEY = {
		48,-126,4,-66,2,1,0,48,13,6,9,42,-122,72,-122,-9,13,1,1,1,5,
		0,4,-126,4,-88,48,-126,4,-92,2,1,0,2,-126,1,1,0,-101,-108,-79,
		90,-46,-68,-62,51,108,-1,126,-85,-57,72,-41,113,37,68,48,37,-8,30,-33,
		-21,-122,-21,-37,97,-98,-47,-87,-122,-11,86,-54,39,94,-127,55,27,-67,78,73,
		-101,-78,95,-111,-11,20,18,-31,118,76,69,77,75,-18,27,-34,76,-45,-47,-121,
		32,46,125,68,50,34,-126,-37,66,-28,76,5,-56,21,-1,58,-37,96,-110,-127,
		-64,112,-119,80,-17,96,-26,-120,-64,39,79,-119,-5,-35,99,-105,96,-124,95,123,
		112,71,61,10,-14,-118,79,-49,62,56,99,43,-125,-2,-22,-114,60,-19,-41,122,
		-60,4,3,-71,95,-11,90,49,-98,-57,-30,-34,62,24,100,-128,26,-55,90,80,
		78,-86,36,123,84,-95,-50,123,117,54,20,-50,24,96,-44,21,-22,-46,-23,103,
		-104,74,-98,126,-76,-104,-118,97,-98,-43,31,-86,125,77,123,-30,95,-81,127,-40,
		121,55,-101,59,93,-76,-36,28,-58,-91,-47,-11,-86,-121,-73,-117,-57,-94,-113,-91,
		118,-128,-32,-44,34,-9,120,-72,-76,-7,-25,59,-80,43,-55,53,-22,89,-37,-23,
		-7,34,81,-86,25,50,80,-55,32,-7,-36,76,-58,54,-73,-91,91,-30,116,28,
		70,123,127,-12,-49,-88,-106,-107,-3,-10,-1,-85,3,2,3,1,0,1,2,-126,
		1,1,0,-122,14,107,123,-116,-42,36,-89,-41,37,-105,106,64,127,29,84,90,
		-2,20,86,-61,35,39,98,116,-111,74,41,37,-122,23,3,56,-25,29,-83,42,
		-101,64,118,-32,121,82,-89,-101,-35,9,-111,25,72,-29,-120,-31,83,93,-75,45,
		104,73,-11,-3,22,47,-50,-91,0,63,0,-52,7,-31,18,20,81,5,50,80,
		-15,-23,47,26,89,99,0,4,119,-19,-117,53,-3,-82,-101,-109,-61,-49,107,124,
		105,-46,7,-46,71,-53,-65,5,67,45,-23,-85,15,-11,-52,-15,29,82,99,-100,
		5,83,-90,96,114,41,80,56,-3,84,126,99,38,109,-3,5,-80,110,-57,-124,
		67,38,95,2,-33,-102,-74,-98,111,105,-107,-69,-69,126,37,-121,45,40,90,-57,
		75,-39,27,98,11,124,-53,94,-74,-113,-112,-63,-20,25,-125,99,15,-108,-36,-127,
		33,123,108,18,-13,47,-95,80,57,91,69,71,-26,-97,-86,15,17,119,-33,-42,
		114,-61,-12,-40,-86,17,42,118,78,112,-75,50,-45,-51,103,-56,-80,-95,-104,11,
		-48,88,-108,-49,33,77,-102,-120,-45,14,-29,34,-122,9,-17,26,-39,-93,81,-19,
		-121,102,28,-110,71,126,1,-94,-121,-37,4,34,-62,-68,2,-12,31,20,97,2,
		-127,-127,0,-18,-99,102,92,65,19,97,50,29,-79,99,-34,-17,22,-3,-41,-111,
		109,33,49,25,75,-101,-127,113,88,-23,89,-73,-80,-81,62,14,80,-125,34,-8,
		-82,0,-70,-79,51,44,-121,1,-110,65,-120,75,-70,79,-9,113,122,112,-26,-9,
		-53,66,-37,-66,-58,20,42,38,110,-22,-113,55,107,26,87,-38,-89,55,13,-96,
		-13,93,-49,-28,-49,-46,-122,-78,52,-16,65,-123,104,-42,104,-52,-7,-86,-109,-112,
		97,-97,25,27,95,69,-32,-8,-57,16,-79,123,47,101,50,-127,-33,64,80,-95,
		-120,-68,14,-14,77,-111,-36,-40,7,-1,-53,2,-127,-127,0,-90,-22,-114,-50,33,
		5,59,-19,-10,-82,23,-17,119,-13,5,11,10,-15,-108,41,47,87,-40,50,13,
		23,-71,76,17,70,-71,45,68,20,-67,-107,-50,-6,-68,124,75,-118,-24,-101,-77,
		39,7,74,29,-40,83,-76,23,-43,-44,34,105,83,119,-33,-25,-34,-84,-119,7,
		39,-101,67,36,121,-23,60,-50,3,-55,86,123,11,-11,76,12,90,-108,83,-13,
		-73,-34,-110,-40,-37,-64,115,-94,88,35,-80,-127,65,-75,102,114,107,-11,13,2,
		91,-91,121,-104,-82,-62,64,108,87,61,126,-42,-76,56,106,-41,126,41,119,-68,
		49,-86,-87,2,-127,-128,77,126,72,-44,5,62,105,-2,-128,-82,47,-91,35,56,
		-16,79,-90,39,46,-12,103,38,-86,-26,43,13,-103,27,78,16,-49,-104,-13,-59,
		42,17,-99,121,-59,58,-36,121,-90,40,98,86,65,122,38,61,-25,-30,-112,-76,
		23,30,-85,-77,19,-113,-110,49,122,51,6,48,87,117,19,-90,112,-13,-65,75,
		55,17,-14,7,-105,-100,0,-49,-115,-85,-71,12,-128,74,-121,45,57,20,-24,28,
		-35,76,-9,66,-3,12,-122,91,54,-78,-115,-104,-8,-50,-21,22,-59,98,-43,-46,
		-49,108,96,73,-85,-23,-98,-65,-102,115,-126,-91,118,105,2,-127,-128,115,42,111,
		113,-91,-78,-40,-48,-83,93,29,66,-86,-66,80,-126,120,0,-118,-69,-121,-32,-46,
		88,102,84,50,19,91,-16,50,32,27,83,60,35,-70,-11,-95,75,25,76,52,
		-122,9,44,42,-119,102,-30,53,-114,-110,-53,-124,92,97,-45,-89,104,35,-79,-83,
		-43,-75,-52,12,2,93,-114,-121,-16,-34,44,26,-92,-62,-83,83,-120,47,21,-24,
		53,-84,120,-10,-26,-41,29,120,65,-48,-121,-125,-56,106,-58,-115,-124,-85,-7,-12,
		-48,15,10,112,-73,-33,50,-28,-16,82,80,55,43,-26,-77,-34,33,73,-95,-48,
		-74,-66,112,126,81,2,-127,-127,0,-43,-50,40,-108,-26,-48,-49,57,-28,-2,61,
		113,-111,81,126,-51,109,-2,98,116,19,-121,-70,9,85,83,-88,-98,-93,121,-6,
		113,84,56,-58,21,29,-97,5,13,-52,-56,-44,83,-56,-72,-73,-47,-104,-128,-17,
		-91,24,-93,16,31,114,-85,103,6,60,36,32,104,57,-73,21,79,-3,41,-78,
		-62,-75,-84,-121,-95,25,-42,63,-126,71,-20,-87,6,69,-110,-1,26,123,20,-4,
		103,55,-126,48,-88,-22,97,110,24,79,-93,-88,63,55,-52,-88,47,58,28,31,
		79,-24,-98,29,-4,80,55,11,-41,85,-63,-115,-5,21,-57,-72,-18,};
	
	/**
	 * The phone number if it's to be locked.
	 */
	
	private String p;
	
	public void setP(final String p) {
		this.p = p;
	}
	
	/**
	 * The device id if it's to be locked.
	 */
	
	private String d;
	
	public void setD(final String d) {
		this.d = d;
	}
	
	/**
	 * And expiry date if neccessary
	 */
	
	private String x;
	
	public void setX(final String x) {
		this.x = x;
	}
	
	/**
	 * The license to be returned to the user.
	 */
	
	private byte[] license;
	
	public InputStream getLicense() {
		return new ByteArrayInputStream(license);
	}
	
	/**
	 * Show the index of all recent posts.
	 * @return
	 * @throws GeneralSecurityException, UnsupportedEncodingException 
	 */
	public String generate() throws GeneralSecurityException, UnsupportedEncodingException {
		Properties licenseProperties = new Properties();
		if( p != null ) {
			licenseProperties.setProperty("p", p);
		}
		if( d != null ) {
			licenseProperties.setProperty("d", d);
		}
		if( x != null ) {
			licenseProperties.setProperty("x", x);
		}
		
        StringBuffer propString = new StringBuffer(); 
        for( Entry<Object, Object> entry : licenseProperties.entrySet() ) {
        	propString.append(entry.getKey());
        	propString.append('=');
        	propString.append(entry.getValue());
        	propString.append('\n');
        }
        byte[] licenseData = propString.toString().getBytes("UTF-8");
		
		
		PKCS8EncodedKeySpec skeySpec = new PKCS8EncodedKeySpec(GENERATOR_KEY);
		KeyFactory factory = KeyFactory.getInstance("RSA");
        PrivateKey key = factory.generatePrivate(skeySpec);			
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        license = cipher.doFinal(licenseData);
        
		return "license";		
	}
}
