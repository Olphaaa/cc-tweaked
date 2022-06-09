package fr.iut.cctweaked.site;

import fr.iut.cctweaked.site.model.Site;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiteController {
    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public ResponseEntity<List<Site>> getAll(){
        return new ResponseEntity<>(siteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        Site site = siteService.getById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Site> addSite(@RequestBody Site site){
//        return siteService.addSite(site);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Site> updateSite(@RequestBody Site site){
//        return siteService.updateSite(site);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
