package dekequan_service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/dekequan/spring/applicationContext.xml", "classpath:/com/dekequan/spring/dispatcher-servlet.xml"})
public class BaseDemo {

}
