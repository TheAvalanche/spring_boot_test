package lv.akurss.boottest.rest;

import lv.akurss.boottest.domain.UserBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test 
	public void testController() {

		UserBean bean = new UserBean();
		bean.setName("John");
		bean.setSurname("Doe");
		
		ResponseEntity<String> response =  restTemplate.postForEntity("/user", bean, String.class);

		Assert.assertEquals("OK", response.getBody());
		
		
	}
	
}
