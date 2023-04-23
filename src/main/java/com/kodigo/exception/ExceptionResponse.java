package com.kodigo.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {

	private LocalDateTime fecha;
	private String mensaje;
	private String detalles;

}
