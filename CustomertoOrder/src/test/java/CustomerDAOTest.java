import org.junit.Before;
import org.junit.Test;

import com.accolite.hibernate.CustomerDAO;
import com.accolite.hibernate.CustomerDAOInterfaceImpl;
import com.accolite.hibernate.model.Customer;
import com.accolite.hibernate.model.Order;
import com.accolite.interfaces.CustomerDAOInterface;
public class CustomerDAOTest {

	private CustomerDAOInterface customerDAO=null;
	
	@Before
	public void setUp() {
		customerDAO = new CustomerDAOInterfaceImpl();
	}
/*
	@Test
	public void testPersistCustomer() {
		Customer customer = new Customer("XYZ", "Business");
		customerDAO.persistCustomer(customer);
		Order account = new Order("order1");
		account.setCustomer(customer);
		customer.getOrders().add(account);
		customerDAO.persistOrder(account);
	}*/
	@Test
	public void testSaveCustomer() {
		for(int i = 0; i < 10; i++) {
			Customer cus = new Customer("XYZ"+i,"testing"+i);
			customerDAO.saveCustomer(cus);
		}
	}/*
	@Test
	public void testGetCustomer() {
		Customer customer = customerDAO.getCustomerByCustId(1l);
	}*/

}
