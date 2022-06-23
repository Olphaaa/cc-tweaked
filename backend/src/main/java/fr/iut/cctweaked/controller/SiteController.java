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
    public ResponseEntity<SiteDTO> addSite(@RequestBody SiteDTO siteDTO){
        Site site = siteService.addSite(SiteMapper.siteDTOtoSite(siteDTO));
        return new ResponseEntity<>(SiteMapper.siteToSiteDTO(site), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SiteDTO> updateSite(@RequestBody Site site){
        Site updatedSite = siteService.updateSite(site);
        return new ResponseEntity<>(SiteMapper.siteToSiteDTO(updatedSite), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSite(@PathVariable("id") String id){
        siteService.deleteSite(new ObjectId(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
