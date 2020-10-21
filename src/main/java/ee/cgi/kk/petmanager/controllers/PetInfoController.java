package ee.cgi.kk.petmanager.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/petinfo")
public class PetInfoController {

    @GetMapping
    public Map<String,String> info()
    {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("status", "200");
		result.put("message", "This is Pet Manager REST service");
        return result;
    }

}
