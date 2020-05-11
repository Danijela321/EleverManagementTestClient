import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.yrgo.domain.Elever;
import com.yrgo.elevermanagement.EleverManagementService;



public class Main {

	public static void main(String[] args) throws NamingException {

Properties jndiProperties = new Properties();

jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                  "org.jboss.naming.remote.client.InitialContextFactory");
jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
jndiProperties.put("jboss.naming.client.ejb.context",true);

Context jndi = new InitialContext(jndiProperties);
EleverManagementService service = (EleverManagementService) jndi.lookup("EleverManagementServerApplication/EleverManagementImplementation!com.yrgo.elevermanagement.EleverManagementService");
	
List<Elever> elever = service.getAllElever();
for (Elever eleverna: elever) {
	System.out.println(eleverna);
}
	
	
	}
	

}
