package com.bruno.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.bookstore.domain.Categoria;
import com.bruno.bookstore.domain.Livro;
import com.bruno.bookstore.repositories.CategoriaRepository;
import com.bruno.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired // autoWired serve para indicar que o spring precisa instanciar o objeto para nós
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public void InstanciaBaseDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Livro de Ficção cientifica");
		Categoria cat3 = new Categoria(null, "Biografia", "Biografia");
		
		Livro l1 = new Livro(null,"Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null,"Engenharia de Software", "Louis V", "Lorem Ipsum", cat1);
		Livro l3 = new Livro(null,"The Time Machine", "H. G. Wells", "Lorem Ipsum", cat2);
		Livro l4 = new Livro(null,"Steve Jobs", "Jobs", "Lorem Ipsum", cat3);
		Livro l5 = new Livro(null,"I, Robot", "Isaac Asimov", "Lorem Ipsum", cat2);
		
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l5));
		cat3.getLivros().addAll(Arrays.asList(l4));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
