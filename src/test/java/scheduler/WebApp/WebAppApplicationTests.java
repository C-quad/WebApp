package scheduler.WebApp;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.scheduler.WebApp.model.Users;


@SpringBootTest
public class WebAppApplicationTests {
    
    //jUnit test to verify Users object correctly saves and retrieves the user's ID number (ID number is of type UUID)
	@Test
	public void idNumTest() 
	{
		
	    ObjectId dNum = ObjectId.get();
	    Users lance = new Users(dNum, "Lance", "Dall", false, "test@gmail.com", "password","");

	    assertEquals(dNum.toHexString(), lance.getEmployeeId());
		
	}

	//another jUnit test to verify Users object correctly saves and retrieves the user's ID number
	@Test
	public void idNumTest2()
	{
	    
		ObjectId dNum2= ObjectId.get();
	        assertEquals(dNum2.toHexString(), new Users(dNum2, "Alex", "Ander", false, "test@gmail.com", "password","").getEmployeeId());
	    
	}
}
