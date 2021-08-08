package br.com.apssystem.client.room.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.apssystem.client.room.api.exception.EntidadeEmUsoException;
import br.com.apssystem.client.room.api.exception.NegocioException;
import br.com.apssystem.client.room.domain.entity.Room;
import br.com.apssystem.client.room.domain.repository.RoomRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomService {

	private RoomRepository roomRepository;

	@Transactional
	public Room save(Room obj) {
		return roomRepository.save(obj);
	}

	public Room edit(Room obj) {
		return save(obj);
	}

	public List<Room> findAll() {
		return roomRepository.findAll();
	}

	public Room findById(Long id) {
		return roomRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Nenhum Room encontrado para esse id " + id));
	}

	public void delete(Long id) {
		findById(id);
		try {
			roomRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Room não pode ser deletada! possui associações com outras tabelas");
		}
	}
}
