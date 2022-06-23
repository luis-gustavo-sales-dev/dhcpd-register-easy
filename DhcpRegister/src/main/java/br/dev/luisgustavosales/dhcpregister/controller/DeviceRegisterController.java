package br.dev.luisgustavosales.dhcpregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.luisgustavosales.dhcpregister.entities.DeviceRegister;
import br.dev.luisgustavosales.dhcpregister.services.DeviceRegisterService;

@RestController
@RequestMapping("/deviceregisters")
public class DeviceRegisterController {

	@Autowired
	private DeviceRegisterService deviceRegisterService;
	
	@GetMapping("/{id}")
	public ResponseEntity<DeviceRegister> findById(
			@PathVariable Long id) {
		
		var deviceRegister = this.deviceRegisterService.findById(id);
		
		if (deviceRegister == null) {
			// Retorne uma exceção
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(deviceRegister);
	}
	
	@PostMapping
	public ResponseEntity<DeviceRegister> create(
			@RequestBody DeviceRegister deviceRegister){
		
		var deviceRegisterCreated = this.deviceRegisterService.create(deviceRegister);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(deviceRegisterCreated);
		
	}
}
