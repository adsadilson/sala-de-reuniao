package br.com.apssystem.client.room.api.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StanderError {

	private Long timestamp;
	private Integer status;
	private String error;

	public StanderError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public StanderError() {
		super();
	}

}
