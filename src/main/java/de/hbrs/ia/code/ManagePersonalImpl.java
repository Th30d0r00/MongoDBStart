package de.hbrs.ia.code;

import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerformanceRecord;

import java.util.List;

/**
 * Control class for managing personal data
 */


public class ManagePersonalImpl implements ManagePersonal{


    private final ManagePersonalService managePersonalService;

    public ManagePersonalImpl(ManagePersonalService managePersonalService) {
        this.managePersonalService = managePersonalService;
    }

    @Override
    public void addSalesMan(SalesMan record) {
        managePersonalService.addSalesMan(record);
    }

    @Override
    public void addSocialPerformanceRecord(SocialPerformanceRecord record, SalesMan salesMan) {
        managePersonalService.addSocialPerformanceRecord(record, salesMan);
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        return managePersonalService.readSalesMan(sid);
    }

    @Override
    public List<SalesMan> readAllSalesMen() {
        return managePersonalService.readAllSalesMen();
    }

    @Override
    public List<SocialPerformanceRecord> readSocialPerformanceRecord(SalesMan salesMan) {
        return managePersonalService.readSocialPerformanceRecord(salesMan);
    }

    @Override
    public void updateSalesMan(SalesMan record) {
        managePersonalService.updateSalesMan(record);
    }

    @Override
    public void deleteSalesMan(SalesMan record) {
        managePersonalService.deleteSalesMan(record);
    }

    @Override
    public void deleteSocialPerformanceRecord(SocialPerformanceRecord socialPerformanceRecord) {
        managePersonalService.deleteSocialPerformanceRecord(socialPerformanceRecord);
    }
}
