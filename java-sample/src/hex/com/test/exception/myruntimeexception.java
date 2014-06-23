package hex.com.test.exception;

import java.util.HashMap;
import java.util.Map;

public class myruntimeexception  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageId =null;
	private Map<String, Object> replaceMap = new HashMap<String, Object>();
	
	public myruntimeexception(String paramMessageId,Map<String, Object> replaceStringMap){
		super();
		this.messageId = paramMessageId;
		this.replaceMap = replaceStringMap;
	}
	
	public myruntimeexception(String paramMessageId){
		super(paramMessageId);
		this.messageId = paramMessageId;
	}
	
}
