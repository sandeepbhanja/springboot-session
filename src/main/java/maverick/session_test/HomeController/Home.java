package maverick.session_test.HomeController;

import java.security.Principal;

import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class Home {

    private final String homeViewCount = "homeViewCount";

    @GetMapping("/")
    public String HomeControl(Principal p, HttpSession session){
        countHome(session,homeViewCount);
        return "Hello," + p.getName();
    }

    @GetMapping("/count")
    public String CountHome(HttpSession session){
        return "HomeViewCount : " + session.getAttribute(homeViewCount);
    }


    
    private void countHome(HttpSession session,String attr){
        int count = session.getAttribute(attr) == null ? 0 : (int)session.getAttribute(attr);
        session.setAttribute(attr, count+=1);
    }
}
