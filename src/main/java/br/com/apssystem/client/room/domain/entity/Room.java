package br.com.apssystem.client.room.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "room")
@SequenceGenerator(name = "ROOM_ID", sequenceName = "ROOM_ID_SEQ")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ROOM_ID_SEQ")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(length = 100, nullable = false, unique = true)
	private String name;

	private LocalDate date;

	private String startHour;

	private String endHour;
	
	private boolean active;

}
