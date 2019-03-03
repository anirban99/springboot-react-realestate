package com.example.realestate.ut.controller;

import com.example.realestate.controller.RealEstateController;
import com.example.realestate.model.RealEstate;
import com.example.realestate.model.RealEstateInfo;
import com.example.realestate.service.RealEstateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RealEstateController.class)
public class RealEstateControllerTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private RealEstateController realEstateController;

    @MockBean
    private RealEstateService realEstateService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(realEstateController).build();
    }

    @Test
    public void whenFindRealEstatesSortedByProductType_thenObjectsAreReturnedSortedByProductType() throws Exception {

        RealEstate firstRealEstate = new RealEstate("Berlin", new RealEstateInfo("10179, Berlin", "BUY", Arrays.asList("1 Bedroom, Kitchen, Bathroom"), "50 sq. m", "65573129","700 EUR", "Best Immo", "Eric", "BI", "www.google.com", "S"));
        RealEstate secondRealEstate = new RealEstate("Berlin", new RealEstateInfo("10178, Berlin", "RENT", Arrays.asList("2 Bedroom, Kitchen, Bathroom") ,"80 sq. m","65573128","1100 EUR", "EB Immo", "Michael", "EBM", "www.google.com", "L"));

        List<RealEstate> allRealEstates = Arrays.asList(secondRealEstate, firstRealEstate);

        given(realEstateService.findRealEstatesSortedByProductType()).willReturn(allRealEstates);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/realestates")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].resultListEntries.productType", is(secondRealEstate.getResultListEntries().getProductType())));

        verify(realEstateService, VerificationModeFactory.times(1)).findRealEstatesSortedByProductType();
        reset(realEstateService);
    }

    @Test
    public void whenFindRealEstatesGroupedByPostCode_thenObjectsAreReturnedGroupedByPostCode() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/realestates/count")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void whenFindByAll_thenAllObjectsAreReturned() throws Exception {

        RealEstate firstRealEstate = new RealEstate("Berlin", new RealEstateInfo("10178, Berlin", "RENT", Arrays.asList("2 Bedroom, Kitchen, Bathroom") ,"80 sq. m","65573128","1100 EUR", "EB Immo", "Michael", "EBM", "www.google.com", "L"));
        RealEstate secondRealEstate = new RealEstate("Berlin", new RealEstateInfo("10179, Berlin", "BUY", Arrays.asList("1 Bedroom, Kitchen, Bathroom"), "50 sq. m", "65573129","700 EUR", "Best Immo", "Eric", "BI", "www.google.com", "S"));

        List<RealEstate> allRealEstates = Arrays.asList(firstRealEstate, secondRealEstate);

        given(realEstateService.findAllRealEstates()).willReturn(allRealEstates);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/realestates/list")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(firstRealEstate.getName())));

        verify(realEstateService, VerificationModeFactory.times(1)).findAllRealEstates();
        reset(realEstateService);
    }
}
