package com.example.Apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class UserRestController {
	
	@Autowired
	private AlbumService albumService;
	@Autowired 
	private IAlbumDao albumDao;
	
	@GetMapping(value="Albums/{id}")
	public Album getAlbum(@PathVariable("id") int id) {
		Album idAlbum=albumService.getByAlbumId(id);
		if(idAlbum.getId()==0){
			String url = "https://jsonplaceholder.typicode.com/albums/"+id;
		    RestTemplateBuilder r = new RestTemplateBuilder();
		    RestTemplate rt = r.build();
		    idAlbum = rt.getForObject(url, Album.class);
		    albumDao.save(idAlbum);
		}
		
		return idAlbum;
	}
}
