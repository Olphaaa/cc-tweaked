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

    public List<Site> getAll() {
        return siteRepository.findAll();
    }

    public Site getById(ObjectId id) {
        return siteRepository.findById(id).orElseThrow(() -> new NotFoundException("Site not found"));
    }

    public Site addSite(Site site) {
        return siteRepository.save(site);
    }

    public Site updateSite(Site site) {
        siteRepository.findById(site.get_id()).orElseThrow(() -> new NotFoundException("Site not found"));
        return siteRepository.save(site);
    }

    public void deleteSite(ObjectId _id) {
        siteRepository.delete(siteRepository.findById(_id).orElseThrow(() -> new NotFoundException("Site not found")));
    }
}
