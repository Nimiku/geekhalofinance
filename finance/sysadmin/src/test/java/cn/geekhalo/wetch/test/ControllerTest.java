package cn.geekhalo.wetch.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@DirtiesContext//This annotation indicates that the application context associated with a test is dirty and should be closed. Subsequent tests will be supplied a new context. Works on class-level and method-level.
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class ControllerTest {
	private MockMvc mockMvc;
	@Autowired 
    private WebApplicationContext ctx;
	 @Before  
    public void init() {  
        this.setMockMvc(MockMvcBuilders.webAppContextSetup(this.ctx).build());
    } 
	 
	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}
	
}
