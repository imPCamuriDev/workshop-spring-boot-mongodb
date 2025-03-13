package kon.br.pepodev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kon.br.pepodev.workshopmongo.domain.Post;
import kon.br.pepodev.workshopmongo.repository.PostRepository;
import kon.br.pepodev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostServices {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional <Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
		
}
