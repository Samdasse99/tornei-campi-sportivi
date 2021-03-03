//package it.itsrizzoli.ifts2021.springsportshub;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import it.itsrizzoli.ifts2021.springsportshub.repository.CampoRepository;
//
//@Component
//public class DatabaseLoader {
//
//	@Autowired
//	private CampoRepository campoRepo;
//	
//	@Autowired
//	private CentroSportivoRepository centroRepo;
//	
//	@Autowired
//	private GiocatoreRepository giocatoreRepo;
//	
//	@Autowired
//	private GruppoRepository gruppoRepo;
//	
//	@Autowired
//	private SlotRepository slotRepo;
//	
//	@Autowired
//	private SportRepository sportRepo;
//	
//	@Autowired
//	private SuperficieRepository superificieRepo;
//	
//	@Bean
//	CommandLineRunner init() {
//		
//    return args -> {
//    	repository.save(new Order("grande mocha"));
//    	repository.save(new Order("venti hazelnut machiatto"));
//    };
//  }
//}
