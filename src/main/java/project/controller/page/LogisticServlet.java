package project.controller.page;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import project.aspect.NotNullByDefault;
import project.factory.Factory;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by klok on 6.10.17.
 */
@NotNullByDefault

@Log4j
@Controller
public class LogisticServlet {

    static { Factory.getFactory().setApplicationContext("root-context.xml"); }

    //welcome page
    @RequestMapping(value = "/")
    public @ResponseBody ModelAndView getIndex() {
        return new ModelAndView("Index");
    }


    //success authorization
    @RequestMapping(value = "/success", method = GET, produces = "application/json")
    public @ResponseBody boolean getSuccessAuth() {
        return true;
    }


    //authorization failure
    @RequestMapping(value = "/failure", method = GET, produces = "application/json")
    public @ResponseBody boolean getFailureAuth() {
        return false;
    }
}
