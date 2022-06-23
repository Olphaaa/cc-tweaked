package fr.iut.cctweaked.utils.mapper;

import fr.iut.cctweaked.domain.Site;
import fr.iut.cctweaked.domain.Site;
import fr.iut.cctweaked.domain.Storage;
import fr.iut.cctweaked.domain.Supplier;
import fr.iut.cctweaked.dto.SiteDTO;
import fr.iut.cctweaked.dto.SiteDTO;
import org.bson.types.ObjectId;

import java.util.List;

public class SiteMapper {

    /**
     * Convert a site to a siteDTO
     * @param siteDTO Site to convert
     * @return SiteDTO
     */
    public static Site siteDTOtoSite(SiteDTO siteDTO) {
        Site site = new Site();
        if (siteDTO.get_id() != null) {
            site.set_id(new ObjectId(siteDTO.get_id()));
        }
        List<Supplier> suppliers = SupplierMapper.supplierDTOListToSupplierList(siteDTO.getSupplierDTOs());
        List<Storage> storages = StorageMapper.storageDTOListToStorageList(siteDTO.getStorageDTOs());
        site.setName(siteDTO.getName())
                .setOwner(siteDTO.getOwner())
                .setSuppliers(suppliers)
                .setStorages(storages);

        return site;
    }

    /**
     * Convert a site to a siteDTO
     * @param site Site to convert
     * @return SiteDTO
     */
    public static SiteDTO siteToSiteDTO(Site site) {
        SiteDTO siteDTO = new SiteDTO();
        siteDTO.set_id(site.get_id().toString())
                .setName(site.getName())
                .setOwner(site.getOwner())
                .setSupplierDTOs(SupplierMapper.supplierListToSupplierDTOList(site.getSuppliers()))
                .setStorageDTOs(StorageMapper.storageListToStorageDTOList(site.getStorages()));

        return siteDTO;
    }

    /**
     * Convert a list of sites to a list of siteDTO
     * @param siteList List of sites to convert
     * @return List of siteDTO
     */
    public static List<SiteDTO> siteListToSiteDTOList(List<Site> siteList) {
        List<SiteDTO> siteDTOList = new java.util.ArrayList<>();
        siteList.forEach(site -> siteDTOList.add(siteToSiteDTO(site)));
        return siteDTOList;
    }
}
