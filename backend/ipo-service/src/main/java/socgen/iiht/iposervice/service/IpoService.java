package socgen.iiht.iposervice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import socgen.iiht.iposervice.model.Ipo;
import socgen.iiht.iposervice.repository.IpoRepo;

import java.util.List;

@Service
public class IpoService {
    @Autowired
    private IpoRepo ipoRepo;

    public List<Ipo> getAllIpo(){
        return ipoRepo.findAll();
    }

    public void addIpo(@RequestBody Ipo ipo){
        ipoRepo.save(ipo);
    }

}
