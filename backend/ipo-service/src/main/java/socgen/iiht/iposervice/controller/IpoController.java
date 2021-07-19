package socgen.iiht.iposervice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socgen.iiht.iposervice.model.Ipo;
import socgen.iiht.iposervice.service.IpoService;

import java.util.List;

@RestController
@RequestMapping("/ipodetails")
public class IpoController {
    @Autowired
    private IpoService ipoService;

    @GetMapping("/get_all_ipo_details")
    public List<Ipo> getAllIpo(){
        return ipoService.getAllIpo();
    }

    @PostMapping("/add_ipo_details")
    public void addIpoDetails(@RequestBody Ipo ipo){
        ipoService.addIpo(ipo);
    }
}
