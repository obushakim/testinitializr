package obus.api.testinitializr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import obus.api.testinitializr.entity.Obus;
import obus.api.testinitializr.service.ObusService;

@RestController
@RequestMapping("/api")
public class ObusController {
	@Autowired
	@Qualifier("obusService")
	private ObusService obusService;

	@GetMapping("/obus/{id}")
	public ResponseEntity<Obus> getObusById(@PathVariable(value = "id") int id) {
		Obus obus = obusService.getObusById(id);

		return ResponseEntity.ok().body(obus);
	}

	@GetMapping("/obus")
	public ResponseEntity<List<Obus>> getObuses() {
		List<Obus> obuses = obusService.getObuses();

		return new ResponseEntity<List<Obus>>(obuses, HttpStatus.OK);
	}

	@PostMapping("/obus")
	public ResponseEntity<Void> insertObus(@RequestBody Obus obus) {
		obusService.insertObus(obus);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/obus")
	public ResponseEntity<Void> updateObus(@RequestBody Obus obus) {
		obusService.updateObus(obus);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/obus/{id}")
	public ResponseEntity<Void> deleteMapping(@PathVariable(value = "id") int id) {
		obusService.deleteObus(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
