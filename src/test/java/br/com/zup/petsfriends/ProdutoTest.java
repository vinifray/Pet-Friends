package br.com.zup.petsfriends;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cadastrarProduto() throws Exception {
        String dados = "{\"email\":\"rodrigo@zup.com.br\", \"produtos\": [ {\"nome\":\"Biscoito Canino\"} ]}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/produtos/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(dados))
        .andExpect(
                MockMvcResultMatchers.status().isCreated()
        ).andExpect(
                MockMvcResultMatchers.content().json(
                        "[{\"nome\":\"Biscoito Canino\", \"preco\": 22.90, \"quantidade\": 19}]"
                )
        );
    }

}
