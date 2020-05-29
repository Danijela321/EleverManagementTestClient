import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.yrgo.domain.Elever;
import com.yrgo.elevermanagement.EleverManagementService;

/**
 * @author danijela
 */

public class Main {

	public static void main(String[] args) throws NamingException {

		Properties jndiProperties = new Properties();

		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context", true);

		Context jndi = new InitialContext(jndiProperties);

		EleverManagementService service = (EleverManagementService) jndi.lookup(
				"EleverManagementServerApplication/EleverManagementImplementation!com.yrgo.elevermanagement.EleverManagementService");

		Elever el2 = new Elever("Sara", "Henriksson", "Yrgo", 1);
//		Elever el3 = new Elever("Mate20", "Lundqvist", "ITH", 2);
//		Elever el4 = new Elever("Mike20", "Pedersson", "ITH", 1);
//		Elever el5 = new Elever("Mark20", "Lundqvist", "Yrgo", 2);

		try {
			service.registerElever(el2);
//			service.registerElever(el3);
//			service.registerElever(el4);
//			service.registerElever(el5);
			System.out.println("Kör programmet flera gånger för att få checked exception");

		} catch (Exception e) {
			// beror på Math.random() funktion i EleverManegerServerApplication
			// kör programmet till fel inte händer
			System.out.println("Fel händer!");
			System.out.println("Kör programmet flera gånger till checked exception inte händer");

		}

		List<Elever> elever = service.getAllElever();
		for (Elever eleverna : elever) {
			System.out.println(eleverna);
		}
	
	}

}
