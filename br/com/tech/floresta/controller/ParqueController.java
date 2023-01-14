package br.com.tech.floresta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech.floresta.model.Parque;
import br.com.tech.floresta.service.ParqueService;

@RestController
@CrossOrigin("*")
@RequestMapping("/parque")
public class ParqueController {
	
private ParqueService parqueService;	
public ParqueController(ParqueService parqueService) {
	this.parqueService = parqueService;
}

@GetMapping
public ResponseEntity<List<Parque>> listarParque(){
	return ResponseEntity.status(200).body(parqueService.listarParque());
}

@PostMapping
public ResponseEntity<Parque> criarParque(@Valid @RequestBody Parque parque){
	return ResponseEntity.status(201).body(parqueService.criarParque(parque));
}

@PutMapping
public ResponseEntity<Parque> atualizarParque(@Valid @RequestBody Parque parque){
	return ResponseEntity.status(200).body(parqueService.editarParque(parque));
}

@DeleteMapping("/{id}")
public ResponseEntity<?> excluirParque(@PathVariable Integer id){
	parqueService.excluirParque(id);
	return ResponseEntity.status(204).build();
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handlerValidationException(MethodArgumentNotValidException ex){
	Map<String, String> errors = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error->{
		String fieldName = ((FieldError) error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);
	}));
	return errors;
}

}
