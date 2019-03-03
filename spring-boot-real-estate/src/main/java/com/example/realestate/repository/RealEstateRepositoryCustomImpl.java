package com.example.realestate.repository;

import com.example.realestate.model.RealEstate;
import com.example.realestate.model.RealEstateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import org.springframework.data.domain.Sort;

import java.util.List;

public class RealEstateRepositoryCustomImpl implements RealEstateRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<RealEstateCount> getRealEstateCount() {

        Aggregation agg = newAggregation(
            match(Criteria.where("resultListEntries.addressToDisplay").regex("^10")),
            group("resultListEntries.addressToDisplay").count().as("total"),
            project("total").and("addressToDisplay").previousOperation(),
            sort(Sort.Direction.ASC, "total")

        );

        System.out.println("agg " +agg);

        AggregationResults<RealEstateCount> groupResults
            = mongoTemplate.aggregate(agg, RealEstate.class, RealEstateCount.class);

        System.out.println("group results " +groupResults);
        List<RealEstateCount> result = groupResults.getMappedResults();
        System.out.println("results " +result);

        return result;
    }
}
