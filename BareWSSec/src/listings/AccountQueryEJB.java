package org.acme.cc.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import org.acme.cc.delegate.AccountQuery;
import org.acme.cc.delegate.AccountQueryDelegate;
import org.acme.cc.jaxws.CCPortType;
import org.acme.cc.jaxws.CCService;
import org.acme.cc.jaxws.QueryFaultMsg;
import org.acme.cc.jaxws.QueryRequest;
import org.acme.cc.jaxws.QueryResponse;

@Stateless
@LocalBean
public class AccountQueryEJB {
   
   public static final String CLASSNAME = AccountQueryEJB.class.getName();
   private static final Logger log = Logger.getLogger(CLASSNAME);
   
   @Resource(name="MockCC", description="Stub the remote CC call")
   Boolean mockCC = false;
   
   @WebServiceRef(name="jaxwsCC") CCService ccService;
   CCPortType account = null;

   public AccountQueryEJB() {
      log.entering(CLASSNAME, "ctor");
      log.exiting(CLASSNAME, "ctor");
   }
   
   @PostConstruct
   void initDelegate() {
      log.entering(CLASSNAME, "initDelegate");
      if (mockCC) {
         log.warning("Mock is set to true. Using mock imlementation of delegate.");
         account = new AccountQueryMock();
         log.fine("AccountQueryMock instance created.");
      } else {
         account = ccService.getCCService();
         log.fine("AccountQueryDelegate instance created.");
      }
      log.exiting(CLASSNAME, "initDelegate");
   }
   
   public QueryResponse query(QueryRequest request) throws QueryFaultMsg {
      log.entering(CLASSNAME, "query");
      QueryResponse response = account.query(request);
      log.exiting(CLASSNAME, "query");
      return response;
   }
}
