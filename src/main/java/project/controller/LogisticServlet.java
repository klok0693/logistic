package project.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import project.NotNullByDefault;
import project.factory.Factory;
import project.model.data.DaoException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klok on 6.10.17.
 */
@Log4j
@Controller
@NotNullByDefault
public class LogisticServlet {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        Factory factory;
        try {
            factory = Factory.getFactory("root-context.xml");
        }
        catch (Exception e) {
            log.error("Can't create factory, return null",e);
            return null;
        }

        try {
            Map<String, String> model = new HashMap<>();
            model.put("trucks", factory.getTruckData().getAll().toString());

            return new ModelAndView("index", model);
        }
        catch (DaoException e) {
            return null;
        }
    }
}
