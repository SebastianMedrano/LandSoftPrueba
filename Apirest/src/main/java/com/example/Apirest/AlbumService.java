package com.example.Apirest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
	@Autowired
	private IAlbumDao albumDao;
	
	public Album getByAlbumId(int id) {
		if (albumDao.findById(id).isEmpty()) {
			return new Album();
		}else {
			return albumDao.findById(id).get();
		}
	}
	
	
}
