package socgen.iiht.sectorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socgen.iiht.sectorservice.model.Sector;
import socgen.iiht.sectorservice.service.SectorService;

import java.util.List;

@RestController
@RequestMapping("/sector")
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @GetMapping("/get_all_sectors")
    public List<Sector> getAllSectors(){
        return sectorService.getAllSectors();
    }

    @PostMapping("/add_sector")
    public void addSector(@RequestBody Sector sector){
        sectorService.addSector(sector);
    }



}
