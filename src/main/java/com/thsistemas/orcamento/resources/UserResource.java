package com.thsistemas.orcamento.resources;

import com.thsistemas.orcamento.dto.UserDTO;
import com.thsistemas.orcamento.dto.UserInsertDTO;
import com.thsistemas.orcamento.dto.UserUpdateDTO;
import com.thsistemas.orcamento.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
        Page<UserDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert (@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<UserDTO> update (@Valid @PathVariable Long id, @RequestBody UserUpdateDTO dto) {
        UserDTO newDTO = service.update(id, dto);
        return ResponseEntity.ok().body(newDTO);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserDTO> delete (@PathVariable Long id) {
         service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
