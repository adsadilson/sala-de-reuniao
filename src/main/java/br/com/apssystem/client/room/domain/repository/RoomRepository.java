package br.com.apssystem.client.room.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apssystem.client.room.domain.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
