package cz.sg.testfast.manualmocks

import cz.sg.testfast.TestFastApplication
import cz.sg.testfast.controllers.DataController
import cz.sg.testfast.services.DataByIdService
import cz.sg.testfast.services.DataListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

class ManualMockSpec03 {
    @AutoConfigureMockMvc
    @SpringBootTest(classes = [TestFastApplication])
    abstract static class BaseSpec extends Specification {
        @Autowired
        MockMvc mockMvc

        @Autowired
        DataController controller

        DataListService _dataListService
        DataListService dataListService = Mock()

        DataByIdService _dataByIdService
        DataByIdService dataByIdService = Mock()

        def setup() {
            _dataListService = controller.dataListService
            controller.dataListService = dataListService
            _dataByIdService = controller.dataByIdService
            controller.dataByIdService = dataByIdService
        }

        def cleanup() {
            controller.dataListService = _dataListService
            controller.dataByIdService = _dataByIdService
        }
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
