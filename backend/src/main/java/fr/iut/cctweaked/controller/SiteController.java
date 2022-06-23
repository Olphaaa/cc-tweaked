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

    /**
     * Get all sites
     * @return List of sites
     */
    @GetMapping
    public ResponseEntity<List<Site>> getAll(){
        return new ResponseEntity<>(siteService.getAll(), HttpStatus.OK);
    }

    /**
     * Get a site by id
     * @param id Site id
     * @return Site
     */
    @GetMapping("/{id}")
    public ResponseEntity<Site> getById(@PathVariable("id") String id){
        Site site = siteService.getById(new ObjectId(id));
        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    /**
     * Add a site
     * @param siteDTO Site
     * @return Added site
     */
    @PostMapping
    public ResponseEntity<Site> addSite(@RequestBody SiteDTO siteDTO){
        return new ResponseEntity<>(siteService.addSite(SiteMapper.siteDTOtoSite(siteDTO)) ,HttpStatus.CREATED);
    }

    /**
     * Edit a site
     * @param site Site to edit
     * @return Edited site
     */
    @PutMapping
    public ResponseEntity<Site> updateSite(@RequestBody Site site){
        Site updatedSite = siteService.updateSite(site);
        return new ResponseEntity<>(updatedSite, HttpStatus.OK);
    }

    /**
     * Delete a site
     * @param id Site id
     * @return Deleted site
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSite(@PathVariable("id") String id){
        siteService.deleteSite(new ObjectId(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
