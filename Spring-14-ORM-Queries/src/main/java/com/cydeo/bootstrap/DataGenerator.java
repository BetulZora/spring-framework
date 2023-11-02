package com.cydeo.bootstrap;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Display all regions in Canada using derived queries in the repository
        System.out.println("---------------------------+++++++++Region Start");
        System.out.println(regionRepository.findByCountry("Canada"));

        System.out.println("---------------------------+++++++++Region End");




    }
}
