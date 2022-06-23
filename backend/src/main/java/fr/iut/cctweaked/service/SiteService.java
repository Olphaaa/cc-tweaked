package fr.iut.cctweaked.service;

import fr.iut.cctweaked.domain.Site;
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

    public List<Site> getAll() {
        return siteRepository.findAll();
    }

    public Site getById(ObjectId id) {
        return siteRepository.findById(id).orElseThrow();
    }

    public Site addSite(Site site) {
        return siteRepository.save(site);
    }

    public Site updateSite(Site site) {
        return siteRepository.save(site);
    }

    public void deleteSite(Site site) {
        siteRepository.delete(site);
    }
}
