import com.akash.spring.crm.exceptions.CustomerNotFoundException;
import com.akash.spring.crm.exceptions.RecordNotFoundException;
import com.akash.spring.crm.model.Action;
import com.akash.spring.crm.model.Call;
import com.akash.spring.crm.model.Customer;
import com.akash.spring.crm.services.calls.CallService;
import com.akash.spring.crm.services.customer.CustomerService;
import com.akash.spring.crm.services.diary.ActionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Akash Agarwal on 5/2/2016.
 */
public class App {

    public static void main (String[] args) {
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("file:src/main/resources/spring/application.xml");

        CustomerService customerService = container.getBean(CustomerService.class);
        CallService callService = container.getBean(CallService.class);
        ActionService actionService = container.getBean(ActionService.class);
        Customer customer = new Customer();
        customer.setId("1");
        customer.setCustomerNotes("Good");
        customer.setCompany("Acme");

        customerService.addCustomer(customer);

        Call call = new Call();
        call.setCallNotes("Say hello");

        Action action1 = new Action();
        action1.setDetails("Grr");
        action1.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        action1.setOwner("aka");

        Action action2 = new Action();
        action2.setDetails("Brrr");
        action2.setRequiredBy(new GregorianCalendar(2016, 3, 5));
        action2.setOwner("aka");

        List<Action> actions = new ArrayList<Action>();
        actions.add(action1);
        actions.add(action2);

        try {
            callService.recordCall("1", call, actions);
        } catch (CustomerNotFoundException e) {
            System.out.println("This guy does not exists");
        }

        try {
            List<Action> actionList = actionService.getAllIncompleteActions("aka");

            for (Action action : actionList) {
                System.out.println(action);
            }
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }

        container.close();
    }
}
