package org.mycompany;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class UpperCaseProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {

		String originalFileContent = (String) exchange.getIn().getBody(String.class);
        String upperCaseFileContent = originalFileContent.toUpperCase();
        exchange.getIn().setBody(upperCaseFileContent);
		
	}

}
