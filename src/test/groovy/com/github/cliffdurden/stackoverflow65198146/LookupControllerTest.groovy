package com.github.cliffdurden.stackoverflow65198146

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import javax.servlet.http.HttpServletResponse

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@AutoConfigureMockMvc
@WebMvcTest
class LookupControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @SpringBean
    private LookupService lookupService = Mock()

    def "should return a single lookup record when test hits the URL and parses JSON output"() {
        when:
        def response = mockMvc
                .perform(get('/api/lookups/')
                        .param("lookupId", "2")
                        .param("page", "0")
                        .param("size", "0"))
                .andReturn()
                .response

        then:
        response.status == HttpServletResponse.SC_OK
    }
}
