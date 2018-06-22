/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package invoice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import invoice.controller.InvoiceController;
import invoice.dao.repository.InvoiceRepository;
import invoice.service.InvoiceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private InvoiceService invoiceService;
    @Mock
    private InvoiceRepository invoiceRepository;
    @InjectMocks
    private InvoiceController invoiceController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sampleTest() throws Exception {
//    	List<InvoiceResult> expect = null;
//        when(invoiceService.search("1")).thenReturn(expect);
//        mockMvc.perform(get("/invoice/1"))
//            .andExpect(status().isOk())
//            .andExpect(content().string(containsString("Hello Mock")));
    }

}
