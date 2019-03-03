package com.example.realestate.ut.service;

import com.example.realestate.model.RealEstate;
import com.example.realestate.model.RealEstateCount;
import com.example.realestate.model.RealEstateInfo;
import com.example.realestate.repository.RealEstateRepository;
import com.example.realestate.service.RealEstateService;
import com.example.realestate.service.RealEstateServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RealEstateServiceImplTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public RealEstateService realEstateService() {
            return new RealEstateServiceImpl();
        }
    }

    @Autowired
    private RealEstateService realEstateService;

    @MockBean
    private RealEstateRepository realEstateRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenFindSortedByProductType_thenReturnObjectsSortedByProductType(){

        RealEstate firstRealEstate = new RealEstate("Berlin", new RealEstateInfo("10179, Berlin", "BUY", Arrays.asList("1 Bedroom, Kitchen, Bathroom"), "50 sq. m", "65573129","700 EUR", "Best Immo", "Eric", "BI", "www.google.com", "S"));
        RealEstate secondRealEstate = new RealEstate("Berlin", new RealEstateInfo("10178, Berlin", "RENT", Arrays.asList("2 Bedroom, Kitchen, Bathroom") ,"80 sq. m","65573128","1100 EUR", "EB Immo", "Michael", "EBM", "www.google.com", "L"));
        RealEstate thirdRealEstate = new RealEstate("Berlin", new RealEstateInfo("10589, Berlin", "BUY", Arrays.asList("3 Bedroom, Kitchen, Bathroom, Balcony"), "90 sq. m", "65573130","1300 EUR", "Immowelt", "Christian", "IW", "www.google.com", "L"));

        List<RealEstate> sortedRealEstates = Arrays.asList(secondRealEstate, thirdRealEstate, firstRealEstate);

        when(realEstateRepository.findAll(new Sort(Sort.Direction.ASC, "resultListEntries.productType"))).thenReturn(sortedRealEstates);

        List<RealEstate> result = realEstateService.findRealEstatesSortedByProductType();

        assertEquals(3, result.size());
        assertEquals("L", result.get(0).getResultListEntries().getProductType());
    }

    @Test
    public void whenFindGroupedByPostCode_thenReturnObjectsGroupedByPostCode(){

        RealEstate firstRealEstate = new RealEstate("Berlin", new RealEstateInfo("10178, Berlin", "RENT", Arrays.asList("2 Bedroom, Kitchen, Bathroom") ,"80 sq. m","65573128","1100 EUR", "EB Immo", "Michael", "EBM", "www.google.com", "L"));
        RealEstate secondRealEstate = new RealEstate("Berlin", new RealEstateInfo("10179, Berlin", "BUY", Arrays.asList("1 Bedroom, Kitchen, Bathroom"), "50 sq. m", "65573129","700 EUR", "Best Immo", "Eric", "BI", "www.google.com", "S"));
        RealEstate thirdRealEstate = new RealEstate("Berlin", new RealEstateInfo("10589, Berlin", "BUY", Arrays.asList("3 Bedroom, Kitchen, Bathroom, Balcony"), "90 sq. m", "65573130","1300 EUR", "Immowelt", "Christian", "IW", "www.google.com", "L"));

        List<RealEstate> allRealEstates = Arrays.asList(firstRealEstate, secondRealEstate, thirdRealEstate);

        RealEstateCount firstRealEstateCount =  new RealEstateCount("10589, Berlin", 1);
        RealEstateCount secondRealEstateCount =  new RealEstateCount("10179, Berlin", 1);
        RealEstateCount thirdRealEstateCount =  new RealEstateCount("10178, Berlin", 1);

        List<RealEstateCount> realEstateCountList = Arrays.asList(firstRealEstateCount, secondRealEstateCount, thirdRealEstateCount);

        when(realEstateRepository.getRealEstateCount()).thenReturn(realEstateCountList);

        List<RealEstateCount> result = realEstateService.findRealEstatesGroupedByPostCode();

        assertEquals("10179, Berlin", result.get(1).getAddressToDisplay());
        assertEquals(1, result.get(1).getTotal());
    }


    @Test
    public void whenFindAll_thenReturnAllRecords(){

        RealEstate firstRealEstate = new RealEstate("Berlin", new RealEstateInfo("10178, Berlin", "RENT", Arrays.asList("2 Bedroom, Kitchen, Bathroom") ,"80 sq. m","65573128","1100 EUR", "EB Immo", "Michael", "EBM", "www.google.com", "L"));
        RealEstate secondRealEstate = new RealEstate("Berlin", new RealEstateInfo("10179, Berlin", "BUY", Arrays.asList("1 Bedroom, Kitchen, Bathroom"), "50 sq. m", "65573129","700 EUR", "Best Immo", "Eric", "BI", "www.google.com", "S"));
        RealEstate thirdRealEstate = new RealEstate("Berlin", new RealEstateInfo("10589, Berlin", "BUY", Arrays.asList("3 Bedroom, Kitchen, Bathroom, Balcony"), "90 sq. m", "65573130","1300 EUR", "Immowelt", "Christian", "IW", "www.google.com", "L"));

        List<RealEstate> allRealEstates = Arrays.asList(firstRealEstate, secondRealEstate, thirdRealEstate);

        when(realEstateRepository.findAll()).thenReturn(allRealEstates);

        List<RealEstate> result = realEstateService.findAllRealEstates();
        assertEquals(3, result.size());
    }

}
