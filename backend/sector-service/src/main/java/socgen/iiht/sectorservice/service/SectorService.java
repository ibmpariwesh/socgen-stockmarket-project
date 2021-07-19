package socgen.iiht.sectorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socgen.iiht.sectorservice.model.Sector;
import socgen.iiht.sectorservice.repository.SectorRepo;

import java.util.List;

@Service
public class SectorService {
    @Autowired
    private SectorRepo sectorRepo;

    public List<Sector> getAllSectors(){
        return sectorRepo.findAll();
    }

    public void addSector(Sector sector){
        sectorRepo.save(sector);
    }
}
