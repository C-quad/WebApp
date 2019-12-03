package scheduler.WebApp;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.scheduler.WebApp.model.Users;


@SpringBootTest
public class EmployeeNameTest {

    //jUnit test to verify Users object correctly saves and retrieves the user's first and last name
    @Test
    public void employeeNameTest() 
    {
        
        UUID idNum = UUID.randomUUID();
        Users lance = new Users(ObjectId.get(), "Lance", "Dall", false, "test@gmail.com", "password","");

        assertEquals("Lance Dall", lance.getFirstName() + " " + lance.getLastName());
        
    }

}
