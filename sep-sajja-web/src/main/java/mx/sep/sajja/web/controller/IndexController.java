package mx.sep.sajja.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {	

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
        
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mostrarIndex(){
        
        return new ModelAndView("index");
    }
	
}
