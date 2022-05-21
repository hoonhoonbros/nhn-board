import com.nhnacademy.jdbc.board.controller.UserController;
import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.interceptor.LoginCheckInterceptor;
import com.nhnacademy.jdbc.board.repository.UserLoginRepository;
import com.nhnacademy.jdbc.board.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserControllerTest {
    MockMvc mockMvc;
    UserServiceImpl userServiceImpl;
    UserLoginRepository userLoginRepository;

    @BeforeEach
    void setUp() {
        userLoginRepository = mock(UserLoginRepository.class);
        userServiceImpl = new UserServiceImpl(userLoginRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userServiceImpl))
                                 .addInterceptors(new LoginCheckInterceptor())
                                 .build();
    }

    @Test
    void goToLoginFormTest() throws Exception {
        mockMvc.perform(get("/login"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("users/form"));
    }

    @Test
    void loginCheckSuccessfulTest() throws Exception {
        User user = new User(0, "admin", "123", "관리자");
        Optional<User> userTest = Optional.of(user);

        when(userLoginRepository.findByUserName(anyString())).thenReturn(userTest);

        MvcResult mockResult = mockMvc.perform(post("/login")
                                              .param("username", "admin")
                                              .param("password", "123"))
                                      .andExpect(status().is3xxRedirection())
                                      .andExpect(view().name("posts/index"))
                                      .andReturn();

        HttpSession session = mockResult.getRequest().getSession(false);
        assertThat(session).isNotNull();
    }

}
