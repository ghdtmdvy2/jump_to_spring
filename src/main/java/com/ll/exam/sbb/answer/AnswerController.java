package com.ll.exam.sbb.answer;

import com.ll.exam.sbb.question.Question;
import com.ll.exam.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor // 생성자 주입
public class AnswerController {
    private final QuestionService questionService;

    @PostMapping("/create/{id}")
    // 이 자리에 @ResponseBody가 없으면 resources/question_list/question_list.html 파일을 뷰로 삼는다.
    public String detail(Model model, @PathVariable int id, String content) {
        Question question = questionService.getQuestion(id);
        return "redirect:/question/detail/%d".formatted(id);
    }
}
