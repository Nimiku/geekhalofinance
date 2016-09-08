package cn.geekhalo.wetch.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext//This annotation indicates that the application context associated with a test is dirty and should be closed. Subsequent tests will be supplied a new context. Works on class-level and method-level.
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class ServiceTest {

}
