import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.customer.CustomerService;
import com.sun.java_cup.internal.runtime.Symbol;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
public class App {

    public static void main (String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("file:src/main/resources/spring/application.xml");

        CustomerService service = container.getBean(CustomerService.class);
        Customer c = null;
        try {
            c = service.getFullCustomerDetail("1");
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(c.toString());
    }
}
