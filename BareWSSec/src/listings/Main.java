package org.acme.cc.client;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.acme.cc.jaxws.CCService;
import org.acme.cc.jaxws.CCPortType;
import org.acme.cc.jaxws.QueryRequest;
import org.acme.cc.jaxws.QueryResponse;
import org.acme.cc.jaxws.QueryFaultMsg;

public class Main {

   public static void main(String[] args) {
      String endpointUrl = "http://localhost:9080/cc/CCService";
      if (args.length == 1) {
         endpointUrl = args[0];
      }
      System.out.println("Using endpoint URL " + endpointUrl);
      CCService service = new CCService();  <co id="code.thinclient.service" linkends="callout.thinclient.service"/>
      CCPortType port = service.getCCPort();  <co id="code.thinclient.port" linkends="callout.thinclient.port"/>
      BindingProvider bp = (BindingProvider)port;  <co id="code.thinclient.bp" linkends="callout.thinclient.bp"/>
      Map&lt;String, Object&gt; reqCtx = bp.getRequestContext();
      reqCtx.put("javax.xml.ws.service.endpoint.address", endpointUrl);
      
      QueryRequest request = new QueryRequest();
      request.setCcNo("2982-3929-5122-4829");
      request.setLastName("Brown");
      
      QueryResponse response = null;

      try {
         response = port.query(request);  <co id="code.thinclient.invoke" linkends="callout.thinclient.invoke"/>
      System.out.println("Remote method returned.");
      } catch (QueryFaultMsg fault) {
         System.out.println("Caught service exception.");
         System.out.println("\tmsg = " + fault);
      }
      if (response != null) {
         System.out.println("Got response.");
         System.out.println("Account Num = " + response.getAcctNo());
         System.out.println(" First name = " + response.getFirstName());
         System.out.println("    Balance = " + response.getBalance());
      }
   }
}
