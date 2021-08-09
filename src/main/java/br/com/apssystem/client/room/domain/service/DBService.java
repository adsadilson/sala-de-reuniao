package br.com.apssystem.client.room.domain.service;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apssystem.client.room.domain.entity.Room;
import br.com.apssystem.client.room.domain.repository.RoomRepository;

@Service
public class DBService {

	@Autowired
	private RoomRepository roomRepository;

	// @formatter:off

	public void instanciaBaseDado() {
		populaRooms();
	}
	
	private void populaRooms() {
	
		Room room = new Room();
		room.setName("Curso de Java: Primeiros passos no Java");
		room.setDate(LocalDate.of(2021, 07, 01));
		room.setStartHour("20:00");
		room.setEndHour("21:30");
		room.setActive(true);

		Room room1 = new Room();
		room1.setName("Spring e Injeção de Dependências");
		room1.setDate(LocalDate.of(2021, 07, 01));
		room1.setStartHour("21:40");
		room1.setEndHour("22:30");
		room1.setActive(true);
		
		Room room2 = new Room();
		room2.setName("Spring vs Jakarta EE (Java EE)");
		room2.setDate(LocalDate.of(2021, 07, 8));
		room2.setStartHour("19:00");
		room2.setEndHour("20:30");
		room2.setActive(false);
		
		Room room3 = new Room();
		room3.setName("O que é injeção de dependências?");
		room3.setDate(LocalDate.of(2021, 07, 8));
		room3.setStartHour("21:00");
		room3.setEndHour("22:30");
		room3.setActive(true);
		
		roomRepository.saveAll(Arrays.asList(room,room1,room2,room3));
		
		
	}
	
	// @formatter:on
}
