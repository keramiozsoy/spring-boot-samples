package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String home(){
        return "home :)";
    }

    @RequestMapping("/sendName")
    public String sendName(@RequestParam(value="nameParam", defaultValue="Noo!!") String name) {
        return counter.incrementAndGet() + " - " + String.format(template, name);
    }
}
