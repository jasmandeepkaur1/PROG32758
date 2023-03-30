package ca.sheridancollege.Assignment3_kau11071.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class sessioncontroller {
    @GetMapping("/")
    public String home(Model model, HttpSession session) {

        List<String> messages = (List<String>) session.getAttribute("my message");

        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);

        return "index";
    }

    @PostMapping("/startSessionMessage")
    public String addMessage(@RequestParam("mess") String mess ,HttpServletRequest request ) {

       @SuppressWarnings("unchecked")
        List<String> messages = (List<String>)
               request.getSession().getAttribute("my message");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute("my message", messages);
        }
        messages.add(mess);

        request.getSession().setAttribute("my message", messages);
        return "redirect:/";
    }
    @GetMapping("/destroysessionMessage")
    public String destroySession( HttpSession session ) {
session.invalidate();
        return "redirect:/";
    }

}
