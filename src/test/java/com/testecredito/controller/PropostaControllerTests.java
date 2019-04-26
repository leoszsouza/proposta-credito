package com.testecredito.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.testecredito.PropostaCreditoApplication;
import com.testecredito.entity.Proposta;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PropostaCreditoApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropostaControllerTests {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private ObjectMapper mapper;
	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void _findAllPropostas() throws Exception {
		this.mockMvc.perform(get("/propostas")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(4)));
	}

	@Test
	public void findOneProposta() throws Exception {
		this.mockMvc.perform(get("/propostas/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id", equalTo(1)))
				.andExpect(jsonPath("$.cpf", equalToIgnoringCase("36587215896")));
	}

//	@Test
//	public void addProposta() throws Exception {
//		final Proposta newTodo = new Proposta("N");
//		final String newTodoJson = this.mapper.writeValueAsString(newTodo);
//		System.out.println("************ " + newTodoJson);
//		this.mockMvc.perform(post("/todos").contentType(MediaType.APPLICATION_JSON).content(newTodoJson))
//				.andExpect(status().isCreated())
//				.andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/todos/4"));
//	}
//
//	@Test
//	public void updateTodo() throws Exception {
//		final Todo updatedTodo = new Todo("Second todo updated");
//		final String updatedTodoJson = this.mapper.writeValueAsString(updatedTodo);
//		this.mockMvc.perform(put("/todos/2").contentType(MediaType.APPLICATION_JSON).content(updatedTodoJson))
//				.andExpect(status().isOk()).andExpect(jsonPath("$.description", equalTo("Second todo updated")));
//	}
//
//	@Test
//	public void deleteTodo() throws Exception {
//		this.mockMvc.perform(delete("/todos/3")).andExpect(status().isOk());
//		this.mockMvc.perform(get("/todos")).andExpect(status().isOk()).andExpect(jsonPath("$..id", hasSize(3)))
//				.andExpect(jsonPath("$..id", not(containsString("3"))));
//	}
}
