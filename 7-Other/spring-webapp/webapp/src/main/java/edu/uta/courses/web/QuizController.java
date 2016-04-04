package edu.uta.courses.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.Quiz;
import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.service.QuizService;
import edu.uta.courses.util.UserUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by me on 27.1.2015.
 */
@Controller
@RequestMapping("/quiz")
@SessionAttributes(value = {"rand1", "rand2", "gamesPlayed","gamesWon"})
public class QuizController {


    @Autowired
    QuizService quizService;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = {"/start", ""})
    public String start(Model model) {

        Integer rand1 = quizService.getRandomNumber();
        Integer rand2 = quizService.getRandomNumber();
        model.addAttribute("rand1",rand1);
        model.addAttribute("rand2",rand2);
        model.addAttribute("gamesPlayed", 0);
        model.addAttribute("gamesWon", 0);


        return "/quiz/form";
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public String quiz(Model model, @RequestParam("answer") Integer answer,
                       @ModelAttribute("rand1") Integer rand1,
                       @ModelAttribute("rand2") Integer rand2,
                       @ModelAttribute("gamesPlayed") Integer gamesPlayed,
                       @ModelAttribute("gamesWon") Integer gamesWon) {
        // be sure to put new randoms to session bu placing them to model
        // get the correct answer using:

        // quizService.getMultiplication(rand1, rand2);
        Integer correctAnswer = quizService.getMultiplication(rand1,rand2);
        // implement the method, it is not there yet.
        if (correctAnswer == answer) {
            gamesWon++;
            model.addAttribute("correctAnswer", Boolean.TRUE);
        } else {
            model.addAttribute("correctAnswer", Boolean.FALSE);
        }
        // do other stuff before returning from controller.
        gamesPlayed++;

        Integer newrand1 = quizService.getRandomNumber();
        Integer newrand2 = quizService.getRandomNumber();
        model.addAttribute("rand1",newrand1);
        model.addAttribute("rand2",newrand2);

        model.addAttribute("gamesPlayed", gamesPlayed);
        model.addAttribute("gamesWon", gamesWon);

        return "/quiz/quiz";
    }

    @RequestMapping("/complete")
    public String complete(Model model, SessionStatus sessionStatus,
                           @ModelAttribute("gamesPlayed") Integer gamesPlayed,
                           @ModelAttribute("gamesWon") Integer gamesWon) {

        Quiz quiz = new Quiz();
        quiz.setCreatedOn(new DateTime());
        quiz.setGamesPlayed(gamesPlayed);
        quiz.setGamesWon(gamesWon);
        // of is not anonymous user, set the user too.
        WwwUser u = UserUtil.getWwwUser();
        try {
            if (u != null) {
                quiz.setUser(personRepository.findById(u.getId()));
            }
        } catch (Exception e) {
            /* noop */
        }
        Float score = ( gamesWon.floatValue() / gamesPlayed.floatValue() ) * 100;
        model.addAttribute("score", score);
        quizService.storeQuiz(quiz);
        model.addAttribute("quiz", quiz);

        sessionStatus.setComplete();
        return "/quiz/theend";
    }

    @RequestMapping("/quizes")
    public String quizes(Model model) {
        model.addAttribute("quizList", quizService.getQuizes());
        return "/quiz/quizes";
    }

}
