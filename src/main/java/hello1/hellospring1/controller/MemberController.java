package hello1.hellospring1.controller;

import hello1.hellospring1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;

@Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
