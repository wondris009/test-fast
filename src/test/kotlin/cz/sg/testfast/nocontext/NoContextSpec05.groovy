package cz.sg.testfast.nocontext

import cz.sg.testfast.controllers.DataController
import cz.sg.testfast.services.DataByIdService
import cz.sg.testfast.services.DataListService
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

class NoContextSpec05 {
    abstract static class BaseSpec extends Specification {
        DataListService dataListService = Mock()
        DataByIdService dataByIdService = Mock()
        DataController controller = new DataController(dataByIdService, dataListService)
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    static class GetAll extends BaseSpec {
        def 'get'() {
            when:
            ResultActions result = this.mockMvc.perform(get("/data"))

            then:
            1 * dataListService.get() >> ['1', '2', '3']
            0 * _
            result.andExpect(content().string('["1","2","3"]'))
        }
    }

    static class GetById extends BaseSpec {
        def 'getById'() {
            when:
            ResultActions result = this.mockMvc.perform(get("/data/1"))

            then:
            1 * dataByIdService.get('1') >> '123'
            0 * _
            result.andExpect(content().string('123'))
        }
    }
}
