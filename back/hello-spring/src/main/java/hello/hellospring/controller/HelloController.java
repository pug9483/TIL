package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // GET메소드
    @GetMapping("hello")
    // Spring이 Model을 만들어서 넣어줌
    public String hello(Model model){
        // 키(data), 값(hello!!) 넣기
        model.addAttribute("data", "hello!!");
        // resources:templates + (ViewName) + .html 을 찾아가서 랜더링한다.
        return "hello";
    }

    @GetMapping("hello-mvc")
    //  외부(URL)에서 받아오기
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    // HTTP에서 header와 body중 body부분에 이 데이터를 직접 넣어주겠다는 의미
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // 해당 문자열이 요청한 클라이언트에 바로 내려감
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
