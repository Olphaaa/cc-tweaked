package fr.iut.cctweaked.service;

import fr.iut.cctweaked.domain.Site;
import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.exception.NotFoundException;
import fr.iut.cctweaked.repository.SiteRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    private final SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    /**
     * Get all sites
     * @return List of sites
     */
    public List<Site> getAll() {
        return siteRepository.findAll();
    }

    /**
     * Get a site by id
     * @param id Site id
     * @return Site
     * @throws NotFoundException if site not found
     */
    public Site getById(ObjectId id) {
        return siteRepository.findById(id).orElseThrow(() -> new NotFoundException("Site not found"));
    }

    /**
     * Add a site
     * @param site Site to add
     * @return Added site
     */
    public Site addSite(Site site) {
        return siteRepository.save(site);
    }

    /**
     * Edit a site
     * @param site Site to edit
     * @return Edited site
     */
    public Site updateSite(Site site) {
        siteRepository.findById(site.get_id()).orElseThrow(() -> new NotFoundException("Site not found"));
        return siteRepository.save(site);
    }

    /**
     * Delete a site
     * @param _id Site id
     */
    public void deleteSite(ObjectId _id) {
        siteRepository.delete(siteRepository.findById(_id).orElseThrow(() -> new NotFoundException("Site not found")));
    }
}
