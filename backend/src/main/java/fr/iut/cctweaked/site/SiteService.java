package fr.iut.cctweaked.site;

import fr.iut.cctweaked.site.model.Site;
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
}
