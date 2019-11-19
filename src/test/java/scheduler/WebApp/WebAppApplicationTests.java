package scheduler.WebApp;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.scheduler.WebApp.model.Users;


@SpringBootTest
public class WebAppApplicationTests {
    
    //jUnit test to verify Users object correctly saves and retrieves the user's ID number (ID number is of type UUID)
	@Test
	public void idNumTest() 
	{
		
	    UUID idNum = UUID.randomUUID();
	    Users lance = new Users(idNum, "Lance", "Dall", false, "test@gmail.com", "password","");

	    assertEquals(idNum, lance.getEmployeeId());
		
	}

	//another jUnit test to verify Users object correctly saves and retrieves the user's ID number
	@Test
	public void idNumTest2()
	{
	    
	        UUID idNum2 = UUID.randomUUID();
	        assertEquals(idNum2, new Users(idNum2, "Alex", "Ander", false, "test@gmail.com", "password","").getEmployeeId());
	    
	}
}
