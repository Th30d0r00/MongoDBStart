package test;

import de.hbrs.ia.code.ManagePersonal;
import de.hbrs.ia.code.ManagePersonalImpl;
import de.hbrs.ia.code.ManagePersonalService;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerformanceRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTests {
    ManagePersonal managePersonal;
    ManagePersonalService managePersonalService;

    @BeforeEach
    void setUp() {

        managePersonalService = new ManagePersonalService("mongodb://localhost:27017", "salesmanGeneral", "Salesman");
        managePersonal = new ManagePersonalImpl(managePersonalService);
    }

    @Test
    void testAddAndReadSalesMen() {
        SalesMan salesManDoe = new SalesMan("John", "Doe", 1);
        SalesMan salesManSmith = new SalesMan("John", "Smith", 2);
        managePersonal.addSalesMan(salesManDoe);
        managePersonal.addSalesMan(salesManSmith);
        assertEquals(2, managePersonal.readAllSalesMen().size());
        managePersonal.deleteSalesMan(salesManDoe);
        assertEquals(1, managePersonal.readAllSalesMen().size());
        managePersonal.deleteSalesMan(salesManSmith);
        assertEquals(0, managePersonal.readAllSalesMen().size());
    }

    @Test
    void testAddAndReadSocialPerformanceRecord() {
        SalesMan salesMan = new SalesMan("John", "Doe", 1);
        managePersonal.addSalesMan(salesMan);
        SocialPerformanceRecord socialPerformanceRecord = new SocialPerformanceRecord(1, 1, 2021,
                20.0, 20.0, 100.0, 20.0,
                50.0, 50.0);
        managePersonal.addSocialPerformanceRecord(socialPerformanceRecord, salesMan);
        assertEquals(1, managePersonal.readSocialPerformanceRecord(salesMan).size());
        managePersonal.deleteSalesMan(salesMan);
        assertEquals(0, managePersonal.readAllSalesMen().size());
        managePersonal.deleteSocialPerformanceRecord(socialPerformanceRecord);
        assertEquals(0, managePersonal.readSocialPerformanceRecord(salesMan).size());
    }
    @Test
    void roundTripTest() {
        SalesMan salesMan = new SalesMan("John", "Doe", 1);
        managePersonal.addSalesMan(salesMan);
        assertEquals(salesMan.getFirstname(), managePersonal.readSalesMan(1).getFirstname());

        managePersonal.updateSalesMan(new SalesMan("John", "Smith", 1));
        assertEquals("Smith", managePersonal.readSalesMan(1).getLastname());

        SocialPerformanceRecord socialPerformanceRecord = new SocialPerformanceRecord(1, 1, 2021,
                20.0, 20.0, 100.0, 20.0,
                50.0, 50.0);
        SocialPerformanceRecord socialPerformanceRecord2 = new SocialPerformanceRecord(2, 1, 2022,
                30.0, 20.0, 100.0, 20.0,
                80.0, 70.0);

        managePersonal.addSocialPerformanceRecord(socialPerformanceRecord, salesMan);
        assertEquals(1, managePersonal.readSocialPerformanceRecord(salesMan).size());

        managePersonal.addSocialPerformanceRecord(socialPerformanceRecord2, salesMan);
        assertEquals(2, managePersonal.readSocialPerformanceRecord(salesMan).size());

        managePersonal.deleteSalesMan(salesMan);
        assertEquals(0, managePersonal.readAllSalesMen().size());

        managePersonal.deleteSocialPerformanceRecord(socialPerformanceRecord);
        managePersonal.deleteSocialPerformanceRecord(socialPerformanceRecord2);
        assertEquals(0, managePersonal.readSocialPerformanceRecord(salesMan).size());
    }
}
