package cz.sg.testfast.nomvc

import cz.sg.testfast.controllers.DataController
import cz.sg.testfast.services.DataByIdService
import cz.sg.testfast.services.DataListService
import spock.lang.Specification

class NoMvcSpec06 {
    abstract static class BaseSpec extends Specification {
        DataListService dataListService = Mock()
        DataByIdService dataByIdService = Mock()
        DataController controller = new DataController(dataByIdService, dataListService)
    }

    static class GetAll extends BaseSpec {
        def 'get'() {
            when:
            def result = controller.get()

            then:
            1 * dataListService.get() >> ['1', '2', '3']
            0 * _
            result == ['1', '2', '3']
        }
    }

    static class GetById extends BaseSpec {
        def 'getById'() {
            when:
            def result = controller.getById('1')

            then:
            1 * dataByIdService.get('1') >> '123'
            0 * _
            result == '123'
        }
    }
}
