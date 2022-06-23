package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.config.SpringFoxConfig;
import fr.iut.cctweaked.domain.Site;
import fr.iut.cctweaked.dto.SiteDTO;
import fr.iut.cctweaked.service.SiteService;
import fr.iut.cctweaked.utils.mapper.SiteMapper;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("site")
@Api(tags = {SpringFoxConfig.SITE_TAG})
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
    public ResponseEntity<Site> getById(@PathVariable("id") String id){
        Site site = siteService.getById(new ObjectId(id));
        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Site> addSite(@RequestBody SiteDTO siteDTO){
//        return siteService.addSite(site);
        return new ResponseEntity<>(siteService.addSite(SiteMapper.siteDTOtoSite(siteDTO)) ,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Site> updateSite(@RequestBody Site site){
//        return siteService.updateSite(site);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
