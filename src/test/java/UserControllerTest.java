import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nhnacademy.jdbc.board.controller.UserController;
import com.nhnacademy.jdbc.board.domain.user.User;
import com.nhnacademy.jdbc.board.interceptor.LoginCheckInterceptor;
import com.nhnacademy.jdbc.board.repository.UserRepository;
import com.nhnacademy.jdbc.board.service.UserService;
import com.nhnacademy.jdbc.board.service.impl.UserServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {
    MockMvc mockMvc;
    UserService userService;
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService))
                                 .addInterceptors(new LoginCheckInterceptor())
                                 .build();
    }

    @Test
    void goToLoginFormTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/login"))
                                     .andExpect(status().is3xxRedirection())
                                     .andReturn();

        // .andExpect(view().name("users/form"));
        assertThat(mvcResult.getResponse().getRedirectedUrl()).isEqualTo("login");
    }

    @Test
    void loginCheckSuccessfulTest() throws Exception {
        User user = new User(0L, "admin", "123", "관리자");
        Optional<User> userTest = Optional.of(user);

        when(userRepository.findByUserName(anyString())).thenReturn(userTest);

        MvcResult mvcResult = mockMvc.perform(post("/login")
                                         .param("username", "admin")
                                         .param("password", "123"))
                                     .andExpect(status().is3xxRedirection())
                                     .andReturn();

        assertThat(mvcResult.getResponse().getRedirectedUrl()).isEqualTo("login");
        // HttpSession session = mvcResult.getRequest().getSession(false);
        // assertThat(session).isNotNull();
    }
}
