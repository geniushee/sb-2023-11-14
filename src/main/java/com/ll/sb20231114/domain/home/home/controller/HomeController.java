package com.ll.sb20231114.domain.home.home.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/") // 해당 주소로 연결(?)
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showMain() {
        System.out.println("안녕하세요."); // 이 메세지는 콘솔에 출력
        return "안녕하세요."; // 이 메세지는 웹에 출력
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b) {
        return "계산기";
    }

    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b) {
        return "계산결과 : ";
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b) {
        return "계산결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b) {
        return "계산결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "-") String a,
            @RequestParam(defaultValue = "-") String b) {
        return "계산결과 : %s".formatted(a + b);
    }

    @GetMapping("/calc6")
    @ResponseBody
    String showCalc6(
            int a,
            int b) {
        return "계산결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a,
            int b) {
        return a > b;
    }

    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name,
            int age) {
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name,
            int age) {
        return new Person2(name, age);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map showCalc10(
            String name,
            int age) {
        Map<String , Object> personMap = Map.of("name", name, "age", age);
        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Person2> showCalc11(
            String name,
            int age) {
        List<Person2> personList = new ArrayList<>(){{
            add(new Person2(name, age));
            add(new Person2(name + "!", age));
            add(new Person2(name + "!!", age));
        }};
        return personList;
    }

    @GetMapping("/calc12")
    @ResponseBody
    int[] showCalc12(
            String name,
            int age) {
        int[] intList = new int[]{1,2,3,4};
        return intList;
    }

    @GetMapping("/calc13")
    @ResponseBody
    List<Integer> showCalc13() {
        List<Integer> nums = new ArrayList<>() {{
            add(10);
            add(-510);
            add(10010);
        }};

        return nums;
    }

    @GetMapping("/calc14")
    @ResponseBody
    StringBuilder showCalc14() {
//        html += "<div>";
//        html += "<input type=\"text\" placeholder=\"내용\">";
//        html += "</div>"; =>
         StringBuilder sb = new StringBuilder();
         sb.append("<div>").append("<input type=\"text\" placeholder=\"내용\">")
                 .append("</div>");
        return sb;
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15(String html) {
        html += "<div>";
        html += "<input type=\"text\" placeholder=\"내용\">";
        html += "</div>";
        return html;
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16(String html) {
        html = """
                <div><input type="text" placeholder="내용"></div>
                """;
        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17(String html) {
        html = """
                <div>
                    <input type="text" placeholder="내용">
                </div>
                """;
        return html;
    }

    @GetMapping("/calc18")
    @ResponseBody
    String showCalc18(String html) {
        html = """
                <div>
                    <input type="text" placeholder="내용" value="반가워요.">
                </div>
                """;
        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(
            @RequestParam(defaultValue = "") String subject,
            @RequestParam(defaultValue = "") String content) {
        String html = """
                <div>
                    <input type="text" placeholder="제목" value="%s">
                </div>
                <div>
                    <input type="text" placeholder="content" value="%s">
                </div>
                """.formatted(subject, content);
        return html;
    }

    @GetMapping("/calc20")
    String showCalc20() {
        return "calc20";
    }

    @GetMapping("/calc21")
    String showCalc21(Model model) {
        model.addAttribute("v1", "안녕!!!!");
        model.addAttribute("v2", "반가워!!!");
        return "calc21";
    }

    int num = 0;
    @GetMapping("/calc22")
    @ResponseBody
    int showCalc22() {
        num++;
        return num;
    }

    @AllArgsConstructor
    class Person {
        public String name;
        public int age;
    }

    @AllArgsConstructor
    @Getter
    class Person2 {
        private String name;
        private int age;
    }
}
