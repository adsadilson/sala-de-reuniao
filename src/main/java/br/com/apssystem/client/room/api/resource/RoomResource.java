package br.com.apssystem.client.room.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.apssystem.client.room.domain.entity.Room;
import br.com.apssystem.client.room.domain.service.RoomService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomResource {

	private RoomService roomService;

	@GetMapping("/{id}")
	public ResponseEntity<Room> findById(@PathVariable Long id) {
		Room obj = roomService.findById(id);
		return ResponseEntity.ok(obj);
	}

	@PutMapping
	public ResponseEntity<Room> edit(@RequestBody Room obj) {
		roomService.edit(obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public List<Room> findAll() {
		return roomService.findAll();
	}

	@PostMapping
	public ResponseEntity<Room> save(@RequestBody Room obj) {
		obj = roomService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		roomService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
