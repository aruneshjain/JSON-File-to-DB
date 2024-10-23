package com.arunesh.DataReader;

import com.arunesh.DataReader.Model.JSONdata;
import com.arunesh.DataReader.Service.FileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DataReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataReaderApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(FileService fileService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<JSONdata>> typeReference = new TypeReference<List<JSONdata>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Data.json");
			try {
				List<JSONdata> data = mapper.readValue(inputStream,typeReference);
				fileService.save(data);
				System.out.println("Data Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Data: " + e.getMessage());
			}
		};
	}
}
