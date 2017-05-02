package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {
    @Test
    public void testHome() {
        HomeController controller = new HomeController();
        try {
            MockMvc mockMvc = standaloneSetup(controller).build();
            mockMvc.perform(get("/")).andExpect(view().name("home"));
        } catch(Throwable t) {
            t.printStackTrace();
            fail(t.getMessage());
        }
    }

    @Test
    public void testHomeExtra() {
        HomeController controller = new HomeController();
        try {
            MockMvc mockMvc = standaloneSetup(controller).build();
            mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
        } catch(Throwable t) {
            t.printStackTrace();
            fail(t.getMessage());
        }
    }
}
