package med.voll.api.controller;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.records.endereco.EnderecoRecord;
import med.voll.api.domain.records.medico.CadastroMedicoRecord;
import med.voll.api.domain.records.medico.MedicoRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private JacksonTester<CadastroMedicoRecord> cadastroMedicoRecordJacksonTester;
    @Autowired
    private JacksonTester<MedicoRecord> medicoRecordJacksonTester;

    @Test
    @DisplayName("Deveria devolver erro 400 se a requisição não tiver um body")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(post("/medicos")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver 200 se estiver tudo certo no json")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var response = mvc.perform(
                post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cadastroMedicoRecordJacksonTester.write(
                                new CadastroMedicoRecord("Teste", "teste@email.com", "4499888866", "132456", Especialidade.CARDIOLOGIA, endereco())
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    private CadastroMedicoRecord criaMedico() {
        CadastroMedicoRecord medico = new CadastroMedicoRecord(
                "Teste",
                "email@teste.com",
                "4499885577",
                "123456",
                Especialidade.CARDIOLOGIA,
                endereco()
        );
        return medico;
    }

    private EnderecoRecord endereco() {
        EnderecoRecord end = new EnderecoRecord(
                "Logradouro",
                "Bairro",
                "456789456",
                "Cidade",
                "UF",
                "Complemento",
                "50"
        );
        return end;
    }

}