package kon.br.pepodev.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import kon.br.pepodev.workshopmongo.dto.AuthorDTO;
import kon.br.pepodev.workshopmongo.dto.CommentDTO;

@Document(collection = "post")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	private List<CommentDTO> comments = new ArrayList<>();
	
	public Post() {}

	public Post(String id, Date date, AuthorDTO author, String title, String body) {
		super();
		this.id = id;
		this.date = date;
		this.author = author;
		this.title = title;
		this.body = body;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}
	
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	public List<CommentDTO> getComments() {
		return comments;
	}
	
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
