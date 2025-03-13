package kon.br.pepodev.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kon.br.pepodev.workshopmongo.domain.Post;
import kon.br.pepodev.workshopmongo.resource.util.URL;
import kon.br.pepodev.workshopmongo.services.PostServices;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostServices service;
	
//	@GetMapping
//	public ResponseEntity<List<UserDTO>> findAll() {
//		List<User> list = service.findAll();
//		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDto);
//	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}
	
	
}
